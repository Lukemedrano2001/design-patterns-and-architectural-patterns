package solid.dip;

public class PedidoService {
    private IPedidoRepository repository;
	
    public PedidoService(IPedidoRepository repository) {
        this.repository = repository;
    }
	
    public void processarPedido(Pedido pedido) {
        // Lógica de processamento do pedido
        repository.salvarPedido(pedido);
    }
}
