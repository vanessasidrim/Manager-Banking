package com.silverlining.system.banking.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.silverlining.system.banking.modelo.Pessoa;
import com.silverlining.system.banking.modelo.PessoaFisica;

public class ConexaoBanco {
	private final String host = "localhost";
	private final String user = "postgres";
	private final String password = "123456";
	private final String database = "Projeto_Java";

	public Connection c;

	public boolean connect() {

		boolean isConnected = false;

		String url;
		String portNumber = "5432";
		url = "jdbc:postgresql://" + this.host + ":" + portNumber + "/" + this.database;

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			this.c = DriverManager.getConnection(url, this.user, this.password);
			isConnected = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			isConnected = false;
		}
		return isConnected;
	}

	public boolean disconnect() {

		boolean isConnected = false;

		String url;
		String portNumber = "5432";
		url = "jdbc:postgresql://" + this.host + ":" + portNumber + "/" + this.database;

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			this.c = DriverManager.getConnection(url, this.user, this.password);
			this.c.close();
			isConnected = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
			isConnected = false;
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
			isConnected = false;
		}

		return isConnected;
	}

	public List titulares() {
		List titulares = new ArrayList<String>();
		String query = "SELECT  nome FROM Fisica";
		try {
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				titulares.add(rs.getString("nome"));
			}
			query = "SELECT razaosocial FROM Juridica";
			rs = st.executeQuery(query);
			while (rs.next()){
				titulares.add(rs.getString("razaosocial"));
			}
		} catch (SQLException e) {

		}
		
		return (ArrayList) titulares;
	}
	
	public List getCpf_cnpj(){
		List id_titulares = new ArrayList<String>();
		String query = "SELECT  cpf FROM Fisica";
		try {
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				id_titulares.add(rs.getString("cpf"));
			}
			query = "SELECT cnpj FROM Juridica";
			rs = st.executeQuery(query);
			while (rs.next()){
				id_titulares.add(rs.getString("cnpj"));
			}
		} catch (SQLException e) {

		}
		
		return (ArrayList) id_titulares;
	}

	public ArrayList<String> selectUf() {
		List<String> ufs = new ArrayList<String>();
		String query = "SELECT sigla FROM UF";
		try {
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ufs.add(rs.getString("sigla").toString());
			}
		} catch (SQLException e) {

		}
		return (ArrayList<String>) ufs;

	}

	public int idTabelas(String query, String coluna) {
		try {
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(coluna);
				return id;
			}
		} catch (SQLException e) {

		}
		return 0;
	}

	public int inserir(String query) {
		int rs = -1;

		try {
			Statement st = c.createStatement();
			rs = st.executeUpdate(query);

		} catch (SQLException e) {

		}

		return rs;
	}
	
	public int editar_excluir(String query) {
		int rs = -1;

		try {
			Statement st = c.createStatement();
			rs = st.executeUpdate(query);
			System.out.println(rs);
		} catch (SQLException e) {

		}

		return rs;
	}
	
	public String data_hora(){
		String query = "SELECT now()";
		String data = null;
		try{
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				data = rs.getString(1);
			}
			}catch (SQLException e){
				
			}
		return data;
	}
	
	public List getCpf(){
		List id_titulares = new ArrayList<String>();
		String query = "SELECT cpf FROM Fisica";
		try {
			Statement st = (Statement) c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				id_titulares.add(rs.getString("cpf"));
			}
		} catch (SQLException e) {

		}
		
		return (ArrayList) id_titulares;
	}
	
	public Pessoa getPessoaFisica(String id){
		Pessoa p = null;
		String query = "SELECT F.nome, f.cpf, f.rg, f.datanascimento, f.sexo, f.estadocivil, p.email, p.telefone, p.logradouro, p.numero, p.bairro, p.cidade, u.sigla FROM Pessoa p INNER JOIN Fisica f ON (p.cpf_cnpj=f.cpf) INNER JOIN UF u ON (u.codigouf = p.codigouf) WHERE f.cpf='" + id + "'";
		try{
			Statement st = (Statement)c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				p = new PessoaFisica(rs.getString("nome"), rs.getString("cidade"), rs.getString("sigla"), rs.getString("bairro"),
						Integer.parseInt(rs.getString("numero")), rs.getString("logradouro"), rs.getString("rg"), rs.getString("cpf"),
						rs.getString("estadocivil"), rs.getString("datanascimento"), rs.getString("sexo").charAt(0));
				p.setEmail(rs.getString("email"));
				((PessoaFisica)p).setTelefone(rs.getString("telefone"));
			}
		}catch (SQLException e){
			
		}
		return ((PessoaFisica)p);
	}

}
