package grasp.altaCoesaoAndBaixoAcoplamento.itemPedido;

import grasp.altaCoesaoAndBaixoAcoplamento.produto.Produto;

public class ItemPedido {
	private Produto produto;
	private int quantidade;
	
	public ItemPedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getItemMenu() {
		return produto;
	}

	public void setItemMenu(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}