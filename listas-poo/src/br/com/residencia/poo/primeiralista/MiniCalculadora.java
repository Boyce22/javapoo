package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class MiniCalculadora {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Olá, eu sou o programa mini calculadora!\n");
			System.out.println("Agora preciso saber os dois números que deseja calcular as operações matemáticas.\n");

			System.out.print("Insira o primeiro número: \n");
			String num1Str = sc.nextLine().replace(',', '.');
			double num1 = 0.0;
			try {
				num1 = Double.parseDouble(num1Str);
			} catch (NumberFormatException e) {
				System.out.println("Erro! Insira apenas números.");
				return;
			}

			System.out.print("Digite a operação desejada (+ Soma, - Subtração, * Multiplicação, / Divisão): \n");
			String operador = sc.nextLine().trim();
			if (!operador.matches("[+\\-*/]")) {
				System.out.println("Erro! Insira um dos operadores disponíveis na calculadora.");
				return;
			}

			System.out.print("Insira o segundo número: ");
			String num2Str = sc.nextLine().replace(',', '.');
			double num2 = 0.0;
			try {
				num2 = Double.parseDouble(num2Str);
			} catch (NumberFormatException e) {
				System.out.println("Erro! Insira apenas números.");
				return;
			}

			double resultado = 0.0;
			switch (operador) {
			case "+":
				resultado = num1 + num2;
				System.out.printf("O resultado de %.1f + %.1f é: %.1f\n", num1, num2, resultado);
				break;
			case "-":
				resultado = num1 - num2;
				System.out.printf("O resultado de %.1f - %.1f é: %.1f\n", num1, num2, resultado);
				break;
			case "*":
				resultado = num1 * num2;
				System.out.printf("O resultado de %.1f * %.1f é: %.1f\n", num1, num2, resultado);
				break;
			case "/":
				if (num2 == 0) {
					System.out.println("Erro! Divisão por zero não é permitida.");
					return;
				}
				resultado = num1 / num2;
				System.out.printf("O resultado de %.1f / %.1f é: %.1f\n", num1, num2, resultado);
				break;
			default:
				System.out.println("Operador inválido.");
				return;
			}
		}
	}
}
