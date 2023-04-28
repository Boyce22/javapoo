package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class TotalDeProdutos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int quantProduto;

		System.out.println("Olá, quantos produtos você deseja?");
		quantProduto = sc.nextInt();

		if (quantProduto == 1) {
			System.out.println("Obrigado por comprar " + quantProduto + " produto");
		} else if (quantProduto > 1) {
			System.out.println("Obrigado por comprar " + quantProduto + " produtos");
		} else {
			System.out.println("Erro, digite uma quantidade válida");
		}
		sc.close();
	}
}
