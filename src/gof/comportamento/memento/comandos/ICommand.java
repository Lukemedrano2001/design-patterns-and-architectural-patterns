package gof.comportamento.memento.comandos;

public interface ICommand {
	public String getNome();
    public void executar();
}