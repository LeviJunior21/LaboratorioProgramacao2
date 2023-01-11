package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Titulo;

class TestTitulo {

	Titulo elemento = new Titulo("Documentos Texto", 1, 1, false);
	
	@Test
	void test_criaTituloNaoLinkavelApartirDaInterfaceEelementoComSucessoEVerificaARepresentacaoCompleta() {
		assertEquals(elemento.gerarRepresentacaoCompleta(), "1. Documentos Texto");
	}
	
	@Test
	void test_criaTituloNaoLinkavelApartirDaInterfaceEelementoComSucessoEVerificaARepresentacaoResumida() {
		assertEquals(elemento.gerarRepresentacaoResumida(), "1. Documentos Texto");
	}

	@Test
	void test_verificaPropriedades() {
		assertEquals(elemento.getPropriedades(), "Documentos Texto\nNível: 1\nLinkável: false\n");
	}
	
	@Test
	void test_gerarRepresentacaoCompletaQuandoNaoLinkavel() {
		assertEquals(elemento.gerarRepresentacaoCompleta(), "1. Documentos Texto");
	}
	
	@Test
	void test_gerarRepresentacaoCompletaQuandoEhLinkavel() {
		Titulo elemento2 = new Titulo("Documentos Texto", 1, 1, true);
		assertEquals(elemento2.gerarRepresentacaoCompleta(), "1. Documentos Texto -- 1-DOCUMENTOSTEXTO");
	}
	
	@Test
	void test_gerarRepresentacaoResumidaQuandoEhLinkavel() {
		Titulo elemento2 = new Titulo("Documentos Texto", 1, 1, true);
		assertEquals(elemento2.gerarRepresentacaoResumida(), "1. Documentos");
	}
	
	@Test
	void test_pegaAPrioridade() {
		assertEquals(elemento.getPrioridade(), 1);
	}

}
