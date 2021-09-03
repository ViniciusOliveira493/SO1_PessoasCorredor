package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {
	public static void main(String[] args) {
		int qtdPessoas = 4;
		int tamanhoCorredor = 200;
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < qtdPessoas; i++) {
			ThreadPessoa p = new ThreadPessoa(i, tamanhoCorredor, semaforo);
			p.start();
		}
	}
}
