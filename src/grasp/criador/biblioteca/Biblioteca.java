package grasp.criador.biblioteca;

import grasp.criador.livro.Livro;

public class Biblioteca {
	public Livro criarLivro(String titulo, String autor) {
        return new Livro(titulo, autor);
    }
}