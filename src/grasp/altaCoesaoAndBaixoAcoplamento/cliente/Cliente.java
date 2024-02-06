package grasp.altaCoesaoAndBaixoAcoplamento.cliente;

import grasp.altaCoesaoAndBaixoAcoplamento.pagamentos.CheckOutPagamento;
import grasp.altaCoesaoAndBaixoAcoplamento.pedido.Pedido;

public class Cliente {
	private CheckOutPagamento checkoutPagamento;

    public Cliente(CheckOutPagamento checkoutPagamento) {
        this.checkoutPagamento = checkoutPagamento;
    }

    public void fazerPedido(Pedido pedido) {
        double totalPedido = pedido.calcularTotal();
        checkoutPagamento.processarOrdemPagamento(totalPedido);
    }
}