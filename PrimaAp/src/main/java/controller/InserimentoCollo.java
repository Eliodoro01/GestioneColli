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

import model.CentroSmistamento;
import model.Collo;
import model.ColloCrud;
import model.Corriere;
import model.CorriereCrud;
import model.Veicolo;
import model.VeicoloCrud;

/**
 * Servlet implementation class InserimentoCollo
 */
@WebServlet("/InserimentoCollo")
public class InserimentoCollo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoCollo() {
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
		Collo c = new Collo();
		ColloCrud crud = new ColloCrud();
		Veicolo v = new Veicolo();
		VeicoloCrud vcrud = new VeicoloCrud();
		CentroSmistamento s = new CentroSmistamento();
		
		boolean flag = false;
		
		c.setMittente(request.getParameter("mittente"));
		c.setDestinatario(request.getParameter("destinatario"));
		c.setCodice(request.getParameter("codice"));
		c.setPeso(Integer.parseInt(request.getParameter("peso")));
		
		
		int id = (int) request.getSession().getAttribute("id"); //questo è l'id del corriere su cui stiamo andando a lavorare e quindi dei suoi veicoli su cui caricare i colli
		//System.out.println("l'id è " + id);
		
		ResultSet rs = vcrud.getListaVeicoli(id);
	
		try {	//QUI SI VA AD IMPLEMENTARE UN ALGORITMO DI NEXT FIT 
			while(rs.next()) //in questo rs sono presenti tutti i veicoli, quindi itera finchè non trova il veicolo con la capienza abbastanza grande da contenere il collo da inserire
				{
//				System.out.println("il peso è " + c.getPeso());
//				System.out.println("il carico attuale è " + rs.getInt("caricoattuale"));
//				System.out.println("la capienza è " + rs.getInt("capienza"));
				
				s.riceviCollo(c, v);
				/*if((c.getPeso() + (rs.getInt("caricoattuale"))) <= (rs.getInt("capienza")) ){ 
					//se il peso del collo da inserire + il carico attuale del veicolo sono < della capienza massima del veicolo 
					//allora il collo potrà essere inserito nel veicolo corrente
					
					flag = true; //impostiamo questo flag TRUE per gestire in seguito il reindirizzamento ad una pagina di "success"
					
					crud.inserimentoCollo(c, rs.getInt("id")); //inseriamo il collo nel veicolo con l'id che andiamo a recuperare dal ResultSet
					
					s.riceviCollo(c, v); //pattern che notifica all'osservatore l'inserimento del collo nel veicolo
					
					vcrud.update((c.getPeso() + (rs.getInt("caricoattuale"))), rs.getInt("id")); //aggiorniamo il carico attuale del veicolo
					break;
				}*/
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) { //se il flag è true significa che si è entrati nell'if precedente e quindi è stato trovato un veicolo con il carico attuale abbastanza grande da contenere un collo
			request.setAttribute("success", "Inserimento collo avvenuto");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}
		
		else {
		request.setAttribute("error", "Non è stato possibile inserire il collo");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); //passa il testimone alla jsp
		rd.forward(request, response); //avviene il passaggio
		}
	}

}
