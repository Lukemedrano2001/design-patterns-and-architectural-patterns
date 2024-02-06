package gof.estruturais.bridge.dispositivo;

public class Radio implements IDispositivo {
	private boolean ligado = false;
	private int volume = 50;
	private int canal = 1;
	
	@Override
	public boolean isLigado() {
		return ligado;
	}

	@Override
	public void ligar() {
		this.ligado = true;
	}

	@Override
	public void desligar() {
		this.ligado = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}
	
	@Override
	public void setVolume(int volume) {
		if(isLigado()) {
			this.volume = volume;			
		}
	}

	@Override
	public void aumentarVolume() {
		if(isLigado()) {
			if(volume > 100) {
				this.volume = 100;
			} else {
				this.volume++;
			}
		} else {
			return;
		}
	}
	
	@Override
	public void diminuirVolume() {
		if(isLigado()) {
			if(volume < 0) {
				this.volume = 0;
			} else {
				this.volume--;
			}
		} else {
			return;
		}
	}

	@Override
	public int getCanal() {
		return canal;
	}

	@Override
	public void trocarCanal(int canal) {
		if(isLigado()) {
			this.canal = canal;			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String ligado = " Ligado? " + isLigado();
		String volume = " | Volume: " + getVolume();
		String canal = " | Canal: " + getCanal();
		
		builder.append(ligado).append(volume).append(canal).append("\n");
		
		return builder.toString();
	}
}