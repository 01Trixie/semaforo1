package controller;

import java.util.concurrent.Semaphore;
import java.text.DecimalFormat;
public class cozinha extends Thread {
	
	private int idPrato;
	private Semaphore semaforo;
	private static int pronto;
	private static int saida;
	
	public cozinha(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	public void run() {
		inicio();
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	
	private void inicio() { 
		DecimalFormat f = new DecimalFormat("0.0");
		if(idPrato % 2 == 0) {
			
			int tempo = 100;
			double tempoTotal = (int) (Math.random()* 601 + 600);
			double tempoCozimento = 0;
			
			while(tempo <tempoTotal) {
				tempoCozimento = (tempo/ tempoTotal) * 100;
				System.out.println("O prato par   #"+ idPrato + " de lasanha a bolonhesa está " + f.format(tempoCozimento) + "% cozido." );
				tempo++;
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("O prato par   #"+ idPrato + " de lasanha a bolanhesa foi o "  + pronto + "° a ficar pronto e demorou " + (tempoCozimento )+ "s.");
			
		}else {
			int tempo = 100;
			double tempoTotal = (int) (Math.random()* 501 + 300);
			double tempoCozimento = 0;


		
			while(tempo <tempoTotal) {
				tempoCozimento = (tempo / tempoTotal) * 100;
				System.out.println("O prato impar #"+ idPrato + " de sopa de cebola está " + f.format(tempoCozimento) + "% cozido." );
				tempo++;
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pronto++;			
			}
			System.out.println("O prato impar  #"+ idPrato + " de sopa de cebola foi o " + pronto + "° a ficar pronto e demorou " + tempoCozimento + "s.");
		}
		pronto++;
		System.out.println(" ");
	}
	
	private void entrega() { 
		saida++;
		System.out.println("O prato #" + idPrato + " foi o " + saida + "° a ser entregue.");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
}
