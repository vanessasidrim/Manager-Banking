package com.silverlining.system.banking.modelo;

public class PessoaJuridica extends Pessoa {
	private String nome_fantasia;
	private String cnpj;
	private String responsavel;
	private String telefone;

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public PessoaJuridica(String nome, String cidade, String uf, String bairro, int numero, String logradouro,
			String cnpj, String responsavel) {
		super(nome, logradouro, bairro, numero, uf, cidade);
		this.cnpj = cnpj;
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
