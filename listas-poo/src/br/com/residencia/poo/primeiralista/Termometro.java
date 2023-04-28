package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class Termometro {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double cel, fahr, convert;
		char escala;

		System.out.println("Olá, eu sou o programa termômetro!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Qual escala termométrica usaremos? °C / °F");
		escala = input.next().charAt(0);
		input.nextLine();

		if (escala == 'C' || escala == 'c') {
			System.out.println("Quantos graus Celsius devemos converter para Fahrenheit?");
			cel = input.nextDouble();
			convert = (cel * 1.8) + 32;
			System.out.println(cel + " graus Celsius equivalem a " + convert + " graus Fahrenheit.");
		} else if (escala == 'F' || escala == 'f') {
			System.out.println("Quantos graus Fahrenheit devemos converter para Celsius?");
			fahr = input.nextDouble();
			convert = (fahr - 32) / 1.8;
			System.out.println(fahr + " graus Fahrenheit equivalem a " + convert + " graus Celsius.");
		} else {
			System.out.println("Opção inválida! Tente novamente.");
		}

		input.close();
	}
}
