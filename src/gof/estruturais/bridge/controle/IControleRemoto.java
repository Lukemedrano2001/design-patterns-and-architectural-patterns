package gof.estruturais.bridge.controle;

public interface IControleRemoto {
	public void power();
	
	public void aumentarVolume();
	public void diminuirVolume();
	
	public void aumentarCanal();
	public void diminuirCanal();
	public void trocarCanal(int canal);
}