package com.silverlining.system.banking.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import com.silverlining.system.banking.modelo.Conta;
import com.silverlining.system.banking.modelo.Pessoa;
import com.silverlining.system.banking.modelo.PessoaFisica;
import com.silverlining.system.banking.modelo.PessoaJuridica;
import com.silverlining.system.banking.repositorio.ConexaoBanco;
import com.silverlining.system.banking.util.Relatorio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FXMLDocumentController implements Initializable {

	// PÃ¡gina Inicial
	@FXML
	private Label lblTitulo1;
	@FXML
	private Label lblTitulo2;

	@FXML
	private ImageView imgPrincipal;

	// Cadastro Pessoa FÃ­sica

	@FXML
	private Label lblTituloFisica;
	@FXML
	private Label lblNome;
	@FXML
	private Label lblData;
	@FXML
	private Label lblSexo;
	@FXML
	private Label lblEstadoCivil;
	@FXML
	private Label lblCPF;
	@FXML
	private Label lblRG;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblFone;
	@FXML
	private Label lblLogradouro;
	@FXML
	private Label lblNum;
	@FXML
	private Label lblBairro;
	@FXML
	private Label lblCidade;
	@FXML
	private Label lblUF;

	@FXML
	private TextField txtNome;
	@FXML


	private TextField txtData;
	@FXML
	private TextField txtCPF;
	@FXML
	private TextField txtRG;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtFone;
	@FXML
	private TextField txtLogradouro;
	@FXML
	private TextField txtNum;
	@FXML
	private TextField txtBairro;
	@FXML
	private TextField txtCidade;

	@FXML
	private ComboBox comboSexo;
	@FXML
	private ComboBox comboEstadoCivil;
	@FXML
	private ComboBox comboUF;

	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnLimpar;

	// Cadastro Pessoa Juridica

	@FXML
	private Label lblTituloJuridica;
	@FXML
	private Label lblRazao;
	@FXML
	private Label lblFantasia;
	@FXML
	private Label lblCNPJ;
	@FXML
	private Label lblResponsavel;
	@FXML
	private Label lblEmailJ;
	@FXML
	private Label lblLogradouroJ;
	@FXML
	private Label lblNumJ;
	@FXML
	private Label lblBairroJ;
	@FXML
	private Label lblCidadeJ;
	@FXML
	private Label lblUFJ;

	@FXML
	private TextField txtRazao;
	@FXML
	private TextField txtFantasia;
	@FXML
	private TextField txtCNPJ;
	@FXML
	private TextField txtResponsavel;
	@FXML
	private TextField txtEmailJ;
	@FXML
	private TextField txtLogradouroJ;
	@FXML
	private TextField txtNumJ;
	@FXML
	private TextField txtBairroJ;
	@FXML
	private TextField txtCidadeJ;

	@FXML
	private ComboBox comboUFJ;

	@FXML
	private Button btnSalvarJ;
	@FXML
	private Button btnLimparJ;

	// Cadastro de Contas
	@FXML
	private Label lblTituloConta;
	@FXML
	private Label lblTitular;
	@FXML
	private Label lblBanco;
	@FXML
	private Label lblNumConta;
	@FXML
	private Label lblAgencia;
	@FXML
	private Label lblSaldo;
	@FXML
	private Label lblTipoConta;

	@FXML
	private TextField txtNumConta;
	@FXML
	private TextField txtAgencia;
	@FXML
	private TextField txtSaldo;

	@FXML
	private ComboBox comboTitular;
	@FXML
	private ComboBox comboBanco;
	@FXML
	private ComboBox comboTipoConta;

	@FXML
	private Button btnSalvarC;
	@FXML
	private Button btnLimparC;

	// RelatÃ³rios
	@FXML
	private Label lblTituloRelatorio;

	@FXML
	private CheckBox checkFisica;
	@FXML
	private CheckBox checkJuridica;
	@FXML
	private CheckBox checkCorrente;
	@FXML
	private CheckBox checkPoupanca;

	@FXML
	private Button btnConsultar;

	// Sobre
	@FXML
	private Label lblEquipe;
	@FXML
	private Label lblAndre;
	@FXML
	private Label lblJanio;
	@FXML
	private Label lblVanessa;

	@FXML
	private ImageView imgSobre;
	
	//Editar Pessoa Fisica
	@FXML
	private ComboBox comboEditProf;
	@FXML
	private Button btnEditFis;
	@FXML
	private TextField txtNome1;
	@FXML 
	private TextField txtData1;
	@FXML
	private ComboBox comboSexo1;
	@FXML
	private ComboBox comboEstadoCivil1;
	@FXML
	private TextField txtCPF1;
	@FXML
	private TextField txtRG1;
	@FXML
	private TextField txtEmail1;
	@FXML
	private TextField txtFone1;
	@FXML
	private TextField txtLogradouro1;
	@FXML
	private TextField txtNum1;
	@FXML
	private TextField txtBairro1;
	@FXML
	private TextField txtCidade1;
	@FXML
	private ComboBox comboUF1;
	@FXML
	private Button btnSalvar1;
	@FXML
	private Button btnLimpar1;
	
	private boolean btnEdit = false;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Inserindo os nomes dos bancos no comoboBox
		comboBanco.getItems().addAll("Banco do Brasil", "Caixa Econômica", "Itaú", "Santander", "Banco do Nordeste");
		// Inserindo tipos da conta no comboBox
		comboTipoConta.getItems().addAll("Corrente", "Poupança");

		// Inserindo ufs no combo
		ConexaoBanco ufs = new ConexaoBanco();
		if (ufs.connect()) {
			comboUF.getItems().addAll(ufs.selectUf());
			comboUFJ.getItems().addAll(comboUF.getItems());
			comboUF1.getItems().addAll(comboUF.getItems());
			// Inserindo titulares no comboBox
			comboTitular.getItems().addAll(ufs.titulares());
			//Inserindo cpfs no comboBox de editar pessoa fisica
			comboEditProf.getItems().addAll(ufs.getCpf());
			ufs.disconnect();
		}

		// Inserindo estado civil no comboBox
		comboEstadoCivil.getItems().addAll("Casado", "Solteiro", "Divorciado");
		comboEstadoCivil1.getItems().addAll("Casado", "Solteiro", "Divorciado");

		// Inserindo sexo no comboBox
		comboSexo.getItems().addAll("F", "M");
		comboSexo1.getItems().addAll("F", "M");

	}
	
	public void limpar_fisica(){
		LimparCampos l = new LimparCampos();
		l.limpar_txt(txtNome); l.limpar_txt(txtData); l.limpar_txt(txtCPF); l.limpar_txt(txtRG);
		l.limpar_txt(txtEmail);l.limpar_txt(txtFone);l.limpar_txt(txtLogradouro);l.limpar_txt(txtNum);
		l.limpar_txt(txtBairro);l.limpar_txt(txtCidade);l.limpar_combo(comboSexo);l.limpar_combo(comboEstadoCivil);
		l.limpar_combo(comboUF);
	}
	
	public void limpar_juridica(){
		LimparCampos l = new LimparCampos();
		l.limpar_txt(txtRazao);l.limpar_txt(txtFantasia);l.limpar_txt(txtCNPJ);l.limpar_txt(txtResponsavel);
		l.limpar_txt(txtEmailJ);l.limpar_txt(txtLogradouroJ);l.limpar_txt(txtNumJ);l.limpar_txt(txtBairroJ);
		l.limpar_txt(txtCidadeJ);l.limpar_combo(comboUFJ);
	}
	
	public void limpar_contas(){
		LimparCampos l = new LimparCampos();
		l.limpar_txt(txtNumConta); l.limpar_txt(txtAgencia); l.limpar_txt(txtSaldo);
		l.limpar_combo(comboBanco);l.limpar_combo(comboTipoConta);l.limpar_combo(comboTitular);
	}
	
	public void salvar_conta(ActionEvent event) {
		Conta conta = new Conta(comboTitular.getValue().toString(), txtAgencia.getText(),
				Double.parseDouble(txtSaldo.getText()), comboBanco.getValue().toString(),
				comboTipoConta.getValue().toString());
		ConexaoBanco connection = new ConexaoBanco();
		if (connection.connect()) {
			// Pegando as Chaves Primarias dos Titulares
			List chaves_primarias = connection.getCpf_cnpj();
			// Pegando a Chave do titular selecionado
			String chave_selecionado = (String) chaves_primarias.get(comboTitular.getSelectionModel().getSelectedIndex());
			chave_selecionado = chave_selecionado.replaceAll(" ", "");
			String query = "INSERT INTO Conta (titular, agencia, saldo, banco, tipoConta, numeroConta) VALUES ('" + chave_selecionado
					+ "', '" + conta.getAgencia() + "', " + conta.getSaldo() + ", '" + conta.getBanco() + "', '"
					+ conta.getTipoConta() + "', '" + txtNumConta.getText() + "')";
			
			limpar_contas();
			
			if (connection.inserir(query) ==  1){
				Alerts a = new Alerts();
				a.sucesso("Mensagem", "Cadastro efetuado com sucesso!");
			} else {
				Alerts a = new Alerts();
				a.erro("ERRO", "Cadastro NÃO efetuado!");
			}
			
			connection.disconnect();

		}

	}

	public void salvar_p_fisica(ActionEvent event) {
		Pessoa pessoa = new PessoaFisica(txtNome.getText(), txtCidade.getText(), comboUF.getValue().toString(),
				txtBairro.getText(), Integer.parseInt(txtNum.getText()), txtLogradouro.getText(), txtRG.getText(),
				txtCPF.getText(), comboEstadoCivil.getValue().toString(), txtData.getText(),
				comboSexo.getValue().toString().charAt(0));
			((PessoaFisica) pessoa).setTelefone(txtFone.getText());
			((PessoaFisica) pessoa).setEmail(txtEmail.getText());

		ConexaoBanco connection = new ConexaoBanco();
		if (connection.connect()) {
			String queryCodUF = "SELECT codigoUF FROM UF WHERE sigla=" + "'" + comboUF.getValue().toString() + "'";
			int codigoUF = connection.idTabelas(queryCodUF, "codigoUF");
			String query = "INSERT INTO Pessoa (codigoUF, email, telefone, logradouro, numero, bairro, cidade, cpf_cnpj) VALUES ("
					+ codigoUF + ", '" + pessoa.getEmail() + "', '" + ((PessoaFisica) pessoa).getTelefone() + "', '"
					+ pessoa.getLogradouro() + "', " + pessoa.getNumero() + ", '" + pessoa.getBairro() + "', '"
					+ pessoa.getCidade() + "', '" + ((PessoaFisica) pessoa).getCpf() + "')";
			String query2 = "INSERT INTO Fisica (cpf, rg, dataNascimento, nome, sexo, estadoCivil) VALUES (" + "'"
					+ ((PessoaFisica) pessoa).getCpf() + "', '" + ((PessoaFisica) pessoa).getRg() + "', '"
					+ ((PessoaFisica) pessoa).getDataNasc() + "', '" + ((PessoaFisica) pessoa).getNome() + "', '"
					+ ((PessoaFisica) pessoa).getSexo() + "', '" + ((PessoaFisica) pessoa).getEstado_civil() + "')";
			
			limpar_fisica();
			if (connection.inserir(query) ==  1 && connection.inserir(query2) == 1){
				comboTitular.getItems().removeAll(connection.titulares());
				comboTitular.getItems().addAll(connection.titulares());
				comboEditProf.getItems().removeAll(connection.getCpf());
				comboEditProf.getItems().addAll(connection.getCpf());
				Alerts a = new Alerts();
				a.sucesso("Mensagem", "Cadastro efetuado com sucesso!");
			} else {
				Alerts a = new Alerts();
				a.erro("ERRO", "Cadastro NÃO efetuado!");
			}
			
			connection.disconnect();
		}
	}

	public void salvar_p_juridica(ActionEvent event) {
		Pessoa pessoa = new PessoaJuridica(txtRazao.getText(), txtCidadeJ.getText(), comboUFJ.getValue().toString(),
				txtBairroJ.getText(), Integer.parseInt(txtNumJ.getText()), txtLogradouroJ.getText(), txtCNPJ.getText(),
				txtResponsavel.getText());
		pessoa.setEmail(txtEmailJ.getText());
		((PessoaJuridica) pessoa).setNome_fantasia(txtFantasia.getText());
		ConexaoBanco connection = new ConexaoBanco();
		if (connection.connect()) {
			String queryCodUF = "SELECT codigoUF FROM UF WHERE sigla=" + "'" + comboUFJ.getValue().toString() + "'";
			int codigoUF = connection.idTabelas(queryCodUF, "codigoUF");
			String query = "INSERT INTO Pessoa (codigoUF, email, logradouro, numero, bairro, cidade, cpf_cnpj) VALUES ("
					+ codigoUF + ", '" + pessoa.getEmail() + "', '" + pessoa.getLogradouro() + "', "
					+ pessoa.getNumero() + ", '" + pessoa.getBairro() + "', '" + pessoa.getCidade() + "', '"
					+ ((PessoaJuridica) pessoa).getCnpj() + "')";
			String query2 = "INSERT INTO Juridica (cnpj, nomeFantasia, razaoSocial, responsavel) VALUES (" + "'"
					+ ((PessoaJuridica) pessoa).getCnpj() + "', '" + ((PessoaJuridica) pessoa).getNome_fantasia()
					+ "', '" + pessoa.getNome() + "', '" + ((PessoaJuridica) pessoa).getResponsavel() + "')";
			
			limpar_juridica();
			
			if (connection.inserir(query) ==  1 && connection.inserir(query2) == 1){
				comboTitular.getItems().removeAll(connection.titulares());
				comboTitular.getItems().addAll(connection.titulares());
				Alerts a = new Alerts();
				a.sucesso("Mensagem", "Cadastro efetuado com sucesso!");
			} else {
				Alerts a = new Alerts();
				a.erro("ERRO", "Cadastro NÃO efetuado!");
			}
			
			connection.disconnect();
		}
	}
	
	public void gerar_relatorios(ActionEvent event){
		if(checkPoupanca.selectedProperty().get()){
			Relatorio r = new Relatorio();
			r.gerar_relatorio_conta_poupanca();
			checkPoupanca.selectedProperty().setValue(null);
		}
		
		if(checkCorrente.selectedProperty().get()){
			Relatorio r = new Relatorio();
			r.gerar_relatorio_conta_corrente();
			checkCorrente.selectedProperty().setValue(null);
		}
		if(checkFisica.selectedProperty().get()){
			Relatorio r = new Relatorio();
			r.gerar_relatorio_pessoa_fisica();
			checkFisica.selectedProperty().setValue(null);
		}
		if(checkJuridica.selectedProperty().get()){
			Relatorio r = new Relatorio();
			r.gerar_relatorio_pessoa_juridica();
			checkJuridica.selectedProperty().setValue(null);
		}
		
	}
	
	public void carrega_dados_fisica(){
		if (comboEditProf.getSelectionModel().getSelectedIndex() > -1){
			btnEdit = true;
			ConexaoBanco c = new ConexaoBanco();
			if (c.connect()){
				PessoaFisica p = (PessoaFisica) c.getPessoaFisica(comboEditProf.getValue().toString());
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					p.setDataNasc(formatter.parse(p.getDataNasc()).toLocaleString());
					p.setDataNasc(p.getDataNasc().replace(" 00:00:00", ""));
				} catch (ParseException e) {
				}
				txtNome1.setText(p.getNome());
				txtData1.setText(p.getDataNasc());
				txtCPF1.setText(p.getCpf());
				txtCPF1.setEditable(false);
				txtRG1.setText(p.getRg());
				txtEmail1.setText(p.getEmail());
				txtFone1.setText(p.getTelefone());
				txtLogradouro1.setText(p.getLogradouro());
				txtNum1.setText(p.getNumero() + "");
				txtBairro1.setText(p.getBairro());
				txtCidade1.setText(p.getCidade());
				comboSexo1.setValue(p.getSexo());
				comboUF1.setValue(p.getUf());
				comboEstadoCivil1.setValue(p.getEstado_civil());
				c.disconnect();
			}
		} 
		else {
			Alerts a = new Alerts();
			a.aviso("Aviso", "Selecione um cpf");
		}
	}
	
	public void edita_pessoa_fisica(){
		if (comboEditProf.getSelectionModel().getSelectedIndex() > -1 && btnEdit == true){
			ConexaoBanco c = new ConexaoBanco();
			if (c.connect()){
				PessoaFisica p = (PessoaFisica) c.getPessoaFisica(comboEditProf.getValue().toString());
				String queryPessoa = "UPDATE fisica set  rg='" + txtRG1.getText() + "', datanascimento='"+txtData1.getText()+"',nome='"
						+txtNome1.getText()+"',sexo='"+comboSexo1.getValue().toString()+"',estadocivil='"
						+comboEstadoCivil1.getValue().toString()+"' WHERE cpf='"+p.getCpf()+"'";
				String cpf=p.getCpf();
				cpf=cpf.replaceAll(" ", "");
				String queryPessoa2="UPDATE pessoa set email='"+txtEmail1.getText()+"',telefone='"
									+txtFone1.getText()+"',logradouro='"+txtLogradouro1.getText()+"',numero='"
									+txtNum1.getText()+"',bairro='"+txtBairro1.getText()+"',cidade='"+txtCidade1.getText()+"' where cpf_cnpj='"
									+cpf+"'";
				
				if (c.inserir(queryPessoa) ==  1 && c.inserir(queryPessoa2) == 1){
					Alerts a = new Alerts();
					a.sucesso("Mensagem", "Cadastro atualizado com sucesso!");
				} 
				else {
					Alerts a = new Alerts();
					a.erro("ERRO", "Cadastro NÃO atualizado!");
				}
				
				comboTitular.getItems().removeAll(c.titulares());
				comboTitular.getItems().addAll(c.titulares());
				comboEditProf.getItems().removeAll(c.getCpf());
				comboEditProf.getItems().addAll(c.getCpf());
				btnEdit = false;
				c.disconnect();
			}
		}
		else {
			Alerts a = new Alerts();
			a.aviso("Aviso", "Selecione um cpf e pressione EDITAR");
		}
	}
	
	public void excluir_pessoa_fisica(){
		if (comboEditProf.getSelectionModel().getSelectedIndex() > -1){
			String query = "DELETE FROM Fisica WHERE cpf='" + comboEditProf.getValue().toString() + "'";
			ConexaoBanco c = new ConexaoBanco();
			if (comboEditProf.getValue().toString() != ""){
				if (c.connect()){
					comboEditProf.getItems().removeAll(c.getCpf());
					if (c.editar_excluir(query) == 1){
						Alerts a = new Alerts();
						a.sucesso("Mensagem", "Dado excluido com sucesso!");
					} else {
						Alerts a = new Alerts();
						a.erro("ERRO", "Dado NÃO Excluído!");
					}
					comboTitular.getItems().removeAll(c.titulares());
					comboTitular.getItems().addAll(c.titulares());
					comboEditProf.setValue(null);
					comboEditProf.getItems().addAll(c.getCpf());
					c.disconnect();
				}
			}
		}
		else {
			Alerts a = new Alerts();
			a.aviso("Aviso", "Selecione um cpf");
		}
	}

}
