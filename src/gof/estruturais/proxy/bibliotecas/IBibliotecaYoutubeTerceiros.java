package gof.estruturais.proxy.bibliotecas;

import java.util.HashMap;

import gof.estruturais.proxy.video.Video;

public interface IBibliotecaYoutubeTerceiros {
	public HashMap<String, Video> videosPopulares();
	public Video getVideo(String videoId);
}