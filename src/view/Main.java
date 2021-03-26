package view;

import java.util.concurrent.Semaphore;

import controller.Corredor;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		int qtdPessoas = 4;
		
		for (int id = 1; id <= qtdPessoas; id++) {
			Thread t = new Corredor(id, semaforo);
			t.start();
		}
	}

}
