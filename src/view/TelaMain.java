package view;

import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Client;

import dao.CidadeDAO;
import dao.ClinDAO;
import model.Categoria;
import model.City;
import model.Customer;
import model.Pedido;

import model.Product;

public class TelaMain {

    public static void main(String[] args) {
        //List<City> cidades = new ArrayList<City>();
        List<City> cidades = CidadeDAO.getCidades();
        //List<Customer> clientes = new ArrayList<Customer>();
        List<Customer> clientes = ClinDAO.getClientes();
        List<Categoria> categorias = new ArrayList<Categoria>();
        List<Product> produtos = new ArrayList<Product>();
        List<Pedido> pedidos = new ArrayList<Pedido>();

        int opcao;
        do {
            opcao = mostrarMenu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    //cidades.add(cadastrarCidade());
                    cadastrarCidade();
                    break;
                case 2:
                cidades = CidadeDAO.getCidades();
                if (cidades.size() == 0) {
                    JOptionPane.showMessageDialog(null,"Necessário cadastrar cidade primeiro.");
                    cadastrarCidade();
                    cidades = CidadeDAO.getCidades();
                    cadastrarCliente(cidades);
                } else{
                    cadastrarCliente(cidades);
                    //clientes.add(cadastrarCliente(cidades));
                }
                    break;
                case 3:
                    categorias.add(cadastrarCategoria());
                    break;
                case 4:
                    if (produtos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Necessário cadastrar categoria primeiro.");
                    }else{
                        produtos.add(cadastrarProduto(categorias));
                    }
                    break;
                case 5:
                    cidades = CidadeDAO.getCidades();
                    listarCidades(cidades);
                    break;
                case 6:
                clientes = ClinDAO.getClientes();
                    listarClientes(clientes);
                    break;
                case 7:
                    listarCategorias(categorias);
                    break;
                case 8:
                    listarProdutos(produtos);
                    break;
                case 9:
                    pedidos.add(cadastrarPedido(pedidos, clientes));
                    break;
                case 10:
                    listarPedidos(pedidos);
                    if (pedidos.size() > 0) {
                        if (produtos.size() == 0) {
                            JOptionPane.showMessageDialog(null, "Nenhum Produto cadastrado");

                        } else {

                            String idPedDigitado = JOptionPane.showInputDialog(null, "Digite o ID: ");
                            if (idPedDigitado.isEmpty()) {
                                break;
                            } else {
                                try {
                                    int idPed = Integer.valueOf(idPedDigitado);
                                    Pedido pedSelected = null;
                                    for (Pedido pedido : pedidos) {
                                        if (pedido.id == idPed) {
                                            pedSelected = pedido;
                                        }
                                    }
                                    addProdutoAoPedido(produtos, pedSelected);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.toString());
                                }

                            }
                        }
                    }
                    break;
                case 11:
                    listarPedidos(pedidos);
                case 12:
                    vizualizarPedido(pedidos);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

        } while (opcao != 0);
    }

    public static void listarCidades(List<City> cidades) {
        String texto = "Cidades cadastradas:";
        if (cidades.size() == 0) {
            texto += "\n\nNenhuma cidade cadastrada";
        }
        for (City cid : cidades) {
            texto += "\n " + cid.id + " - " + cid.name +
                    "\n-------------------------";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void listarCategorias(List<Categoria> categorias) {
        String texto = "Categorias cadastradas:";
        if (categorias.size() == 0) {
            texto += "\n\nNenhuma categoria cadastrada";
        }
        for (Categoria cat : categorias) {
            texto += "\n " + cat.id + " - " + cat.name +
                    "\n-------------------------";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void listarClientes(List<Customer> clientes) {
        String texto = "Clientes cadastrados:";
        if (clientes.size() == 0) {
            texto += "\n\nNenhum cliente cadastrado";
        }
        for (Customer cli : clientes) {
            texto += "\n " + cli.id + " - " + cli.name +
                    "\nEnd: " + cli.address +
                    "\nCidade: " + cli.city.name +
                    "\n-------------------------";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void listarProdutos(List<Product> produtos) {
        String texto = "Produtos cadastrados:";
        if (produtos.size() == 0) {
            texto += "\n\nNenhum produto cadastrado";
        }
        for (Product prod : produtos) {
            texto += "\n " + prod.id + " - " + prod.name +
                    "\nPreço: " + prod.price +
                    "\nQuantidade: " + prod.amount +
                    "\nCategoria: " + prod.categoria.name +
                    "\n-------------------------";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void listarPedidos(List<Pedido> pedidos) {
        String texto = "Pedidos cadastrados:";
        if (pedidos.size() == 0) {
            texto += "\n\nNenhum pedido cadastrado";
        } else {
            for (Pedido ped : pedidos) {
                texto += "\n-----------------------\n";
                texto += "ID do pedido: " + ped.id;
                texto += "\nPedido no end: " + ped.endereco;
                texto += "\nNome do Cliente: " + ped.cliente.name;
                texto += "\nNome da cidade do Cliente: " + ped.cliente.city.name;
                texto += "\nTotal do Pedido: R$ " +
                        String.format("%.2f", ped.getTotalPedido());
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

   

    public static int mostrarMenu() {
        String texto = "----Lojinha---- \n\n" +
                "1 - Cadastrar Cidade \n" +
                "2 - Cadastrar Cliente \n" +
                "3 - Cadastrar Categoria \n" +
                "4 - Cadastrar Produto \n" +
                "5 - Listar Cidades \n" +
                "6 - Listar Clientes \n" +
                "7 - Listar Categorias \n" +
                "8 - Listar Produtos \n" +
                "9 - Cadastrar Pedido \n" +
                "10 - Adicionar Produtos ao Pedido \n" +
                "11 - Listar Pedidos \n" +
                "12 - Visualizar Pedido \n" +
                "0 - Sair \n " +
                "\nDigite a opção desejada: ";
        int opcao = -1;
        String opcaoDigitada = JOptionPane.showInputDialog(texto);
        if (!opcaoDigitada.isEmpty()) {
            opcao = Integer.valueOf(opcaoDigitada);
        }
        return opcao;
    }

    /* 

    public static void cadastrarCidade() {
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Cidade");
        int id = 0;
        if (!idDigitado.isEmpty()) {
            id = Integer.valueOf(idDigitado);
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da Cidade");
        City novaCidade = new City(id, nome);
        return novaCidade;
    }
    */

    public static void cadastrarCidade() {
        String nome = JOptionPane.showInputDialog("Digite o nome da Cidade");
        if ( !nome.isEmpty() ) 
            CidadeDAO.cadastrar(nome);
    }

    public static Categoria cadastrarCategoria() {
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Categoria");
        int id = 0;
        if (!idDigitado.isEmpty()) {
            id = Integer.valueOf(idDigitado);
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da Categoria");
        Categoria novaCategoria = new Categoria(id, nome);
        return novaCategoria;
    }

    public static void cadastrarCliente(List<City> municipios) {
        // String idDigitado = JOptionPane.showInputDialog("Digite o ID da Cliente: ");
        // int id = 0;
        // if (!idDigitado.isEmpty()) {
        //     id = Integer.valueOf(idDigitado);
        // }
        String nome = JOptionPane.showInputDialog("Digite o nome da Cliente: ");
        String end = JOptionPane.showInputDialog("Digite o endereço: ");

        String texto = "Cidades cadastradas:";
        for (City cidade : municipios) {
            texto += "\n " + cidade.id + " - " + cidade.name;
        }

        texto += "\n  Digite o id da cidade deste cliente: ";
        int idCidade = Integer.valueOf(JOptionPane.showInputDialog(texto));
        City cidSelecionada = null;
        for (City cidade : municipios) {
            if (cidade.id == idCidade) {
                cidSelecionada = cidade;
            }
        }
        Customer novoCliente = new Customer(0,nome, end, cidSelecionada);
        ClinDAO.cadastrar(novoCliente);
    }

    public static Product cadastrarProduto(List<Categoria> categorias) {
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Produto: ");
        int id = 0;
        if (!idDigitado.isEmpty()) {
            id = Integer.valueOf(idDigitado);
        }

        String nome = JOptionPane.showInputDialog("Digite o nome da Produto: ");

        String precoDigitado = JOptionPane.showInputDialog("Digite o preço: ");
        precoDigitado = precoDigitado.replace(",", ".");
        double preco = 0;
        if (!precoDigitado.isEmpty()) {
            preco = Double.valueOf(precoDigitado);
        }

        String qtdDigitada = JOptionPane.showInputDialog("Digite a quantidade: ");
        qtdDigitada = qtdDigitada.replace(",", ".");
        double qtd = 0;
        if (!qtdDigitada.isEmpty()) {
            qtd = Double.valueOf(qtdDigitada);
        }

        String texto = "Categorias cadastradas:";
        for (Categoria cat : categorias) {
            texto += "\n " + cat.id + " - " + cat.name;
        }
        texto += "\n  Digite o id da categoria deste produto: ";

        int idCategoria = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Categoria catSelecionada = null;
        for (Categoria cat : categorias) {
            if (cat.id == idCategoria) {
                catSelecionada = cat;
            }
        }
        Product novoProduto = new Product(nome, preco, qtd, catSelecionada);
        novoProduto.id = id;
        return novoProduto;
    }

    public static Pedido cadastrarPedido(List<Pedido> pedidos, List<Customer> clientes) {
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Pedido: ");
        int id = 0;
        if (!idDigitado.isEmpty()) {
            id = Integer.valueOf(idDigitado);
        }
        String end = JOptionPane.showInputDialog("Digite o endereço de entrega: ");
        String texto = "Clientes cadastrados:";
        for (Customer cli : clientes) {
            texto += "\n " + cli.id + " - " + cli.name;
        }
        texto += "\n  Digite o id do cliente deste Pedido: ";
        int idCliente = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Customer cliSelecionado = null;
        for (Customer cli : clientes) {
            if (cli.id == idCliente) {
                cliSelecionado = cli;
            }
        }
        Pedido novoPedido = new Pedido();
        novoPedido.id = id;
        novoPedido.endereco = end;
        novoPedido.cliente = cliSelecionado;
        return novoPedido;
    }

    public static void addProdutoAoPedido(List<Product> produtos, Pedido pedido) {
        String texto = "Produtos cadastrados:";
        if (produtos.size() == 0) {
            texto += "\n\nNenhum produto cadastrado";
        }
        for (Product prod : produtos) {
            texto += "\n " + prod.id + " - " + prod.name +
                    "\nPreço: " + prod.price +
                    "\nQuantidade: " + prod.amount +
                    "\nCategoria: " + prod.categoria.name +
                    "\n-------------------------";
        }
        texto += "\n\nDigite o id do Produto";
        String idDigitado = JOptionPane.showInputDialog(null, texto);
        int idProduto = 0;
        if (!idDigitado.isEmpty()) {
            idProduto = Integer.valueOf(idDigitado);
        }

        Product prodSelecionado = null;
        for (Product produto : produtos) {
            if (produto.id == idProduto) {
                prodSelecionado = produto;
            }
        }
        pedido.addProduto(prodSelecionado);

    }

    public static void vizualizarPedido(List<Pedido> pedidos) {
        int idPedido = Integer.valueOf(JOptionPane.showInputDialog("Id do Pedido:"));
        Pedido pedSelecionado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.id == idPedido) {
                pedSelecionado = pedido;
            }
        }
        String texto = "";
        texto += "ID do pedido: " + pedSelecionado.id;
        texto += "\nPedido no end: " + pedSelecionado.endereco;
        texto += "\nNome do Cliente: " + pedSelecionado.cliente.name;
        texto += "\nNome da cidade do Cliente: " + pedSelecionado.cliente.city.name;
        texto += "\nTotal do Pedido: R$ " +
                String.format("%.2f", pedSelecionado.getTotalPedido());
        if (pedSelecionado.produtos.size() == 0) {
            texto += "\nPedido Vazio";
        } else {
            texto += "\nProdutos do Pedido: ";
            for (Product prod : pedSelecionado.produtos) {
                texto += "\n" + prod.name + " - " + prod.price + " - " + prod.categoria.name;
            }
        }
        JOptionPane.showMessageDialog(null, texto);

    }

}
