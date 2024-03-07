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

import model.Corriere;
import model.CorriereCrud;
import model.DTOAccountcorriere;

/**
 * Servlet implementation class ModificaCorriere
 */
@WebServlet("/ModificaCorriere")
public class ModificaCorriere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCorriere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String piva = request.getParameter("piva");
		
		DTOAccountcorriere c = new DTOAccountcorriere();
		CorriereCrud crud = new CorriereCrud();
		ResultSet rs = crud.getCorriere(piva);
		
		try {
			if(rs.next()) {
				
				c.setNome(rs.getString("nome"));
				c.setCap(rs.getString("cap"));
				c.setCitta(rs.getString("citta"));
				c.setIndirizzo(rs.getString("indirizzo"));
				c.setPiva(rs.getString("piva"));
				c.setTelefono(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setIdaccount(rs.getInt("idaccount"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);
		request.setAttribute("corriere", c);
		RequestDispatcher rd = request.getRequestDispatcher("form_inserimento_corriere.jsp"); //passa il testimone alla jsp
		rd.forward(request, response); //avviene il passaggio
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Corriere c = new Corriere();
		CorriereCrud crud = new CorriereCrud();
		String pivaOld = request.getParameter("pold");
		int id = Integer.parseInt(request.getParameter("idaccount"));
		
		c.setNome(request.getParameter("nome"));
		c.setIndirizzo(request.getParameter("indirizzo"));
		c.setCap(request.getParameter("cap"));
		c.setCitta(request.getParameter("citta"));
		c.setPiva(request.getParameter("piva"));
		c.setTelefono(request.getParameter("telefono"));
		
		
		if(crud.modificaCorriere(pivaOld, c) > 0 ) { 							
			
			request.setAttribute("success", "Modifica effettuata correttamente");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		else {
			request.setAttribute("error", "Errore nella modifica");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
	}

}
