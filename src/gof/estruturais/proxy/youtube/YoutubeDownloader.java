package gof.estruturais.proxy.youtube;

import java.util.HashMap;

import gof.estruturais.proxy.bibliotecas.IBibliotecaYoutubeTerceiros;
import gof.estruturais.proxy.video.Video;

public class YoutubeDownloader {
	private IBibliotecaYoutubeTerceiros api;

    public YoutubeDownloader(IBibliotecaYoutubeTerceiros api) {
        this.api = api;
    }

    public void renderizarPaginaVideo(String videoId) {
        Video video = api.getVideo(videoId);
        
        System.out.println("\n-------------------------------");
        System.out.println("Página do Vídeo (Imagine um arquivo HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Título: " + video.titulo);
        System.out.println("Vídeo: " + video.dado);
        System.out.println("-------------------------------\n");
    }

    public void renderizarVideosPopulares() {
        HashMap<String, Video> list = api.videosPopulares();
        System.out.println("\n-------------------------------");
        System.out.println("Vídeos mais populares do Youtube (Imagine um arquivo HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Título: " + video.titulo);
        }
        
        System.out.println("-------------------------------\n");
    }
}