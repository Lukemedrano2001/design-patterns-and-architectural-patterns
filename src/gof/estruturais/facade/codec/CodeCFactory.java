package gof.estruturais.facade.codec;

import gof.estruturais.facade.arquivos.ArquivoVideo;

public class CodeCFactory {
	public static ICodeC extract(ArquivoVideo arquivo) {
        String type = arquivo.getCodeCTipo();
        
        if (type.equals("mp4")) {
            System.out.println("ICodeC Factory: Extraindo audio no formato mp4/mpeg.");
            return new MPEG4CompressorCodeC();
        } else {
            System.out.println("ICodeC Factory: Extraindo audio no formato ogg.");
            return new OggCompressorCodeC();
        }
    }
}