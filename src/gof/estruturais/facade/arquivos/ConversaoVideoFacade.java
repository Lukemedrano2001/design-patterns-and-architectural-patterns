package gof.estruturais.facade.arquivos;

import java.io.File;

import gof.estruturais.facade.codec.CodeCFactory;
import gof.estruturais.facade.codec.ICodeC;
import gof.estruturais.facade.codec.MPEG4CompressorCodeC;
import gof.estruturais.facade.codec.OggCompressorCodeC;

public class ConversaoVideoFacade {
	public File convertVideo(String fileName, String format) {
        System.out.println("Conversão BibliotecaYoutubeTerceirosImpl Facade: Conversão começou.");
        ArquivoVideo arquivo = new ArquivoVideo(fileName);
        ICodeC codigoCodeC = CodeCFactory.extract(arquivo);
        ICodeC destinoCodeC;
        
        if (format.equals("mp4")) {
            destinoCodeC = new MPEG4CompressorCodeC();
        } else {
            destinoCodeC = new OggCompressorCodeC();
        }
        
        ArquivoVideo buffer = LeitorTaxaBits.ler(arquivo, codigoCodeC);
        ArquivoVideo resultadoIntermediario = LeitorTaxaBits.converter(buffer, destinoCodeC);
        File resultado = (new MixerAudio()).mixar(resultadoIntermediario);
        System.out.println("Conversão BibliotecaYoutubeTerceirosImpl Facade: Conversão finalizada.");
        return resultado;
    }
}