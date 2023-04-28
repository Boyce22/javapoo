package br.com.poo.sistema;

import java.io.IOException;
import java.util.Map;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Diretor;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.OperadorCaixa;
import br.com.poo.cargos.Presidente;

public class MenuPrincipal {

	public static void menuPrincipalFunc(Funcionario func) throws IOException {
		MenuInterativo menuInterativo = new MenuInterativo();
		HomePage homePage = new HomePage();

		while (true) {
			menuInterativo.imprimeLinhaHorizontal();
			System.out.println("=============Painel===============");
			System.out.println("[1]\tRelatórios\n");
			System.out.println("[2]\tBonificação\n");
			System.out.println("[0]\tRetonar");
			System.out.println("Digite a opção desejada: ");
			int opc = MenuInterativo.sc.nextInt();

			switch (opc) {
			case 1:
				relatoriosOpcoes(func);
				break;
			case 2:
				bonificacaoOpcoes(func);
				break;
			case 0:
				Wait.aguarde(2000);
				menuInterativo.limpaTela();
				homePage.login();
			default:
				break;
			}
		}
	}

	private static void relatoriosOpcoes(Funcionario func) throws IOException {
		if (func instanceof OperadorCaixa) {
			System.out.println("\nOpção disponível apenas para Gerentes, Diretores e Presidente.");
			return;
		}

		MenuInterativo menuInterativo = new MenuInterativo();
		System.out.println("\n=========Relatório=========");
		System.out.println("[1]\tRelatório de Contas da Agência\n");
		System.out.println("[2]\tRelatório dos Clientes do Banco\n");
		System.out.println("[3]\tRelatório de Capital do Banco");
		System.out.println("[0]\tRetornar ao Menu");

		menuInterativo.imprimeLinhaHorizontal();

		System.out.println("Digite a opção desejada: ");
		int opc1 = MenuInterativo.sc.nextInt();

		switch (opc1) {
		case 1:
			relatorioContasDaAgencia(func);
			break;
		case 2:
			relatorioClientesDoBanco(func);
			break;
		case 3:
			relatorioCapitalDoBanco(func);
			break;
		case 0:
			Wait.aguarde(2000);
			menuInterativo.limpaTela();
			menuPrincipalFunc(func);

		default:
			break;
		}
	}

	private static void relatorioContasDaAgencia(Funcionario func) throws IOException {
		if (func instanceof Gerente) {
			// Código para imprimir relatório de contas da agência
			String agencia = ((Gerente) func).getAgenciaResp();
			int totalContas = 0;
			for (Conta conta : Conta.mapaContas.values()) {
				if (conta.getAgencia().equals(agencia)) {
					System.out.println(conta);
					LeituraEscrita.relatorioContasDaAgencia(agencia);
					Wait.aguarde(500);
					totalContas++;
				}
			}

			System.out.println("Total de contas na agência " + agencia + ": " + totalContas);

		} else if (func instanceof Diretor || func instanceof Presidente) {
			// Código para imprimir relatório de contas da agência
			for (Conta conta : Conta.mapaContas.values()) {
				System.out.println(conta);
				Wait.aguarde(500);
			}
			Wait.aguarde(700);

		}
	}

	private static void relatorioClientesDoBanco(Funcionario func) throws IOException {
		if (func instanceof Gerente) {
			System.out.println("\nOpção disponível apenas para Diretores e Presidente.");
			Wait.aguarde(3000);

		} else if (func.getTipoFuncionario().equalsIgnoreCase("diretor")
				|| func.getTipoFuncionario().equalsIgnoreCase("presidente")) {
			// Código para imprimir relatório dos clientes do banco

			int quantidadeClientes = 0;
			for (Conta conta : Conta.ordenaContas.values()) {
				System.out.println(conta + " - Saldo: " + conta.getSaldo());
				LeituraEscrita.relatorioClientesDoBanco();
				quantidadeClientes++;
			}
			System.out.println("Quantidade de clientes: " + quantidadeClientes);

		}
	}

	private static void relatorioCapitalDoBanco(Funcionario func) throws IOException {
		if (func instanceof Gerente || func instanceof Diretor) {

			System.out.println("Opção disponível apenas para o Presidente.");
			Wait.aguarde(3000);

		} else if (func.getTipoFuncionario().equalsIgnoreCase("diretor")) {
			double saldoTotal = 0;
			for (Map.Entry<String, Conta> entrada : Conta.mapaContas.entrySet()) {
				saldoTotal += entrada.getValue().getSaldo();
			}
			System.out.println("A capital total do Banco é: " + saldoTotal);
			LeituraEscrita.relatorioCapitalDoBanco(saldoTotal);
			Wait.aguarde(3000);
		}
	}

	private static void bonificacaoOpcoes(Funcionario func) {
		if (func instanceof OperadorCaixa) {

			System.out.printf("Sua bonificação é de 15%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getBonificacao());

			System.out.println("\n");

			Wait.aguarde(4000);
		}
		if (func instanceof Gerente) {
			System.out.printf("Sua bonificação é de 20%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getBonificacao());
			System.out.println("\n");
			Wait.aguarde(2000);

		}
		if (func instanceof Diretor) {
			System.out.printf("Sua bonificação é de 30%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getBonificacao());
			System.out.println("\n");
			Wait.aguarde(2000);
		}
		if (func instanceof Presidente) {
			System.out.printf("Sua bonificação é de 35%% do seu salário de R$%.2f é R$%.2f.", func.getSalario(),
					func.getBonificacao());

			System.out.println("\n");
			Wait.aguarde(2000);
		}

	}

	public static void menuPrincipal(Cliente cliente, Conta conta) throws IOException {

		int escolha, dias;
		Double value, inputValor;
		HomePage homePage = new HomePage();
		MenuInterativo menuInterativo = new MenuInterativo();
		ContaPoupanca cp = new ContaPoupanca();

		while (true) {
			System.out.println("\n=========Menu========");
			System.out.println("[1]\tSaque");
			System.out.println("[2]\tDepósito");
			System.out.println("[3]\tTransferência");
			System.out.println("[4]\tSaldo");
			System.out.println("[5]\tRelatório");
			System.out.println("[0]\tSair");
			menuInterativo.imprimeLinhaHorizontal();
			System.out.println("Digite a opção desejada: ");

			int opc = MenuInterativo.sc.nextInt();

			if (conta instanceof ContaPoupanca) {
				switch (opc) {
				case 1:

					System.out.println("Digite o valor que deseja sacar: \n");
					inputValor = MenuInterativo.sc.nextDouble();
					LeituraEscrita.comprovanteSaque(conta, inputValor);
					conta.sacar(inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;
				case 2:

					System.out.println("Digite o valor que deseja Depositar: \n");
					inputValor = MenuInterativo.sc.nextDouble();
					conta.depositar(inputValor + conta.getSaldo());
					LeituraEscrita.comprovanteDeposito(conta, inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;
				case 3:
					System.out.println("Digite o CPF da conta destino:");
					String cpfDestino = MenuInterativo.sc.next();

					if (Conta.mapaContas.containsKey(cpfDestino)) {
						Conta contaDestino = Conta.mapaContas.get(cpfDestino);

						if (!cpfDestino.equals(conta.getCpf())) {
							System.out.println("\nSaldo atual da conta de destino: R$" + contaDestino.getSaldo());
							System.out.println("Digite o valor que deseja transferir:");
							Double valorTransferencia = MenuInterativo.sc.nextDouble();
							conta.transferir(valorTransferencia, contaDestino);
							LeituraEscrita.comprovanteTransferencia(valorTransferencia, contaDestino, contaDestino);
							Wait.aguarde(2000);
							menuInterativo.limpaTela();
						} else {
							System.out.println("Não é possível transferir para a mesma conta!");
							Wait.aguarde(2000);
							menuInterativo.limpaTela();
						}
					} else {
						System.out.println("Conta não encontrada!");
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					}
					break;

				case 4:

					System.out.println("=============SALDO============\n");
					System.out.printf("Seu saldo é" + conta.getSaldo());
					LeituraEscrita.comprovanteSaldo(conta);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;
				case 5:

					do {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Relatórios Desejados:\n");
						System.out.println("Relatório de Rendimento com Saldo Atual(1)\n");
						System.out.println("Calcular rendimento(2)\n");
						System.out.println("Relatório de Movimentações(3)\n");
						System.out.println("Qual relatório deseja?\n");
						escolha = MenuInterativo.sc.nextInt();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();

					} while (escolha < 0 || escolha > 3);
					if (escolha == 1) {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("=============Relatório de Rendimento=============\n");
						System.out.printf("O rendimento mensal de R$ %.2f é R$ %.2f\n", conta.getSaldo(),
								cp.calcularRendimento(conta));
						LeituraEscrita.comprovanteRendimento(conta, cp.calcularRendimento(conta));
						menuInterativo.imprimeLinhaHorizontal();
						Wait.aguarde(3000);
						menuInterativo.limpaTela();

					} else if (escolha == 2) {

						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("=============Calcular Rendimento=============\n");
						System.out.println("Qual o valor que deseja render?\n");
						value = MenuInterativo.sc.nextDouble();
						System.out.println("Quantos dias de rendimento?\n");
						dias = MenuInterativo.sc.nextInt();

						Double previsaoderendimento = ContaPoupanca.previsaoRendimento(conta, value, dias);

						LeituraEscrita.comprovanteCalculoRendimento(conta, value, dias, previsaoderendimento);
						Wait.aguarde(2000);
						menuInterativo.limpaTela();

						break;
					} else {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Total de saques feitos: " + conta.getTotalSaques());
						System.out.println("Total de depósitos feitos: " + conta.getTotalDepositos());
						System.out.println("Total de transferências feitas: " + conta.getTotalTransferencias());
						menuInterativo.imprimeLinhaHorizontal();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					}

				case 0:
					homePage.login();
					return;

				default:

					System.out.println("Opção inválida! Tente novamente.");
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

				}
			} else if (conta instanceof ContaCorrente) {
				switch (opc) {
				case 1:

					menuInterativo.imprimeLinhaHorizontal();
					System.out.println("Digite o valor que deseja sacar: ");

					inputValor = MenuInterativo.sc.nextDouble();

					conta.sacar(inputValor);

					LeituraEscrita.comprovanteSaque(conta, inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;
				case 2:
					menuInterativo.imprimeLinhaHorizontal();
					System.out.println("Digite o valor que deseja depositar: ");

					inputValor = MenuInterativo.sc.nextDouble();

					conta.depositar(inputValor);

					LeituraEscrita.comprovanteDeposito(conta, inputValor);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();

					break;

				case 3:
					System.out.println("Digite o CPF da conta destino:");
					String cpfDestino = MenuInterativo.sc.next();

					if (Conta.mapaContas.containsKey(cpfDestino)) {
						Conta contaDestino = Conta.mapaContas.get(cpfDestino);

						if (!cpfDestino.equals(conta.getCpf())) {
							System.out.println("\nSaldo atual da conta de destino: R$" + contaDestino.getSaldo());
							System.out.println("Digite o valor que deseja transferir:");
							Double valorTransferencia = MenuInterativo.sc.nextDouble();
							conta.transferir(valorTransferencia, contaDestino);
							LeituraEscrita.comprovanteTransferencia(valorTransferencia, contaDestino, contaDestino);
							Wait.aguarde(2000);
							menuInterativo.limpaTela();
						} else {
							System.out.println("Não é possível transferir para a mesma conta!");
							Wait.aguarde(2000);
							menuInterativo.limpaTela();
						}
					} else {
						System.out.println("Conta não encontrada!");
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					}
					break;

				case 4:

					System.out.println("=============SALDO============\n");
					System.out.println("Seu saldo é" + conta.getSaldo());
					LeituraEscrita.comprovanteSaldo(conta);
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					break;

				case 5:

					Wait.aguarde(2000);
					do {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Relatórios Desejados:\n");
						System.out.println("Relatório de Movimentações(1)\n");
						System.out.println("Qual relatório deseja?\n");
						escolha = MenuInterativo.sc.nextInt();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					} while (escolha != 1);

					if (escolha == 1) {
						menuInterativo.imprimeLinhaHorizontal();
						System.out.println("Total de saques feitos: " + conta.getTotalSaques());
						System.out.println("Total de depósitos feitos: " + conta.getTotalDepositos());
						System.out.println("Total de transferências feitas: " + conta.getTotalTransferencias());
						menuInterativo.imprimeLinhaHorizontal();
						Wait.aguarde(2000);
						menuInterativo.limpaTela();

					} else {
						System.out.println("=============Opção Inválida!=============");
						Wait.aguarde(2000);
						menuInterativo.limpaTela();
					}
					break;

				case 0:
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
					homePage.login();
					return;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					Wait.aguarde(2000);
					menuInterativo.limpaTela();
				}
			}

		}
	}
}