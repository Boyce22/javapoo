package br.com.poo.cargos;

public class OperadorCaixa extends Funcionario {

	private String tipoFuncionario;
	private String nome;
	private String cpf;
	private String senha;
	private Double salario;

	public OperadorCaixa(String tipoFuncionario, String nome, String cpf, String senha, Double salario) {
		super(tipoFuncionario, nome, cpf, senha, salario);
		this.tipoFuncionario = tipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.salario = salario;
		setTipoFuncionario("caixa");
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

	public Double getSalario1() {
		return salario;
	}

	@Override

	public Double getBonificacao() {
		return super.getSalario() * 0.15;
	}
}
