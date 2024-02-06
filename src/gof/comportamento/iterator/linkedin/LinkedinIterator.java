package gof.comportamento.iterator.linkedin;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.iterator.perfil.IPerfilIterator;
import gof.comportamento.iterator.perfil.Perfil;

public class LinkedinIterator implements IPerfilIterator {
	private Linkedin linkedIn;
    private String tipo;
    private String email;
    private int posicaoAtual = 0;
    private List<String> emails = new ArrayList<>();
    private List<Perfil> contatos = new ArrayList<>();

    public LinkedinIterator(Linkedin linkedin, String tipo, String email) {
        this.linkedIn = linkedin;
        this.tipo = tipo;
        this.email = email;
    }

    public void carregamentoLento() {
        if (emails.size() == 0) {
            List<String> perfis = linkedIn.requestContatosRelacionadosLinkedin(this.email, this.tipo);
            for (String perfil: perfis) {
                this.emails.add(perfil);
                this.contatos.add(null);
            }
        }
    }

    @Override
    public boolean temProximo() {
        carregamentoLento();
        return posicaoAtual < emails.size();
    }

    @Override
    public Perfil getProximo() {
        if (!temProximo()) {
            return null;
        }

        String amigoEmail = emails.get(posicaoAtual);
        Perfil amigoContato = contatos.get(posicaoAtual);
        
        if (amigoContato == null) {
        	amigoContato = linkedIn.requestInformacoesContatoDoLinkedin(amigoEmail);
            contatos.set(posicaoAtual, amigoContato);
        }
        
        posicaoAtual++;
        return amigoContato;
    }

    @Override
    public void resetar() {
        posicaoAtual = 0;
    }
}