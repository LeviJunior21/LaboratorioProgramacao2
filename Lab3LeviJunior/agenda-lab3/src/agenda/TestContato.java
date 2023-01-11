package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestContato {

	private Contato contato;

	@BeforeEach
	void test_cadastraContato() {
		this.contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
	}
	
	@Test
	void test_pegaONomeDoContato() {
		assertEquals(this.contato.getNome(), "Matheus");
	}
	
	@Test
	void test_pegaOSobrenomeDoContato() {
		assertEquals(this.contato.getSobrenome(), "Gaudencio");
	}
	
	@Test
	void test_pegaOTelefoneDoContato() {
		assertEquals(this.contato.getTelefone(), "(83) 99999-0000");
	}
	
	@Test
	void test_pegaONomeCompleto() {
		assertEquals(this.contato.getNomeCompleto(), "Matheus Gaudencio");
	}
	
	@Test
	void test_aleteraNumeroSendoEleInvalido() {
		try {
		this.contato.setTelefone(null);
		}
		catch (NullPointerException npe) {
			assertEquals("TELEFONE INVÁLIDO!", npe.getMessage());
			assertEquals(this.contato.getTelefone(), "(83) 99999-0000");
		}
	}
}
