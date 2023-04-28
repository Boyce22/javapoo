package br.com.poo.contas;

public class ContaPoupanca extends Conta {

	private Double rendimento;

	public ContaPoupanca() {
		super();
		setTipoConta("poupanca");
	}

	public ContaPoupanca(String tipoConta, String agencia, String numConta, String titular, String cpf, Double saldo) {
		super(tipoConta, agencia, numConta, titular, cpf, saldo);
		setTipoConta("poupanca");
	}

	public Double calcularRendimento(Conta conta) {
		rendimento = 0.05 * conta.getSaldo();
		return rendimento;
	}

	public static Double previsaoRendimento(Conta conta, Double valor, int dias) {
		ContaPoupanca cp = new ContaPoupanca();
		Double rendimentoTotal = cp.calcularRendimento(conta) * dias / 30.0;
		System.out.printf("\nO valor do rendimento para %d dias é de: R$%.2f\n", dias, rendimentoTotal);
		return rendimentoTotal;
	}

	public Double getSaldo() {
		return super.getSaldo();
	}

	@Override

	public void sacar(Double valor) {
		if (super.saldo >= valor + 0.6) {
			super.saldo -= valor + 0.6;
			System.out.println("\nOperação realizada com sucesso!");
			System.out.printf("\nValor sacado: R$%.2f ", valor);
			System.out.printf("\nTaxa para saque: R$ 0.60\n");
			System.out.printf("\nSaldo atual: R$%.2f ", super.saldo);
		} else {
			System.out.println("\nValor inserido + o tributo excede o saldo disponível!");
		}
	}

	@Override
	public void depositar(Double valor) {
		if (super.saldo == null) {
			super.saldo = 0.0;
		}
		super.saldo += valor - 0.3;
		System.out.println("\nOperação realizada com sucesso!");
		System.out.printf("\nValor depositado: R$%.2f ", valor);
		System.out.printf("\nTaxa para depósito: R$ 0.30\n");
		System.out.printf("\nSaldo atual: R$%.2f ", super.saldo);
	}

	@Override

	public void transferir(Double valor, Conta destino) {
		if (super.saldo >= valor + 0.4) {
			super.saldo -= valor + 0.4;
			destino.depositar(valor);
			System.out.println("\nOperação realizada com sucesso!");
			System.out.printf("\nValor transferido: R$%.2f", valor);
			System.out.printf("\nTaxa de transferência: R$ 0.40\n");
			System.out.printf("\nSaldo atual: R$ " + super.saldo);

		} else {
			System.out.println("Valor inserido + taxa de transferência excede o saldo disponível!");
		}
	}
}