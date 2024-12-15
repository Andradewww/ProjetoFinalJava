package Main;
import BO.CarroBO;
import DTO.Carro;

public class Main {
	public static void main(String[] args) {
		// Teste Inserir
		CarroBO carroBO = new CarroBO();
		
		// Criando o objeto Carro com todos os atributos
		Carro carro = new Carro(1,"AAA5F53", "marca teste", "modelo teste");
		
		if (carroBO.inserir(carro))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}