package solid.ocp;

public class AprovaExameSangue implements IAprovaExame {

	@Override
	public void aprovarSolicitacaoExame(Exame exame) {
		if(verificaCondicoesExame(exame)) {
			System.out.println("Exame de sangue aprovado!");			
		}
	}

	@Override
	public boolean verificaCondicoesExame(Exame exame) {
		return false;
	}
}
