package gof.comportamento.command.commands.botoesComando;

import gof.comportamento.command.Editor;
import gof.comportamento.command.commands.Command;

public class CommandRecortar extends Command { 
	public CommandRecortar(Editor editor) {
		super(editor);
	}

	@Override
	public boolean execute() {
		String textoSelecionado = editor.campoTexto.getSelectedText();
	    if (textoSelecionado != null && !textoSelecionado.isEmpty()) {
	        backup();
	        String fonte = editor.campoTexto.getText();
	        editor.prancheta = textoSelecionado;
	        editor.campoTexto.setText(recortarString(fonte));
	        return true;
	    } else {
	        return false;
	    }
	}
	
	private String recortarString(String fonte) {
	    String inicio = fonte.substring(0, editor.campoTexto.getSelectionStart());
	    String fim = fonte.substring(editor.campoTexto.getSelectionEnd());
	    return inicio + fim;
	}
}