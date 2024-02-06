package grasp.criador;

import grasp.criador.biblioteca.Biblioteca;
import grasp.criador.livro.Livro;

public class Application {
	public static void main(String[] args) {
		// A classe Biblioteca é responsável por criar instâncias de Livro
        Biblioteca biblioteca = new Biblioteca();

        // Criando um novo livro usando a Biblioteca
        Livro livro1 = biblioteca.criarLivro("Design Patterns", "Erich Gamma");
        Livro livro2 = biblioteca.criarLivro("Clean Code", "Robert C. Martin");

        // Exibir no console
        System.out.println(livro1.toString());
        System.out.println(livro2.toString());
	}
}