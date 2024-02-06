package gof.estruturais.decorator.codigoFonte;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class CodigoFonteArquivo implements ICodigoFonte {
	private String nome;

	public CodigoFonteArquivo(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void escreverDado(String dado) {
		File arquivo = new File(nome);
		
        try (OutputStream fileOutputSystem = new FileOutputStream(arquivo)) {
            fileOutputSystem.write(dado.getBytes(), 0, dado.length());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
	}

	@Override
	public String lerDado() {
		char[] buffer = null;
        File arquivo = new File(nome);
        
        try (FileReader fileLeitor = new FileReader(arquivo)) {
            buffer = new char[(int) arquivo.length()];
            fileLeitor.read(buffer);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        
        return new String(buffer);
	}
}