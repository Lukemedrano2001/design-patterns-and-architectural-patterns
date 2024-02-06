package gof.comportamento.visitor.documentos;

public abstract class Documento {
	private String nome;
	private String extensao;
	
	public Documento(String nome, String extensao) {
		this.nome = nome;
		this.extensao = extensao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	@Override
	public String toString() {
		String arquivoCompleto = this.getNome() + "." + this.getExtensao();
		return String.format("%s", arquivoCompleto);
	}
}