package Main;

import BO.CarroBO;
import DTO.Carro;

public class Main {
	public static void main(String[] args) {
		// Teste Inserir
		CarroBO marcaBO = new CarroBO();
		Carro marca = new Carro("AAA5F53");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		marca = new Carro("ABC1234");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		marca = new Carro("ACV0987");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}
