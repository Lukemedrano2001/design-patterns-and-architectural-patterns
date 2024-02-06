package gof.estruturais.decorator.criptografia;

import java.util.Base64;

import gof.estruturais.decorator.codigoFonte.CodigoFonteDecorator;
import gof.estruturais.decorator.codigoFonte.ICodigoFonte;

public class CriptografiaDecorator extends CodigoFonteDecorator {
	public CriptografiaDecorator(ICodigoFonte codigo) {
        super(codigo);
    }

    @Override
    public void escreverDado(String dado) {
        super.escreverDado(encode(dado));
    }

    @Override
    public String lerDado() {
        return decodificar(super.lerDado());
    }

    private String encode(String dado) {
        byte[] resultado = dado.getBytes();
        for (int i = 0; i < resultado.length; i++) {
        	resultado[i] += (byte) 1;
        }
        
        return Base64.getEncoder().encodeToString(resultado);
    }

    private String decodificar(String dado) {
        byte[] resultado = Base64.getDecoder().decode(dado);
        for (int i = 0; i < resultado.length; i++) {
        	resultado[i] -= (byte) 1;
        }
        
        return new String(resultado);
    }
}