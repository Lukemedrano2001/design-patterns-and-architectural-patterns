package gof.comportamento.iterator.redeSocial;

import gof.comportamento.iterator.perfil.IPerfilIterator;
import gof.comportamento.iterator.perfil.Perfil;

public class RedeSocialNotificador {
	public IRedeSocial redeConexao;
    public IPerfilIterator iterator;

    public RedeSocialNotificador(IRedeSocial redeConexao) {
        this.redeConexao = redeConexao;
    }

    public void enviarMensagemAmigos(String perfilEmail, String mensagem) {
        System.out.println("\nIterando sobre os amigos...\n");
        iterator = redeConexao.estabeleceAmigosIterator(perfilEmail);
        
        while (iterator.temProximo()) {
            Perfil perfil = iterator.getProximo();
            enviarMensagem(perfil.getEmail(), mensagem);
        } 
    }

    public void enviarMensagemConexoes(String perfilEmail, String mensagem) {
        System.out.println("\nIterando sobre as conexões...\n");
        iterator = redeConexao.estabeleceConexaoIterator(perfilEmail);
        
        while (iterator.temProximo()) {
        	Perfil perfil = iterator.getProximo();
            enviarMensagem(perfil.getEmail(), mensagem);
        }
    }

    public void enviarMensagem(String email, String mensagem) {
        System.out.println("Enviou mensagem para: " + email + ". Corpo da Mensagem: " + mensagem + "");
    }
}