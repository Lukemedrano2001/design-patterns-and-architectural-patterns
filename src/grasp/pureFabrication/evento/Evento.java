package grasp.pureFabrication.evento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String nome;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFinal;
	private String status;
	
	public Evento(String nome, LocalDateTime data1, LocalDateTime data2, String status) {
		this.nome = nome;
		this.dataHoraInicio = data1;
		this.dataHoraFinal = data2;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime data) {
		this.dataHoraInicio = data;
	}
	
	public LocalDateTime getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(LocalDateTime dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		String nome = "Nome: " + this.getNome();
		String data1 = "Início: " + this.getDataHoraInicio().format(fmt);
		String data2 = "Final: " + this.getDataHoraFinal().format(fmt);
		String status = "Status: " + this.getStatus();
		
		return String.format("%s | %s | %s | %s", nome, data1, data2, status);
	}
}