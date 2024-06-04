package model;

public class Product {

    public int id;
    public String name;
    public double price, amount;
    public Categoria categoria;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double price, double amount, Categoria cat) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.categoria = cat;
    }
}
