package gof.criacao.singleton;

public class Application {
	public static void main(String[] args) {
        Singleton singleton = Singleton.getInstancia("FOO");
        Singleton anotherSingleton = Singleton.getInstancia("BAR");
        
        if(singleton.equals(anotherSingleton)) {
        	System.out.println("O singleton tem o mesmo valor para ambos. \n");
        } else {
        	System.out.println("2 singletons foram criados e possuem valores diferentes.");
        }
        
        System.out.println(singleton.getValor());
        System.out.println(anotherSingleton.getValor());
	}
}