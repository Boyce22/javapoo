package br.com.poo.enums;

public enum PessoaEnum {
	
	
	CLIENTE("cliente", 1),
	OPERADOR_CAIXA("caixa",2),
	GERENTE("gerente",3),
	DIRETOR("diretor",4),
	PRESIDENTE("presidente",5);
	

	private String cargo;
	private int id;

	private PessoaEnum(String cargo, int id) {
		this.cargo = cargo;
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public int getId() {
		return id;
	}
	
}
