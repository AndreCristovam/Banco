package models;

import java.util.ArrayList;
import java.util.Scanner;

import helpers.Utils;

import view.MenuView;

public class Banco{

	public static Scanner teclado = new Scanner(System.in);
	public static ArrayList<Conta> contas;
	
	public static void efetuarSaque() {
		System.out.println("Informe o número da conta: ");

		int numero = Banco.teclado.nextInt();

		Conta conta = Banco.buscarContaPorNumero(numero);

		if (conta != null) {
			System.out.println("Informe o valor para saque: ");
			Double valor = Banco.teclado.nextDouble();

			conta.sacar(valor);
		} else {
			System.out.println("Não foi encontrada a conta número: " + numero);
		}

		Utils.pause(6);
		System.out.println();
		System.out.println();
		System.out.println();

		MenuView.menu();
	}
	
	public static void verificarSaldo() {
		System.out.println("Informe o número da conta: ");

		int numero = Banco.teclado.nextInt();
		
		Conta conta = Banco.buscarContaPorNumero(numero);
		
		if (conta != null) {
			System.out.println(conta.toString());
			Utils.pause(3);
			MenuView.menu();
		} else {
			System.out.println("Não foi encontrada a conta número: " + numero);
			Utils.pause(3);
			MenuView.menu();
		}
	}

	public static void efetuarDeposito() {
		System.out.println("Informe o número da conta: ");

		int numero = Banco.teclado.nextInt();

		Conta conta = Banco.buscarContaPorNumero(numero);
		
		if (conta != null) {
			System.out.println("Informe o valor de depósito: ");
			Double valor = Banco.teclado.nextDouble();

			conta.depositar(valor);
		} else {
			System.out.println("Não foi encontrada a conta número: " + numero);
		}

		Utils.pause(6);
		MenuView.menu();
	}

	public static void efetuarTranferencia() {
		System.out.println("Informe o número da sua conta: ");
		int numero_origem = Banco.teclado.nextInt();

		Conta conta_origem = Banco.buscarContaPorNumero(numero_origem);
		
		if (conta_origem != null) {
			System.out.println("Informe o número da conta destino: ");
			int numero_destino = Banco.teclado.nextInt();
			
			Conta conta_destino = Banco.buscarContaPorNumero(numero_destino);
			if(conta_destino != null) {
				System.out.println("Informe o valor da transferência: ");
				Double valor = Banco.teclado.nextDouble();
				
				conta_origem.tranferir(conta_destino, valor);
			}else {
				System.out.println("A conta destino número: " + numero_origem + " não foi encontrada.");
			}			
		} else {
			System.out.println("Não foi encontrada a conta número: " + numero_origem);
		}

		Utils.pause(6);
		System.out.println();
		System.out.println();
		System.out.println();

		MenuView.menu();
	}

	public static void listarContas() {
		if(Banco.contas.size() > 0) {
			System.out.println("Listagem de Contas");
			System.out.println();
			
			for(Conta conta : Banco.contas) {
				System.out.println(conta);
				System.out.println();
				Utils.pause(1);
			}
			System.out.println();
		}else {
			System.out.println("Não existem contas cadastradas ainda.");
			Utils.pause(2);
			MenuView.menu();
		}
	}
	
	public static Conta buscarContaPorNumero(int numero) {
		Conta c = null;
		if(Banco.contas.size() > 0) {
			for(Conta conta : Banco.contas) {
				if(conta.getNumero() == numero) {
					c = conta;
				}
			}
		}
		return c;
	}

}
