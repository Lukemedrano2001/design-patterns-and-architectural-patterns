package gof.comportamento.visitor.visitantes;

import gof.comportamento.visitor.documentos.DocumentoPDF;
import gof.comportamento.visitor.documentos.DocumentoWord;

public interface IVisitorDocumento {
	public void visitarDocumentoWord(DocumentoWord documentoWord);
	public void visitarDocumentoPDF(DocumentoPDF documentoPDF);
}