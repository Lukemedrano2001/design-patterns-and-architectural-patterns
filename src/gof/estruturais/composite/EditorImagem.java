package gof.estruturais.composite;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import gof.estruturais.composite.formas.FormaComposta;
import gof.estruturais.composite.formas.IForma;

public class EditorImagem {
    private EditorCanvas canvas;
    private FormaComposta todasFormas = new FormaComposta();

    public EditorImagem() {
        canvas = new EditorCanvas();
    }

    public void carregarFormas(IForma... shapes) {
        todasFormas.clear();
        todasFormas.adicionar(shapes);
        canvas.recarregar();
    }

    @SuppressWarnings("serial")
	private class EditorCanvas extends Canvas {
        JFrame frame;

        private static final int PADDING = 10;

        EditorCanvas() {
            criarFrame();
            recarregar();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evento) {
                    todasFormas.deselecionar();
                    todasFormas.selecionarFilhoNaPosicao(evento.getX(), evento.getY());
                    evento.getComponent().repaint();
                }
            });
        }

        void criarFrame() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel conteudoPainel = new JPanel();
            Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
            conteudoPainel.setBorder(padding);
            frame.setContentPane(conteudoPainel);

            frame.add(this);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        public int getLargura() {
            return todasFormas.getX() + todasFormas.getLargura() + PADDING;
        }

        public int getAltura() {
            return todasFormas.getY() + todasFormas.getAltura() + PADDING;
        }

        void recarregar() {
            this.setSize(getLargura(), getAltura());
            frame.pack();
        }

        public void paint(Graphics graficos) {
            todasFormas.paint(graficos);
        }
    }
}