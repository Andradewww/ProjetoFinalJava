package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DTO.Carro;
import Conexao.ConexaoBD;

public class CarroDAO {

    final String NOMEDATABELA = "carro";
    
    public boolean inserir(Carro carro) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (placa, marca, modelo) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carro.getPlaca().substring(0, 7));
            ps.setString(2, carro.getMarca());
            ps.setString(3, carro.getModelo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Carro carro) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET marca = ?, modelo = ?, placa = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carro.getMarca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getPlaca());
            ps.setInt(4, carro.getId()); 
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean excluir(Carro carro) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, carro.getId());
            //ps.setString(2, carro.getMarca());
            //ps.setString(3, carro.getModelo());
            //ps.setString(4, carro.getPlaca());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public Carro procurarPorPlaca(String placa) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Carro obj = new Carro(
                		rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                obj.setId(rs.getInt(1));
                obj.setMarca(rs.getString(2));
                obj.setModelo(rs.getString(3));
                obj.setPlaca(rs.getString(4));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    
    public boolean existe(Carro carro) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carro.getPlaca());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public List<Carro> pesquisarTodos() {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Carro> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Carro> montarLista(ResultSet rs) {
        List<Carro> listObj = new ArrayList<Carro>();
        try {
            while (rs.next()) {
                Carro obj = new Carro(
                		rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("placa")
                );
                obj.setId(rs.getInt(1));
                obj.setMarca(rs.getString(2));
                obj.setModelo(rs.getString(3));
                obj.setPlaca(rs.getString(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}