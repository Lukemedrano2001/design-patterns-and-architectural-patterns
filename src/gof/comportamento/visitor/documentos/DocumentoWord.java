package gof.comportamento.visitor.documentos;

import gof.comportamento.visitor.visitantes.IVisitorDocumento;

public class DocumentoWord extends Documento implements IDocumentoVisivel {
	public DocumentoWord(String nome, String extensao) {
		super(nome, extensao);
	}
	
	@Override
	public void aceitarVisitante(IVisitorDocumento visitante) {
		visitante.visitarDocumentoWord(this);
	}
}