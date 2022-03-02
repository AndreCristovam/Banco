package models;

import helpers.Utils;

public class Conta {
	private static int codigo = 1001;

	private int numero;
	private Cliente cliente;
	private Double saldo = 0.0;
	private Double limite = 0.0;
	private Double saldoTotal;

	public Conta(Cliente cliente) {
		this.numero = Conta.codigo;
		this.cliente = cliente;
		Conta.codigo += 1;
		this.atualizaSaldoTotal();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limete) {
		this.limite = limete;
	}

	public int getNumero() {
		return numero;
	}

	public Double getSaldoTotal() {
		return saldoTotal;
	}

	private void atualizaSaldoTotal() {
		this.saldoTotal = this.getSaldo() + this.getLimite();
	}

	public String toString() {
		return "Número da Conta: " + this.getNumero() + "\nCliente: " + this.cliente.getNome() + "\nSaldo Total: "
				+ Utils.doubleToString(this.getSaldoTotal());
	}

	public void depositar(Double valor) {

		if (valor > 0) {
			this.saldo = this.getSaldo() + valor;
			this.atualizaSaldoTotal();
			System.out.println("Depósito efetuado com sucesso!");
		} else {
			System.out.println("Erro ao efetuar o depósito. Tente novamente.");
		}
	}

	public void sacar(Double valor) {
		
		if(valor > 0 && this.getSaldoTotal() >= valor) {
			
			if(this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso!");;
			}else {
			
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() - restante;
				this.saldo = 0.0;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso!");
			}
			
		}else {		
			System.out.println("Saque não realizado. Tente novamente.");
		}
	}

	public void tranferir(Conta destino, Double valor) {
		
		if(valor > 0 && this.getSaldoTotal() >= valor) {
			if(this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				destino.saldo = destino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Tranferência realizada com sucesso!");
			}else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() - restante;
				this.saldo = 0.0;
				destino.saldo = destino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Tranferência realizada com sucesso!");
			}
		}else {
			System.out.println("Tranferência não realizada. Tente novamente.");
		}
	}
}
