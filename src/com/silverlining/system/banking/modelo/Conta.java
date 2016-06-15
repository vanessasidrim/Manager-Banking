package com.silverlining.system.banking.modelo;

public class Conta {
	
	protected String titular;
	protected String agencia;
	protected double saldo;
	protected String banco;
	protected String tipoConta;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public Conta(String titular, String agencia, double saldo, String banco, String tipoConta){
		this.titular = titular;
		this.agencia = agencia;
		this.saldo = saldo;
		this.banco = banco;
		this.tipoConta = tipoConta;
	}

}
