package gof.criacao.prototype.formas;

import java.util.Objects;

public abstract class Forma {
	public int x;
	public int y;
	public String cor;
	
	public Forma(int x, int y, String cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }
	
	public Forma(Forma alvo) {
		if (alvo != null) {
            this.x = alvo.x;
            this.y = alvo.y;
            this.cor = alvo.cor;
        }
	}

	public abstract Forma clone();

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;			
		}
		if (objeto == null || getClass() != objeto.getClass()) {
			return false;			
		}
		
		Forma forma = (Forma) objeto;
		return Objects.equals(cor, forma.cor);
	}	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String x = " X: " + this.x;
		String y = " | Y: " + this.y;
		String cor = " | Cor: " + this.cor;
		
		builder.append(x).append(y).append(cor);
		
		return builder.toString();
	}
}