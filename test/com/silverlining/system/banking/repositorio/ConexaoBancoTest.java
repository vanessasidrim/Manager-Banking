package com.silverlining.system.banking.repositorio;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;

public class ConexaoBancoTest extends TestCase{
    
	public void testConnect(){
		ConexaoBanco c = new ConexaoBanco();
		boolean retornoEsperado = true;
		boolean retornoFeito = c.connect();
		
		assertEquals(retornoEsperado, retornoFeito);
		
	}
	
	public void testDisconnect(){
		ConexaoBanco c = new ConexaoBanco();
		boolean retornoEsperado = true;
		boolean retornoFeito = c.connect();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testEditar_excluir(){
		ConexaoBanco c = new ConexaoBanco();
		c.connect();
		int retornoEsperado = -1;
		int retornoFeito = c.editar_excluir("DELETE FROM Fisica WHERE cpf=777");
		c.disconnect();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testInserir(){
		ConexaoBanco c = new ConexaoBanco();
		c.connect();
		int retornoEsperado = -1;
		int retornoFeito = c.editar_excluir("INSERT");
		
		c.disconnect();
		
		assertEquals(retornoEsperado, retornoFeito);
	}
	
	public void testIdTabelas(){
		
	}
    
}
