package gof.comportamento.state.player;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerGUI {
	private Player player;
	private static JTextField textField = new JTextField();
	
	public PlayerGUI(Player player) {
	    this.player = player;
	}
	
	public void init() {
	    // Frame
		JFrame frame = new JFrame("Player");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Contexto
	    JPanel contexto = new JPanel();
	    contexto.setLayout(new BoxLayout(contexto, BoxLayout.Y_AXIS));
	    frame.getContentPane().add(contexto); 
	    
	    // Botões
	    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    contexto.add(textField);
	    contexto.add(buttons);
	
	    // Play
	    JButton play = new JButton("Tocar");
	    play.addActionListener(evento -> textField.setText(player.getState().onPlay()));
	    
	    // Stop
	    JButton pausar = new JButton("Pausar");
	    pausar.addActionListener(evento -> textField.setText(player.getState().onLock()));
	    
	    // Next
	    JButton proximo = new JButton("Próximo");
	    proximo.addActionListener(evento -> textField.setText(player.getState().onNext()));
	    
	    // Previous
	    JButton anterior = new JButton("Anterior");
	    anterior.addActionListener(evento -> textField.setText(player.getState().onPrevious()));
	    
	    // Frame
	    frame.setVisible(true);
	    frame.setSize(400, 100);
	    
	    // Botões
	    buttons.add(play);
	    buttons.add(pausar);
	    buttons.add(proximo);
	    buttons.add(anterior);
	}
}