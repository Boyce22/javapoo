package br.com.poo.cargos;

public class Diretor extends Funcionario {

	private String tipoFuncionario;
	private String nome;
	private String cpf;
	private String senha;
	private Double salario;
	private String agenciaDiretor;

	public Diretor(String tipoFuncionario, String nome, String cpf, Double salario, String senha) {
		super(tipoFuncionario, nome, cpf, senha, salario);
		this.tipoFuncionario = tipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.salario = salario;
		setTipoFuncionario("diretor");
	}

	public Diretor(String agenciaDiretor) {
		super();
		this.agenciaDiretor = agenciaDiretor;
	}

	public String tipoFuncionario() {
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

	public String getAgenciaDiretor() {
		return agenciaDiretor;
	}
	@Override

	public Double getBonificacao() {
		return super.getSalario() * 0.30;
	}
}