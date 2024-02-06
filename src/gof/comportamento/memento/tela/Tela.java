package gof.comportamento.memento.tela;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import gof.comportamento.memento.comandos.CommandCor;
import gof.comportamento.memento.comandos.CommandMover;
import gof.comportamento.memento.editor.Editor;
import gof.comportamento.memento.formas.IForma;

@SuppressWarnings("serial")
public class Tela extends Canvas {    
	private Editor editor;
	private JFrame frame;
	private static final int PADDING = 10;
	
	public Tela(Editor editor) {
	    this.editor = editor;
	    createFrame();
	    attachKeyboardListeners();
	    attachMouseListeners();
	    recarregar();
	}
	
	private void createFrame() {
	    frame = new JFrame();
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	
	    JPanel conteudoPainel = new JPanel();
	    Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
	    conteudoPainel.setBorder(padding);
	    conteudoPainel.setLayout(new BoxLayout(conteudoPainel, BoxLayout.Y_AXIS));
	    frame.setContentPane(conteudoPainel);
	
	    conteudoPainel.add(new JLabel("Selecione e arraste para mover."), BorderLayout.PAGE_END);
        conteudoPainel.add(new JLabel("Clique direito para mudar a cor."), BorderLayout.PAGE_END);
        conteudoPainel.add(new JLabel("Desfazer: Ctrl+Z, Refazer: Ctrl+R"), BorderLayout.PAGE_END);
        conteudoPainel.add(this);
	    frame.setVisible(true);
	    conteudoPainel.setBackground(Color.LIGHT_GRAY);
	}
	
	private void attachKeyboardListeners() {
	    addKeyListener(new KeyAdapter() { 
	        @Override
	        public void keyPressed(KeyEvent evento) {
	            if ((evento.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) == InputEvent.CTRL_DOWN_MASK) {
	                switch (evento.getKeyCode()) {
	                    case KeyEvent.VK_Z:
	                        editor.desfazer();
	                        break;
	                    case KeyEvent.VK_R:
	                        editor.refazer();
	                        break;
	                }
	            }
	        }
	    });
	}
	
	private void attachMouseListeners() {
	    MouseAdapter colorizer = new MouseAdapter() {
	        @Override 
	        public void mousePressed(MouseEvent evento) {
	            if (evento.getButton() != MouseEvent.BUTTON3) {
	                return;
	            }
	            
	            IForma target = editor.getFormas().getChildAt(evento.getX(), evento.getY());
	            if (target != null) {
	                editor.executar(new CommandCor(editor, new Color((int) (Math.random() * 0x1000000))));
	                repaint();
	            }
	        }
	    };
	    
	    addMouseListener(colorizer);
	
	    MouseAdapter selector = new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent evento) {
	            if (evento.getButton() != MouseEvent.BUTTON1) {
	                return;
	            } 
	
	            IForma alvo = editor.getFormas().getChildAt(evento.getX(), evento.getY());
	            boolean ctrl = (evento.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) == ActionEvent.CTRL_MASK;
	
	            if (alvo == null) {
	                if (!ctrl) { 
	                    editor.getFormas().deselecionar();
	                }
	            } else {
	                if (ctrl) {
	                    if (alvo.isSelecionado()) {
	                        alvo.deselecionar();
	                    } else {
	                        alvo.selecionar();
	                    }
	                } else {
	                    if (!alvo.isSelecionado()) {
	                        editor.getFormas().deselecionar();
	                    }
	                    
	                    alvo.selecionar();
	                }
	            }
	            
	            repaint();
	        }
	    };
	    
	    addMouseListener(selector);
	
	
	    MouseAdapter dragger = new MouseAdapter() {
	    	CommandMover moveCommand;
	 
	        @Override
	        public void mouseDragged(MouseEvent evento) {
	            if ((evento.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != MouseEvent.BUTTON1_DOWN_MASK) {
	                return;
	            }
	            
	            if (moveCommand == null) {
	                moveCommand = new CommandMover(editor);
	                moveCommand.comecar(evento.getX(), evento.getY());
	            }
	            
	            moveCommand.mover(evento.getX(), evento.getY());
	            repaint();
	        }
	
	        @Override
	        public void mouseReleased(MouseEvent evento) {
	            if (evento.getButton() != MouseEvent.BUTTON1 || moveCommand == null) {
	                return; 
	            }
	            
	            moveCommand.parar(evento.getX(), evento.getY());
	            editor.executar(moveCommand);
	            this.moveCommand = null;
	            repaint();
	        }
	    };
	    addMouseListener(dragger);
	    addMouseMotionListener(dragger);
	}
	
	public int getWidth() {
	    return editor.getFormas().getX() + editor.getFormas().getLargura() + PADDING;
	}
	
	public int getHeight() {
	    return editor.getFormas().getY() + editor.getFormas().getAltura() + PADDING;
	}
	
	public void recarregar() {
	    this.setSize(getWidth(), getHeight());
	    frame.pack();
	}
	
	public void update(Graphics graficos) {
	    paint(graficos); 
	}
	 
	public void paint(Graphics graficos) {
	    BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D graficos2D = buffer.createGraphics();
	    graficos2D.setBackground(Color.WHITE);
	    graficos2D.clearRect(0, 0, this.getWidth(), this.getHeight());
	
	    editor.getFormas().paint(buffer.getGraphics());
	
	    graficos.drawImage(buffer, 0, 0, null);
	}
}