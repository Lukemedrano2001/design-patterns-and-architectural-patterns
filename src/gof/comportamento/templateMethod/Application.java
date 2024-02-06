package gof.comportamento.templateMethod;

import gof.comportamento.templateMethod.bebidas.Cafe;
import gof.comportamento.templateMethod.bebidas.Cha;
import gof.comportamento.templateMethod.bebidas.Refrigerante;
import gof.comportamento.templateMethod.bebidas.Suco;
import gof.comportamento.templateMethod.maquinasBebidas.MaquinaCafe;
import gof.comportamento.templateMethod.maquinasBebidas.MaquinaCha;
import gof.comportamento.templateMethod.maquinasBebidas.MaquinaRefrigerante;
import gof.comportamento.templateMethod.maquinasBebidas.MaquinaSuco;

public class Application {
	public static void main(String[] args) {
		// Café
		System.out.println("Máquina de Café:");
		MaquinaCafe maquinaCafe = new MaquinaCafe();
        maquinaCafe.prepararBebida(new Cafe("Café"));
        
        // Chá
        System.out.println("\nMáquina de Chá:");
        MaquinaCha maquinaCha = new MaquinaCha();
        maquinaCha.prepararBebida(new Cha("Chá"));

        // Refrigerante
        System.out.println("\nMáquina de Refrigerante:");
        MaquinaRefrigerante maquinaRefrigerante = new MaquinaRefrigerante();
        maquinaRefrigerante.prepararBebida(new Refrigerante("Refrigerante"));

        // Suco
        System.out.println("\nMáquina de Suco:");
        MaquinaSuco maquinaSuco = new MaquinaSuco();
        maquinaSuco.prepararBebida(new Suco("Suco de Laranja"));
	}
}