package gof.estruturais.decorator.compressor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import gof.estruturais.decorator.codigoFonte.CodigoFonteDecorator;
import gof.estruturais.decorator.codigoFonte.ICodigoFonte;

public class CompressorDecorator extends CodigoFonteDecorator {
	private int nivelCompressao = 6;

    public CompressorDecorator(ICodigoFonte codigo) {
        super(codigo);
    }

    public int getNivelCompressao() {
        return nivelCompressao;
    }

    public void setNivelCompressao(int valor) {
    	nivelCompressao = valor;
    }

    @Override
    public void escreverDado(String dado) {
        super.escreverDado(compressao(dado));
    }

    @Override
    public String lerDado() {
        return descompressao(super.lerDado());
    }

    public String compressao(String stringDado) {
        byte[] dados = stringDado.getBytes();
        
        try {
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream(512);
            DeflaterOutputStream deflaterOutStream = new DeflaterOutputStream(byteArrayOutStream, new Deflater(nivelCompressao));
            
            deflaterOutStream.write(dados);
            deflaterOutStream.close();
            byteArrayOutStream.close();
            
            return Base64.getEncoder().encodeToString(byteArrayOutStream.toByteArray());
        } catch (IOException exception) {
            return null;
        }
    }

    public String descompressao(String stringDado) {
        byte[] dados = Base64.getDecoder().decode(stringDado);
        
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(dados);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream(512);
            
            int bytes;
            while ((bytes = inflaterInputStream.read()) != -1) {
                byteArrayOutStream.write(bytes);
            }
            
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutStream.close();
            return new String(byteArrayOutStream.toByteArray());
        } catch (IOException exception) {
            return null;
        }
    }
}