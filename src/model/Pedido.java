
package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	public static double TAXA_DE_ENTREGA = 8.99;

	public int id;
	public String endereco;
	public List<Product> produtos;
	public Customer cliente;
	private double totalPedido;

	// Métodos construtores

	public Pedido() {
		this.produtos = new ArrayList<Product>();
		this.totalPedido = 0;
	}

	public Pedido(String end, Customer cli) {
		this.endereco = end;
		this.cliente = cli;
		this.produtos = new ArrayList<Product>();
		this.totalPedido = 0;
	}

	// Métodos acessores (GET)

	public double getTotalPedido() {
		return this.totalPedido;
	}

	// Método Modificador - Setters (SET)

	public void setTotalPedido(double valor) {
		if (valor >= TAXA_DE_ENTREGA) {
			this.totalPedido = valor;
		} else {
			System.out.println("Valor não permitido");
		}
	}

	public void addProduto(Product prod) {
		if (this.produtos.size() == 0) {
			this.totalPedido += TAXA_DE_ENTREGA;
		}
		this.produtos.add(prod);
		this.totalPedido += prod.price;
	}

	// public void addProduto(Product[] listaDeProdutos){
	// for (Product product : listaDeProdutos) {

	// this.produtos.add( product );
	// }
	// }›‹
	public void addProduto(Product... n) {
		if (this.produtos.size() == 0) {
			this.totalPedido += TAXA_DE_ENTREGA;
		}
		for (Product product : n) {

			this.produtos.add(product);
			this.totalPedido += product.price;
		}
	}

	public void imprimirPedido() {
		System.out.println("\n--------------------");
		System.out.println("Pedido no end: " + this.endereco);
		System.out.println("Nome do cliente: " + this.cliente.name);
		System.out.println("Cidade do cliente: " + this.cliente.city.name);
		System.out.println("Total do Pedido: " + String.format("%.2f",this.totalPedido));
		if (this.produtos.size() == 0) {
			System.out.println("Pedido Vazio");
		} else {
			System.out.println("Produtos do Pedido");
			for (Product prod : this.produtos) {
				System.out.println(prod.name + " - " + prod.price);
			}
		}
	}

}