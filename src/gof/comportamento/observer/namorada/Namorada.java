package gof.comportamento.observer.namorada;

import gof.comportamento.observer.chegadaAniversariante.ChegadaAniversarianteEvento;
import gof.comportamento.observer.chegadaAniversariante.ChegadaAniversarianteObserver;

public class Namorada implements ChegadaAniversarianteObserver {
	@Override
	public void chegou(ChegadaAniversarianteEvento evento) {
		System.out.println("Apaguem as luzes.");
		System.out.println("Silêncio.");
		System.out.println("Surpresa.");
	}
}