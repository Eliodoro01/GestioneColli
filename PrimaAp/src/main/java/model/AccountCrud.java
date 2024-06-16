package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountCrud {

	public String verificaLogin(String username, String password) {

		ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();

		String query = "select * from account join permessi on account.idpermesso = permessi.id where(username = ? or email = ?) and password = ?";
		// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
		//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, username); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(2, username); // diciamo che il secondo punto interrogativo (per questo 2) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(3, password); // diciamo che il terzo punto interrogativo (per questo 3) deve essere uguale alla password che passiamo al metodo verificaLogin

			res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)
			//res funziona come un iteratore 

			if(res.next()) { //res è bool quindi quando res.next() sarà true entrerà nell'if e ritornerà il permesso di un determinato account
				return res.getString("permesso");//ritorniamo il valore specificando il nome del campo che vogliamo prendere dal result set
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore Login");
		}

		return ""; //se la connessione non va a buon fine o non trova il permesso legato ad un account ritorniamo null

	}
	
	public int inserimentoAccount(Account a) {
		
		int num = -1;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();
		
		String query = "insert into account (username, email, password, idpermesso) values (?,?,?,?)";
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, a.getUsername()); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(2, a.getEmail()); // diciamo che il secondo punto interrogativo (per questo 2) deve essere uguale al'username che passiamo al metodo verificaLogin
			stat.setString(3, a.getPassword()); // diciamo che il terzo punto interrogativo (per questo 3) deve essere uguale alla password che passiamo al metodo verificaLogin
			stat.setInt(4, 2); //essendo che dobbiamo gestire solo guest settiamo noi il valore dell'id a 2 
			
			num = stat.executeUpdate(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//executeUpdate è per comandi DML (QUINDI È PER QUERY CHE MODIFICANO IL DB) e ritorna un intero che sarebbe il numero di record inseriti nel DB

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore nell'Inserimento account");
		}
		
		return num;
	}
	
	public int ricercaAccount(String email) {
		
		ResultSet res = null; //andiamo a creare un oggetto di tipo ResultSet per andare a gestire in seguito il result set restituito dalla query

		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();

		String query = "select id from account where email = ?";
		// andiamo a fare una query per prendere le righe dal DB che rispettando le condizioni del where, cioè l'username o l'email e la password devono
		//essere uguali a quelle inserite nel form per questo si usano i punti interrogativi
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query

			stat.setString(1, email); // diciamo che il primo punto interrogativo (per questo 1) deve essere uguale al'username che passiamo al metodo verificaLogin

			res = stat.executeQuery(); //eseguiamo la query con i valori che siamo andati ad identificare nel setString
			//per comandi DQL bisogna usare executeQuery che ritornetà un ResultSet (QUINDI SI USA SOLO PER INTERROGAZIONI AL DB)
			//res funziona come un iteratore 

			if(res.next()) { //res è bool quindi quando res.next() sarà true entrerà nell'if e ritornerà il permesso di un determinato account
				return res.getInt("id");//ritorniamo il valore specificando il nome del campo che vogliamo prendere dal result set
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore ricerca e-mail");
		}

		return 0;
	}
	
	public int modificaAccount(Account a, int idaccount) {
		
		int result = 0;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();

		String query = "UPDATE account SET email=?,username=?,password=? WHERE id = ?";
		// andiamo a fare una query per prendere tutte le colonne della tabella corriere che ha come campo piva quella passata al metodo
	
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); //andiamo a preparare la query
			stat.setString(1, a.getEmail());
			stat.setString(2, a.getUsername()); 
			stat.setString(3, a.getPassword());
			stat.setInt(4, idaccount); //nella clausola where
			
			result = stat.executeUpdate(); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore modifica");
		}
		
		return result;
		
	}
	
	public int eliminaAccount(int id) {
		
		int result = 0;
		
		Connessione istanza = Connessione.getIstanza(); //crea un' istanza per poter usare il metodo getConnection per effettuare una connessione al DB
		Connection conn = istanza.getConnection();

		String query = "DELETE FROM account WHERE id = ?";
		// andiamo a fare una query per eliminare le righe dal DB che rispettando le condizioni del where, cioè la partita iva deve
		//essere uguale a quella passata al metodo
		
		PreparedStatement stat; //è un oggetto che contiene uno statement precompilato in SQL per eseguire in modo efficiente una query più volte
		try {
			stat = conn.prepareStatement(query); // andiamo a preparare la query
			stat.setInt(1, id);     // "imposta" il primo punto interrogativo al valore che gli passiamo voi di piva
			
			System.out.println("Lo stat è " + stat);
			
			result = stat.executeUpdate();  // executeUpdate è diverso da execute query

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Errore eliminazione account");
		}

		
		
		return result;
	}
}
