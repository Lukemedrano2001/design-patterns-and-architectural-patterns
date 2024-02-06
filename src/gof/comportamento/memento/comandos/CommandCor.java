package gof.comportamento.memento.comandos;

import java.awt.Color;

import gof.comportamento.memento.editor.Editor;
import gof.comportamento.memento.formas.IForma;

public class CommandCor implements ICommand {
    private Editor editor;
    private Color cor;

    public CommandCor(Editor editor, Color cor) {
        this.editor = editor;
        this.cor = cor;
    }

    @Override
    public String getNome() {
        return "Colorindo: " + cor.toString();
    }

    @Override
    public void executar() {
        for (IForma filho: editor.getFormas().getSelecionado()) {
        	filho.setCor(cor);
        }
    }
}