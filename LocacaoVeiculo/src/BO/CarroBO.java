package BO;
import DTO.Carro;
import DAO.CarroDAO;
import java.util.List;

public class CarroBO {
    private CarroDAO carroDAO;

    public CarroBO() {
        carroDAO = new CarroDAO();
    }

    public boolean inserir(Carro carro){
        if (!existe(carro)) {
            return carroDAO.inserir(carro);
        }
        return false;
    }

    public boolean alterar(Carro carro){
        return carroDAO.alterar(carro);
    }

    public boolean excluir(String placa){
        return carroDAO.excluir(placa);
    }

    public Carro procurarPorPlaca(String placa) {
        CarroDAO carroDAO = new CarroDAO();
        return carroDAO.procurarPorPlaca(placa);
    }

    public boolean existe(Carro carro){
        return carroDAO.existe(carro);
    }

    public List<Carro> pesquisarTodos(){
        return carroDAO.pesquisarTodos();
    }
}