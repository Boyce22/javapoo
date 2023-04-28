package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class Riuju {

	public static void main(String[] args) {

		Integer expA = 2 + 3 - 5 * 8 - 4 + 354 - 521 + 7 * 66;
		Integer expB = 2 + 7 * (14 - 21) + 28 * 3 * 42 + 740 - (156 + 4 + 40) * 9;

		Scanner sc = new Scanner(System.in);
		System.out.println("Olá, eu sou o Programa Riuji\n");
		System.out.println(
				"Vamos calcular algumas expressões?\n" + "Escolha qual das expressões deseja resolver. (A/B)\n");
		String escolha = getEscolha(sc);

		if (escolha.equals("a")) {
			System.out.println("O resultado da expressão é: " + expA + "\n");
		} else {
			System.out.println("O resultado da expressão é: " + expB);
		}
		sc.close();
	}

	public static String getEscolha(Scanner sc) {
		String escolha;
		do {
			System.out.println("A) 2 + 3 - 5 * 8 - 4 + 354 - 521 + 7 * 66\n");
			System.out.println("B) 2 + 7 * (14 - 21) + 28 * 3 * 42 + 740 - (156 + 4 + 40) * 9\n");
			escolha = sc.next().toLowerCase();
			if (!escolha.equals("a") && !escolha.equals("b")) {
				System.out.println("Escolha uma das expressões disponíveis.\n");
			}
		} while (!escolha.equals("a") && !escolha.equals("b"));
		return escolha;
	}
}
