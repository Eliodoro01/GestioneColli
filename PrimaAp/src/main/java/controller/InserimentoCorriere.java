package controller;

import java.io.IOException;

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

/**
 * Servlet implementation class InserimentoCorriere
 */
@WebServlet("/InserimentoCorriere")
public class InserimentoCorriere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserimentoCorriere() {
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
		// TODO Auto-generated method stub

		Corriere corr = new Corriere();
		Account acc = new Account();
		AccountCrud crud = new AccountCrud();
		CorriereCrud corcrud = new CorriereCrud();

		acc.setEmail(request.getParameter("email"));
		acc.setUsername(request.getParameter("username"));
		acc.setPassword(request.getParameter("password"));

		int idacc = -1;

		if(crud.inserimentoAccount(acc) > 0)
		{
			idacc = crud.ricercaAccount(acc.getEmail());
			if(idacc > 0) 
			{ // solo se andiamo a creare correttamente un account andiamo ad  inizializzare un corriere con un determinato idaccount
				acc.setId(idacc);

				corr.setNome(request.getParameter("nome"));
				corr.setTelefono(request.getParameter("telefono"));
				corr.setPiva(request.getParameter("piva"));
				corr.setCitta(request.getParameter("città"));
				corr.setIndirizzo(request.getParameter("indirizzo"));
				corr.setCap(request.getParameter("cap"));

				corr.setIdaccount(idacc);

				if(corcrud.inserimentoCorriere(corr)>0) {
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
			else {
				// TODO qui bidognerà gestire una pagina in caso di errore 
				request.setAttribute("error", "Registrazione non avvenuta. Errore nella creazione dell'account");
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); //passa il testimone alla jsp
				rd.forward(request, response); //avviene il passaggio
			}
		}

		else {
			// TODO qui bidognerà gestire una pagina in caso di errore 
			request.setAttribute("error", "Registrazione non avvenuta. Errore nella ricerca dell'account");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); //passa il testimone alla jsp
			rd.forward(request, response); //avviene il passaggio
		}




	}

}
