package Main;

import DAO.AgenteDAO;
import DTO.Agente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletar os dados do agente
        System.out.println("Digite o id do agente:");
        int id = scanner.nextInt();

        System.out.println("Digite o código do agente:");
        int codigo = scanner.nextInt();

        System.out.println("Digite o nome do agente:");
        String nome = scanner.next();

        System.out.println("Digite a idade do agente:");
        int idade = scanner.nextInt();

        System.out.println("Digite o email do agente:");
        String email = scanner.next();

        System.out.println("Digite a senha do agente:");
        String senha = scanner.next();

        // Criar o objeto Agente com os dados coletados
        Agente agente = new Agente(id, codigo, nome, idade, email, senha);

        // Instanciar o DAO
        AgenteDAO agenteDAO = new AgenteDAO();

        // Inserir o agente no banco de dados
        if (agenteDAO.inserir(agente)) {
            System.out.println("Agente cadastrado com sucesso!");

            // Verificar se o agente foi realmente cadastrado
            Agente agenteVerificado = agenteDAO.procurarPorCodigo(codigo);
            if (agenteVerificado != null) {
                System.out.println("Agente encontrado:");
                System.out.println("Nome: " + agenteVerificado.getNome());
                System.out.println("Idade: " + agenteVerificado.getIdade());
                System.out.println("Email: " + agenteVerificado.getEmail());
            } else {
                System.out.println("Erro ao encontrar o agente no banco de dados.");
            }
        } else {
            System.out.println("Erro ao cadastrar o agente.");
        }

        scanner.close();
    }
}
