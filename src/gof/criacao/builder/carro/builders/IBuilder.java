package gof.criacao.builder.carro.builders;

import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;
import gof.criacao.builder.carro.configs.TipoCarro;

public interface IBuilder {
	public void setTipoCarro(TipoCarro tipoCarro);
	public void setNumeroAssentos(int numeroAssentos);
	public void setMotor(Motor motor);
	public void setTransmissao(Transmissao transmissao);
	public void setComputadorDeViagem(ComputadorDeViagem computadorDeViagem);
	public void setGPSNavegador(GPSNavegador gpsNavegador);
}