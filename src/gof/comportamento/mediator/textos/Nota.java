package gof.comportamento.mediator.textos;

public class Nota {
	private String nome;
    private String texto;

    public Nota() {
        nome = "Nova nota";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return nome;
    }
}