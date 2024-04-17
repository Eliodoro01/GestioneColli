package model;

public class CentroSmistamento {
	
	public String notify(Corriere corriere) {

		return "Il collo è stato aggiunto e si trova al seguete indirizzo: " + corriere.getIndirizzo() ;
	}
}
