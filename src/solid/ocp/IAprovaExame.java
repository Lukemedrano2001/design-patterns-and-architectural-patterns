package solid.ocp;

public interface IAprovaExame {
	void aprovarSolicitacaoExame(Exame exame);
    boolean verificaCondicoesExame(Exame exame);
}