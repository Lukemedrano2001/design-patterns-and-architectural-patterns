package gof.comportamento.command.commands.botoesComando;

import gof.comportamento.command.Editor;
import gof.comportamento.command.commands.Command;

public class CommandCopiar extends Command {
	public CommandCopiar(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.prancheta = editor.campoTexto.getSelectedText();
        return false;
    }
}