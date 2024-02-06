package gof.comportamento.command.commands;

import java.util.Stack;

public class CommandHistorico {
	private Stack<Command> historico = new Stack<Command>();

    public void push(Command command) {
        historico.push(command);
    }

    public Command pop() {
        return historico.pop();
    }

    public boolean isEmpty() { 
    	return historico.isEmpty(); 
    }
}