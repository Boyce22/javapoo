package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class Bem_vindo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Eu sou o programa Bem-Vindo!\n");
		System.out.println("Agora vamos para algumas perguntas.\n");

		String genero = getGenero(sc);

		System.out.println("Qual é o seu nome?\n");
		String nome = getNome(sc);

		System.out.println("Qual é o seu sobrenome?\n");
		String sobrenome = getSobrenome(sc);

		nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase();
		sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1).toLowerCase();

		if (genero.equals("m")) {
			System.out.println("Seja bem-vindo " + nome + " " + sobrenome + "!");
		} else {
			System.out.println("Seja bem-vinda " + nome + " " + sobrenome + "!");
		}
		sc.close();
	}

	public static String getGenero(Scanner sc) {
		String genero;
		do {
			System.out.println("Qual é o seu gênero? (M/F)\n");
			genero = sc.next().toLowerCase();
			if (!genero.equals("m") && !genero.equals("f")) {
				System.out.println("Género inválido. Por favor, digite M (Masculino) ou F (Feminino).");
			}
		} while (!genero.equals("m") && !genero.equals("f"));

		return genero;
	}

	public static String getNome(Scanner sc) {
		String nome = "";
		while (!nome.matches("^[a-zA-Z]+$")) {
			nome = sc.next();
			if (!nome.matches("^[a-zA-Z]+$")) {
				System.out.println("Nome inválido. Por favor, digite somente letras, sem números.");
			}
		}

		return nome;
	}

	public static String getSobrenome(Scanner sc) {
		String sobrenome = "";
		while (!sobrenome.matches("^[a-zA-Z]+$")) {
			sobrenome = sc.next();
			if (!sobrenome.matches("^[a-zA-Z]+$")) {
				System.out.println("Sobrenome inválido. Por favor, digite somente letras, sem números");
			}
		}
		return sobrenome;
	}
}