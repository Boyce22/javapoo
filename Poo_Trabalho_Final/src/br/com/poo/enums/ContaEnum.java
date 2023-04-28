package br.com.poo.enums;

public enum ContaEnum {

	CORRENTE("corrente", 1),
	POUPANCA("poupanca", 2);

	private String tipoConta;
	private int id;
	
	ContaEnum(String tipoConta, int id) {
		this.tipoConta = tipoConta;
		this.id = id;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getId() {
		return id;
	}
	
}