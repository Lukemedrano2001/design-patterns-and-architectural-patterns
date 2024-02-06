package gof.estruturais.facade;

import java.io.File;

import gof.estruturais.facade.arquivos.ConversaoVideoFacade;

@SuppressWarnings("unused")
public class Application {
	public static void main(String[] args) {
		ConversaoVideoFacade converter = new ConversaoVideoFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
	}
}