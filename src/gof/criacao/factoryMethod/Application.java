package gof.criacao.factoryMethod;

import gof.criacao.factoryMethod.dialog.Dialog;
import gof.criacao.factoryMethod.dialog.HtmlDialog;
import gof.criacao.factoryMethod.dialog.WindowsDialog;

public class Application {
	private static Dialog dialog;
	
	public static void configurar() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    public static void runBusinessLogic() {
        dialog.renderWindow();
    }
    
    public static void main(String[] args) {
        configurar();
        runBusinessLogic();
    }
}