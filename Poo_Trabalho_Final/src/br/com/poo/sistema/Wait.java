package br.com.poo.sistema;


public class Wait {
	public static void aguarde(int tempo) {
	    try {
	        Thread.sleep(tempo);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
