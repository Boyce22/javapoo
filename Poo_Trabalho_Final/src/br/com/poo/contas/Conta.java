package br.com.poo.contas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import br.com.poo.cargos.Cliente;

public abstract class Conta extends Cliente {

	private String tipoConta;
	private String agencia;
	private String numConta;
	private String titular;
	private String cpf;
	private Integer totalSaques = 0;
	private Integer totalDepositos = 0;
	private Integer totalTransferencias = 0;
	protected Double saldo = 0.0;

	public static Map<String, Conta> mapaContas = new HashMap<>();
	public static TreeMap<String, Conta> ordenaContas = new TreeMap<>();

	public Conta() {

	}

	public Conta(String tipoConta, String agencia, String numConta, String titular, String cpf, Double saldo) {
		super();
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.numConta = numConta;
		this.titular = titular;
		this.cpf = cpf;
		this.saldo = saldo;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public String getTitular() {
		return titular;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Integer getTotalSaques() {
		return totalSaques;
	}

	public Integer getTotalDepositos() {
		return totalDepositos;
	}

	public Integer getTotalTransferencias() {
		return totalTransferencias;
	}

	public void sacar(Double valor) {
		this.saldo = this.saldo < valor ? this.saldo : this.saldo - valor;
		++totalSaques;
	}

	public void depositar(Double valor) {
		if (this.saldo == null) {
			this.saldo = 0.0;
		} else {
			this.saldo += valor;
			++totalDepositos;

		}
	}

	public void transferir(Double valor, Conta destino) {
		sacar(valor);
		destino.depositar(valor);
		++totalTransferencias;
	}

	@Override
	public String toString() {
		return "\nTitular: " + titular + "\nTipo de Conta: " + tipoConta + "\nAgência: " + agencia
				+ "\nNúmero da Conta: " + numConta + "\nCPF: " + cpf;
	}

}