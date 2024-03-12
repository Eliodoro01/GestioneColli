package model;

import util.Veicolo;

public class TipoVeicolo implements Veicolo{
	
	int capienza;
	String codice;
	String tipo;

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
	
	//TODO inserire i veicoli con un form

}
