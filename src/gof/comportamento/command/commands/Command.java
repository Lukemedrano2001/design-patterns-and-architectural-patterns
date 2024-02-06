package gof.comportamento.command.commands;

import gof.comportamento.command.Editor;

public abstract class Command {
	public Editor editor;
	public String backup;
	
	public Command(Editor editor) {
		this.editor = editor;
	}
	
	public void backup() {
        backup = editor.campoTexto.getText();
    }

    public void desfazer() {
        editor.campoTexto.setText(backup);
    }

    public abstract boolean execute();

	public String getName() {
		return null;
	}
}