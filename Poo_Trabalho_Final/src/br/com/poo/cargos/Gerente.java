package br.com.poo.cargos;

//import java.util.HashMap;
//import java.util.Map;

//10% da bonificação do Funcionario(R$ 5.00) somado a 15% sobre o seu salário;

public class Gerente extends Funcionario {
	// public static Map<String, Gerente> mapaGerente = new HashMap<String,
	// Gerente>();

	private String tipoFuncionario;
	private String nome;
	private String cpf;
	private String senha;
	private Double salario;
	private String agenciaResp;

	public Gerente(String tipoFuncionario, String nome, String cpf, String senha, Double salario, String agenciaResp) {
		super(tipoFuncionario, nome, cpf, senha, salario);
		this.tipoFuncionario = tipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.salario = salario;
		this.agenciaResp = agenciaResp;
		setTipoFuncionario("gerente");
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

	public String getAgenciaResp() {
		return agenciaResp;
	}

	@Override

	public Double getBonificacao() {
		return super.getSalario() * 0.20;
	}

}