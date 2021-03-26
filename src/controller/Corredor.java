package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread{
	
	private Semaphore semaforo;
	private int id;
	private static int d = 200;
	
	public Corredor(int id, Semaphore semaforo){
		this.semaforo = semaforo;
		this.id = id;
	}
	
	@Override
	public void run() {
		corrida();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

	private void corrida() {
		int passo = 0;
		while(d > 0) {
		    passo = (int) ((Math.random()*3)+4);
				d -= passo;
				System.out.println("A " + id + "a. pessoa  percorreu " + passo + "m. Faltam " + d + "m");
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void porta() {
		int tempo = (int)((Math.random() * 2000 )+2000);
		try {
			sleep(tempo);
			System.out.println("A pessoa "+id+" cruzou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
