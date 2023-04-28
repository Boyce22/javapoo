package br.com.residencia.poo.segundalista;

import java.util.concurrent.TimeUnit;

public class Universo {
	public static void main(String[] args) {
		int universo;

		System.out.println("Qual o significado da vida, do universo e tudo mais?");
		wait(3);
		

		System.out.println("A resposta para essa pergunta fundamental..");
		wait(3);
		

		for (int i = 3; i >= 0; i--) {
			System.out.println("PENSANDO. \n");
			wait(1);
		
			System.out.println("PENSANDO.. \n");
			wait(1);
			
			System.out.println("PENSANDO... \n");
			wait(1);
			
		}

		universo = 42;
		System.out.println("é " + universo + ".");
		wait(3);
	}

	public static void wait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

