package gof.estruturais.facade.arquivos;

import java.io.File;

public class MixerAudio {
	public File mixar(ArquivoVideo resultado){
        System.out.println("Mixer Audio: Mixando audio.");
        return new File("tmp");
    }
}