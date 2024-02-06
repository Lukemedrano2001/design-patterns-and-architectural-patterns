package gof.criacao.builder.carro.configs;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;

public class CarroPopular extends Carro {
	private ComputadorDeViagem computadorDeViagem;
    private GPSNavegador gpsNavegador;
    private double combustivel = 0;
	
    public CarroPopular(TipoCarro tipoCarro, int numeroAssentos, Motor motor, Transmissao transmissao, 
    		ComputadorDeViagem computadorDeViagem, GPSNavegador gpsNavegador) {
		super(tipoCarro, numeroAssentos, motor, transmissao);
		this.computadorDeViagem = computadorDeViagem;
		this.gpsNavegador = gpsNavegador;
		if (this.computadorDeViagem != null) {
			this.computadorDeViagem.setCarro(this);
		}
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

	public double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String carroString = super.toString();
		String gpsNavegador  = this.getGpsNavegador().toString();
		String combustivel = " | Combustível: " + this.getCombustivel();
		
		builder.append(carroString).append(gpsNavegador).append(combustivel).append("\n");
		
		return builder.toString();
	}
}