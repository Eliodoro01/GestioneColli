package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColloCrud {

public int inserimentoCollo(Collo c, int id) {
		
		int num = -1;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();
		
		String query = "insert into colli (codice, mittente, destinatario, peso, idveicolo) values (?,?,?,?,?)";
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, c.getCodice()); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(2, c.getMittente()); // diciamo che il secondo punto interrogativo (per questo 2) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(3, c.getDestinatario()); // diciamo che il terzo punto interrogativo (per questo 3) deve essere uguale alla password che passiamo al metodo verificaLogin
			stat.setInt(4, c.getPeso());
			stat.setInt(5, id);
			System.out.println("lo stat del collo è " + stat);
			
			num = stat.executeUpdate(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//executeUpdate è per comandi DML (QUINDI È PER QUERY CHE MODIFICANO IL DB) e ritorna un intero che sarebbe il numero di record inseriti nel DB

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore nell'Inserimento del collo");
		}
		
		return num;
	}

public int updateStato(int id, String stato) {
	
	int result = 0;
	
	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "UPDATE colli SET stato = ? WHERE id = ?";
	// andiamo a fare una query per prendere tutte le colonne della tabella corriere che ha come campo piva quella passata al metodo
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); //andiamo a preparare la query
		stat.setString(1, stato);
		stat.setInt(2, id); //nella clausola where
		
		result = stat.executeUpdate(); 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Errore update stato del collo");
	}
	
	return result;
	}

public ResultSet getCollo(String codice) {
	
	ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

	Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
	Connection conn = istanza.getConnection();

	String query = "SELECT colli.mittente, colli.destinatario, colli.peso, colli.stato, corrieri.nome, corrieri.telefono, corrieri.citta FROM colli join veicoli on veicoli.id = colli.idveicolo join corrieri on corrieri.id = veicoli.idcorriere WHERE colli.codice = ?";
	// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
	//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
	
	PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
	try {
		stat = conn.prepareStatement(query); // andiamo a preparare la query

		stat.setString(1, codice); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale a codice che passiamo al metodo getCollo

		System.out.println("Lo stat è "+ stat);
		
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
}
