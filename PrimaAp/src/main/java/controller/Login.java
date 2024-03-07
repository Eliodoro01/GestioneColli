package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountCrud;

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
		HttpSession session = request.getSession(); 	//crea una sessione un po come se fosse un singleton assegnando un id randomico mettendolo nei cookie
		
		String user = request.getParameter("username"); //tramite metodo GET specificato nel form di login nel file login.jsp 
		String pass = request.getParameter("password"); //andiamo a prendere i dati inseriti dall'utente e li "mettiamo" in queste variabili 
		
		System.out.println("l'user è " + user);
		System.out.println("la pass è " + pass);
		
		String permesso = acc.verificaLogin(user, pass); // creaiamo una stringa permesso dove mettere il permesso dell'account 
		
		if(permesso != null) { 							//nella sessione possiamo mettere tutte le informazioni che vogliamo
			session.setAttribute("permesso", permesso); //gli passiamo "l'etichetta name" del permesso come se fosse un id e il valore, che è il permesso vero e proprio
			request.setAttribute("success", "Login effettuato correttamente");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Login fallito");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); //passa il testimone alla jsp
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
