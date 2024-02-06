package gof.criacao.prototype.formas;

public class Circulo extends Forma {
	public double raio;
	
	public Circulo(int x, int y, String cor, int raio) {
		super(x, y, cor);
		this.raio = raio;
	}
	
	public Circulo(Circulo alvo) {
		super(alvo);
		if(alvo != null) {
			this.raio = alvo.raio;
		}
	}
	
	@Override
	public Forma clone() {
		return new Circulo(this);
	}
	
	@Override
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Circulo) || !super.equals(objeto)) {
        	return false;
        }
        
        Circulo circulo = (Circulo) objeto;
        return circulo.raio == raio;
    }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String formaString = super.toString();
		String raio = " | Raio: " + this.raio;
		
		builder.append(formaString).append(raio);
		
		return builder.toString();
	}
}