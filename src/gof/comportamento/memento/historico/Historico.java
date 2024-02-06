package gof.comportamento.memento.historico;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.memento.comandos.ICommand;
import gof.comportamento.memento.mementos.Memento;

public class Historico {
    private List<Pair> historico = new ArrayList<Pair>();
    private int ladoVirtual = 0;  

    private class Pair {
        ICommand command;
        Memento memento;
        Pair(ICommand command, Memento memento) {
            this.command = command;
            this.memento = memento;
        }

        private ICommand getCommand() {
            return command;
        }

        private Memento getMemento() {
            return memento;
        }
    }

    public void push(ICommand command, Memento memento) {
        if (ladoVirtual != historico.size() && ladoVirtual > 0) {
            historico = historico.subList(0, ladoVirtual - 1);
        }
         
        historico.add(new Pair(command, memento));
        ladoVirtual = historico.size();
    }

    public boolean desfazer() {
        Pair pair = getDesfazer();
        if (pair == null) {
            return false;
        }
        
        System.out.println("Desfazendo: " + pair.getCommand().getNome());
        pair.getMemento().restaurar();
        return true;
    }

    public boolean refazer() {
        Pair pair = getRefazer();
        if (pair == null) {
            return false;
        }
        
        System.out.println("Refazendo: " + pair.getCommand().getNome());
        pair.getMemento().restaurar();
        pair.getCommand().executar();
        return true;
    }

    private Pair getDesfazer() {
        if (ladoVirtual == 0) {
            return null;
        }
        
        ladoVirtual = Math.max(0, ladoVirtual - 1);
        return historico.get(ladoVirtual);
    }

    private Pair getRefazer() {
        if (ladoVirtual == historico.size()) {
            return null;
        }
        
        ladoVirtual = Math.min(historico.size(), ladoVirtual + 1);
        return historico.get(ladoVirtual - 1);
    }
}