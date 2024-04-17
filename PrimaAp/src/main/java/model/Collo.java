package model;


import util.Observer;

public class Collo{

	private String codice;
	private String mittente;
	private String destinatario;
	private int peso;
	private int idveicolo;
	private String stato;
	
	private int id;
	
	public Collo(int id, int peso) {
        this.id = id;
        this.peso = peso;
    }
	
	public Collo() {}

    public int getPeso() {
        return peso;
    }

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getMittente() {
		return mittente;
	}

	public void setMittente(String mittente) {
		this.mittente = mittente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public int getIdveicolo() {
		return idveicolo;
	}

	public void setIdveicolo(int idveicolo) {
		this.idveicolo = idveicolo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}



	public void setPeso(int peso) {
		this.peso = peso;
	}


	@Override
	public String toString() {
		return "Collo [codice=" + codice + ", mittente=" + mittente + ", destinatario=" + destinatario + ", peso="
				+ peso + ", idveicolo=" + idveicolo + ", stato=" + stato + ", id=" + id + "]";
	}
	
	

}