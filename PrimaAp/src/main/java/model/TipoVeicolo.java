package model;

import util.Veicolo;

public class TipoVeicolo implements Veicolo{
	
	int capienza;
	String codice;
	String tipo;
	int idcorriere;

	public int getIdcorriere() {
		return idcorriere;
	}

	public void setIdcorriere(int idcorriere) {
		this.idcorriere = idcorriere;
	}

	@Override
	public void setCapienza(int capienza) {

		this.capienza = capienza;
	}

	@Override
	public void setTipo(String tipo) {
		
		this.tipo = tipo;
	}

	@Override
	public void setCodice(String codice) {
		
		this.codice = codice;
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
	
	//TODO inserire i veicoli con un form
	

}
