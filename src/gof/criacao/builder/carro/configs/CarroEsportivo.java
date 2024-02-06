package gof.criacao.builder.carro.configs;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;

public class CarroEsportivo extends Carro {
	private ComputadorDeViagem computadorDeViagem;
    private GPSNavegador gpsNavegador;
    
    public CarroEsportivo(TipoCarro tipoCarro, int numeroAssentos, Motor motor, Transmissao transmissao, 
    		ComputadorDeViagem computadorDeViagem, GPSNavegador gpsNavegador) {
    	super(tipoCarro, numeroAssentos, motor, transmissao);
    	this.computadorDeViagem = computadorDeViagem;
    	this.gpsNavegador = gpsNavegador;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String carroString = super.toString();
		String gpsNavegador  = this.getGpsNavegador().toString();
		
		builder.append(carroString).append(gpsNavegador).append("\n");
		
		return builder.toString();
	}
}