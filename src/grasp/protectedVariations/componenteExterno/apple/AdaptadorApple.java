package grasp.protectedVariations.componenteExterno.apple;

import grasp.protectedVariations.componenteInterno.audio.IAudioPlayer;

public class AdaptadorApple implements IAudioPlayer {
	private ApplePlayer applePlayer;
	
	public AdaptadorApple(ApplePlayer applePlayer) {
		this.applePlayer = applePlayer;
	}
	
	@Override
    public void reproduzir(String musica) {
        // Utiliza o adaptador interno para chamar o método específico do ApplePlayer
		applePlayer.playAppleMusic(musica);
    }
}