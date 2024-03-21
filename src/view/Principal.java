package view;

import controller.cozinha;
import java.util.concurrent.Semaphore;

public class Principal {
	public static void main(String[] args) {
		
		int entrega = 1;
		Semaphore semaforo = new Semaphore(entrega);
		
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			Thread tPrato = new cozinha (idPrato, semaforo);
			tPrato.start();
		}
	}
}
