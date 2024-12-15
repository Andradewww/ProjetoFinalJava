package Main;
import BO.AgenteBO;
import BO.CarroBO;
import DTO.Agente;
import DTO.Carro;

public class Main {
	public static void main(String[] args) {
	    AgenteBO agenteBO = new AgenteBO();
	    Agente agenteEncontrado = agenteBO.procurarPorCodigo(1234); // Substitua '1' pelo código que deseja buscar

	    if (agenteEncontrado != null) {
	        System.out.println("Agente encontrado:");
	        System.out.println("Nome: " + agenteEncontrado.getNome());
	        System.out.println("Idade: " + agenteEncontrado.getIdade());
	        System.out.println("Codigo: " + agenteEncontrado.getCodigo());
	    } else {
	        System.out.println("Nenhum agente encontrado com o código especificado.");
	    }
	}
}