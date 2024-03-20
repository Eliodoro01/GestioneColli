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

import model.Account;
import model.AccountCrud;
import model.Corriere;
import model.CorriereCrud;
import model.DTOAccountcorriere;
import model.Veicolo;
import model.VeicoloCrud;

/**
 * Servlet implementation class InserimentoVeicolo
 */
@WebServlet("/InserimentoVeicolo")
public class InserimentoVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoVeicolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("prova");
	//ArrayList<DTOAccountcorriere> array = new ArrayList<DTOAccountcorriere>();
		ArrayList<Veicolo> array = new ArrayList<Veicolo>();
		
		VeicoloCrud crud = new VeicoloCrud();
		
		int id = (int) request.getSession().getAttribute("id");
		System.out.println("l'id è " + id);
		
		ResultSet rs = crud.getListaVeicoli(id);
	
		try {
			while(rs.next()) {
				Veicolo v = new Veicolo();
				v.setCapienza(rs.getInt("capienza"));
				v.setCodice(rs.getString("codice"));
				v.setTipo(rs.getString("tipo"));
				v.setCaricoAttuale(rs.getInt("caricoattuale"));
				v.setIdcorriere(rs.getInt("idcorriere"));
				
				array.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Veicolo tipoVeicolo : array) {
			System.out.println(tipoVeicolo);
		} 
		request.setAttribute("lista", array);
		RequestDispatcher rd = request.getRequestDispatcher("gestione_veicoli.jsp"); //passa il testimone alla jsp
		rd.forward(request, response); //avviene il passaggio
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Veicolo v = new Veicolo();
		VeicoloCrud crud = new VeicoloCrud();
		CorriereCrud corr = new CorriereCrud();
		Corriere c = new Corriere();
		
		int id = (int) request.getSession().getAttribute("id");
		
		//BISOGNA PASSARE DI NASCOSTO LA PIVA DEL CORRIERE CHE VOGLIAMO COLLEGARE AL VEICOLO
		
		v.setTipo(request.getParameter("tipo"));	//preparo il veicolo che andrò ad inserire							
		v.setCapienza(Integer.parseInt(request.getParameter("capienza")));
		v.setCodice(request.getParameter("codice"));
		v.setIdcorriere(id); //setto l'id del corriere come id del veicolo
		
			if(crud.inserimentoVeicolo(v)>0) { //se l'inserimento del veicolo va a buon fine si viene reindirizzati alla home
					//TODO gestire una pagina di corretto inserimento del corriere
					request.setAttribute("success", "Registrazione effettuata correttamente");
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
					rd.forward(request, response); //avviene il passaggio
				}

				else {
					//TODO pagina che genera un errore legato al corriere
					request.setAttribute("error", "Registrazione non avvenuta. Errore nella creazione del corriere");
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); //passa il testimone alla jsp
					rd.forward(request, response); //avviene il passaggio
				}

			}
		
	}

