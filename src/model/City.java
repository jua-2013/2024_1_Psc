package model;

public class City {

    public int id;
    public String name;

    // Método construtor que não recebe parâmetros
    public City(){
        this.id = 0;
        this.name = "Sem nome";

    }

    public City(String name){
        this.id = 0;
        this.name = name;
    }
    
    public City(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Cidade: \nid: " + this.id + "\nName: " + this.name;
    }
}
