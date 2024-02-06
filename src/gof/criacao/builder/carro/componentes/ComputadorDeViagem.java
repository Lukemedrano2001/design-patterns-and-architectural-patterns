package gof.criacao.builder.carro.componentes;

import gof.criacao.builder.carro.configs.CarroPopular;

public class ComputadorDeViagem {
	private CarroPopular carro;

    public void setCarro(CarroPopular carro) {
        this.carro = carro;
    }

    public void exibirCombustivel() {
        System.out.println("Combustível: " + carro.getCombustivel());
    }

    public void exibirStatus() {
        if (this.carro.getMotor().isLigado()) {
            System.out.println("Carro ligou");
        } else {
            System.out.println("Carro não ligou");
        }
    }
}