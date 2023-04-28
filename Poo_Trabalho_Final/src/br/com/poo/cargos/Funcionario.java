package br.com.poo.cargos;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Funcionario extends Pessoa {

	public static Map<String, Funcionario> mapaFuncionarios = new HashMap<String, Funcionario>();
	public static TreeMap<String, Funcionario> ordenaFuncionarios = new TreeMap<>();

	private String tipoFuncionario;
	private String nome;
	private String cpf;
	private String senha;
	private Double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String tipoFuncionario, String nome, String cpf, String senha, Double salario) {
		super();
		this.tipoFuncionario = tipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.salario = salario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
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

	public Double getSalario() {
		return salario;
	}

	public Double getBonificacao() {
		return getSalario() * 0.10;
	}
}
