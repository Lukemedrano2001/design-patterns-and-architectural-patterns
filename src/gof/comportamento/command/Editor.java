package gof.comportamento.command;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import gof.comportamento.command.commands.Command;
import gof.comportamento.command.commands.CommandHistorico;
import gof.comportamento.command.commands.botoesComando.CommandColar;
import gof.comportamento.command.commands.botoesComando.CommandCopiar;
import gof.comportamento.command.commands.botoesComando.CommandRecortar;

public class Editor {
	public JTextArea campoTexto;
    public String prancheta;
    private CommandHistorico history = new CommandHistorico();

    public void init() {
        JFrame frame = new JFrame("Editor de Texto");
        JPanel content = new JPanel();
        
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        campoTexto = new JTextArea();
        campoTexto.setLineWrap(true);
        content.add(campoTexto);
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl + C");
        JButton ctrlX = new JButton("Ctrl + X");
        JButton ctrlV = new JButton("Ctrl + V");
        JButton ctrlZ = new JButton("Ctrl + Z");
        Editor editor = this;
        
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
            	executarCommand(new CommandCopiar(editor));
            }
        });
        
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
            	executarCommand(new CommandRecortar(editor));
            }
        });
        
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
            	executarCommand(new CommandColar(editor));
            }
        });
        
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
            	desfazerCommand();
            }
        });
        
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        
        content.add(buttons);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executarCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void desfazerCommand() {
        if (history.isEmpty()) {
        	return;
        }

        Command command = history.pop();
        if (command != null) {
            command.desfazer();
        }
    }
}