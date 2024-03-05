package model;

import java.util.Objects;

public class Corriere {
	
	private int id;
	private String nome;
	private String piva;
	private String indirizzo;
	private String telefono;
	private String citta;
	private String cap;
	private int idaccount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(cap, citta, id, idaccount, indirizzo, nome, piva, telefono);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corriere other = (Corriere) obj;
		return Objects.equals(cap, other.cap) && Objects.equals(citta, other.citta) && id == other.id
				&& idaccount == other.idaccount && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(nome, other.nome) && Objects.equals(piva, other.piva)
				&& Objects.equals(telefono, other.telefono);
	}
	
	@Override
	public String toString() {
		return "Corriere [id=" + id + ", nome=" + nome + ", piva=" + piva + ", indirizzo=" + indirizzo + ", telefono="
				+ telefono + ", citta=" + citta + ", cap=" + cap + ", idaccount=" + idaccount + "]";
	}
	
	public Corriere(int id, String nome, String piva, String indirizzo, String telefono, String citta, String cap,
			int idaccount) {
		super();
		this.id = id;
		this.nome = nome;
		this.piva = piva;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.citta = citta;
		this.cap = cap;
		this.idaccount = idaccount;
	}
	
	
	public Corriere() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
