import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLocal {

	@Test
	void criaUmLocalEVerificaSeEstaCriado() {
		Local local = new Local("CAA", "Exatas", "1010");
		assertEquals(local.toString(), "CAA - Exatas - 1010");
	}
	
	@Test
	void criaUmLocalEVerificaSeONomeEstaIgualAoCadastrado() {
		Local local = new Local("CAA", "Exatas", "1010");
		assertEquals(local.getNome(), "CAA");
	}

	@Test
	void cadastraComitivasComPosicaoValidaNoLimiteInferior() {
		Local local = new Local("CAA", "Exatas", "1010");
		Comitiva comitiva = new Comitiva(1, "BG", 10, "99565678");
		local.cadastraComitiva(comitiva, 0);
	}
	
	@Test
	void cadastraComitivasComPosicaoValidaNoLimiteSuperior() {
		Local local = new Local("CAA", "Exatas", "1010");
		Comitiva comitiva = new Comitiva(1, "BG", 10, "99565678");
		local.cadastraComitiva(comitiva, 99);
	}
	
	@Test
	void cadastraComitivasComPosicaoInValidaAbaixoDoLimiteInferior() {
		Local local = new Local("CAA", "Exatas", "1010");
		Comitiva comitiva = new Comitiva(1, "BG", 10, "99565678");
		try {
			local.cadastraComitiva(comitiva, -1);
		}
		catch (IndexOutOfBoundsException ibe) {
			assertEquals(ibe.getMessage(), "Posição inválida");
		}
	}
	
	@Test
	void cadastraComitivasComPosicaoInValidaAcimaDoLimiteSuperior() {
		Local local = new Local("CAA", "Exatas", "1010");
		Comitiva comitiva = new Comitiva(1, "BG", 10, "99565678");
		try {
			local.cadastraComitiva(comitiva, 100);
		}
		catch (IndexOutOfBoundsException ibe) {
			assertEquals(ibe.getMessage(), "Posição inválida");
		}
	}
	
	 @Test
	  void verificaSeComitivaFoiCadastradaEmLocal() {
		  Local local = new Local("LCC", "UFCG", "1010");
		  Comitiva comitiva = new Comitiva(0, "BG", 10, "Descrição");
		  local.cadastraComitiva(comitiva, 0);
		  assertEquals(local.getComitivas().length, 1);
	  }
	
}
