package gof.comportamento.visitor;

import gof.comportamento.visitor.documentos.DocumentoPDF;
import gof.comportamento.visitor.documentos.DocumentoWord;
import gof.comportamento.visitor.visitantes.IVisitorDocumento;

public class ProcessadorDocumento implements IVisitorDocumento {
	@Override
	public void visitarDocumentoPDF(DocumentoPDF documentoPDF) {
		System.out.println("Processando o documento PDF: " + documentoPDF.toString());
	}

	@Override
	public void visitarDocumentoWord(DocumentoWord documentoWord) {
		System.out.println("Processando o documento PDF: " + documentoWord.toString());
	}
}