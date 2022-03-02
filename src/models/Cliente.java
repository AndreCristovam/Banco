package models;

import java.util.Date;

public class Cliente extends Pessoa {	

	public Cliente(String nome, String cpf, Date dataNascimento, String email) {
		super(nome, cpf, dataNascimento, email);	
		this.nome = nome;
		this.email = email;		
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = new Date();		
	}
	
}
