package br.com.poo.sistema;

import java.io.IOException;
import java.util.Scanner;

import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Funcionario;
//import br.com.poo.cargos.Pessoa;
import br.com.poo.contas.Conta;

public class MenuInterativo {

	private String inputCpf;
	private String inputSenha;
	public static Scanner sc = new Scanner(System.in);

	public void loginFunc() throws IOException {

		Funcionario func;

		do {

			System.out.println("\nInforme seu CPF: \n  ");
			inputCpf = sc.next();				
			
			System.out.println("\nDigite sua Senha: \n  ");
			inputSenha = sc.next();		

			func = Funcionario.mapaFuncionarios.get(inputCpf);
			
		

			if (func == null || !(func.getSenha().equals(inputSenha))) {
				System.out.println("\nCPF e/ou Senha incorreto(s).");
			}
		} while (func == null || !(func.getSenha().equals(inputSenha)));

		limpaTela();
		subMenuFunc(func);
	}

	public void login() throws IOException {
		Cliente cliente;
		Conta conta;

		do {
			System.out.println("Digite seu CPF: ");
			inputCpf = sc.next();
			System.out.println("Digite sua Senha: ");
			inputSenha = sc.next();

			cliente = Cliente.mapaCliente.get(inputCpf);
			conta = Conta.mapaContas.get(inputCpf);

			if (cliente == null || !(cliente.getSenha().equals(inputSenha))) {
				System.out.println("CPF e/ou Senha incorreto(s).");
			}
		} while (cliente == null || !(cliente.getSenha().equals(inputSenha)));

		limpaTela();
		subMenu(cliente, conta);
		sc.close();
	}

	public void subMenuFunc(Funcionario func) throws IOException {
		imprimeLinhaHorizontal();
		System.out.println(
				"Bem-vindo(a) ao seu Banco, " + func.getNome() + "\n Cargo atual:" + func.getTipoFuncionario() + "!\n");
		imprimeLinhaHorizontal();
		System.out.println("Escolha uma das opções abaixo:");
		MenuPrincipal.menuPrincipalFunc(func);
	}

	public void subMenu(Cliente cliente, Conta conta) throws IOException {
		imprimeLinhaHorizontal();
		System.out.println("Bem-vindo(a) ao seu Banco, " + cliente.getNome() + "!\n");
		imprimeLinhaHorizontal();
		System.out.println("Escolha uma das opções abaixo:");
		MenuPrincipal.menuPrincipal(cliente, conta);
	}

	public void limpaTela() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public void imprimeLinhaHorizontal() {
		System.out.println("-------------------------------------------------------");
	}

}
