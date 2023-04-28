package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String senha;
	public static Map<String, Pessoa> mapaPessoa = new HashMap<String, Pessoa>();

	public Pessoa() {
	}

	public Pessoa(String nome, String senha, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}
}
