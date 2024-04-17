package model;

import java.util.ArrayList;
import java.util.List;

public class Veicolo extends Observable{
	
	private int capienza;
	private String codice;
	private String tipo;
	private int idcorriere;
	private int id;
    private int caricoAttuale;
    

    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdcorriere() {
		return idcorriere;
	}

	public void setIdcorriere(int idcorriere) {
		this.idcorriere = idcorriere;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapienza() {
		return capienza;
	}

	public String getCodice() {
		return codice;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCaricoAttuale() {
		return caricoAttuale;
	}

	public void setCaricoAttuale(int caricoAttuale) {
		this.caricoAttuale = caricoAttuale;
	}


	@Override
	public String toString() {
		return "Veicolo [capienza=" + capienza + ", codice=" + codice + ", tipo=" + tipo + ", idcorriere=" + idcorriere
				+ ", caricoAttuale=" + caricoAttuale ;
	}
	
	
	//TODO inserire i veicoli con un form
	

}
