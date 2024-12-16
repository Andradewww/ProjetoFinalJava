package Main;

import DAO.AdminDAO;
import DAO.ClienteDAO;
import DAO.AgenteDAO;
import DTO.Admin;
import DTO.Cliente;
import DTO.Agente;
import java.util.Scanner;

public class Main {
    
public static void main(String[] args) {
	
	//view inicial para verificacoes
    
    AdminDAO adminDAO = new AdminDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    AgenteDAO agenteDAO = new AgenteDAO();

    //verificar se já existe um administrador cadastrado
    
    if (adminDAO.existe()) {
        System.out.println("Redirecionando para login ...");
        iniciarLogin(adminDAO, clienteDAO, agenteDAO);
    } else {
        System.out.println("Nenhum administrador cadastrado. Vamos criar um administrador.");
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe um Email seguro: ");
        String email = leia.next();
        System.out.println("Informe a Senha: ");
        String senha = leia.next();
        leia.close();

        if (adminDAO.inserir(new Admin(0, email, senha))) {
            System.out.println("Administrador criado com sucesso! Redirecionando para login ...");
            iniciarLogin(adminDAO, clienteDAO, agenteDAO);
        } else {
            System.out.println("Erro ao criar administrador. Tente novamente.");
        }
    }
}

    //view login
    public static void iniciarLogin(AdminDAO adminDAO, ClienteDAO clienteDAO, AgenteDAO agenteDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (adminDAO.validaEmailSenha(email, senha)) { //foi necessário implementar mais um método a parte para admin
            System.out.println("Login como administrador bem-sucedido. Bem-vindo ao sistema!");

            TelaAdmin.TelaAdmin(adminDAO, clienteDAO, agenteDAO);
            
        } else if (clienteDAO.existe(email, senha)) {
            System.out.println("Login como cliente bem-sucedido. Bem-vindo ao sistema!");

            TelaCliente.TelaCliente(clienteDAO, senha);
            
        } else if (agenteDAO.existe(email, senha)) {
            System.out.println("Login como agente bem-sucedido. Bem-vindo ao sistema!");

            TelaAgente.TelaAgente(agenteDAO, clienteDAO);
            
        } else {
            System.out.println("Credenciais incorretas. Tente novamente.");
            iniciarLogin(adminDAO, clienteDAO, agenteDAO); //tenta novamente
        }

        scanner.close();
    }
    
    
    
    
}
