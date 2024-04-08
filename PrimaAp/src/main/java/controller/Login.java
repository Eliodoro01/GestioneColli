package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountCrud;
import model.CorriereCrud;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountCrud acc = new AccountCrud();
		CorriereCrud c; 
		ResultSet rs;
		
		HttpSession session = request.getSession(); 	//crea una sessione un po come se fosse un singleton assegnando un id randomico mettendolo nei cookie
		
		String user = request.getParameter("username"); //tramite metodo GET specificato nel form di login nel file login.jsp 
		String pass = request.getParameter("password"); //andiamo a prendere i dati inseriti dall'utente e li "mettiamo" in queste variabili 
		
		System.out.println("l'user è " + user);
		System.out.println("la pass è " + pass);
		
		String permesso = acc.verificaLogin(user, pass); // creaiamo una stringa permesso dove mettere il permesso dell'account 
		
		if(permesso.equals("guest")) { 							//nella sessione possiamo mettere tutte le informazioni che vogliamo	
			
			//System.out.println("ciao");
			c = new CorriereCrud();
			try {
				rs = c.getId(user, pass);
				if(rs.next() ) {
					session.setAttribute("id", rs.getInt("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			session.setAttribute("permesso", permesso); //gli passiamo "l'etichetta name" del permesso come se fosse un id e il valore, che è il permesso vero e proprio		
			request.setAttribute("success", "Login effettuato correttamente");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		
		else if(permesso.equals("admin")) {
			session.setAttribute("permesso", permesso); //gli passiamo "l'etichetta name" del permesso come se fosse un id e il valore, che è il permesso vero e proprio		
			request.setAttribute("success", "Login effettuato correttamente");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			
			request.setAttribute("error", "Login fallito");
			RequestDispatcher rd = request.getRequestDispatcher("error_login.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
