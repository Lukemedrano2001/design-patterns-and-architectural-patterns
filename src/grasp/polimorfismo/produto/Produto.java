package grasp.polimorfismo.produto;

import grasp.polimorfismo.calculadoraDesconto.ICalculadoraDescontos;

public class Produto {
	private final int id;
	private String nome;
	private double preco;
	private ICalculadoraDescontos calculadoraDescontos;
	
	public Produto(int id, String nome, double preco, ICalculadoraDescontos calculadoraDescontos) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.calculadoraDescontos = calculadoraDescontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public double precoComDesconto() {
		double desconto = calculadoraDescontos.calcularDesconto(preco);
        double precoFinal = preco - desconto;
        
        return precoFinal;
    }
	
	@Override
	public String toString() {
		String id = "Id: " + this.getId();
		String nome = "Nome: " + this.getNome();
		String preco = String.format("Preço sem Desconto: %.2f R$", this.getPreco());
		String precoFinal = String.format("Preço com Desconto: %.2f R$", this.precoComDesconto());
		
		return String.format("%s | %s | %s | %s", id, nome, preco, precoFinal);
	}
}