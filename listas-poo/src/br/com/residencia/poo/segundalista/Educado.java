package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class Educado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome, apelido;

		System.out.println("Olá, qual é o seu nome? \n");
		nome = sc.nextLine();

		System.out.println(nome + ", como gostaria de ser chamado? \n");
		apelido = sc.nextLine();

		System.out.println("Ótimo, agora te chamarei por " + apelido + ".");

		sc.close();

	}
}


