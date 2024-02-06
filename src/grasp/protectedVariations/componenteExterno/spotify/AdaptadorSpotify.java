package grasp.protectedVariations.componenteExterno.spotify;

import grasp.protectedVariations.componenteInterno.audio.IAudioPlayer;

public class AdaptadorSpotify implements IAudioPlayer {
	private SpotifyPlayer spotifyPlayer;

    public AdaptadorSpotify(SpotifyPlayer spotifyPlayer) {
        this.spotifyPlayer = spotifyPlayer;
    }

    @Override
    public void reproduzir(String musica) {
        // Utiliza o adaptador interno para chamar o método específico do SpotifyPlayer
        spotifyPlayer.playSpotify(musica);
    }
}