package gof.comportamento.memento.mementos;

import gof.comportamento.memento.editor.Editor;

public class Memento {
	private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restaurar() {
        editor.restaurar(backup);
    }
}