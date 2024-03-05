package model;

import java.util.Objects;

public class Permesso {
	
	private int id;
	private String permesso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermesso() {
		return permesso;
	}
	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, permesso);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permesso other = (Permesso) obj;
		return id == other.id && Objects.equals(permesso, other.permesso);
	}
	
	@Override
	public String toString() {
		return "Permesso [id=" + id + ", permesso=" + permesso + "]";
	}
	
	public Permesso(int id, String permesso) {
		super();
		this.id = id;
		this.permesso = permesso;
	}
	
	
	public Permesso() {
		super();
		// TODO Auto-generated constructor stub
	}

}
