package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoBD;
import DTO.Locacao;

public class LocacaoDAO {
	
final String NOMEDATABELA = "locacao";
    
    public boolean inserir(Locacao locacao) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (placaVeiculo, agenteLocacao, cliente, dataInicio, dataFim) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, locacao.getPlacaVeiculo().substring(0, 7));
            ps.setString(2, locacao.getAgenteLocacao());
            ps.setString(2, locacao.getCliente());
            ps.setDate(3, (Date) locacao.getDataInicio());
            ps.setDate(4, (Date) locacao.getDataFim());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Locacao locacao) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET placaVeiculo = ?, agenteLocacao = ?, cliente = ?, dataInicio = ?, dataFim = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, locacao.getPlacaVeiculo().substring(0, 7));
            ps.setString(2, locacao.getAgenteLocacao());
            ps.setString(2, locacao.getCliente());
            ps.setDate(3, (Date) locacao.getDataInicio());
            ps.setDate(4, (Date) locacao.getDataFim());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean excluir(Locacao locacao) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, locacao.getId());
            //ps.setString(1, locacao.getPlacaVeiculo().substring(0, 7));
            //ps.setString(2, locacao.getAgenteLocacao());
            //ps.setString(2, locacao.getAgenteCliente());
            //ps.setDate(3, (Date) locacao.getDataInicio());
            //ps.setDate(4, (Date) locacao.getDataFim());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public Locacao procurarPorCliente(String cliente) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cliente = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Locacao obj = new Locacao(
                		rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6)
                );
                obj.setId(rs.getInt(1));
                obj.setPlacaVeiculo(rs.getString(2));
                obj.setAgenteLocacao(rs.getString(3));
                obj.setCliente(rs.getString(4));
                obj.setDataInicio(rs.getDate(5));
                obj.setDataFim(rs.getDate(6));
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
    
    public boolean existe(Locacao locacao) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placaVeiculo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, locacao.getPlacaVeiculo());
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
    
    public List<Locacao> pesquisarTodos() {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Locacao> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Locacao> montarLista(ResultSet rs) {
        List<Locacao> listObj = new ArrayList<Locacao>();
        try {
            while (rs.next()) {
            	Locacao obj = new Locacao(
            			rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6)
                );
                obj.setId(rs.getInt(1));
                obj.setPlacaVeiculo(rs.getString(2));
                obj.setAgenteLocacao(rs.getString(3));
                obj.setCliente(rs.getString(4));
                obj.setDataInicio(rs.getDate(5));
                obj.setDataInicio(rs.getDate(6));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
