package gof.estruturais.bridge;

import gof.estruturais.bridge.controle.ControleRemotoAvancado;
import gof.estruturais.bridge.controle.ControleRemotoBasico;
import gof.estruturais.bridge.dispositivo.IDispositivo;
import gof.estruturais.bridge.dispositivo.Radio;
import gof.estruturais.bridge.dispositivo.Televisao;

public class Application {
	public static void main(String[] args) {
		testeDispositivo(new Televisao());
		testeDispositivo(new Radio());		
	}
	
	public static void testeDispositivo(IDispositivo iDispositivo) {
		IDispositivo dispositivoBasico = new Radio();
		IDispositivo dispositivoAvancado = new Televisao();
		
        ControleRemotoBasico controleRemotoBasico = new ControleRemotoBasico(dispositivoBasico);
        ControleRemotoAvancado controleRemotoAvancado = new ControleRemotoAvancado(dispositivoAvancado);
        
        // Básico
        controleRemotoBasico.aumentarVolume();
        controleRemotoBasico.aumentarCanal();
        
        // Avançado
        controleRemotoAvancado.power();
        controleRemotoAvancado.mutar();
        controleRemotoAvancado.trocarCanal(20);

        // Básico      
        System.out.println(controleRemotoBasico);
        
        // Avançado
        System.out.println(controleRemotoAvancado);
	}
}