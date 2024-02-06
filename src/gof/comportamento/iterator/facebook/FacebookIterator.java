package gof.comportamento.iterator.facebook;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.iterator.perfil.IPerfilIterator;
import gof.comportamento.iterator.perfil.Perfil;

public class FacebookIterator implements IPerfilIterator {
	private Facebook facebook;
    private String tipo;
    private String email;
    private int posicaoAtual = 0;
    private List<String> emails = new ArrayList<>();
    private List<Perfil> perfis = new ArrayList<>();

    public FacebookIterator(Facebook facebook, String tipo, String email) {
        this.facebook = facebook;
        this.tipo = tipo;
        this.email = email;
    }

    private void carregamentoLento() {
        if (emails.size() == 0) {
            List<String> perfis = facebook.requestPerfilAmigosDoFacebook(this.email, this.tipo);
            for (String perfil: perfis) {
                this.emails.add(perfil);
                this.perfis.add(null);
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
        Perfil amigoPerfil = perfis.get(posicaoAtual);
        
        if (amigoPerfil == null) {
        	amigoPerfil = facebook.requestPerfilDoFacebook(amigoEmail);
            perfis.set(posicaoAtual, amigoPerfil);
        }
        
        posicaoAtual++;
        return amigoPerfil;
    }

    @Override
    public void resetar() {
        posicaoAtual = 0;
    }
}