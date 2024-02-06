package gof.criacao.builder.carro.builders;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;
import gof.criacao.builder.carro.configs.CarroEletrico;
import gof.criacao.builder.carro.configs.TipoCarro;

public class BuilderCarroEletrico implements IBuilderCarroEletrico {
	private TipoCarro tipoCarro;
    private int numeroAssentos;
    private Motor motor;
    private Transmissao transmissao;
    private ComputadorDeViagem computadorDeViagem;
    private GPSNavegador gpsNavegador;
    private double capacidadeBateria;
    
    @Override
	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	@Override
	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}

	@Override
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public void setTransmissao(Transmissao transmissao) {
		this.transmissao = transmissao;
	}

	@Override
	public void setComputadorDeViagem(ComputadorDeViagem computadorDeViagem) {
		this.computadorDeViagem = computadorDeViagem;
	}

	@Override
	public void setGPSNavegador(GPSNavegador gpsNavegador) {
		this.gpsNavegador = gpsNavegador;
	}
	
	@Override
	public void setCapacidadeBateria(double capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}
	
	public CarroEletrico getResultado() {
		return new CarroEletrico(tipoCarro, numeroAssentos, motor, transmissao, 
				computadorDeViagem, gpsNavegador, capacidadeBateria);
	}
}