package model;

public class DTOAccountcorriere {
	
	private String username;
	private String email;
	private String password;
	private String nome;
	private String piva;
	private String indirizzo;
	private String telefono;
	private String citta;
	private String cap;
	private int idaccount;
	
	
	public int getIdaccount() {
		return idaccount;
	}
	public void setIdaccount(int idaccount) {
		this.idaccount = idaccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	@Override
	public String toString() {
		return "DTOAccountcorriere [username=" + username + ", email=" + email + ", password=" + password + ", nome="
				+ nome + ", piva=" + piva + ", indirizzo=" + indirizzo + ", telefono=" + telefono + ", citta=" + citta
				+ ", cap=" + cap + "]";
	}
	
	
}
