package grasp.protectedVariations;

import grasp.protectedVariations.componenteExterno.apple.AdaptadorApple;
import grasp.protectedVariations.componenteExterno.apple.ApplePlayer;
import grasp.protectedVariations.componenteExterno.spotify.AdaptadorSpotify;
import grasp.protectedVariations.componenteExterno.spotify.SpotifyPlayer;
import grasp.protectedVariations.componenteInterno.audio.ClienteAudio;
import grasp.protectedVariations.componenteInterno.audio.IAudioPlayer;
import grasp.protectedVariations.componenteInterno.reprodutor.ReprodutorInterno;

public class Application {
    public static void main(String[] args) {
        // IAudioPlayer e ReprodutorInterno (Componente Interno)
        IAudioPlayer reprodutorInterno = new ReprodutorInterno();

        // ClienteAudio que utiliza o AudioPlayer interno
        ClienteAudio clienteAudioInterno = new ClienteAudio(reprodutorInterno);

        // Players (Componente Externo)
        SpotifyPlayer spotifyPlayer = new SpotifyPlayer();
        ApplePlayer applePlayer = new ApplePlayer();
        
        // Adaptadores de Players (Interfaces Intermediárias)
        AdaptadorSpotify adaptadorSpotify = new AdaptadorSpotify(spotifyPlayer);
        AdaptadorApple adapatadorApple = new AdaptadorApple(applePlayer);

        // ClienteAudio que utiliza os Adaptadores de Players
        // Então, o ClienteAudio usa para reproduzir a música nos Players
        ClienteAudio clienteAudioSpotify = new ClienteAudio(adaptadorSpotify);
        ClienteAudio clienteAudioApple = new ClienteAudio(adapatadorApple);
        
        
        // Exibição no console
        clienteAudioInterno.tocarMusica("Música Interna");
        clienteAudioSpotify.tocarMusica("Música no Spotify");
        clienteAudioApple.tocarMusica("Música no Apple Music");
    }
}
