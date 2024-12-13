package Main;

import BO.CarroBO;
import DTO.Carro;

public class MainInsercao {
	public static void main(String[] args) {
		// Teste Inserir
		CarroBO marcaBO = new CarroBO();
		Carro marca = new Carro("Dell");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		marca = new Carro("Android");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		marca = new Carro("LG");
		if (marcaBO.inserir(marca))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}