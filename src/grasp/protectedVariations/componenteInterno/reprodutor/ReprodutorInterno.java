package grasp.protectedVariations.componenteInterno.reprodutor;

import grasp.protectedVariations.componenteInterno.audio.IAudioPlayer;

public class ReprodutorInterno implements IAudioPlayer {
	@Override
	public void reproduzir(String musica) {
		System.out.println("Reproduzindo música internamente: " + musica);
	}
}