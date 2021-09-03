package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{
	private int tamanhoCorredor;
	private int posicao = 0;
	private Semaphore semaforo;
	private int id;
	public ThreadPessoa(int id,int tamanhoCorredor, Semaphore semaforo) {
		this.tamanhoCorredor = tamanhoCorredor;
		this.semaforo = semaforo;
		this.id = id+1;
	}
	
	@Override
	public void run() {
		andar();
	}
	
	private void andar() {
		while (posicao<tamanhoCorredor) {
			try {
				int metrosAndar = (int) ((Math.random()*3)+4);
				posicao+=metrosAndar;
				this.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		System.err.println("A pessoa #"+id+" chegou na porta");
		passarPelaPorta();
	}
	
	private void passarPelaPorta() {
		try {
			semaforo.acquire();
			int tempoParaPassarPelaPorta = (int) ((Math.random()*1001)+1000);
			sleep(tempoParaPassarPelaPorta);
			System.out.println("A pessoa #"+id+" passou pela porta");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
}
