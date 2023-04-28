package br.com.poo.sistema;

import java.io.IOException;

public class HomePage {

	public void login() throws IOException {

		Integer valor;

		MenuInterativo menuInterativo = new MenuInterativo();
		System.out.println("\tOlá bem vindo(a) ao BancoSevenDeadlySins\n");
		Wait.aguarde(2000);
		System.out.println("\t    I N T E R N E T  B A N K I N G");
		Wait.aguarde(2000);
		menuInterativo.imprimeLinhaHorizontal();
		System.out.println("\n\t\t(1) Login Funcionário \n" + "\t\t(2) Login Cliente\n");
		menuInterativo.imprimeLinhaHorizontal();
		valor = MenuInterativo.sc.nextInt();
		if (valor == 1) {

			menuInterativo.loginFunc();

		} else {

			menuInterativo.login();

		}
	}

}
