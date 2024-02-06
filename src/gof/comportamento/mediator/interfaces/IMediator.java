package gof.comportamento.mediator.interfaces;

import javax.swing.ListModel;

import gof.comportamento.mediator.textos.Nota;

@SuppressWarnings("rawtypes")
public interface IMediator {
	void adicionarNovaNota(Nota nota);
    void deletarNota();
    void getInformacoesDaLista(Nota nota);
    void salvarMudancas();
    void marcarNota();
    void limpar();
	void enviarParaFiltro(ListModel lista);
    void setListaElementos(ListModel lista);
    void registrarComponente(IComponente Componente);
    void esconderElementos(boolean bandeira);
    void createGUI();
}