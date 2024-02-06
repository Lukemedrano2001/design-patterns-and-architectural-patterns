package grasp.pureFabrication.geradorRelatorios;

import java.time.Duration;
import java.util.List;

import grasp.pureFabrication.evento.Evento;

public class GeradorRelatorios {
	public static void gerarRelatorioEventos(List<Evento> eventos) {
		if (eventos.isEmpty()) {
            System.out.println("Não há eventos para gerar relatório.");
            return;
        }

        for (Evento evento: eventos) {
            System.out.println(evento.toString());
            System.out.println("Duração do evento: " + calcularDuracaoEvento(evento));
            System.out.println();
        }
    }
	
	private static String calcularDuracaoEvento(Evento evento) {
		Duration duracao = Duration.between(evento.getDataHoraInicio(), evento.getDataHoraFinal());

        String horas = "Horas: " + duracao.toHours();
        String minutos = "Minutos: " + duracao.toMinutesPart();
        String segundos = "Segundos: " + duracao.toSecondsPart();

        return String.format("%s, %s, %s", horas, minutos, segundos);
    }
}