package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.City;
import model.Customer;

public class ClinDAO {

    public static void cadastrar(Customer cliente){
        String sql = "INSERT INTO cliente (nome, endereco, codCidade) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.name);
            ps.setString(2, cliente.address);
            ps.setInt(3, cliente.city.id);
            ps.execute();
            //Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }
 
    public static void editar(Customer cliente){
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, codCidade = ?, WHERE id = ?";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.name);
            ps.setString(2, cliente.address);
            ps.setInt(3, cliente.city.id);
            ps.setInt(4, cliente.id);
            ps.execute();
            Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }

    public static void excluir(int idCliente){
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.execute();
            Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }

    public static List<Customer> getClientes(){
        List<Customer> lista = new ArrayList<Customer>();
        
        
        String sql = "SELECT p.id, p.nome, p.endereco, c.id, c.nome " +
        " FROM cliente p" + 
        " INNER JOIN cidade c ON c.id = p.codCidade" +
        " ORDER BY p.nome";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    City cid = new City();
                    cid.id = rs.getInt(4);
                    cid.name = rs.getString(5);
                    
                    Customer cli = new Customer();
                    cli.id = rs.getInt(1);
                    cli.name = rs.getString(2);
                    cli.address = rs.getString(3);
                    cli.city = cid;
                    lista.add(cli);

                }
                
            }
            //Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
        return lista;
    }
}
