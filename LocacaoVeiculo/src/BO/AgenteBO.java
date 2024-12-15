package BO;

import java.util.List;
import DAO.AgenteDAO;
import DTO.Agente;

public class AgenteBO {
	private AgenteDAO agenteDAO;

    public AgenteBO() {
    	agenteDAO = new AgenteDAO();
    }

    public boolean inserir(Agente agente){
        if (!existe(agente)) {
            return agenteDAO.inserir(agente);
        }
        return false;
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

    public boolean existe(Agente agente){
        return agenteDAO.existe(agente);
    }

    public List<Agente> pesquisarTodos(){
        return agenteDAO.pesquisarTodos();
    }
}