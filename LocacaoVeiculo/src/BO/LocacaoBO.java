package BO;

import java.util.List;
import DAO.LocacaoDAO;
import DTO.Locacao;

public class LocacaoBO {
	private LocacaoDAO locacaoDAO;

    public LocacaoBO() {
    	locacaoDAO = new LocacaoDAO();
    }

    public boolean inserir(Locacao locacao){
        if (!existe(locacao)) {
            return locacaoDAO.inserir(locacao);
        }
        return false;
    }

    public boolean alterar(Locacao locacao){
        return locacaoDAO.alterar(locacao);
    }

    public boolean excluir(Locacao locacao){
        return locacaoDAO.excluir(locacao);
    }

    public Locacao procurarPorCliente(String cliente) {
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        return locacaoDAO.procurarPorCliente(cliente);
    }

    public boolean existe(Locacao locacao){
        return locacaoDAO.existe(locacao);
    }

    public List<Locacao> pesquisarTodos(){
        return locacaoDAO.pesquisarTodos();
    }
}