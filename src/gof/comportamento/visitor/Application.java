package gof.comportamento.visitor;

import gof.comportamento.visitor.documentos.DocumentoPDF;
import gof.comportamento.visitor.documentos.DocumentoWord;
import gof.comportamento.visitor.documentos.IDocumentoVisivel;
import gof.comportamento.visitor.visitantes.IVisitorDocumento;

public class Application {
	public static void main(String[] args) {
		IDocumentoVisivel documentoPDF = new DocumentoPDF("word", "docx");
        IDocumentoVisivel documentoWord = new DocumentoWord("excel", "xlsx");

        IVisitorDocumento processador = new ProcessadorDocumento();

        documentoPDF.aceitarVisitante(processador);
        documentoWord.aceitarVisitante(processador);
	}
}