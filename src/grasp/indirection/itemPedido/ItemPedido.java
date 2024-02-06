package grasp.indirection.itemPedido;

import grasp.indirection.produto.Produto;

public class ItemPedido {
	private final int id;
    private Produto produto;
    private int quantidade;
    private double desconto;

    public ItemPedido(int id, Produto produto, int quantidade, double desconto) {
    	this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }
    
    public int getId() {
    	return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double subTotalSemDesconto() {
        return quantidade * produto.getPreco();
    }
    
    public double subTotalComDesconto() {
    	double semDesconto = this.subTotalSemDesconto();
    	double comDesconto = semDesconto * (1 - desconto / 100);
    	
    	return comDesconto;
    }

    @Override
    public String toString() {
        String produto = "Id do Produto: " + this.getProduto().getId();
        String quantidade = "Quantidade: " + this.getQuantidade();
        String semDesconto = String.format("SubTotal sem Desconto: %.2f R$", this.subTotalSemDesconto());
        String comDesconto = String.format("SubTotal com Desconto: %.2f R$", this.subTotalComDesconto());

        return String.format("%s | %s | %s | %s", 
        		produto, quantidade, semDesconto, comDesconto);
    }
}