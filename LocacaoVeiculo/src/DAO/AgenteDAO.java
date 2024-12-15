package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DTO.Agente;
import Conexao.ConexaoBD;

public class AgenteDAO {
	
	final String NOMEDATABELA = "agente";
    
    public boolean inserir(Agente agente) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (codigo, nome, idade) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, agente.getCodigo());
            ps.setString(2, agente.getNome());
            ps.setInt(3, agente.getIdade());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Agente agente) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET codigo = ?, nome = ?, idade = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, agente.getCodigo());
            ps.setString(2, agente.getNome());
            ps.setInt(3, agente.getIdade());
            ps.setInt(4, agente.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean excluir(Agente agente) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, agente.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public Agente procurarPorCodigo(int codigo) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Agente obj = new Agente(
                		rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                obj.setId(rs.getInt(1));
                obj.setCodigo(rs.getInt(2));
                obj.setNome(rs.getString(3));
                obj.setIdade(rs.getInt(4));
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
    
    public boolean existe(Agente agente) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, agente.getNome());
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
    
    public List<Agente> pesquisarTodos() {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Agente> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Agente> montarLista(ResultSet rs) {
        List<Agente> listObj = new ArrayList<Agente>();
        try {
            while (rs.next()) {
            	Agente obj = new Agente(
            			rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)
            	);
                obj.setId(rs.getInt(1));
                obj.setCodigo(rs.getInt(2));
                obj.setNome(rs.getString(3));
                obj.setIdade(rs.getInt(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}