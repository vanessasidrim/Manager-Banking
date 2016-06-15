package com.silverlining.system.banking.util;

import junit.framework.TestCase;

public class RelatorioTest extends TestCase {
	
	public void testGerar_relatorio_conta_poupanca(){
		Relatorio r = new Relatorio();
		int retornoEsperado = 1;
		int retornoFeito = r.gerar_relatorio_conta_poupanca();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testGerar_relatorio_conta_corrente(){
		Relatorio r = new Relatorio();
		int retornoEsperado = 1;
		int retornoFeito = r.gerar_relatorio_conta_corrente();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testGerar_relatorio_pessoa_fisica(){
		Relatorio r = new Relatorio();
		int retornoEsperado = 1;
		int retornoFeito = r.gerar_relatorio_pessoa_fisica();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testGerar_relatorio_pessoa_juridica(){
		Relatorio r = new Relatorio();
		int retornoEsperado = 1;
		int retornoFeito = r.gerar_relatorio_pessoa_juridica();
		
		assertEquals(retornoEsperado, retornoFeito);
	}

}
