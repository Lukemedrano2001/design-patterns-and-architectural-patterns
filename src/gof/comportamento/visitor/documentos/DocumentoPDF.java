package gof.comportamento.visitor.documentos;

import gof.comportamento.visitor.visitantes.IVisitorDocumento;

public class DocumentoPDF extends Documento implements IDocumentoVisivel {
	public DocumentoPDF(String nome, String extensao) {
		super(nome, extensao);
	}
	
	@Override
	public void aceitarVisitante(IVisitorDocumento visitante) {
		visitante.visitarDocumentoPDF(this);
	}
}