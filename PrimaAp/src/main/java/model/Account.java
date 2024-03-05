package model;

import java.util.Objects;

public class Account {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private int idpermesso;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getIdpermesso() {
		return idpermesso;
	}
	public void setIdpermesso(int idpermesso) {
		this.idpermesso = idpermesso;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id, idpermesso, password, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(email, other.email) && id == other.id && idpermesso == other.idpermesso
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", idpermesso=" + idpermesso + "]";
	}
	
	
	public Account(int id, String username, String email, String password, int idpermesso) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.idpermesso = idpermesso;
	}
	
	
	public Account() {
		
	
	}
	
	

}
