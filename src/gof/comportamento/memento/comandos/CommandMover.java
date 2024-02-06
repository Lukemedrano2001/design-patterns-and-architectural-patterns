package gof.comportamento.memento.comandos;

import gof.comportamento.memento.editor.Editor;
import gof.comportamento.memento.formas.IForma;

public class CommandMover implements ICommand {
    private Editor editor;
    private int inicioX;
    private int inicioY; 
    private int fimX;
    private int fimY; 

    public CommandMover(Editor editor) {
        this.editor = editor;
    }

    @Override
    public String getNome() {
        return "X: " + (fimX - inicioX) + " Y: " + (fimY - inicioY);
    }

    public void comecar(int x, int y) {
        this.inicioX = x;
        this.inicioY = y;
        for (IForma filho: editor.getFormas().getSelecionado()) {
        	filho.arrastar();
        }
    }

    public void mover(int x, int y) {
        for (IForma filho: editor.getFormas().getSelecionado()) {
        	filho.moverPara(x - inicioX, y - inicioY);
        }
    }

    public void parar(int x, int y) {
        this.fimX = x;
        this.fimY = y;
        for (IForma filho: editor.getFormas().getSelecionado()) {
        	filho.soltar();
        }
    }

    @Override
    public void executar() {
        for (IForma filho: editor.getFormas().getSelecionado()) {
        	filho.moverAte(fimX - inicioX, fimY - inicioY);
        }
    }
}