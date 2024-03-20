package model;

import java.util.ArrayList;
import java.util.List;

public class Veicolo extends Observable{
	
	private int capienza;
	private String codice;
	private String tipo;
	private int idcorriere;
	
    private int caricoAttuale;
    private List<Collo> colliCaricati;
	

    public void caricaCollo(Collo collo) {
        if (caricoAttuale + collo.getPeso() <= capienza) {
            colliCaricati.add(collo);
            caricoAttuale += collo.getPeso();
            notifyObservers(collo);
            
        } else {
            System.out.println("Veicolo " + codice + " pieno. Impossibile caricare il collo.");
        }
    }

    public List<Collo> getColliCaricati() {
        return colliCaricati;
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

	public void setColliCaricati(List<Collo> colliCaricati) {
		this.colliCaricati = colliCaricati;
	}

	@Override
	public String toString() {
		return "Veicolo [capienza=" + capienza + ", codice=" + codice + ", tipo=" + tipo + ", idcorriere=" + idcorriere
				+ ", caricoAttuale=" + caricoAttuale + ", colliCaricati=" + colliCaricati + "]";
	}
	
	
	//TODO inserire i veicoli con un form
	

}
