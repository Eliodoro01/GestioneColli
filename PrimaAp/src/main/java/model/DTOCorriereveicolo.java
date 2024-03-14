package model;

public class DTOCorriereveicolo {

	private int idcorriere;
	private String nome;
	private String piva;
	private String indirizzo;
	private String telefono;
	private String citta;
	private String cap;
	int capienza;
	String codice;
	String tipo;
	
	
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
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "DTOCorriereveicolo [idcorriere=" + idcorriere + ", nome=" + nome + ", piva=" + piva + ", indirizzo="
				+ indirizzo + ", telefono=" + telefono + ", citta=" + citta + ", cap=" + cap + ", capienza=" + capienza
				+ ", codice=" + codice + ", tipo=" + tipo + ", getIdcorriere()=" + getIdcorriere() + ", getNome()="
				+ getNome() + ", getPiva()=" + getPiva() + ", getIndirizzo()=" + getIndirizzo() + ", getTelefono()="
				+ getTelefono() + ", getCitta()=" + getCitta() + ", getCap()=" + getCap() + ", getCapienza()="
				+ getCapienza() + ", getCodice()=" + getCodice() + ", getTipo()=" + getTipo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
