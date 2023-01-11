package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.DocumentoController;

class TestDocumentoController {

	DocumentoController documentoController;
	@BeforeEach
	void criarDocumento() {
		this.documentoController = new DocumentoController();
	}

	@Test
	void cadastraDocumentoComSucessoIlitado() {
		assertEquals(this.documentoController.criarDocumento("Doc"), true);
		assertEquals(this.documentoController.criarDocumento("Doc"), false);
	}
	
	@Test
	void cadastraDocumentoComSucessoLimitado() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarDocumento("Doc", 2), false);
	}
	
	@Test
	void testCriaTituloDocumentoInexistente() {
		try {
			this.documentoController.criarTitulo("receitas", "Machado de Assis", 5, 99, false);
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaTextoDocumentoInexistente() {
		try {
			this.documentoController.criarTexto("Desenhos", "Kung Fu Panda", 4);
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaTermosDocumentoInexistente() {
		try {
			this.documentoController.criarTermos("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM");
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistente() {
		try {
			this.documentoController.criarLista("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}

	@Test
	void testCriaTituloDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.documentoController.criarTitulo("", "Machado de Assis", 5, 99, false);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaTextoDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.documentoController.criarTexto("", "Kung Fu Panda", 4);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaTermosDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.documentoController.criarTermos("", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.documentoController.criarLista("", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistenteComTtituloDocComEspaco() {
		try {
			this.documentoController.criarLista(" ", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoComTituloComEspaco() {
		try {
			this.documentoController.criarDocumento(" ", 2);
		}
		catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING COM APENAS ESPAÇOS!");
		}
	}
	
	@Test
	void testRemoveDocumentoNaoCadastrado() {
		try {
			this.documentoController.removerDocumento("Doc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testRemoveTituloDocumentoNaoCadastrado() {
		try {
			this.documentoController.removerDocumento("Doc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testRemoveTituloDocumentoCadastrado() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		this.documentoController.removerDocumento("Doc");
	}
	
	@Test
	void testCriaAtalhoComTituloVazio() {
		try {
			this.documentoController.criarAtalho("", "Doc");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaAtalhoComDocumentoInexistente() {
		try {
			this.documentoController.criarAtalho("Doc", "OutroDoc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaRepresentacaoCompletaTituloInexistente() {
		try {
			this.documentoController.pegarRepresentacaoCompleta("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaRepresentacaoResumidaTituloInexistente() {
		try {
			this.documentoController.pegarRepresentacaoResumida("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testApagaElementoTituloDocInexistente() {
		try {
			this.documentoController.apagarElemento("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testMoverElementoParaCimaComTituloDocNaoCadastrado() {
		try {
			this.documentoController.moverParaCima("", 1);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testMoverElementoParaBaixoComTituloDocNaoCadastrado() {
		try {
			this.documentoController.moverParaBaixo("", 1);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirDocumentoInexistente() {
		try {
			this.documentoController.exibirDocumento("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void tesContaElementoEmDocumentoInexistente() {
		try {
			this.documentoController.contarElementos("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}

	@Test
	void testExibirVisaoCompletaDocumentoInexistente() {
		try {
			this.documentoController.criarVisaoCompleta("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoResumidaDocumentoInexistente() {
		try {
			this.documentoController.criarVisaoResumida("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoTituloResumidaDocumentoInexistente() {
		try {
			this.documentoController.criarVisaoTitulo("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoPrioritariaDocumentoInexistente() {
		try {
			this.documentoController.criarVisaoPrioritaria("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriarAtalho() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarDocumento("Doc2", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.documentoController.criarAtalho("Doc", "Doc2");
	}
	
	@Test
	void testCriarAtalhoQueDocumentoJaParticipaDeUmOutroAtalho() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarDocumento("Doc2", 2), true);
		assertEquals(this.documentoController.criarDocumento("Doc3", 3), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarAtalho("Doc", "Doc2"), 3);
		
		try {
			this.documentoController.criarAtalho("Doc", "Doc3");
		}
		catch(IllegalStateException ise) {
			assertEquals(ise.getMessage(), "O DOCUMENTO JA TEM UM ATALHO");
		}
	}
	
	@Test
	void testCriaTituloDocumentoComSucesso() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarTitulo("Doc", "Machado de Assis", 5, 99, false), 1);
	}
	
	@Test
	void testCriaTextoDocumentoComSucesso() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarTexto("Doc", "Kung Fu Panda", 4), 1);
	}
	
	@Test
	void testCriaTextoDocumentoComSucessoOutro() {
		assertEquals(this.documentoController.criarDocumento("Doc", 1), true);
		assertEquals(this.documentoController.criarTexto("Doc", "Kung Fu Panda", 4), 1);
	}
	
	@Test
	void testCriaTermosDocumentoComSucesso() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarTermos("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM"), 1);
		
	}
	
	@Test
	void testCriaListaDocumentoComSucesso() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
	}
	
	@Test
	void testCriaRepresentacaoCompletaTituloExistente() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.pegarRepresentacaoCompleta("Doc", 1), "- Termos de compromisso\n- Termos de prioridade");
	}
	
	@Test
	void testCriaRepresentacaoResumidaTituloExistente() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.pegarRepresentacaoResumida("Doc", 1), "Termos de compromisso, Termos de prioridade");
	}
	
	@Test
	void testApagaElementoCriado() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		this.documentoController.apagarElemento("Doc", 1);
	}
	
	@Test
	void testMoverElementoNoDocumentoParaCima() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.documentoController.moverParaCima("Doc", 2);
	}
	
	@Test
	void testMoverElementoNoDocumentoParaBaixo() {
		assertEquals(this.documentoController.criarDocumento("Doc", 2), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.documentoController.moverParaBaixo("Doc", 1);
	}
	
	@Test
	void testContarElementosCadastrados() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.contarElementos("Doc"), 2);
	}
	
	@Test
	void testcadastraVisaoResumida() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarVisaoResumida("Doc"), 1);
	}

	@Test
	void testcadastraVisaoTitulo() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarVisaoTitulo("Doc"), 1);
	}
	
	@Test
	void testcadastraVisaoCompletaPrioritaria() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarVisaoPrioritaria("Doc", 1), 1);
	}
	
	@Test
	void testExibeVisao() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarVisaoCompleta("Doc"), 1);
		assertEquals(Arrays.toString(documentoController.exibirVisao(1)), "[- Termos de compromisso\n- Termos de prioridade, - Termos de compromissos\n- Termos de prioridade]");
	}
	
	@Test
	void testExibeElemento() {
		assertEquals(this.documentoController.criarDocumento("Doc", 4), true);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.documentoController.criarVisaoCompleta("Doc"), 1);
		assertEquals(Arrays.toString(documentoController.exibirDocumento("Doc")), "[- Termos de compromisso\n- Termos de prioridade\n, - Termos de compromissos\n- Termos de prioridade\n]");
	}
}
