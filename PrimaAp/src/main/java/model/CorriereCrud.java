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
			System.out.println("Errore nell'Inserimento");
		}
		
		return num;
	}

public ResultSet getListaCorrieri() {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * from corrieri join account on account.id = corrieri.idaccount";
	// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
	//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)
		//res funziona come un iteratore 


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
	// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
	//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, piva); 
		result = stat.executeUpdate(); 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca e-mail");
	}

	
	
	return result;
}

public ResultSet getCorriere(String piva) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * from corrieri join account on account.id = corrieri.idaccount where corrieri.piva = ?";
	// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
	//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, piva);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)
		//res funziona come un iteratore 


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca e-mail");
	}

	return res;
} 

public int modificaCorriere(String pivaOld, Corriere c) {
	
	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "UPDATE corrieri SET nome=?,piva=?,indirizzo=?,telefono=?,citta=?,cap=? WHERE piva = ?";
	// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
	//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
	
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
		
		System.out.println(stat);
		
		result = stat.executeUpdate(); 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore modifica");
	}
	
	return result;
}

}
