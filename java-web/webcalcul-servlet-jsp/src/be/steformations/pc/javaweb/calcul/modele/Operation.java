package be.steformations.pc.javaweb.calcul.modele;

public enum Operation {

	ADDITION("+"), SOUSTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

	private final String signe;
	
	private Operation(String signe) {
		this.signe = signe;
	}
	
	public String getSigne() {
		return signe;
	}
}
