package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.DocumentoSistema;

class TestDocumentoSistema {

	DocumentoSistema sistema;
	DocumentoSistema sistema2;
	
	@BeforeEach
	void test_InicializaDocumentos() {
		 sistema =  new DocumentoSistema("Documentario");
		 sistema2 = new DocumentoSistema("Documentario", 1);
	}
	
	@Test
	void test_cadastraTextoComSucessoEVerificaOIndiceDeRetorno() {
		assertEquals(sistema.criarTexto("Documento", 1), 1);		
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoIndifinidoComTituloVazio() {
		try {
			new DocumentoSistema("");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING VAZIA!");
		}
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoIndifinidoComTituloNull() {
		try {
			new DocumentoSistema(null);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING NULL!");
		}
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoIndifinidoComTituloComApenasEspacos() {
		try {
			new DocumentoSistema(" ");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING COM APENAS ESPAÇOS!");
		}
	}
	

	@Test
	void test_cadastraDocumentoDeTamanhoInvalido() {
		try {
			new DocumentoSistema("Documentario", -1);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "TAMANHO INVÁLIDO");
		}
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoDedifinidoComTituloVazio() {
		try {
			new DocumentoSistema("", 1);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING VAZIA!");
		}
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoDedifinidoComTituloNull() {
		try {
			new DocumentoSistema(null, 1);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING NULL!");
		}
	}
	
	@Test
	void test_cadastraDocumentoDeTamanhoDefinidoComTituloComApenasEspacos() {
		try {
			new DocumentoSistema(" ", 1);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING COM APENAS ESPAÇOS!");
		}
	}
	
	@Test
	void test_cadastraDocumentoComUmEspacoEVerificaSeEstaCheioEVerificaTituloDoDcumento() {
		assertEquals(sistema2.getTitulo(), "Documentario");
		assertEquals(sistema2.criarTexto("Documento", 1), 1);
		assertEquals(sistema2.criarTexto("Documento2", 1), -1);
	}
	
	@Test
	void test_criaTituloLinkavelComSucesso() {
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "1. Documentos Texto -- 1-DOCUMENTOSTEXTO");
		assertEquals(sistema.pegarRepresentacaoResumida(1), "1. Documentos");
	}
	
	@Test
	void test_criaTituloLinkavelComSucessoESemEspaco() {
		assertEquals(sistema2.criarTitulo("Documentos Texto", 1, 1, true), 1);
		assertEquals(sistema2.criarTitulo("Documentos Texto", 1, 1, true), -1);
	}
	
	@Test
	void test_criaTituloNaoLinkavelComSucesso() {
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, false), 1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "1. Documentos Texto");
		assertEquals(sistema.pegarRepresentacaoResumida(1), "1. Documentos Texto");
	}
	
	@Test
	void test_criaTituloNaoLinkavelComSucessoESemEspaco() {
		assertEquals(sistema2.criarTitulo("Documentos Texto", 1, 1, false), 1);
		assertEquals(sistema2.criarTitulo("Documentos Texto", 1, 1, false), -1);
	}
	
	@Test
	void test_criaListaComSucesso() {
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 1, "|", "-"), 1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "- Exemplo\n- de uma lista\n- de 3 termos");
		assertEquals(sistema.pegarRepresentacaoResumida(1), "Exemplo, de uma lista, de 3 termos");
	}
	
	@Test
	void test_criaListaComSucessoESemEspaco() {
		assertEquals(sistema2.criarLista("Exemplo | de uma lista | de 3 termos", 1, "|", "-"), 1);
		assertEquals(sistema2.criarLista("Lista Texto", 1, "|", "-"), -1);
	}
	
	@Test
	void test_criaTermoComSucesso() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Total termos: 3\n- Teste, termos, Aleatórios");
		assertEquals(sistema.pegarRepresentacaoResumida(1), "Teste / termos / Aleatórios");
	}
	
	@Test
	void test_criaTermoComSucessoESemEspaco() {
		assertEquals(sistema2.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema2.criarTermos("Teste / termos", 1, "/", "NENHUM"), -1);
	}
	
	@Test
	void test_apagarElementoEContaElementos() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarTermos("Teste / termos ", 1, "/", "NENHUM"), 2);
		assertEquals(sistema.criarTermos("Teste", 1, "/", "NENHUM"), 3);
		sistema.apagarElemento(1);
		assertEquals(sistema.contarElementos(), 2);
	}
	
	@Test
	void test_moveElementoParaBaixo() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarTermos("Teste / termos ", 1, "/", "NENHUM"), 2);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Total termos: 3\n- Teste, termos, Aleatórios");
		assertEquals(sistema.pegarRepresentacaoCompleta(2), "Total termos: 2\n- Teste, termos");
		sistema.moverParaBaixo(1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Total termos: 2\n- Teste, termos");
		assertEquals(sistema.pegarRepresentacaoCompleta(2), "Total termos: 3\n- Teste, termos, Aleatórios");	
	}
	
	@Test
	void test_moveElementoParaCima() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarTermos("Teste / termos ", 1, "/", "NENHUM"), 2);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Total termos: 3\n- Teste, termos, Aleatórios");
		assertEquals(sistema.pegarRepresentacaoCompleta(2), "Total termos: 2\n- Teste, termos");
		sistema.moverParaCima(2);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Total termos: 2\n- Teste, termos");
		assertEquals(sistema.pegarRepresentacaoCompleta(2), "Total termos: 3\n- Teste, termos, Aleatórios");	
	}

	@Test 
	void test_calculaMediaElementos() {
		assertEquals(Double.toString(sistema.calculaMedia()), "0.0");
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarTermos("Teste / termos ", 3, "/", "NENHUM"), 2);
		assertEquals(Double.toString(sistema.calculaMedia()), "2.0");
	}

	@Test
	void criaAtalhoEVerificaSeODocumentoTemAtalho() {
		assertEquals(sistema.temAtalho(), false);
		assertEquals(sistema.criarAtalho(null, 0, null, null), 1);
		assertEquals(sistema.temAtalho(), true);
	}
	
	@Test
	void criaAtalhoSemEspacoNoDocumento() {
		assertEquals(sistema2.criarAtalho(null, 0, null, null), 1);
		assertEquals(sistema2.criarAtalho(null, 0, null, null), -1);
	}
	
	@Test
	void test_exibirDocumento() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 1, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 1), 5);
		assertEquals(Arrays.toString(sistema.exibirDocumento()), "[Total termos: 3\n- Teste, termos, Aleatórios\n\n, - Exemplo\n- de uma lista\n- de 3 termos\n\n, 1. Documentos Texto -- 1-DOCUMENTOSTEXTO\n\n, 1. Documentos Texto\n\n, Documento\n\n]");
	}
	
	@Test
	void test_exibirRepresentacoesCompletas() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 4, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 1, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 4, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 1), 5);
		assertEquals(Arrays.toString(sistema.getRepresentacoesCompletas()), "[Total termos: 3\n- Teste, termos, Aleatórios\n, 1. Documentos Texto -- 1-DOCUMENTOSTEXTO\n]");
	}
	
	@Test
	void test_exibirRepresentacoesResumidas() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 4, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 4, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 4), 5);
		assertEquals(Arrays.toString(sistema.getRepresentacoesResumidas()), "[Teste / termos / Aleatórios\n, Exemplo, de uma lista, de 3 termos\n, 1. Documentos\n, 1. Documentos Texto\n, Documento\n]");
	}
	
	@Test
	void test_criarAtalhoComSucessoEVerificaSeusMetodos() {
		assertEquals(sistema.criarAtalho("Outro documento", 1, "Representacao Completa", "Representacao Resumida"), 1);
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Representacao Completa");
		assertEquals(sistema.pegarRepresentacaoResumida(1), "Representacao Resumida");
	}

	@Test
	void test_tentaPegarRepresentacaoCompletaElementoInexistente() {
		assertEquals(sistema.pegarRepresentacaoCompleta(1), "Posição inválida.");
	}
	
	@Test
	void test_tentaPegarRepresentacaoResumidaElementoInexistente() {
		assertEquals(sistema.pegarRepresentacaoResumida(1), "Posição inválida.");
	}
	
	@Test
	void moverParaCimaComElementoInexistente() {
		try {
			sistema.moverParaCima(10);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "Elemento não encontrado nesta posição.");
		}
	}
	
	@Test
	void moverParaBaixoComElementoInexistente() {
		try {
			sistema.moverParaBaixo(10);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "Elemento não encontrado nesta posição.");
		}
	}
	
	@Test
	void test_exibirVisaoCompleta() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 4, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 4, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 4), 5);
		assertEquals(Arrays.toString(sistema.getVisaoCompleta()), "[Total termos: 3\n- Teste, termos, Aleatórios, - Exemplo\n- de uma lista\n- de 3 termos, 1. Documentos Texto -- 1-DOCUMENTOSTEXTO, 1. Documentos Texto, Documento]");
	}
	
	@Test
	void test_exibirVisaoResumida() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 4, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 4, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 4), 5);
		assertEquals(Arrays.toString(sistema.getVisaoResumida()), "[Teste / termos / Aleatórios, Exemplo, de uma lista, de 3 termos, 1. Documentos, 1. Documentos Texto, Documento]");
	}
	
	@Test
	void test_exibirVisaoPrioridade() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 4, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto", 4, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 4), 5);
		assertEquals(Arrays.toString(sistema.getVisaoPrioridade(4)), "[- Exemplo\n- de uma lista\n- de 3 termos, 1. Documentos Texto, Documento]");
	}

	@Test
	void test_exibirVisaoTitulo() {
		assertEquals(sistema.criarTermos("Teste / termos / Aleatórios ", 1, "/", "NENHUM"), 1);
		assertEquals(sistema.criarLista("Exemplo | de uma lista | de 3 termos", 4, "|", "-"), 2);
		assertEquals(sistema.criarTitulo("Documentos Texto", 1, 1, true), 3);
		assertEquals(sistema.criarTitulo("Documentos Texto2", 4, 1, false), 4);
		assertEquals(sistema.criarTexto("Documento", 4), 5);
		assertEquals(Arrays.toString(sistema.getVisaoTitulo()), "[1. Documentos, 1. Documentos Texto2]");
	}

}
