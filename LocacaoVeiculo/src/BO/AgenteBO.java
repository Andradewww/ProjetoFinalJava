package BO;

import java.util.List;
import DAO.AgenteDAO;
import DTO.Agente;

public class AgenteBO {
	private AgenteDAO agenteDAO;

    public AgenteBO() {
    	agenteDAO = new AgenteDAO();
    }

    public boolean existe(Agente agente) {
        return agenteDAO.existe(agente.getEmail(), agente.getSenha());
    }
    
    public boolean alterar(Agente agente){
        return agenteDAO.alterar(agente);
    }

    public boolean excluir(Agente agente){
        return agenteDAO.excluir(agente);
    }

    public Agente procurarPorCodigo(int codigo) {
        return agenteDAO.procurarPorCodigo(codigo);
    }

    public boolean existe(String email, String senha) {
        return agenteDAO.existe(email, senha);
    }

    public List<Agente> pesquisarTodos(){
        return agenteDAO.pesquisarTodos();
    }
}
