package view;

import java.util.Scanner;

import cadastro.Cadastro;
import helpers.Utils;
import models.Banco;

public class MenuView {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void menu() {
		int opcao = 0;
		System.out.println("=======================================================");
		System.out.println("|                        ATM                          |");
		System.out.println("|                  " + MainView.nome + "                   |");
		System.out.println("=======================================================");
		System.out.println("|              Selecione uma opção no menu            |");
		System.out.println("|              ---------------------------            |");	
		System.out.println("| 1 - Criar conta                                     |");
		System.out.println("| 2 - Verificar saldo                                 |");
		System.out.println("| 3 - Efetuar saque                                   |");
		System.out.println("| 4 - Efetuar depósito                                |");
		System.out.println("| 5 - Efetuar Transferência                           |");
		System.out.println("| 6 - Listar contas                                   |");
		System.out.println("| 7 - Sair do sistema                                 |");
		System.out.println("=======================================================");

		try {
			opcao = Integer.parseInt(MenuView.teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Por Favor, informe uma opção válida");
			Utils.pause(1);
			MenuView.menu();
		}

		switch (opcao) {
		case 1:
			Cadastro.criarConta();
			break;
		case 2:
			Banco.verificarSaldo();
			break;
		case 3:
			Banco.efetuarSaque();
			break;
		case 4:
			Banco.efetuarDeposito();
			break;
		case 5:
			Banco.efetuarTranferencia();
			break;
		case 6:
			Banco.listarContas();
			break;
		case 7:
			System.out.println("Logout efetuado com Sucesso!");
			Utils.pause(2);
			System.exit(0);
		default:
			System.out.println("Opção inválida.");
			break;
		}

	}

}
