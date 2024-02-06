package gof.comportamento.visitor.documentos;

import gof.comportamento.visitor.visitantes.IVisitorDocumento;

public interface IDocumentoVisivel {
	public void aceitarVisitante(IVisitorDocumento visitante);
}