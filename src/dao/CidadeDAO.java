package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.City;

public class CidadeDAO {

    public static void cadastrar(String nome){
        String sql = "INSERT INTO cidade (nome) VALUES (?)";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
            //Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }
 
    public static void editar(City cidade){
        String sql = "UPDATE cidade SET nome = ?WHERE id = ?";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cidade.name);
            ps.setInt(2, cidade.id);
            ps.execute();
            Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }

    public static void excluir(int idCidade){
        String sql = "DELETE FROM cidade WHERE id = ?";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCidade);
            ps.execute();
            Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }

    public static List<City> getCidades(){
        List<City> lista = new ArrayList<City>();
        
        
        String sql = "SELECT id, nome FROM cidade ORDER BY nome";
        PreparedStatement ps = null;

        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    City cid = new City();
                    cid.id = rs.getInt(1);
                    cid.name = rs.getString(2);
                    lista.add(cid);

                }
                
            }
            //Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
        return lista;
    }
}
