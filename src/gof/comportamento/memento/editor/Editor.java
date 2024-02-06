package gof.comportamento.memento.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import javax.swing.JComponent;

import gof.comportamento.memento.comandos.ICommand;
import gof.comportamento.memento.formas.FormaComposta;
import gof.comportamento.memento.formas.IForma;
import gof.comportamento.memento.historico.Historico;
import gof.comportamento.memento.mementos.Memento;
import gof.comportamento.memento.tela.Tela;

@SuppressWarnings("serial")
public class Editor extends JComponent { 
	private Tela tela; 
	private FormaComposta todasFormas = new FormaComposta();
	private Historico historico;
	
	public Editor() { 
	    tela = new Tela(this); 
	    historico = new Historico();
	}
	
	public void carregarFormas(IForma... formas) {
	    todasFormas.limpar();
	    todasFormas.adicionar(formas);
	    tela.recarregar();
	}
	
	public FormaComposta getFormas() {
	    return todasFormas;
	}
	
	public void executar(ICommand command) {
	    historico.push(command, new Memento(this));
	    command.executar();
	}
	
	public void desfazer() {
	    if (historico.desfazer())
	        tela.repaint();
	}
	
	public void refazer() {
	    if (historico.refazer())
	        tela.repaint();
	}
	
	public String backup() {
	    try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        oos.writeObject(this.todasFormas);
	        oos.close();
	        return Base64.getEncoder().encodeToString(baos.toByteArray());
	    } catch (IOException e) {
	        return "";
	    }
	}
	
	public void restaurar(String estado) {
	    try {
	        byte[] data = Base64.getDecoder().decode(estado);
	        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
	        this.todasFormas = (FormaComposta) ois.readObject();
	        ois.close();
	    } catch (ClassNotFoundException exception) {
	        System.out.print("ClassNotFoundException ocorreu.");
	    } catch (IOException exception) {
	        System.out.print("IOException ocorreu.");
	    }
	}
}