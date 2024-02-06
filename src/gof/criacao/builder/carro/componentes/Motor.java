package gof.criacao.builder.carro.componentes;

public class Motor {
	private final double volume;
	private double quilometragem;
	private double velocidade;
	private boolean ligado;
	
	public Motor(double volume, double quilometragem) {
		this.volume = volume;
		this.quilometragem = quilometragem;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void ligarMotor(boolean ligado) {
		this.ligado = ligado;
	}
	
	public void desligarMotor(boolean ligado) {
		this.ligado = ligado;
	}
	
	public double getVelocidade() {
		return velocidade;
	}

	public void acelerar(double velocidade) {
		if(velocidade > 0) {
			this.velocidade += velocidade;			
		}
	}

	public double getVolume() {
		return volume;
	}
	
	public void andar(double quilometragem, double velocidade) {
		if (ligado) {
			this.quilometragem += quilometragem;
			acelerar(velocidade);
		} else {
			System.err.println("Ligue o motor primeiro!");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String volume = " | Volume: " + this.getVolume();
		String quilometragem = " | Quilometragem: " + this.getQuilometragem();
		String velocidade = " | Velocidade: " + this.getVelocidade();
		String ligado = " | Ligado: " + this.isLigado();
		
		builder.append(volume).append(quilometragem)
			.append(velocidade).append(ligado);
		
		return builder.toString();
	}
}