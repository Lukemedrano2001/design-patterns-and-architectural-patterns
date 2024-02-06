package grasp.pureFabrication;

import java.time.LocalDateTime;
import java.util.List;

import grasp.pureFabrication.evento.Evento;
import grasp.pureFabrication.geradorRelatorios.GeradorRelatorios;

public class Application {
	public static void main(String[] args) {
		// Datas
		LocalDateTime data1 = LocalDateTime.parse("2024-01-24T15:30:30");
		LocalDateTime data2 = LocalDateTime.parse("2024-01-24T18:00:00");
		
		LocalDateTime data3 = LocalDateTime.parse("2024-04-30T12:00:00");
		LocalDateTime data4 = LocalDateTime.parse("2024-04-30T23:50:50");
		
		// Eventos
		Evento evento1 = new Evento("WorkShop", data1, data2, "Em Andamento");
		Evento evento2 = new Evento("Reunião", data3, data4, "Em Andamento");

		// Gerador de Relatórios
		List<Evento> eventos = List.of(evento1, evento2);
		GeradorRelatorios.gerarRelatorioEventos(eventos);
	}
}