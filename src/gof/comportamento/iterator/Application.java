package gof.comportamento.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gof.comportamento.iterator.facebook.Facebook;
import gof.comportamento.iterator.linkedin.Linkedin;
import gof.comportamento.iterator.perfil.Perfil;
import gof.comportamento.iterator.redeSocial.IRedeSocial;
import gof.comportamento.iterator.redeSocial.RedeSocialNotificador;

public class Application { 
	public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Especifique a rede social:");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String escolha = scanner.nextLine();

        IRedeSocial redeConexao;
        if (escolha.equals("2")) {
            redeConexao = new Linkedin(teste());
        } else {
            redeConexao = new Facebook(teste());
        }

        RedeSocialNotificador notificador = new RedeSocialNotificador(redeConexao);
        notificador.enviarMensagemAmigos("ana.silva@gmail.com",
        	    "Oi! Aqui é o amigo da Ana. Você poderia dar uma curtida neste post [link]?");
        	notificador.enviarMensagemConexoes("ana.silva@gmail.com",
        	    "Oi! Aqui é o chefe da Ana. Ela me disse que você poderia se interessar por [link].");
    }

    public static List<Perfil> teste() {
        List<Perfil> dados = new ArrayList<Perfil>();
        
        dados.add(new Perfil("ana.silva@gmail.com", "Ana Silva", "amigos:carlos.almeida@yahoo.com", "amigos:renata.souza@hotmail.com", "conexões:pedro.lima@amazon.com"));
        dados.add(new Perfil("carlos.almeida@yahoo.com", "Carlos Almeida", "amigos:ana.silva@gmail.com", "conexões:pedro.lima@amazon.com"));
        dados.add(new Perfil("bill@microsoft.eu", "Bill Oliveira", "conexões:luana.rodrigues@ukr.net"));
        dados.add(new Perfil("luana.rodrigues@ukr.net", "Luana Rodrigues", "conexões:bill@microsoft.eu"));
        dados.add(new Perfil("pedro.lima@amazon.com", "Pedro Lima", "conexões:ana.silva@gmail.com", "conexões:carlos.almeida@yahoo.com", "amigos:renata.souza@hotmail.com"));
        dados.add(new Perfil("renata.souza@hotmail.com", "Renata Souza", "amigos:ana.silva@gmail.com", "amigos:pedro.lima@amazon.com"));
        
        return dados;
    }
}