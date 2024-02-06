package gof.comportamento.iterator.perfil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Perfil {
	private String nome;
    private String email;
    private Map<String, List<String>> contatos = new HashMap<>();

    public Perfil(String email, String nome, String... contatos) {
        this.email = email;
        this.nome = nome;

        for (String contato : contatos) {
            String[] partes = contato.split(":");
            String tipoContato = "amigo", emailContato;
            
            if (partes.length == 1) {
            	emailContato = partes[0];
            } else {
                tipoContato = partes[0];
                emailContato = partes[1];
            }
            
            if (!this.contatos.containsKey(tipoContato)) {
                this.contatos.put(tipoContato, new ArrayList<>());
            }
            
            this.contatos.get(tipoContato).add(emailContato);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getContatos(String tipoContato) {
        if (!this.contatos.containsKey(tipoContato)) {
            this.contatos.put(tipoContato, new ArrayList<>());
        }
        return contatos.get(tipoContato);
    }
}