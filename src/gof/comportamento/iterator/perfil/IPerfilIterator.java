package gof.comportamento.iterator.perfil;

public interface IPerfilIterator {
	public boolean temProximo();
    public Perfil getProximo();
    public void resetar();
}