package com.silverlining.system.banking.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.silverlining.system.banking.repositorio.ConexaoBanco;

public class Relatorio {
	private Document document = new Document(PageSize.A4, 0, 0, 0, 0);

	public int gerar_relatorio_conta_poupanca() {
		try {
			ConexaoBanco connection = new ConexaoBanco();
			String data = null;
			if (connection.connect()){
				data = connection.data_hora();
				data = data.replaceAll(" ", "_");
				data = data.replaceAll(":", "_");
				data = data.replaceAll("-", "_");
			}
			PdfWriter.getInstance(document, new FileOutputStream("C:/SystemBanking/RelatorioContasPoupanca_" +
				data + ".pdf"));
			document.open();
			
			Image img = Image.getInstance("src/com/silverlining/system/banking/controller/logoRelatorio.png");
			img.scaleAbsolute(140f, 120f);
			img.setAlignment(Image.ALIGN_CENTER);
			
			Paragraph p = new Paragraph(" ");
			PdfPTable table = new PdfPTable(new float[]{0.6f, 0.2f, 0.2f, 0.4f, 0.3f, 0.3f});
			PdfPCell header = new PdfPCell(new Paragraph("Relatório de Contas Poupança"));
			header.setColspan(6);
			table.addCell(header);
			table.addCell("Titular");
			table.addCell("Conta");
			table.addCell("Agência");
			table.addCell("Banco");
			table.addCell("Tipo");
			table.addCell("Saldo");
			
			String query = "SELECT F.nome, C.numeroconta, C.agencia, C.Banco, C.tipoconta, C.saldo "
					+ "FROM Conta C "
					+ "INNER JOIN Fisica F ON (C.titular=F.cpf) "
					+ "WHERE C.tipoconta='Poupança'";
			Statement st = connection.c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				table.addCell(rs.getString("nome"));
				table.addCell(rs.getString("numeroconta"));
				table.addCell(rs.getString("agencia"));
				table.addCell(rs.getString("banco"));
				table.addCell(rs.getString("tipoconta"));
				table.addCell(rs.getString("saldo"));
			}
			query = "SELECT J.razaosocial, C.numeroconta, C.agencia, C.Banco, C.tipoconta, C.saldo "
					+ "FROM Conta C "
					+ "INNER JOIN Juridica J ON (C.titular=J.cnpj) "
					+ "WHERE C.tipoconta='Poupança'";
			rs = st.executeQuery(query);
			while(rs.next()){
					table.addCell(rs.getString("razaosocial"));
					table.addCell(rs.getString("numeroconta"));
					table.addCell(rs.getString("agencia"));
					table.addCell(rs.getString("banco"));
					table.addCell(rs.getString("tipoconta"));
					table.addCell(rs.getString("saldo"));
			}

			document.add(img);
			document.add(p);
			document.add(table);
			document.close();
			Runtime.getRuntime().exec("cmd /c start C:/SystemBanking/RelatorioContasPoupanca_" +
				data + ".pdf");
			connection.disconnect();
			return 1;
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return 0;
		} catch (SQLException e){
			return 0 ;
		}
	}
	
	public int gerar_relatorio_conta_corrente() {
		try {
			ConexaoBanco connection = new ConexaoBanco();
			String data = null;
			if (connection.connect()){
				data = connection.data_hora();
				data = data.replaceAll(" ", "_");
				data = data.replaceAll(":", "_");
				data = data.replaceAll("-", "_");
			}
			PdfWriter.getInstance(document, new FileOutputStream("C:/SystemBanking/RelatorioContasCorrente_" +
				data + ".pdf"));
			document.open();
			
			Image img = Image.getInstance("src/com/silverlining/system/banking/controller/logoRelatorio.png");
			img.scaleAbsolute(140f, 120f);
			img.setAlignment(Image.ALIGN_CENTER);
			
			Paragraph p = new Paragraph(" ");
			PdfPTable table = new PdfPTable(new float[]{0.6f, 0.2f, 0.2f, 0.4f, 0.3f, 0.3f});
			PdfPCell header = new PdfPCell(new Paragraph("Relatório de Contas Corrente"));

			header.setColspan(6);
			table.addCell(header);
			table.addCell("Titular");
			table.addCell("Conta");
			table.addCell("Agência");
			table.addCell("Banco");
			table.addCell("Tipo");
			table.addCell("Saldo");
			
			String query = "SELECT F.nome, C.numeroconta, C.agencia, C.Banco, C.tipoconta, C.saldo "
					+ "FROM Conta C "
					+ "INNER JOIN Fisica F ON (C.titular=F.cpf) "
					+ "WHERE C.tipoconta='Corrente'";
			Statement st = connection.c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				table.addCell(rs.getString("nome"));
				table.addCell(rs.getString("numeroconta"));
				table.addCell(rs.getString("agencia"));
				table.addCell(rs.getString("banco"));
				table.addCell(rs.getString("tipoconta"));
				table.addCell(rs.getString("saldo"));
			}
			query = "SELECT J.razaosocial, C.numeroconta, C.agencia, C.Banco, C.tipoconta, C.saldo "
					+ "FROM Conta C "
					+ "INNER JOIN Juridica J ON (C.titular=J.cnpj) "
					+ "WHERE C.tipoconta='Corrente'";
			rs = st.executeQuery(query);
			while(rs.next()){
					table.addCell(rs.getString("razaosocial"));
					table.addCell(rs.getString("numeroconta"));
					table.addCell(rs.getString("agencia"));
					table.addCell(rs.getString("banco"));
					table.addCell(rs.getString("tipoconta"));
					table.addCell(rs.getString("saldo"));
			}

			document.add(img);
			document.add(p);
			document.add(table);
			document.close();
			Runtime.getRuntime().exec("cmd /c start C:/SystemBanking/RelatorioContasCorrente_" +
					data + ".pdf");
			connection.disconnect();
			return 1;
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return 0;
		} catch (SQLException e){
			return 0;
		}
	}
	
	public int gerar_relatorio_pessoa_fisica() {
		try {
			ConexaoBanco connection = new ConexaoBanco();
			String data = null;
			if (connection.connect()){
				data = connection.data_hora();
				data = data.replaceAll(" ", "_");
				data = data.replaceAll(":", "_");
				data = data.replaceAll("-", "_");
			}
			PdfWriter.getInstance(document, new FileOutputStream("C:/SystemBanking/RelatorioContasFisica_" +
				data + ".pdf"));
			document.open();
			
			Image img = Image.getInstance("src/com/silverlining/system/banking/controller/logoRelatorio.png");
			img.scaleAbsolute(140f, 120f);
			img.setAlignment(Image.ALIGN_CENTER);
			
			PdfPTable table = new PdfPTable(11);
			table.setTotalWidth(600);
			table.setLockedWidth(true);
			PdfPCell header = new PdfPCell(new Paragraph("Relatório de Pessoas Física"));
			header.setColspan(11);
			table.addCell(header);
			table.addCell("Nome");
			table.addCell("CPF");
			table.addCell("RG");
			table.addCell("Sexo");
			table.addCell("Est.Civil");
			table.addCell("E-mail");
			table.addCell("Telefone");
			table.addCell("Logra.");
			table.addCell("Numero");
			table.addCell("Bairro");
			table.addCell("UF");
			String query = "SELECT F.nome,P.cpf_cnpj,F.RG,F.dataNascimento,F.sexo,F.estadoCivil,P.email,P.telefone,P.logradouro,P.numero,P.bairro,P.cidade,U.sigla "
					+"FROM Fisica F INNER JOIN Pessoa P ON (F.cpf=P.cpf_cnpj) "
					+"INNER JOIN UF U on (P.codigoUF=U.codigoUF)";
			Statement st = connection.c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				table.addCell(rs.getString("nome"));
				table.addCell(rs.getString("cpf_cnpj"));
				table.addCell(rs.getString("RG"));
				table.addCell(rs.getString("sexo"));
				table.addCell(rs.getString("estadoCivil"));
				table.addCell(rs.getString("email"));
				table.addCell(rs.getString("telefone"));
				table.addCell(rs.getString("logradouro"));
				table.addCell(rs.getString("numero"));
				table.addCell(rs.getString("bairro"));
				table.addCell(rs.getString("sigla"));
			}

			Paragraph p = new Paragraph(" ");
			document.add(img);
			document.add(p);
			document.add(table);
			document.close();
			Runtime.getRuntime().exec("cmd /c start C:/SystemBanking/RelatorioContasFisica_" +
					data + ".pdf");
			connection.disconnect();
			return 1;
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return 0;
		} catch (SQLException e){
			return 0;
		}
	}
	
	public int gerar_relatorio_pessoa_juridica() {
		try {
			ConexaoBanco connection = new ConexaoBanco();
			String data = null;
			if (connection.connect()){
				data = connection.data_hora();
				data = data.replaceAll(" ", "_");
				data = data.replaceAll(":", "_");
				data = data.replaceAll("-", "_");
			}
			PdfWriter.getInstance(document, new FileOutputStream("C:/SystemBanking/RelatorioContasJuridica_" +
				data + ".pdf"));
			document.open();
			
			Image img = Image.getInstance("src/com/silverlining/system/banking/controller/logoRelatorio.png");
			img.scaleAbsolute(140f, 120f);
			img.setAlignment(Image.ALIGN_CENTER);
			
			PdfPTable table = new PdfPTable(9);
			table.setTotalWidth(600);
			table.setLockedWidth(true);
			PdfPCell header = new PdfPCell(new Paragraph("Relatório de Pessoas Jurídicas"));
			header.setColspan(9);
			table.addCell(header);
			table.addCell("Nome");
			table.addCell("CNPJ");
			table.addCell("Resp.");
			table.addCell("R.social");
			table.addCell("E-mail");
			table.addCell("Logra.");
			table.addCell("Numero");
			table.addCell("Bairro");
			table.addCell("UF");
			String query = "SELECT F.nomeFantasia,P.cpf_cnpj,F.razaoSocial,F.responsavel,P.email,P.logradouro,P.numero,P.bairro,P.cidade,U.sigla "
					+"FROM  Juridica F INNER JOIN Pessoa P ON (F.cnpj=P.cpf_cnpj) "
					+"INNER JOIN UF U on (P.codigoUF=U.codigoUF)";
			Statement st = connection.c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				table.addCell(rs.getString("nomeFantasia"));
				table.addCell(rs.getString("cpf_cnpj"));
				table.addCell(rs.getString("responsavel"));
				table.addCell(rs.getString("razaoSocial"));
				table.addCell(rs.getString("email"));
				table.addCell(rs.getString("logradouro"));
				table.addCell(rs.getString("numero"));
				table.addCell(rs.getString("bairro"));
				table.addCell(rs.getString("sigla"));
			}
			
			Paragraph p = new Paragraph(" ");
			document.add(img);
			document.add(p);
			document.add(table);
			document.close();
			Runtime.getRuntime().exec("cmd /c start C:/SystemBanking/RelatorioContasJuridica_" +
					data + ".pdf");
			connection.disconnect();
			return 1;
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return 0;
		} catch (SQLException e){
			return 0;
		}
	}

}
