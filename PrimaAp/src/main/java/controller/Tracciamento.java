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

import model.Collo;
import model.ColloCrud;
import model.DTOCorrierecollo;

/**
 * Servlet implementation class Tracciamento
 */
@WebServlet("/Tracciamento")
public class Tracciamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tracciamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("codice");
		System.out.println("Il codice di tracciamento " + codice);
		ColloCrud crud = new ColloCrud();
		DTOCorrierecollo c = new DTOCorrierecollo();
		
        ResultSet rs = crud.getCollo(codice);
		
		try {
			while(rs.next()) {
				System.out.println("Siamo nel rs");
				c.setCodice(codice);
				c.setDestinatario(rs.getString("destinatario"));				
				c.setMittente(rs.getString("mittente"));
				c.setPeso(rs.getInt("peso"));
				c.setStato(rs.getString("stato"));
				c.setNome(rs.getString("nome"));
				c.setTelefono(rs.getString("telefono"));
				c.setCitta(rs.getString("citta"));			
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(c != null ) {
		
			System.out.println(c);
			request.setAttribute("success", "Il collo è stato trovato");
			request.setAttribute("collo", c);
			RequestDispatcher rd = request.getRequestDispatcher("dettaglio_tracciamento.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Il collo non è stato trovato");
			RequestDispatcher rd = request.getRequestDispatcher("dettaglio_tracciamento.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio		
		}
		
	}

}
