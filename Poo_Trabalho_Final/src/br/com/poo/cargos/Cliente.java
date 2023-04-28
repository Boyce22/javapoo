package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Pessoa {

	private String tipoCliente;
	private String nome;
	private String cpf;
	private String senha;

	public static Map<String, Cliente> mapaCliente = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(String tipoCliente, String nome, String cpf, String senha) {
		super();
		this.tipoCliente = tipoCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

}