package gof.estruturais.proxy.youtube;

import java.util.HashMap;

import gof.estruturais.proxy.bibliotecas.BibliotecaYoutubeTerceirosImpl;
import gof.estruturais.proxy.bibliotecas.IBibliotecaYoutubeTerceiros;
import gof.estruturais.proxy.video.Video;

public class YoutubeCacheProxy implements IBibliotecaYoutubeTerceiros {
	private IBibliotecaYoutubeTerceiros youtubeServico;
    private HashMap<String, Video> cacheVideosPopulares = new HashMap<String, Video>();
    private HashMap<String, Video> cacheTodosVideos = new HashMap<String, Video>();

    public YoutubeCacheProxy() {
        this.youtubeServico = new BibliotecaYoutubeTerceirosImpl();
    }

    @Override
    public HashMap<String, Video> videosPopulares() {
        if (cacheVideosPopulares.isEmpty()) {
            cacheVideosPopulares = youtubeServico.videosPopulares();
        } else {
            System.out.println("Retornando a lista para o cache.");
        }
        return cacheVideosPopulares;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheTodosVideos.get(videoId);
        if (video == null) {
            video = youtubeServico.getVideo(videoId);
            cacheTodosVideos.put(videoId, video);
        } else {
            System.out.println("Retornando Vídeo " + videoId + " para o cache.");
        }
        
        return video;
    }

    public void reset() {
        cacheVideosPopulares.clear();
        cacheTodosVideos.clear();
    }
}