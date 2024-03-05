package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
