package solid.lsp;

public abstract class Estudante {
	String nome;

    public Estudante(String nome) {
        this.nome = nome;
    }

    public String estudar() {
    	return String.format("%s está estudando.", this.nome);
    }
}