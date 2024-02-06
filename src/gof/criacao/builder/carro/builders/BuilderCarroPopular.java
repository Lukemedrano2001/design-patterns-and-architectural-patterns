package gof.criacao.builder.carro.builders;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;
import gof.criacao.builder.carro.configs.CarroPopular;
import gof.criacao.builder.carro.configs.TipoCarro;

public class BuilderCarroPopular implements IBuilder {
	private TipoCarro tipoCarro;
    private int numeroAssentos;
    private Motor motor;
    private Transmissao transmissao;
    private ComputadorDeViagem computadorDeViagem;
    private GPSNavegador gpsNavegador;
    
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
	
	public CarroPopular getResultado() {
		return new CarroPopular(tipoCarro, numeroAssentos, motor, transmissao, 
				computadorDeViagem, gpsNavegador);
	}
}