package gof.criacao.prototype.formas;

public class Retangulo extends Forma {
	private double altura;
	
	public Retangulo(int x, int y, String cor, double altura) {
		super(x, y, cor);
		this.altura = altura;
	};
	
	public Retangulo(Retangulo alvo) {
		super(alvo);
		if(alvo != null) {
	        this.altura = alvo.altura;
		}
	}

	@Override
	public Forma clone() {
		return new Retangulo(this);
	}
	
	@Override
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Retangulo) || !super.equals(objeto)) {
        	return false;
        }
        
        Retangulo circulo = (Retangulo) objeto;
        return circulo.altura == altura;
    }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String formaString = super.toString();
		String altura = " | Altura: " + this.altura;
		
		builder.append(formaString).append(altura);
		
		return builder.toString();
	}
}