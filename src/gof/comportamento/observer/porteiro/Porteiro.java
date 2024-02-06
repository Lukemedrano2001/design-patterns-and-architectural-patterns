package gof.comportamento.observer.porteiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import gof.comportamento.observer.chegadaAniversariante.ChegadaAniversarianteEvento;
import gof.comportamento.observer.chegadaAniversariante.ChegadaAniversarianteObserver;

public class Porteiro extends Thread {
	private List<ChegadaAniversarianteObserver> observadores = new ArrayList<>();
	
	public void registrarObservador(ChegadaAniversarianteObserver observador) {
		this.observadores.add(observador);
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while(true) {
				int valor = scanner.nextInt();
				
				if(valor == 1) {
					ChegadaAniversarianteEvento evento = new ChegadaAniversarianteEvento(new Date());
					
					// Notificar os observadores
					for(ChegadaAniversarianteObserver observador: observadores) {
						observador.chegou(evento);
					}
					
					System.exit(0);
				} else {
					System.out.println("Alarme Falso");
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}