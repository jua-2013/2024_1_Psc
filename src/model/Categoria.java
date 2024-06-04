package model;

public class Categoria {

    
    public int id;
    public String name;

    // Método construtor que não recebe parâmetros
    public Categoria(){
        this.id = 0;
        this.name = "Sem nome";

    }

    public Categoria(String name){
        this.id = 0;
        this.name = name;
    }
    
    public Categoria(int id, String name){
        this.id = id;
        this.name = name;
    }

}
