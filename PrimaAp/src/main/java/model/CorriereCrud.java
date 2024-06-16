package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorriereCrud {

public int inserimentoCorriere(Corriere c) {
		
		int num = -1;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();
		
		String query = "insert into corrieri (nome, piva, indirizzo, telefono, citta, cap, idaccount) values (?,?,?,?,?,?,?)";
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, c.getNome()); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(2, c.getPiva()); // diciamo che il secondo punto interrogativo (per questo 2) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(3, c.getIndirizzo()); // diciamo che il terzo punto interrogativo (per questo 3) deve essere uguale alla password che passiamo al metodo verificaLogin
			stat.setString(4, c.getTelefono());
			stat.setString(5, c.getCitta());
			stat.setString(6, c.getCap());
			stat.setInt(7, c.getIdaccount()); 
			
			num = stat.executeUpdate(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//executeUpdate è per comandi DML (QUINDI È PER QUERY CHE MODIFICANO IL DB) e ritorna un intero che sarebbe il numero di record inseriti nel DB

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore nell'Inserimento corriere");
		}
		
		return num;
	}

public ResultSet getListaCorrieri() { //ritorna un resultSet con tutti i corriere del DB
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * from corrieri join account on account.id = corrieri.idaccount";
	// andiamo a fare una query per prendere tutti i corrieri che hanno un account dal DB
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca e-mail");
	}

	return res;
}

public int eliminaCorriere(String piva) {
	
	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "DELETE FROM corrieri WHERE piva = ?";
	// andiamo a fare una query per eliminare le righe dal DB che rispettando le condizioni del where, cioè la partita iva deve
	//essere uguale a quella passata al metodo
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, piva);     // "imposta" il primo punto interrogativo al valore che gli passiamo voi di piva
		
		System.out.println("Lo stat è " + stat);
		
		result = stat.executeUpdate();  // executeUpdate è diverso da execute query

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore eliminazione corriere");
	}

	
	
	return result;
}

public ResultSet getCorriere(String piva) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * from corrieri join account on account.id = corrieri.idaccount where corrieri.piva = ?";
	// andiamo a fare una query per prendere il corriere a cui corrisponde la partita iva che vogliamo eliminare, quindi stiamo utilizzando la partita iva come se fosse una chiave
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, piva);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore nella ricerca della piva");
	}

	return res;
} 

public int modificaCorriere(String pivaOld, Corriere c) { //gli dobbiamo passare la vecchia partita iva per capire quale corriere stiamo andando a modificare
	
	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "UPDATE corrieri SET nome=?,piva=?,indirizzo=?,telefono=?,citta=?,cap=? WHERE piva = ?";
	// andiamo a fare una query per prendere tutte le colonne della tabella corriere che ha come campo piva quella passata al metodo
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); //andiamo a preparare la query
		stat.setString(1, c.getNome());
		stat.setString(2, c.getPiva()); 
		stat.setString(3, c.getIndirizzo());
		stat.setString(4, c.getTelefono()); 
		stat.setString(5, c.getCitta()); 
		stat.setString(6, c.getCap());
		stat.setString(7, pivaOld); //nella clausola where
		
		System.out.println("lo stat è: " + stat);
		
		result = stat.executeUpdate(); 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore modifica");
	}
	
	return result;
}

public ResultSet getId(String username, String password) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "select corrieri.id from account join corrieri on account.id = corrieri.idaccount where account.username = ? or account.email = ? and account.password = ?";
	// andiamo a fare una query per prendere il corriere a cui corrisponde la partita iva che vogliamo eliminare, quindi stiamo utilizzando la partita iva come se fosse una chiave
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, username);
		stat.setString(2, username);
		stat.setString(3, password);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore nella ricerca della piva");
	}
	
	return res;
}


public Corriere getCorriereById(int id, Corriere corriere) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * from corrieri where id = ?";
	// andiamo a fare una query per prendere il corriere a cui corrisponde la partita iva che vogliamo eliminare, quindi stiamo utilizzando la partita iva come se fosse una chiave
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setInt(1, id);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)
		while(res.next()) {
			corriere.setIndirizzo(res.getString("indirizzo"));
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore nella ricerca della piva");
	}

	return corriere;
} 


}
