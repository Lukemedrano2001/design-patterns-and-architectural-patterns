package grasp.especialista.produto;

public class Produto {
	private final int id;
	private String nome;
	private double preco;
	
	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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
	
	@Override
	public String toString() {
		String id = "Id: " + this.getId();
		String nome = "Nome: " + this.getNome();
		String preco = "Preço: " + this.getPreco();
		
		return String.format("%s | %s | %s", id, nome, preco);
	}
}