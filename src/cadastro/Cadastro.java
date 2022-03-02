package cadastro;

import java.util.Scanner;

import helpers.Utils;
import models.Banco;
import models.Cliente;
import models.Conta;
import view.MainView;
import view.MenuView;

public class Cadastro {
	
	public static Scanner teclado = new Scanner(System.in);
	public static Banco banco = new Banco();
	
	public static void criarConta() {	

		System.out.println("Informe o nome do cliente: ");
		String nome = Cadastro.teclado.nextLine();
		
		System.out.println("CPF do cliente: ");
		String cpf = MainView.teclado.nextLine();
		
		System.out.println("Data de nascimento do cliente: ");
		System.out.println("dd/MM/YYYY");
		String data_nascimento = Cadastro.teclado.nextLine();

		System.out.println("E-mail do cliente: ");
		String email = Cadastro.teclado.nextLine();		

		Cliente cliente = new Cliente(nome, cpf, Utils.stringToDate(data_nascimento), email);

		Conta conta = new Conta(cliente);
		
		System.out.println("=======================================================");
		System.out.println("|               Conta criada com sucesso!             |");
		System.out.println("=======================================================");
		System.out.println("|                 Dados da conta criada               |");
		System.out.println("-------------------------------------------------------");		
		System.out.println(conta);
		System.out.println("=======================================================");
		
		Utils.pause(6);
		Banco.contas.add(conta);
		MenuView.menu();
	}

}
