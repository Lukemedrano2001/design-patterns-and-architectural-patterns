package gof.estruturais.facade.arquivos;

public class ArquivoVideo {
	private String nome;
	private String codeCTipo;
	
	public ArquivoVideo(String nome) {
		this.nome = nome;
        this.codeCTipo = nome.substring(nome.indexOf(".") + 1);
	}

	public String getNome() {
		return nome;
	}

	public String getCodeCTipo() {
		return codeCTipo;
	}
}