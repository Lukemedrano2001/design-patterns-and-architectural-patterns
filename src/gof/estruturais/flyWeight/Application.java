package gof.estruturais.flyWeight;

import java.awt.Color;

import gof.estruturais.flyWeight.floresta.Floresta;

public class Application {
	public static int TAMANHO_TELA = 500;
	public static int ARVORES_PARA_DESENHAR = 1_000_000;
	public static int TIPOS_ARVORES = 2;

    public static void main(String[] args) {
        Floresta floresta = new Floresta();
        for (int i = 0; i < Math.floor(ARVORES_PARA_DESENHAR / TIPOS_ARVORES); i++) {
            floresta.plantarArvore(random(0, TAMANHO_TELA), random(0, TAMANHO_TELA),
                    "Carvalho de Verão", Color.GREEN, "Esboço de Textura de Carvalho de Verão");
            floresta.plantarArvore(random(0, TAMANHO_TELA), random(0, TAMANHO_TELA),
                    "Carvalho de Outono", Color.ORANGE, "Esboço de Textura de Carvalho de Outono");
        }
        
        floresta.setSize(TAMANHO_TELA, TAMANHO_TELA);
        floresta.setVisible(true);

        System.out.println(exibeNoConsole(ARVORES_PARA_DESENHAR, TIPOS_ARVORES));
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    
    public static String exibeNoConsole(int numeroArvores, int tiposArvores) {
    	StringBuilder builder = new StringBuilder();
    	
    	builder.append("Árvores desenhadas: " + numeroArvores).append("\n\n");
    	
    	// Memória RAM
    	builder.append("Uso de Memória RAM:").append("\n");
    	builder.append("Tamanho da Árvore com 8 bytes * " + numeroArvores).append("\n");
    	builder.append("Tamanho dos Tipos de Árvores com ~30 bytes * " + tiposArvores).append("\n\n");
    	
    	// Cálculo de uso de Memória RAM
    	// Byte para KiloByte -> Divisão por 1024
    	// Byte para MegaByte -> Divisão por 1024^2
    	// Byte para GigaByte -> Divisão por 1024^3
    	double resultado1 = (numeroArvores * 8 + tiposArvores * 30) / 1024 / 1024;
    	double resultado2 = (numeroArvores * (8 + 30) / 1024/ 1024);
    	
    	builder.append("Total: ").append(resultado1).append(" MB");
    	builder.append(" ao invés de ").append(resultado2).append(" MB");
    	
    	return builder.toString();
    }
}