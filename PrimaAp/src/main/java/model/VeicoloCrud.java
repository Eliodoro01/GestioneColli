package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeicoloCrud {

public int inserimentoVeicolo(Veicolo v) {
		
		int num = -1;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();
		
		String query = "insert into veicoli (codice, tipo, capienza, idcorriere) values (?,?,?,?)";
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, v.getCodice()); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(2, v.getTipo()); // diciamo che il secondo punto interrogativo (per questo 2) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setInt(3, v.getCapienza()); // diciamo che il terzo punto interrogativo (per questo 3) deve essere uguale alla password che passiamo al metodo verificaLogin
			stat.setInt(4, v.getIdcorriere());
			
			num = stat.executeUpdate(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//executeUpdate è per comandi DML (QUINDI È PER QUERY CHE MODIFICANO IL DB) e ritorna un intero che sarebbe il numero di record inseriti nel DB

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore nell'Inserimento corriere");
		}
		
		return num;
	}

public ResultSet getListaVeicoli(int id) { //ritorna un resultSet con tutti i corriere del DB
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * FROM veicoli WHERE idcorriere = ?";
	// andiamo a fare una query per prendere tutti i corrieri che hanno un account dal DB
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setInt(1, id);
		
		System.out.println("Lo stat è " + stat);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca dell'id veicolo");
	}

	return res;
}

public int eliminaVeicolo(String codice) {
	
	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "DELETE FROM veicoli WHERE codice = ?";
	// andiamo a fare una query per eliminare le righe dal DB che rispettando le condizioni del where, cioè la partita iva deve
	//essere uguale a quella passata al metodo
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setString(1, codice);     // "imposta" il primo punto interrogativo al valore che gli passiamo voi di piva
		result = stat.executeUpdate();  // executeUpdate è diverso da execute query

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca piva");
	}

	
	
	return result;
}

public int update(int caricoAggiornato, int id) {

	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "UPDATE veicoli SET caricoattuale=? WHERE id = ?";
	// andiamo a fare una query per prendere tutte le colonne della tabella corriere che ha come campo piva quella passata al metodo
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); //andiamo a preparare la query
		stat.setInt(1, caricoAggiornato);
		stat.setInt(2, id); //nella clausola where
		
		result = stat.executeUpdate(); 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore update carico attuale");
	}
	
	return result;
}

public ResultSet getColli(int id) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT * FROM colli WHERE idveicolo = ?;";
	// andiamo a fare una query per prendere tutti i colli che hanno un idveicolo che passiamo noi 
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query
		stat.setInt(1, id);
		
		System.out.println("Lo stat di getColli è " + stat);
		
		res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
		//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)

		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore ricerca dell'id veicolo");
	}

	return res;
	
}
}


