package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione { //SINGLETON

	private static Connessione istanza = null;
	
	//JDBC driver and db url
	static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost:3306/gestionecolli";
	static final String UserDB ="root";
	static final String PasswordDB ="";
	
	
	private static Connection conn = null;
	
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL, UserDB, PasswordDB);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized Connessione getIstanza() {
		if(istanza == null )
			istanza = new Connessione();	//se non c'è un oggetto di tipo Connessione chiamato istanza lo va a creare
		
		return istanza;						//ritorna l'oggetto istanza per poter usare i metodi della classe Connessione
	}
	
	public Connection getConnection() {
		
		return conn;
	}
	
	private Connessione() {
		
	}
}
