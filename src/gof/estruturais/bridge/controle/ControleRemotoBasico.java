package gof.estruturais.bridge.controle;

import gof.estruturais.bridge.dispositivo.IDispositivo;

public class ControleRemotoBasico implements IControleRemoto {
	protected IDispositivo dispositivo;
	
	public ControleRemotoBasico() {}
	
	public ControleRemotoBasico(IDispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	@Override
	public void power() {
		if(dispositivo.isLigado()) {
			dispositivo.desligar();
		} else {
			dispositivo.ligar();
		}
	}
	
	@Override
	public void aumentarVolume() {
		dispositivo.aumentarVolume();
	}

	@Override
	public void diminuirVolume() {
		dispositivo.diminuirVolume();
	}

	@Override
	public void aumentarCanal() {
		int canalAtual = dispositivo.getCanal();
		dispositivo.trocarCanal(canalAtual + 1);
	}

	@Override
	public void diminuirCanal() {
		int canalAtual = dispositivo.getCanal();
		dispositivo.trocarCanal(canalAtual - 1);
	}

	@Override
	public void trocarCanal(int canal) {
		dispositivo.trocarCanal(canal);
	}
	
	@Override
    public String toString() {
        return "Controle Remoto Básico | " + dispositivo.toString();
    }
}