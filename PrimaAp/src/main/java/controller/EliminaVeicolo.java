package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiSystem;

import model.CorriereCrud;
import model.VeicoloCrud;

/**
 * Servlet implementation class EliminaVeicolo
 */
@WebServlet("/EliminaVeicolo")
public class EliminaVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaVeicolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("codice"); //recuperiamo la piva del corriere che vogliamo eliminare che ci è stata passata dal form
	
		VeicoloCrud v = new VeicoloCrud(); //instanziamo un oggetto di tipo corriereCrud per usare i suoi metodi, in questo caso eliminazione
		
		if(v.eliminaVeicolo(codice) > 0) { //eliminaCorriere se va a buon fine ritorna il numero di righe eliminate quindi se ritorna un valore positivo si viene reindirizzati alla home	
			
			request.setAttribute("success", "Veicolo eliminato correttamente"); //messaggi che visualizza solo l'admin
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Eliminazione veicolo fallita");
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
