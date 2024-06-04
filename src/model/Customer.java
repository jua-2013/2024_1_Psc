package model;

public class Customer {

    public int id;
    public String name, address;
    public City city;

    public Customer() {
        this.name = "Sem nome";
        //System.out.println("Nome do cliente: " + this.name);
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int id, String name, String address, City city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString(){
        String texto = "Nome do Cliente: " + this.name + "\nCidade: " + this.city;

        return texto;
    }

}
