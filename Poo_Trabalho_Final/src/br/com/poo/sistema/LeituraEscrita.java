package br.com.poo.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.enums.ContaEnum;

import br.com.poo.enums.PessoaEnum;
import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.OperadorCaixa;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.Diretor;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Presidente;

public class LeituraEscrita {

	static final String PATH_BASICO = ".\\temp2\\";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path));
		String linha = buffRead.readLine();
		while (linha != null) {
			String[] dados = linha.split(";");
			if (dados[0].equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
				ContaCorrente cc = new ContaCorrente(dados[0], dados[1], dados[2], dados[3], dados[4],
						Double.parseDouble(dados[5]));

				Conta.mapaContas.put(dados[4], cc);
				Conta.ordenaContas.put(dados[3], cc);
			} else if (dados[0].equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {
				ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], dados[2], dados[3], dados[4],
						Double.parseDouble(dados[5]));

				Conta.mapaContas.put(dados[4], cp);
				Conta.ordenaContas.put(dados[3], cp);
			} else if (dados[0].equalsIgnoreCase(PessoaEnum.CLIENTE.getCargo())) {
				Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3]);
				Cliente.mapaCliente.put(dados[2], cliente);
			} else if (dados[0].equalsIgnoreCase(PessoaEnum.PRESIDENTE.getCargo())) {
				Presidente presidente = new Presidente(dados[0], dados[1], dados[2], Double.parseDouble(dados[4]),
						dados[3]);

				Funcionario.mapaFuncionarios.put(dados[2], presidente);
				Funcionario.ordenaFuncionarios.put(dados[2], presidente);
			} else if (dados[0].equalsIgnoreCase(PessoaEnum.DIRETOR.getCargo())) {
				Diretor diretor = new Diretor(dados[0], dados[1], dados[2], Double.parseDouble(dados[4]), dados[3]);

				Funcionario.mapaFuncionarios.put(dados[2], diretor);
				Funcionario.ordenaFuncionarios.put(dados[2], diretor);
			} else if (dados[0].equalsIgnoreCase(PessoaEnum.GERENTE.getCargo())) {
				Gerente gerente = new Gerente(dados[0], dados[1], dados[2], dados[3], Double.parseDouble(dados[4]),
						dados[5]);

				Funcionario.mapaFuncionarios.put(dados[2], gerente);
				Funcionario.ordenaFuncionarios.put(dados[2], gerente);
			} else if (dados[0].equalsIgnoreCase(PessoaEnum.OPERADOR_CAIXA.getCargo())) {
				OperadorCaixa caixa = new OperadorCaixa(dados[0], dados[1], dados[2], dados[3],
						Double.parseDouble(dados[4]));

				Funcionario.mapaFuncionarios.put(dados[2], caixa);
				Funcionario.ordenaFuncionarios.put(dados[2], caixa);
			}

			linha = buffRead.readLine();
		}

		buffRead.close();
	}

	public static void comprovanteSaldo(Conta conta) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_saldo";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** SALDO **************";
		buffWrite.append(linha + "\n");

		linha = "Nome: " + conta.getTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");

		linha = "Saldo: " + conta.getSaldo();
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Consulta realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteTransferencia(Double valorTrans, Conta contaOrigem, Conta contaDestino)
			throws IOException {
		String nomeArquivo = contaOrigem.getCpf() + "_" + contaOrigem.getAgencia() + "_transferencia";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");
		linha = "             COMPROVANTE DE TRANSFERÊNCIA       ";
		buffWrite.append(linha + "\n");
		linha = "===============================================";
		buffWrite.append(linha + "\n");
		linha = "Conta origem: " + contaOrigem.getNumConta();
		buffWrite.append(linha + "\n");
		linha = "Titular: " + contaOrigem.getTitular();
		buffWrite.append(linha + "\n");
		linha = "Valor transferido: R$" + valorTrans;
		buffWrite.append(linha + "\n");
		linha = "Conta destino: " + contaDestino.getNumConta();
		buffWrite.append(linha + "\n");
		linha = "Titular: " + contaDestino.getTitular();
		buffWrite.append(linha + "\n");
		linha = "Saldo origem: R$" + contaOrigem.getSaldo();
		buffWrite.append(linha + "\n");
		linha = "Novo saldo origem: R$" + (contaOrigem.getSaldo() - valorTrans);
		buffWrite.append(linha + "\n");
		linha = "Saldo destino: R$" + contaDestino.getSaldo();
		buffWrite.append(linha + "\n");
		linha = "Novo saldo destino: R$" + (contaDestino.getSaldo() + valorTrans);
		buffWrite.append(linha + "\n");
		linha = "===============================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteSaque(Conta conta, Double valorSaque) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_transferencia";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** TRANSFERENCIA **************";
		buffWrite.append(linha + "\n");

		linha = "Nome: " + conta.getTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$ " + valorSaque;
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		linha = "************* FIM TRANSFERENCIA ************";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteDeposito(Conta conta, Double valorDepo) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_deposito";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** DEPOSITO **************";
		buffWrite.append(linha + "\n");

		linha = "Nome: " + conta.getTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$ " + valorDepo;
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		linha = "************* FIM DEPOSITO ************";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public static void comprovanteRendimento(Conta conta, Double rendimentoTotal) throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_rendimento";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");
		linha = "              COMPROVANTE DE RENDIMENTO         ";
		buffWrite.append(linha + "\n");
		linha = "===============================================";
		buffWrite.append(linha + "\n");
		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");
		linha = "Titular: " + conta.getTitular();
		buffWrite.append(linha + "\n");
		linha = "Saldo anterior: R$" + conta.getSaldo();
		buffWrite.append(linha + "\n");
		linha = "Rendimento mensal: R$" + rendimentoTotal;
		buffWrite.append(linha + "\n");
		linha = "Novo saldo: R$" + (conta.getSaldo() + rendimentoTotal);
		buffWrite.append(linha + "\n");
		linha = "===============================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteCalculoRendimento(Conta conta, Double value, int dias, Double rendimento)
			throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getAgencia() + "_calculo_rendimento";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "          COMPROVANTE DE CÁLCULO DE RENDIMENTO          ";
		buffWrite.append(linha + "\n");

		linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");

		linha = "Titular: " + conta.getTitular();
		buffWrite.append(linha + "\n");

		linha = "Valor investido: R$" + value;
		buffWrite.append(linha + "\n");

		linha = "Dias de rendimento: " + dias;
		buffWrite.append(linha + "\n");

		linha = "Rendimento: R$" + rendimento;
		buffWrite.append(linha + "\n");

		linha = "Saldo após rendimento: R$" + (conta.getSaldo() + rendimento);
		buffWrite.append(linha + "\n");

		linha = "===============================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
		System.out.println("\nComprovante de cálculo de rendimento gerado com sucesso!");
	}

	public static void relatorioContasDaAgencia(String agencia) throws IOException {
		String nomeArquivo = "relatorioContasDaAgencia_" + agencia;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "       RELATÓRIO DE CONTAS DA AGÊNCIA " + agencia + "       ";
		buffWrite.append(linha + "\n");

		linha = "===============================================";
		buffWrite.append(linha + "\n\n");

		for (Conta conta : Conta.mapaContas.values()) {
			if (conta.getAgencia().equals(agencia)) {
				linha = "Conta: " + conta.getNumConta();
				buffWrite.append(linha + "\n");
				linha = "Titular: " + conta.getTitular();
				buffWrite.append(linha + "\n");
				linha = "Saldo: R$ " + conta.getSaldo();
				buffWrite.append(linha + "\n\n");
			}
		}

		buffWrite.close();
	}

	public static void relatorioClientesDoBanco() throws IOException {
		String nomeArquivo = "relatorioClientesDoBanco";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "          RELATÓRIO DE CLIENTES DO BANCO       ";
		buffWrite.append(linha + "\n");

		linha = "===============================================";
		buffWrite.append(linha + "\n\n");

		for (Conta conta : Conta.ordenaContas.values()) {
			linha = "Conta: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Titular: " + conta.getTitular();
			buffWrite.append(linha + "\n");

			linha = "Agência: " + conta.getAgencia();
			buffWrite.append(linha + "\n");

			linha = "Saldo: R$" + conta.getSaldo();
			buffWrite.append(linha + "\n");

			buffWrite.append("\n");
		}

		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void relatorioCapitalDoBanco(Double saldoTotal) throws IOException {
		String nomeArquivo = "relatorioCapitalDoBanco";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "             RELATÓRIO DE CAPITAL DO BANCO        ";
		buffWrite.append(linha + "\n");

		linha = "===============================================";
		buffWrite.append(linha + "\n");

		linha = "A capital total do Banco é: " + saldoTotal;
		buffWrite.append(linha + "\n");

		buffWrite.close();

		System.out.println("Relatório gerado com sucesso!");
	}

}
