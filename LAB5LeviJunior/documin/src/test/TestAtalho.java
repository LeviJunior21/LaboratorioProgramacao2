package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Atalho;

class TestAtalho {

	Atalho atalho;
	@BeforeEach
	void test_criaAtalaho() {
		atalho = new Atalho("Atalho", 4, "Representacao completa", "Representacao Resumida");	
	}
	
	@Test
	void test_metodosAtalho() {
		assertEquals(atalho.gerarRepresentacaoCompleta(), "Representacao completa");
		assertEquals(atalho.gerarRepresentacaoResumida(), "Representacao Resumida");
		assertEquals(atalho.getPrioridade(), 4);
	}
}
