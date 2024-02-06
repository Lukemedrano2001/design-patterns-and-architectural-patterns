package gof.criacao.builder.carro.configs;

import gof.criacao.builder.carro.builders.IBuilder;
import gof.criacao.builder.carro.builders.IBuilderCarroEletrico;
import gof.criacao.builder.carro.componentes.ComputadorDeViagem;
import gof.criacao.builder.carro.componentes.GPSNavegador;
import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;

public class Diretor {
	public void construirCarroEsportivo(IBuilder builder) {
        builder.setTipoCarro(TipoCarro.CARRO_ESPORTIVO);
        builder.setNumeroAssentos(2);
        builder.setMotor(new Motor(3.0, 0));
        builder.setTransmissao(Transmissao.SEMI_AUTOMATICA);
        builder.setComputadorDeViagem(new ComputadorDeViagem());
        builder.setGPSNavegador(new GPSNavegador());
    }

    public void construirCarroPopular(IBuilder builder) {
        builder.setTipoCarro(TipoCarro.CARRO_POPULAR);
        builder.setNumeroAssentos(6);
        builder.setMotor(new Motor(1.2, 0));
        builder.setTransmissao(Transmissao.AUTOMATICA);
        builder.setComputadorDeViagem(new ComputadorDeViagem());
        builder.setGPSNavegador(new GPSNavegador());
    }

    public void construirCarroSUV(IBuilder builder) {
        builder.setTipoCarro(TipoCarro.SUV);
        builder.setNumeroAssentos(4);
        builder.setMotor(new Motor(2.5, 0));
        builder.setTransmissao(Transmissao.MANUAL);
        builder.setGPSNavegador(new GPSNavegador());
    }
    
    public void construirCarroEletrico(IBuilderCarroEletrico builder) {
    	builder.setTipoCarro(TipoCarro.ELETRICO);
        builder.setNumeroAssentos(4);
        builder.setMotor(new Motor(5.5, 0));
        builder.setTransmissao(Transmissao.AUTOMATICA);
        builder.setGPSNavegador(new GPSNavegador());
        builder.setCapacidadeBateria(10);
    }
}