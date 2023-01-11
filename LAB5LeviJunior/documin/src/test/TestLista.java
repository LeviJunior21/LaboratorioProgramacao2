package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Lista;

class TestLista {

	@Test
	void test_criarListaComSucessoEVerificaRepresentacaoCompleta() {
		Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
		assertEquals(lista.gerarRepresentacaoCompleta(), "- Exemplo\n- de uma lista\n- de 3 termos");
	}
	
	@Test
	void test_criarListaComSucessoEVerificaRepresentacaoResumida() {
		Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
		assertEquals(lista.gerarRepresentacaoResumida(), "Exemplo, de uma lista, de 3 termos");
	}

	@Test
	void test_verificaPrioridade() {
		Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
		assertEquals(lista.getPrioridade(), 1);
	}
}
