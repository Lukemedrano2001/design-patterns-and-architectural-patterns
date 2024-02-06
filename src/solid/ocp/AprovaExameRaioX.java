package solid.ocp;

public class AprovaExameRaioX implements IAprovaExame {
	@Override
	public void aprovarSolicitacaoExame(Exame exame) {
		 if(verificaCondicoesExame(exame)) {
			System.out.println("Raio-X aprovado!");				 
		 }
	}

	@Override
	public boolean verificaCondicoesExame(Exame exame) {
		return false;
	}
	
}
