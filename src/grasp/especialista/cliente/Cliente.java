package grasp.especialista.cliente;

public class Cliente {
	private final int id;
	private String nome;
	
	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		
		return String.format("Id: %s | Nome: %s", this.getId(), this.getNome());
	}
}