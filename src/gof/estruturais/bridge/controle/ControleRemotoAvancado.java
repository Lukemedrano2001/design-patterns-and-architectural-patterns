package gof.estruturais.bridge.controle;

import gof.estruturais.bridge.dispositivo.IDispositivo;

public class ControleRemotoAvancado extends ControleRemotoBasico {
	public ControleRemotoAvancado(IDispositivo dispositivo) {
		super(dispositivo);
	}
	
	public void mutar() {
		dispositivo.setVolume(0);
	}
	
	@Override
    public String toString() {
        return "Controle Remoto Avançado | " + dispositivo.toString();
    }
}