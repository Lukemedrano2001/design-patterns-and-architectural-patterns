package gof.criacao.builder.carro.configs;

import gof.criacao.builder.carro.componentes.Motor;
import gof.criacao.builder.carro.componentes.Transmissao;

public abstract class Carro {
	private TipoCarro tipoCarro;
    private int numeroAssentos;
    private Motor motor;
    private Transmissao transmissao;
    
	public Carro(TipoCarro tipoCarro, int numeroAssentos, Motor motor, Transmissao transmissao) {
		this.tipoCarro = tipoCarro;
		this.numeroAssentos = numeroAssentos;
		this.motor = motor;
		this.transmissao = transmissao;
	}

	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public int getNumeroAssentos() {
		return numeroAssentos;
	}

	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Transmissao getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(Transmissao transmissao) {
		this.transmissao = transmissao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String tipoCarro = "Tipo de Carro: " + this.getTipoCarro();
		String numeroAssentos = " | Nº de assentos: " + this.getNumeroAssentos();
		String motor = this.getMotor().toString();
		String transmissao = " | Transmissão: " + this.getTransmissao();
		
		builder.append(tipoCarro).append(numeroAssentos)
			.append(motor).append(transmissao);
		
		return builder.toString();
	}
}