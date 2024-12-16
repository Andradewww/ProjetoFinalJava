package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoBD;
import DTO.Locacao;
import DTO.Carro;
import DTO.Agente;
import DTO.Cliente;

public class LocacaoDAO {
    
    final String NOMEDATABELA = "locacao";

    public boolean inserir(Locacao locacao) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (carro_id, agenteLocacao_id, cliente_id, dataInicio, dataFim) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, locacao.getVeiculo().getId());
            ps.setInt(2, locacao.getAgenteLocacao().getId());
            ps.setInt(3, locacao.getCliente().getId());
            ps.setDate(4, new Date(locacao.getDataInicio().getTime()));
            ps.setDate(5, new Date(locacao.getDataFim().getTime()));
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Locacao locacao) { //
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET carro_id = ?, agenteLocacao_id = ?, cliente_id = ?, dataInicio = ?, dataFim = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, locacao.getVeiculo().getId());
            ps.setInt(2, locacao.getAgenteLocacao().getId());
            ps.setInt(3, locacao.getCliente().getId());
            ps.setDate(4, new Date(locacao.getDataInicio().getTime()));
            ps.setDate(5, new Date(locacao.getDataFim().getTime()));
            ps.setInt(6, locacao.getId());
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
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Locacao procurarPorCliente(String clienteNome) {
        try {
            Connection conn = ConexaoBD.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cliente_id = (SELECT id FROM cliente_id WHERE nome_id = ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, clienteNome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Locacao obj = montarObjeto(rs);
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
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE carro_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, locacao.getVeiculo().getId());
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            ps.close();
            rs.close();
            conn.close();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

    private Locacao montarObjeto(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        Carro carro = new CarroDAO().procurarPorPlaca(rs.getString("carro_id"));
        Agente agenteLocacao = new AgenteDAO().procurarPorCodigo(rs.getInt("agenteLocacao_id"));
        Cliente cliente = new ClienteDAO().procurarPorCodigo(rs.getInt("cliente_id"));
        Date dataInicio = rs.getDate("dataInicio");
        Date dataFim = rs.getDate("dataFim");
        return new Locacao(id, carro, agenteLocacao, cliente, dataInicio, dataFim);
    }

    private List<Locacao> montarLista(ResultSet rs) {
        List<Locacao> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                listObj.add(montarObjeto(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObj;
    }
}