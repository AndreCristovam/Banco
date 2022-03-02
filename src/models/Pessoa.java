package models;

import java.util.Date;

import helpers.Utils;

public abstract class Pessoa {
	
	private static int contador = 101;
	
	protected int codigo;
	protected String nome;
	protected String cpf;
	protected Date dataNascimento;
	protected String email;
	protected Date dataCadastro;

	public Pessoa(String nome, String cpf, Date dataNascimento, String email) {
		super();
		this.codigo = Pessoa.contador;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		
		Pessoa.contador += 1;
	}

	public int getCodigo() {
		return codigo;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataCadastro() {
		return this.dataCadastro;
	}	
	

	public String toString() {
		return "Código: " + this.getCodigo() +
				"\nNome: " + this.getNome() +
				"\nE-mail: " + this.getEmail() +
				"\nCPF: " + this.getCpf() +
				"\nData de Nascimento: " + Utils.dateToString(this.getDataNascimento()) +
				"\nData de Cadastro: " + Utils.dateToString(this.getDataCadastro());				
	}

}
