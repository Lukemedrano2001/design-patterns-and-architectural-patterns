package gof.estruturais.proxy.bibliotecas;

import java.util.HashMap;

import gof.estruturais.proxy.video.Video;

public class BibliotecaYoutubeTerceirosImpl implements IBibliotecaYoutubeTerceiros {

	@Override
	public HashMap<String, Video> videosPopulares() {
		getConexaoServidor("http://www.youtube.com");
		return getVideosAleatorios();
	}

	@Override
	public Video getVideo(String videoId) {
		getConexaoServidor("http://www.youtube.com/" + videoId);
		return getAlgumVideo(videoId);
	}
	
	// Métodos falsos para simular atividade de rede. Eles são tão lentos como na vida real.

	public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public void latenciaRede() {
        int latenciaAleatoria = random(5, 10);
        for (int i = 0; i < latenciaAleatoria; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
            	exception.printStackTrace();
            }
        }
    }

    public void getConexaoServidor(String server) {
        System.out.print("Conectando na URL " + server + " ... ");
        latenciaRede();
        System.out.print("\nConectado!" + "\n");
    }

    public HashMap<String, Video> getVideosAleatorios() {
        System.out.print("Baixando videos populares... ");

        latenciaRede();
        HashMap<String, Video> hashMap = new HashMap<String, Video>();
        hashMap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hashMap.put("mkafksangasj", new Video("mkafksangasj", "Cachorro brincando com uma bola.mp4"));
        hashMap.put("dancesvideoo", new Video("asdfas3ffasd", "Video dançando.mpq"));
        hashMap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs Real Madrid.mov"));
        hashMap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Lição de Programação#1.avi"));

        System.out.print("Feito!" + "\n");
        return hashMap;
    }

    public Video getAlgumVideo(String videoId) {
        System.out.print("Baixando video... ");

        latenciaRede();
        Video video = new Video(videoId, "Algum título de vídeo");

        System.out.print("Feito!" + "\n");
        return video;
    }
}