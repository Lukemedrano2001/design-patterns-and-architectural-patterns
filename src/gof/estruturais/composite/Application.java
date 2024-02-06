package gof.estruturais.composite;

import java.awt.Color;

import gof.estruturais.composite.formas.Circulo;
import gof.estruturais.composite.formas.FormaComposta;
import gof.estruturais.composite.formas.Ponto;
import gof.estruturais.composite.formas.Retangulo;

public class Application {
    public static void main(String[] args) {
        EditorImagem editor = new EditorImagem();

        editor.carregarFormas(
                new Circulo(10, 10, 10, Color.BLUE),

                new FormaComposta(
                    new Circulo(110, 110, 50, Color.RED),
                    new Ponto(160, 160, Color.RED)
                ),

                new FormaComposta(
                        new Retangulo(250, 250, 100, 100, Color.GREEN),
                        new Ponto(240, 240, Color.GREEN),
                        new Ponto(240, 360, Color.GREEN),
                        new Ponto(360, 360, Color.GREEN),
                        new Ponto(360, 240, Color.GREEN)
                )
        );
    }
}