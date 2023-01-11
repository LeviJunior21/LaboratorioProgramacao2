package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Texto;

class TestTexto {

	@Test
	void test_cadastraTextoEGeraRepresentacaoCompleta() {
		Texto texto = new Texto("Exemplo de texto", 1);
		assertEquals(texto.gerarRepresentacaoCompleta(), "Exemplo de texto");
	}
	
	@Test
	void test_cadastraTextoEGeraRepresentacaoResumida() {
		Texto texto = new Texto("Exemplo de texto", 1);
		assertEquals(texto.gerarRepresentacaoResumida(), "Exemplo de texto");

	}
	
	@Test 
	void verificaPrioridade() {
		Texto texto = new Texto("Exemplo de texto", 1);
		assertEquals(texto.getPrioridade(), 1);
	}
}
