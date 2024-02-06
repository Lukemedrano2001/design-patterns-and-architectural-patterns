package gof.criacao.builder.carro.configs;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;

public class CarroEletrico extends Carro {
	private ComputadorDeViagem computadorDeViagem;
    private GPSNavegador gpsNavegador;
    private final double capacidadeBateria;
	
	public CarroEletrico(TipoCarro tipoCarro, int numeroAssentos, Motor motor, Transmissao transmissao,
			ComputadorDeViagem computadorDeViagem, GPSNavegador gpsNavegador, double capacidadeBateria) {
		super(tipoCarro, numeroAssentos, motor, transmissao);
		this.computadorDeViagem = computadorDeViagem;
    	this.gpsNavegador = gpsNavegador;
    	this.capacidadeBateria = capacidadeBateria;
	}

	public ComputadorDeViagem getComputadorDeViagem() {
		return computadorDeViagem;
	}

	public void setComputadorDeViagem(ComputadorDeViagem computadorDeViagem) {
		this.computadorDeViagem = computadorDeViagem;
	}

	public GPSNavegador getGpsNavegador() {
		return gpsNavegador;
	}

	public void setGpsNavegador(GPSNavegador gpsNavegador) {
		this.gpsNavegador = gpsNavegador;
	}

	public double getCapacidadeBateria() {
		return capacidadeBateria;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String carroString = super.toString();
		String gpsNavegador  = this.getGpsNavegador().toString();
		String bateria = " | Bateria: " + this.getCapacidadeBateria();
		
		builder.append(carroString).append(gpsNavegador).append(bateria).append("\n");
		
		return builder.toString();
	}
}