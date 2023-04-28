package br.com.poo.contas;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
		setTipoConta("corrente");
	}

	public ContaCorrente(String tipoConta, String agencia, String numConta, String titular, String cpf, Double saldo) {
		super(tipoConta, agencia, numConta, titular, cpf, saldo);
	}

	@Override

	public void sacar(Double valor) {
		if (super.saldo >= valor + 0.3) {
			super.saldo -= valor + 0.3;
			System.out.println("\nOperação realizada com sucesso!");
			System.out.printf("\nValor sacado: R$%.2f ", valor);
			System.out.printf("\nTaxa para saque: R$ 0.30\n");
			System.out.printf("\nSaldo atual: R$%.2f ", super.saldo);
		} else {
			System.out.println("Valor inserido + o tributo excede o saldo disponível!");
		}
	}

	@Override
	public void depositar(Double valor) {
		if (super.saldo == null) {
			super.saldo = 0.0;
		}
		super.saldo += valor - 0.1;
		System.out.println("\nOperação realizada com sucesso!");
		System.out.printf("\nValor depositado: R$%.2f ", valor);
		System.out.printf("\nTaxa para depósito: R$ 0.10\n");
		System.out.printf("\nSaldo atual: R$%.2f ", super.saldo);
	}

	@Override

	public void transferir(Double valor, Conta destino) {
		if (super.saldo >= valor + 0.2) {
			super.saldo -= valor + 0.2;
			destino.depositar(valor);
			System.out.println("\nOperação realizada com sucesso!");
			System.out.printf("\nValor transferido: R$%.2f", valor);
			System.out.printf("\nTaxa de transferência: R$ 0.20\n");
			System.out.printf("\nSaldo atual: R$ " + super.saldo);

		} else {
			System.out.println("Valor inserido + taxa de transferência excede o saldo disponível!");
		}
	}
}
