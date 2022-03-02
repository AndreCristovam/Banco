package view;

import java.util.ArrayList;
import java.util.Scanner;

import models.Banco;
import models.Conta;

public class MainView{

	public static String nome = "Banco Desalocado";
	public static Scanner teclado = new Scanner(System.in);
//	public static ArrayList<Conta> contas;

	public static void main(String[] args) {
		
		Banco.contas = new ArrayList<Conta>();
		
		MenuView.menu();
	}	
	
}
