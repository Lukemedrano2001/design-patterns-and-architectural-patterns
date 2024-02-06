package solid.lsp;

public class EstudantePosGraduacao extends Estudante {
	public EstudantePosGraduacao(String nome) {
		super(nome);
	}

	@Override
	public String estudar() {
    		return String.format("%s está estudando e pesquisando.", this.nome);
    }
}
