package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Termo;

class TestTermos {

	Termo termo = new Termo("Teste / termos / Aleatórios", 1 , "/", "ALFABÉTICA");
	Termo termo2 = new Termo("Teste / termos / Aleatórios", 1 , "/", "NENHUM");
	Termo termo3 = new Termo("Teste / termos / Aleatórios", 1 , "/", "ALFABÉTICA");

	@Test
	void test_cadastraTermoComSucessoEGeraRepresentacaoCompleta1() {
		assertEquals(termo.gerarRepresentacaoCompleta(), "Total termos: 3\n- Aleatórios, Teste, termos");
	}
	
	@Test
	void test_cadatraTermoComSucessoEGerarRepresentacaoResumida1() {
		assertEquals(termo.gerarRepresentacaoResumida(), "Aleatórios / Teste / termos");
	}
	
	@Test
	void test_cadastraTermoComSucessoEGeraRepresentacaoCompleta2() {
		assertEquals(termo2.gerarRepresentacaoCompleta(), "Total termos: 3\n- Teste, termos, Aleatórios");
	}
	
	@Test
	void test_cadatraTermoComSucessoEGerarRepresentacaoResumida2() {
		assertEquals(termo2.gerarRepresentacaoResumida(), "Teste / termos / Aleatórios");
	}
	
	@Test
	void test_cadastraTermoComSucessoEGeraRepresentacaoCompleta3() {
		assertEquals(termo3.gerarRepresentacaoCompleta(), "Total termos: 3\n- Aleatórios, Teste, termos");
	}
	
	@Test
	void test_cadatraTermoComSucessoEGerarRepresentacaoResumida3() {
		assertEquals(termo3.gerarRepresentacaoResumida(), "Aleatórios / Teste / termos");
	} 
	
	@Test
	void test_verificarPrioridadeDoTermo() {
		assertEquals(termo.getPrioridade(), 1);
	}

}
