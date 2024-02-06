package gof.comportamento.mediator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import gof.comportamento.mediator.botoes.BotaoAdicionar;
import gof.comportamento.mediator.botoes.BotaoDeletar;
import gof.comportamento.mediator.botoes.BotaoSalvar;
import gof.comportamento.mediator.filtro.Filtro;
import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;
import gof.comportamento.mediator.lista.Lista;
import gof.comportamento.mediator.textos.CaixaDeTexto;
import gof.comportamento.mediator.textos.Nota;
import gof.comportamento.mediator.textos.Titulo;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Editor implements IMediator {
	private Titulo titulo;
    private CaixaDeTexto caixaDeTexto;
    private BotaoAdicionar adicionar;
    private BotaoDeletar deletar;
    private BotaoSalvar salvar; 
    private Lista lista;
    private Filtro filtro;
  
    private JLabel labelTitulo = new JLabel("Título:");
    private JLabel labelTexto = new JLabel("Texto:");
    private JLabel label = new JLabel("Adicione ou Selecione uma nota existente para prosseguir ...");
  
    @Override
    public void registrarComponente(IComponente componente) {
        componente.setMediator(this);
        String componenteNome = componente.getNome();
         
        if(componenteNome.equalsIgnoreCase("Botao de Adicionar")) {
        	this.adicionar = (BotaoAdicionar)componente;
        } else if(componenteNome.equalsIgnoreCase("Botao de Deletar")) {
        	this.deletar = (BotaoDeletar)componente;
        } else if(componenteNome.equalsIgnoreCase("Filtro")) {
        	this.filtro = (Filtro)componente;
        } else if(componenteNome.equalsIgnoreCase("Lista")) {
        	this.lista = (Lista)componente;
            this.lista.addListSelectionListener(listaSelecaoEvento -> {
                Nota nota = (Nota)lista.getSelectedValue();
                if (nota != null) {
                	getInformacoesDaLista(nota);
                } else {
                    limpar();
                }
            });
        } else if(componenteNome.equalsIgnoreCase("Botao de Salvar")) {
        	this.salvar = (BotaoSalvar)componente;
        } else if(componenteNome.equalsIgnoreCase("Caixa de Texto")) {
        	this.caixaDeTexto = (CaixaDeTexto)componente;
        }  else if(componenteNome.equalsIgnoreCase("Titulo")) {
        	this.titulo = (Titulo)componente;
        }
    }

    @Override
    public void adicionarNovaNota(Nota nota) {
        titulo.setText("");
        caixaDeTexto.setText("");
        lista.adicionarElemento(nota);
    }

    @Override
    public void deletarNota() {
        lista.deletarElemento();
    }

    @Override
    public void getInformacoesDaLista(Nota nota) {
        titulo.setText(nota.getNome().replace('*', ' '));
        caixaDeTexto.setText(nota.getTexto());
    }

    @Override
    public void salvarMudancas() {
        try {
            Nota nota = (Nota) lista.getSelectedValue();
            nota.setNome(titulo.getText());
            nota.setTexto(caixaDeTexto.getText());
            lista.repaint();
        } catch (NullPointerException ignorar) {}
    }

    @Override
    public void marcarNota() {
        try {
            Nota nota = lista.getElementoAtual();
            String nome = nota.getNome();
            
            if (!nome.endsWith("*")) {
                nota.setNome(nota.getNome() + "*");
            }
            
            lista.repaint();
        } catch (NullPointerException ignorar) {}
    }

    @Override
    public void limpar() {
        titulo.setText("");
        caixaDeTexto.setText("");
    }

    @Override
    public void enviarParaFiltro(ListModel lista) {
        filtro.setList(lista);
    }

    @Override
    public void setListaElementos(ListModel lista) {
        this.lista.setModel(lista);
        this.lista.repaint();
    }

    @Override
    public void esconderElementos(boolean bandeira) {
        labelTitulo.setVisible(!bandeira);
        labelTexto.setVisible(!bandeira);
        titulo.setVisible(!bandeira);
        caixaDeTexto.setVisible(!bandeira);
        salvar.setVisible(!bandeira);
        label.setVisible(bandeira); 
    }
  
    @Override
    public void createGUI() {
        JFrame notas = new JFrame("Notas");
        notas.setSize(960, 600);
        
        notas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel esquerda = new JPanel();
        esquerda.setBorder(new LineBorder(Color.BLACK));
        esquerda.setSize(320, 600);
        esquerda.setLayout(new BoxLayout(esquerda, BoxLayout.Y_AXIS));
        
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filtro:"));
        filtro.setColumns(20);
        filterPanel.add(filtro);
        filterPanel.setPreferredSize(new Dimension(280, 40));
        
        JPanel listPanel = new JPanel();
        lista.setFixedCellWidth(260);
        listPanel.setSize(320, 470);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(275, 410));
        listPanel.add(scrollPane);
        
        JPanel botaoPainel = new JPanel();
        this.adicionar.setPreferredSize(new Dimension(85, 25));
        botaoPainel.add(adicionar);
        deletar.setPreferredSize(new Dimension(85, 25));
        botaoPainel.add(deletar);
        botaoPainel.setLayout(new FlowLayout());
        esquerda.add(filterPanel);
        esquerda.add(listPanel); 
        esquerda.add(botaoPainel);
        
        JPanel direita = new JPanel(); 
        direita.setLayout(null);
        direita.setSize(640, 600);
        direita.setLocation(320, 0);
        direita.setBorder(new LineBorder(Color.BLACK));
        
        labelTitulo.setBounds(20, 4, 50, 20);
        titulo.setBounds(60, 5, 555, 20);
        labelTexto.setBounds(20, 4, 50, 130);
        caixaDeTexto.setBorder(new LineBorder(Color.DARK_GRAY));
        caixaDeTexto.setBounds(20, 80, 595, 410);
        salvar.setBounds(270, 535, 80, 25);
        label.setFont(new Font("Verdana", Font.PLAIN, 22));
        label.setBounds(100, 240, 500, 100);
        
        direita.add(label);
        direita.add(labelTitulo);
        direita.add(titulo);
        direita.add(labelTexto);
        direita.add(caixaDeTexto);
        direita.add(salvar);
        
        notas.setLayout(null);
        notas.getContentPane().add(esquerda);
        notas.getContentPane().add(direita);
        notas.setResizable(false);
        notas.setLocationRelativeTo(null);
        notas.setVisible(true);
    }
}