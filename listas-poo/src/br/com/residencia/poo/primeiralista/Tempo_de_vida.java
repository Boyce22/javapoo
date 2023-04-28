package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class Tempo_de_vida {

	public static void main(String[] args) {
		int resultado = 0;

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i <= 4; i++) {
			System.out.println("Qual a idade do " + (i + 1) + "° colega\n");
			int idade = getIdade(sc);

			resultado += idade;
		}

		System.out.println("O tempo de vida meu e dos meus colegas é " + resultado + " anos");
		sc.close();

	}

	public static int getIdade(Scanner sc) {
		int idade;
		do {
			System.out.println("Digite a idade:\n");
			String input = sc.next();
			if (!input.matches("\\d+")) {
				System.out.println("Erro! Digite uma idade válida.\n");

				idade = -1;

			} else {
				idade = Integer.parseInt(input);
				if (idade < 0) {
					System.out.println("Erro! Digite uma idade positiva.\n");
				}
				if (idade > 120) {
					System.out.println("Erro! Insira uma idade válida\n");
				}
			}
		} while (idade < 0 || idade > 120);
		return idade;
	}
}
