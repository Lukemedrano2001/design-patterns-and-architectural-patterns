package gof.comportamento.observer.chegadaAniversariante;

import java.util.Date;

public class ChegadaAniversarianteEvento {
	private final Date horaChegada;

	public ChegadaAniversarianteEvento(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}
}