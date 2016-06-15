package com.silverlining.system.banking.modelo;

public class Pessoa {
	protected String nome;
	protected String email;
	protected String logradouro;
	protected int numero;
	protected String bairro;
	protected String cidade;
	protected String uf;
	
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Pessoa(String nome, String logradouro, String bairro, int numero, String uf, String cidade){
		this.nome = nome;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.uf = uf;
		this.cidade = cidade;
	}
}
