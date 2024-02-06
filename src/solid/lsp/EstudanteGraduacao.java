package solid.lsp;

public class EstudanteGraduacao extends Estudante {
	public EstudanteGraduacao(String nome) {
		super(nome);
	}
	
	public String estudar() {
		return String.format("%s está estudando na graduação.", this.nome);
	}
	
	public void entregarTCC(){}
}