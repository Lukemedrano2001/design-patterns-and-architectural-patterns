package gof.comportamento.iterator.facebook;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.iterator.perfil.IPerfilIterator;
import gof.comportamento.iterator.perfil.Perfil;
import gof.comportamento.iterator.redeSocial.IRedeSocial;

public class Facebook implements IRedeSocial { 
	private List<Perfil> perfis;

    public Facebook(List<Perfil> cache) {
        if (cache != null) {
            this.perfis = cache;
        } else {
            this.perfis = new ArrayList<>();
        }
    }

    public Perfil requestPerfilDoFacebook(String perfilEmail) {
        latenciaRede();
        System.out.println("Facebook: Carregando perfil '" + perfilEmail + " pela rede...");

        return findPerfil(perfilEmail);
    }

    public List<String> requestPerfilAmigosDoFacebook(String perfilEmail, String tipoContato) {
        latenciaRede();
        System.out.println("Facebook: Carregando " + tipoContato + " lista de " + perfilEmail + " pela rede...");

        Perfil perfil = findPerfil(perfilEmail);
        if (perfil != null) {
            return perfil.getContatos(tipoContato);
        }
        
        return null;
    }

    public Perfil findPerfil(String perfilEmail) {
        for (Perfil perfil: perfis) {
            if (perfil.getEmail().equals(perfilEmail)) {
                return perfil;
            }
        }
        
        return null;
    }

    public void latenciaRede() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException exception) {
        	exception.printStackTrace();
        }
    }

    @Override
    public IPerfilIterator estabeleceAmigosIterator(String perfilEmail) {
        return new FacebookIterator(this, "amigos", perfilEmail);
    }

    @Override
    public IPerfilIterator estabeleceConexaoIterator(String perfilEmail) {
        return new FacebookIterator(this, "conexões", perfilEmail);
    }
}