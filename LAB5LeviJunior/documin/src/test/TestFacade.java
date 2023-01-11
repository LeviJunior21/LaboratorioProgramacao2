package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Facade;

class TestFacade {

	Facade facade;
	@BeforeEach
	void InicializaFacade() {
		this.facade = new Facade();
	}
	
	@Test
	void cadastraDocumentoComSucessoIlitado() {
		assertEquals(this.facade.criarDocumento("Doc"), true);
		assertEquals(this.facade.criarDocumento("Doc"), false);
	}
	
	@Test
	void cadastraDocumentoComSucessoLimitado() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarDocumento("Doc", 2), false);
	}
	
	@Test
	void testCriaTituloDocumentoInexistente() {
		try {
			this.facade.criarTitulo("receitas", "Machado de Assis", 5, 99, false);
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaTextoDocumentoInexistente() {
		try {
			this.facade.criarTexto("Desenhos", "Kung Fu Panda", 4);
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaTermosDocumentoInexistente() {
		try {
			this.facade.criarTermos("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM");
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistente() {
		try {
			this.facade.criarLista("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}

	@Test
	void testCriaTituloDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.facade.criarTitulo("", "Machado de Assis", 5, 99, false);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaTextoDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.facade.criarTexto("", "Kung Fu Panda", 4);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaTermosDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.facade.criarTermos("", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistenteComTtituloDocVazia() {
		try {
			this.facade.criarLista("", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoInexistenteComTtituloDocComEspaco() {
		try {
			this.facade.criarLista(" ", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaListaDocumentoComTituloComEspaco() {
		try {
			this.facade.criarDocumento(" ", 2);
		}
		catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "ERRO: STRING COM APENAS ESPAÇOS!");
		}
	}
	
	@Test
	void testRemoveDocumentoNaoCadastrado() {
		try {
			this.facade.removerDocumento("Doc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testRemoveTituloDocumentoNaoCadastrado() {
		try {
			this.facade.removerDocumento("Doc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testRemoveTituloDocumentoCadastrado() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		this.facade.removerDocumento("Doc");
	}
	
	@Test
	void testCriaAtalhoComTituloVazio() {
		try {
			this.facade.criarAtalho("", "Doc");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "CONTEM CARACTERE(S) INVALIDO!");
		}
	}
	
	@Test
	void testCriaAtalhoComDocumentoInexistente() {
		try {
			this.facade.criarAtalho("Doc", "OutroDoc");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaRepresentacaoCompletaTituloInexistente() {
		try {
			this.facade.pegarRepresentacaoCompleta("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriaRepresentacaoResumidaTituloInexistente() {
		try {
			this.facade.pegarRepresentacaoResumida("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testApagaElementoTituloDocInexistente() {
		try {
			this.facade.apagarElemento("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testMoverElementoParaCimaComTituloDocNaoCadastrado() {
		try {
			this.facade.moverParaCima("", 1);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testMoverElementoParaBaixoComTituloDocNaoCadastrado() {
		try {
			this.facade.moverParaBaixo("", 1);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirDocumentoInexistente() {
		try {
			this.facade.exibirDocumento("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void tesContaElementoEmDocumentoInexistente() {
		try {
			this.facade.contarElementos("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}

	@Test
	void testExibirVisaoCompletaDocumentoInexistente() {
		try {
			this.facade.criarVisaoCompleta("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoResumidaDocumentoInexistente() {
		try {
			this.facade.criarVisaoResumida("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoTituloResumidaDocumentoInexistente() {
		try {
			this.facade.criarVisaoTitulo("");
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testExibirVisaoPrioritariaDocumentoInexistente() {
		try {
			this.facade.criarVisaoPrioritaria("", 0);
		}
		catch(NoSuchElementException nse) {
			assertEquals(nse.getMessage(), "DOCUMENTO NAO ENCONTRADO!");
		}
	}
	
	@Test
	void testCriarAtalho() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarDocumento("Doc2", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.facade.criarAtalho("Doc", "Doc2");
	}
	
	@Test
	void testCriarAtalhoQueDocumentoJaParticipaDeUmOutroAtalho() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarDocumento("Doc2", 2), true);
		assertEquals(this.facade.criarDocumento("Doc3", 3), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarAtalho("Doc", "Doc2"), 3);
		
		try {
			this.facade.criarAtalho("Doc", "Doc3");
		}
		catch(IllegalStateException ise) {
			assertEquals(ise.getMessage(), "O DOCUMENTO JA TEM UM ATALHO");
		}
	}
	
	@Test
	void testCriaTituloDocumentoComSucesso() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarTitulo("Doc", "Machado de Assis", 5, 99, false), 1);
	}
	
	@Test
	void testCriaTextoDocumentoComSucesso() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarTexto("Doc", "Kung Fu Panda", 4), 1);
	}
	
	@Test
	void testCriaTextoDocumentoComSucessoOutro() {
		assertEquals(this.facade.criarDocumento("Doc", 1), true);
		assertEquals(this.facade.criarTexto("Doc", "Kung Fu Panda", 4), 1);
	}
	
	@Test
	void testCriaTermosDocumentoComSucesso() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarTermos("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM"), 1);
		
	}
	
	@Test
	void testCriaListaDocumentoComSucesso() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
	}
	
	@Test
	void testCriaRepresentacaoCompletaTituloExistente() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.pegarRepresentacaoCompleta("Doc", 1), "- Termos de compromisso\n- Termos de prioridade");
	}
	
	@Test
	void testCriaRepresentacaoResumidaTituloExistente() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.pegarRepresentacaoResumida("Doc", 1), "Termos de compromisso, Termos de prioridade");
	}
	
	@Test
	void testApagaElementoCriado() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		this.facade.apagarElemento("Doc", 1);
	}
	
	@Test
	void testMoverElementoNoDocumentoParaCima() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.facade.moverParaCima("Doc", 2);
	}
	
	@Test
	void testMoverElementoNoDocumentoParaBaixo() {
		assertEquals(this.facade.criarDocumento("Doc", 2), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		this.facade.moverParaBaixo("Doc", 1);
	}
	
	@Test
	void testContarElementosCadastrados() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.contarElementos("Doc"), 2);
	}
	
	@Test
	void testcadastraVisaoResumida() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarVisaoResumida("Doc"), 1);
	}

	@Test
	void testcadastraVisaoTitulo() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarVisaoTitulo("Doc"), 1);
	}
	
	@Test
	void testcadastraVisaoCompletaPrioritaria() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarVisaoPrioritaria("Doc", 1), 1);
	}
	
	@Test
	void testExibeVisao() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarVisaoCompleta("Doc"), 1);
		assertEquals(Arrays.toString(facade.exibirVisao(1)), "[- Termos de compromisso\n- Termos de prioridade, - Termos de compromissos\n- Termos de prioridade]");
	}
	
	@Test
	void testExibeElemento() {
		assertEquals(this.facade.criarDocumento("Doc", 4), true);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4 , "|", "-"), 1);
		assertEquals(this.facade.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4 , "|", "-"), 2);
		assertEquals(this.facade.criarVisaoCompleta("Doc"), 1);
		assertEquals(Arrays.toString(facade.exibirDocumento("Doc")), "[- Termos de compromisso\n- Termos de prioridade\n, - Termos de compromissos\n- Termos de prioridade\n]");
	}
}
