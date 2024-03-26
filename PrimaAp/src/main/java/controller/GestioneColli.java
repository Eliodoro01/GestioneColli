package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Collo;
import model.ColloCrud;
import model.Veicolo;
import model.VeicoloCrud;

/**
 * Servlet implementation class GestioneColli
 */
@WebServlet("/GestioneColli")
public class GestioneColli extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ArrayList<Collo> array = new ArrayList<Collo>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneColli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("l'id del veicolo é " + request.getParameter("id"));
		
		//ArrayList<Collo> array = new ArrayList<Collo>();		
		VeicoloCrud crud = new VeicoloCrud();
	
		ResultSet rs = crud.getColli(Integer.parseInt(request.getParameter("id")));
		
		try {
			while(rs.next()) {
				Collo c = new Collo();
				c.setCodice(rs.getString("codice"));
				c.setDestinatario(rs.getString("destinatario"));
				c.setId(rs.getInt("id"));
				c.setIdveicolo(rs.getInt("idveicolo"));
				c.setMittente(rs.getString("mittente"));
				c.setPeso(rs.getInt("peso"));
				c.setStato(rs.getString("stato"));
				
				array.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Collo collo : array) {
			System.out.println("il collo è " + collo);
		}
		request.setAttribute("lista", array);
		RequestDispatcher rd = request.getRequestDispatcher("gestione_colli.jsp"); //passa il testimone alla jsp
		rd.forward(request, response); //avviene il passaggio
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("La mia scelta è " + request.getParameter("stato"));
		System.out.println("L'id collo è " + request.getParameter("idcollo"));
	
		
		String stato = request.getParameter("stato");
		int idcollo = Integer.parseInt(request.getParameter("idcollo"));
		int idveicolo = Integer.parseInt(request.getParameter("idveicolo"));
		ColloCrud crud = new ColloCrud();
		
		int result = crud.updateStato(idcollo, stato);
		
		for (Collo collo : array) {
			if(collo.getId() == idcollo) 
				collo.setStato(stato);		
		}
		
		if(result > 0) {
		
			request.setAttribute("lista", array);
			RequestDispatcher rd = request.getRequestDispatcher("gestione_colli.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Non è stato possibile aggiornare il collo");
			RequestDispatcher rd = request.getRequestDispatcher("gestione_colli.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
	}

}
