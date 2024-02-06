package gof.criacao.abstractFactory;

import gof.criacao.abstractFactory.gui.IGUIFactory;
import gof.criacao.abstractFactory.gui.MacOSFactory;
import gof.criacao.abstractFactory.gui.WindowsFactory;

public class Application {
	public static ConfiguracaoApplication configureApplication() {
        ConfiguracaoApplication app;
        IGUIFactory factory;
        
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new ConfiguracaoApplication(factory);
        return app;
    }
	
	 public static void main(String[] args) {
		 ConfiguracaoApplication app = configureApplication();
		 app.paint();
	 }
}