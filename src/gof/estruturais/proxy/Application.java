package gof.estruturais.proxy;

import gof.estruturais.proxy.bibliotecas.BibliotecaYoutubeTerceirosImpl;
import gof.estruturais.proxy.youtube.YoutubeCacheProxy;
import gof.estruturais.proxy.youtube.YoutubeDownloader;

public class Application {
	public static void main(String[] args) {
		YoutubeDownloader downloadNativo = new YoutubeDownloader(new BibliotecaYoutubeTerceirosImpl());
		YoutubeDownloader downloadInteligente = new YoutubeDownloader(new YoutubeCacheProxy());
		
		long nativo = teste(downloadNativo);
		long inteligente = teste(downloadInteligente);
		System.out.print("Tempo economizado pelo cache do proxy: " + (nativo - inteligente) + "ms");
	}
	
	public static long teste(YoutubeDownloader downloader) {
		long tempoInicial = System.currentTimeMillis();
		
		// Comportamento do usuário em nosso aplicativo:
		downloader.renderizarVideosPopulares();
		downloader.renderizarPaginaVideo("cachorros");
		downloader.renderizarVideosPopulares();
		downloader.renderizarPaginaVideo("videos+de+dança");
		
		// Os usuários podem visitar a mesma página com bastante frequência.
		downloader.renderizarPaginaVideo("gatos");
		downloader.renderizarPaginaVideo("clash+of+clans");
		
		long tempoEstimado = System.currentTimeMillis() - tempoInicial;
		System.out.print("Tempo decorrido: " + tempoEstimado + "ms\n");
		return tempoEstimado;
	}
}