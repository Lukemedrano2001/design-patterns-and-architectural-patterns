package grasp.controller;

import grasp.controller.conta.Conta;
import grasp.controller.conta.Controller;
import grasp.controller.conta.VisualizarConta;

public class Application {
	public static void main(String[] args) {
		// Conta
        Conta conta = new Conta(1, 12345, 1000.0);
        
        // VisualizarConta
        VisualizarConta visualizacaoConta = new VisualizarConta();

        // Controller
        Controller controller = new Controller(conta, visualizacaoConta);

        // Exibir Saldo
        System.out.println("Saldo Inicial:");
        controller.realizarOperacao(0);

        // Operações na conta
        controller.realizarOperacao(200.0);
        controller.realizarOperacao(-50.0);
        controller.realizarOperacao(100.0);

        // Exibir Saldo
        System.out.println("\nSaldo Final:");
        controller.realizarOperacao(0);
	}
}