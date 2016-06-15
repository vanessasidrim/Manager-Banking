package com.silverlining.system.banking.modelo;

public class PessoaFisica extends Pessoa{
	private String dataNasc;
	private char sexo;
	private String estado_civil;
	private String cpf;
	private String rg;
	private String telefone;
	
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public PessoaFisica(String nome, String cidade, String uf, String bairro, int numero, String logradouro,
			String rg, String cpf, String estado_civil, String dataNasc, char sexo) {
		super (nome, logradouro, bairro, numero, uf, cidade);
		this.rg = rg;
		this.cpf = cpf;
		this.estado_civil = estado_civil;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
	}
	
}
