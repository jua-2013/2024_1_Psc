package model;

public class ClienteJuridico extends Customer{
    public String cnpj = "";

    public ClienteJuridico(){
        super();
        System.out.println("Cliente jurídico");
    }

    public ClienteJuridico(String name){
        super("Maria");

    }

    @Override
    public String toString() {
        String txt = "Nome da Empresa: " + this.name + "\nCNPJ: " + this.cnpj + "\nEndereço: " + this.address + "\nCidade: " + this.city.name;

        return txt;
    }
}
