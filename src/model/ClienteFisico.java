package model;

public class ClienteFisico extends Customer{
    public String cpf;
    public double height;
    public boolean married;

    public ClienteFisico(){
        super();

    }

    public ClienteFisico(String name){
        super(name);

    }

    public ClienteFisico(String name, String cpf){
        super(name);
        this.cpf = cpf;

    }
    
    public ClienteFisico(int id, String name, String address, City city,  String cpf, double height, boolean married){
        super(id, name, address, city);
        this.cpf = cpf;
        this.height = height;
        this.married = married;
        System.out.println( this );

    }

    @Override
    public String toString(){
        String txtCasado = "";
        if ( this.married == true) {
            txtCasado = "Sim";
        } else{
            txtCasado = "Não";
        }
        return super.toString() + "\nAltura " + this.height + "\nCasado: " + txtCasado;
    }
}
