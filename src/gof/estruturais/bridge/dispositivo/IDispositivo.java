package gof.estruturais.bridge.dispositivo;

public interface IDispositivo {
	public boolean isLigado();
	public void ligar();
	public void desligar();
	
	public int getVolume();
	public void setVolume(int volume);
	public void aumentarVolume();
	public void diminuirVolume();
	
	public int getCanal();
	public void trocarCanal(int canal);
}