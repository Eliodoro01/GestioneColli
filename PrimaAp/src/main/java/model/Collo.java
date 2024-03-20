package model;


import util.Observer;

public class Collo implements Observer{

	private String codice;
	private String mittente;
	private String destinatario;
	private int peso;
	private int idveicolo;
	private String stato;
	
	private String id;
	
	public Collo(String id, int peso) {
        this.id = id;
        this.peso = peso;
    }
	
	public Collo() {}

    public int getPeso() {
        return peso;
    }

    public String getId() {
        return id;
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

	public void setId(String id) {
		this.id = id;
	}

	public void update(Collo collo) {
		// TODO Auto-generated method stub
		
	}
	
	

}