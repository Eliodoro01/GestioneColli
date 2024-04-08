package model;

public class DTOCorrierecollo {

	private int idcorriere;
	private String nome;
	private String piva;
	private String indirizzo;
	private String telefono;
	private String citta;
	private String cap;
	private int idaccount;
	private String codice;
	private String mittente;
	private String destinatario;
	private int peso;
	private int idveicolo;
	private String stato;
	
	private int idcollo;

	public int getIdcorriere() {
		return idcorriere;
	}

	public void setIdcorriere(int idcorriere) {
		this.idcorriere = idcorriere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public int getIdaccount() {
		return idaccount;
	}

	public void setIdaccount(int idaccount) {
		this.idaccount = idaccount;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
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

	public int getIdcollo() {
		return idcollo;
	}

	public void setIdcollo(int idcollo) {
		this.idcollo = idcollo;
	}

	@Override
	public String toString() {
		return "DTOCorrierecollo [idcorriere=" + idcorriere + ", nome=" + nome + ", piva=" + piva + ", indirizzo="
				+ indirizzo + ", telefono=" + telefono + ", citta=" + citta + ", cap=" + cap + ", idaccount="
				+ idaccount + ", codice=" + codice + ", mittente=" + mittente + ", destinatario=" + destinatario
				+ ", peso=" + peso + ", idveicolo=" + idveicolo + ", stato=" + stato + ", idcollo=" + idcollo + "]";
	}
	
	
	
}
