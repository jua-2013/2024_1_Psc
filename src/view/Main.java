// package view;



// import model.Categoria;
// import model.City;
// import model.ClienteFisico;
// import model.ClienteJuridico;
// import model.Customer;
// import model.Pedido;
// import model.Product;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Store Project!");

//         City c1 = new City();
//         City c2 = new City("Porto Alegre");
//         City c3 = new City(1,"Belo Horizonte");

//         //System.out.println("Cidade c1: id - " + c1.id + " - " + c1.name);
//         //System.out.println("Cidade c2: id - " + c2.id + " - " + c2.name);
//         //System.out.println("Cidade c3: id - " + c3.id + " - " + c3.name);

//         Customer customer1 = new Customer(1, "Juarez", "Rua das Flautas", c3);

//         Customer customer2 = new Customer(2, "Thalyta", "Rua Miguel Gentil", c3);

//         Customer customer3 = new Customer(3, "Guilherme", "Rua das Flautas", c3);

//         //JOptionPane.showMessageDialog(null, "id: " + customer1.id + " - Name: " + customer1.name + " - Address: " + customer1.address + " - Height: " + customer1.height + " - Married: " + customer1.married + " - City: " + customer1.city.name);


//         //customer 1
//         //System.out.println("id: " + customer1.id + " - Name: " + customer1.name + " - Address: " + customer1.address + " - Height: " + customer1.height + " - Married: " + customer1.married + " - City: " + customer1.city.name);
//         //customer 2
//         //System.out.println("id: " + customer2.id + " - Name: " + customer2.name + " - Address: " + customer2.address + " - Height: " + customer2.height + " - Married: " + customer2.married + " - City: " + customer2.city.name);
//         //customer 3
//         //System.out.println("id: " + customer3.id + " - Name: " + customer3.name + " - Address: " + customer3.address + " - Height: " + customer3.height + " - Married: " + customer3.married + " - City: " + customer3.city.name);

//         //System.out.println( c3 );

//         City[] cit = { c1 , c2 , c3};

//         for (City city : cit) {

//             //System.out.println(city.name);
            
//         }

//         // System.out.println("23/04/24------------------------");
//         // System.out.println("Nome da cidade: " + c3.name);
//         // System.out.println("------------------------");
//         // System.out.println(c3);

//         ClienteFisico pf1 = new ClienteFisico();
//         pf1.name = "Guilherme";
//         pf1.city = c2;
        
//         //System.out.println("Nome do Cliente pf1: " + pf1.name);

//         ClienteFisico pf2 = new ClienteFisico("Juarez", "141.040.196-07");
        
//         // System.out.println("Nome do Cliente pf2: " + pf2.name + " CPF do Cliente: " + pf2.cpf);

//         ClienteFisico pf3 = new ClienteFisico(1, "Saliba", "Arena MRV", c3, "141.040.196.07" , 1.80,true );

//         // System.out.println("id: " + pf3.id + " - Name: " + pf3.name + " - Address: " + pf3.address + " - Height: " + pf3.height + " - Married: " + pf3.married + " - City: " + pf3.city.name + " - CPF: " + pf3.cpf );

//         //System.out.println("----------Pj1-----------");

//         ClienteJuridico pj1 = new ClienteJuridico();
//         pj1.name = "Luciana Saliba Terapia Capilar";
//         pj1.cnpj = "00.11.222/0001-33";
//         pj1.city = c2;
//         pj1.address = "Rua c 395";        
//         //System.out.println(pj1);


//         // 30/04/2024 -----------

//         System.out.println("-----Aula de hoje----");

//         Categoria cat01 = new Categoria(1, "Bebidas");
//         Categoria cat02 = new Categoria(2, "Alimentos");

//         Product prod01 = new Product("Coca-Cola");
//         prod01.price = 8.99;
//         prod01.amount = 100;
//         prod01.categoria = cat01;

//         Product prod02 = new Product("Pepsi", 7.65, 50, cat01);

//         Product prod03 = new Product("Arroz", 4.99, 80, cat02);

//         Pedido ped01 = new Pedido("Rua A, 150", pf1);

//         ped01.imprimirPedido();

//         ped01.addProduto(prod01);
//         ped01.imprimirPedido();
//         ped01.addProduto(prod02 , prod03);
//         ped01.imprimirPedido();
//         ped01.imprimirPedido();

//         System.out.println("-------Modificadores e acessores-------");
//         ped01.setTotalPedido(5);
//         System.out.println("Total do Pedido confirmação: " + ped01.getTotalPedido());
//         System.out.println("\nTaxa de Entrega: " + Pedido.TAXA_DE_ENTREGA);

        






        
//     }
// }
