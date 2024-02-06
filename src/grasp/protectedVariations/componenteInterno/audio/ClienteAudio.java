package grasp.protectedVariations.componenteInterno.audio;

public class ClienteAudio {
	private IAudioPlayer audioPlayer; 
	
	public ClienteAudio(IAudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public void tocarMusica(String musica) {
        // Utiliza o componente interno para reproduzir a música
        audioPlayer.reproduzir(musica);
    }
}