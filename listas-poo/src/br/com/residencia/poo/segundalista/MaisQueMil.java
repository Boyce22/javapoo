package br.com.residencia.poo.segundalista;

import java.util.concurrent.TimeUnit;

public class MaisQueMil {
	public static void main(String[] args) throws InterruptedException {
		int resulMultide4, somaPrimos, resultMil;

		int n1 = 1004, n2 = 1008, n3 = 1012, n4 = 1016;
		int p1 = 2, p2 = 3, p3 = 5, p4 = 7;

		resulMultide4 = n1 + n2 + n3 + n4;

		somaPrimos = p1 + p2 + p3 + p4;

		resultMil = resulMultide4 - somaPrimos;

		System.out.print("O resultado da soma dos 4 primeiros múltiplos de 4 acima de mil é " + resulMultide4 + ", ");
		TimeUnit.SECONDS.sleep(3);

		System.out.println("\nsubtraindo dos primeiros 4 números primos a partir de um fica: " + resultMil);
		TimeUnit.SECONDS.sleep(3);
	}
}
