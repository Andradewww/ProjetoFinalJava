package BO;

import DTO.Carro;
import DAO.CarroDAO;
import java.util.List;

public class CarroBO {

    public boolean inserir(Carro carro){
        if (existe(carro) != true) {
            CarroDAO carroDAO = new CarroDAO();
            return carroDAO.inserir(carro);
        }
        return false;
    }
    /*
    public boolean alterar(Carro marca){
        MarcaDAO marcasDAO = new MarcaDAO();
        return marcasDAO.alterar(marca);
    }
    public boolean excluir(Carro marca){
        MarcaDAO marcasDAO = new MarcaDAO();
        return marcasDAO.excluir(marca);
    }
    public Carro procurarPorCodigo(Carro marca){
        MarcaDAO marcasDAO = new MarcaDAO();
        return marcasDAO.procurarPorCodigo(marca);
    }
    public Carro procurarPorDescricao(Carro marca){
        MarcaDAO marcasDAO = new MarcaDAO();
        return marcasDAO.procurarPorDescricao(marca);
    }
    */
    public boolean existe(Carro carro){
    	CarroDAO carroDAO = new CarroDAO();
        return carroDAO.existe(carro);
    }
        /*
    public List<Carro> pesquisarTodos(){
        MarcaDAO marcasDAO = new MarcaDAO();
        return marcasDAO.pesquisarTodos();
    }*/
}