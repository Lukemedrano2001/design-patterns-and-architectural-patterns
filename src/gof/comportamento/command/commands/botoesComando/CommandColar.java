package gof.comportamento.command.commands.botoesComando;

import gof.comportamento.command.Editor;
import gof.comportamento.command.commands.Command;

public class CommandColar extends Command { 
	public CommandColar(Editor editor) {
		super(editor);
	}

	@Override
	public boolean execute() {
	    if (editor.prancheta == null || editor.prancheta.isEmpty()) { 
	    	return false;
	    };
	
	    backup();
	    editor.campoTexto.insert(editor.prancheta, editor.campoTexto.getCaretPosition());
	    return true;
	}
}