package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorriereCrud;

/**
 * Servlet implementation class EliminaCorriere
 */
@WebServlet("/EliminaCorriere")
public class EliminaCorriere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaCorriere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String piva = request.getParameter("piva"); //recuperiamo la piva del corriere che vogliamo eliminare che ci è stata passata dal form
	
		CorriereCrud corr = new CorriereCrud(); //instanziamo un oggetto di tipo corriereCrud per usare i suoi metodi, in questo caso eliminazione
		
		if(corr.eliminaCorriere(piva) > 0) { //eliminaCorriere se va a buon fine ritorna il numero di righe eliminate quindi se ritorna un valore positivo si viene reindirizzati alla home	
			
			request.setAttribute("success", "Corriere eliminato correttamente"); //messaggi che visualizza solo l'admin
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Eliminazione corriere fallita");
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
