package gof.estruturais.facade.arquivos;

import gof.estruturais.facade.codec.ICodeC;

public class LeitorTaxaBits {
	public static ArquivoVideo ler(ArquivoVideo arquivo, ICodeC iCodeC) {
        System.out.println("Leitor de Taxa de Bits: Lendo arquivo.");
        return arquivo;
    }

    public static ArquivoVideo converter(ArquivoVideo buffer, ICodeC iCodeC) {
        System.out.println("Leitor de Taxa de Bits: Convertendo arquivo.");
        return buffer;
    }
}