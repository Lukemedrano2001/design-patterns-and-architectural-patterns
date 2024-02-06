package gof.estruturais.flyWeight.arvore;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {
	static Map<String, TipoArvore> tipoArvores = new HashMap<String, TipoArvore>();

    public static TipoArvore getTipoArvore(String nome, Color cor, String outrosDadosArvores) {
        TipoArvore resultado = tipoArvores.get(nome);
        if (resultado == null) {
        	resultado = new TipoArvore(nome, cor, outrosDadosArvores);
            tipoArvores.put(nome, resultado);
        }
        
        return resultado;
    }
}