package gof.comportamento.iterator.linkedin;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.iterator.perfil.IPerfilIterator;
import gof.comportamento.iterator.perfil.Perfil;
import gof.comportamento.iterator.redeSocial.IRedeSocial;

public class Linkedin implements IRedeSocial { 
	private List<Perfil> contatos;

    public Linkedin(List<Perfil> cache) {
        if (cache != null) {
            this.contatos = cache;
        } else {
            this.contatos = new ArrayList<>();
        }
    }

    public Perfil requestInformacoesContatoDoLinkedin(String perfilEmail) {
        latenciaRede();
        System.out.println("Linkedin: Carregando perfil " + perfilEmail + " pela rede...");

        return findContato(perfilEmail);
    }

    public List<String> requestContatosRelacionadosLinkedin(String perfilEmail, String tipoContato) {
        latenciaRede();
        System.out.println("Linkedin: Carregando " + tipoContato + " lista de " + perfilEmail + " pela rede...");

        Perfil profile = findContato(perfilEmail);
        if (profile != null) {
            return profile.getContatos(tipoContato);
        }
        
        return null;
    }

    private Perfil findContato(String perfilEmail) {
        for (Perfil perfil: contatos) {
            if (perfil.getEmail().equals(perfilEmail)) {
                return perfil;
            }
        }
        return null;
    }

    private void latenciaRede() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException exception) {
        	exception.printStackTrace();
        }
    }

    @Override
    public IPerfilIterator estabeleceAmigosIterator(String perfilEmail) {
        return new LinkedinIterator(this, "amigos", perfilEmail);
    }

    @Override
    public IPerfilIterator estabeleceConexaoIterator(String perfilEmail) {
        return new LinkedinIterator(this, "conexões", perfilEmail);
    }
}