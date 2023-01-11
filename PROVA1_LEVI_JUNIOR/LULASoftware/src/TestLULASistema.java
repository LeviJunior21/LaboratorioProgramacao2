import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLULASistema {
  
  LULASistema sistema = new LULASistema();

  @BeforeEach
  void cadastrandoComitiva() {
    sistema.cadastraComitiva(1, "BG", 10, "99565678");
  }
  
  @BeforeEach
  void cadastrandoLocal() {
    sistema.cadastraLocal("CAA", "Exatas", "1010");
  }

  @Test
  void verificaSeCriouUmaComitiva() {
    assertEquals(this.sistema.exibeComitiva(1).toString(), "ID: 1\nComitiva: BG\nIntegrantes: 10\nContato: 99565678");
  }

  @Test
  void cadastraComitivaComPosicaoInvalidaAlemDoLimiteSuperior() {
    try {
      sistema.cadastraComitiva(101, "BG", 10, "Descrição");
    }
    catch (IndexOutOfBoundsException ibe) {
        assertEquals("Posição inválida!", ibe.getMessage());
    }
  }
  
  @Test
  void cadastraComitivaComPosicaoInvalidaAbaixoDoLimiteInferior() {
	  try {
		  sistema.cadastraComitiva(-1, "LCC", 10, "(83) 99999-0000");
	  }
	  catch (IndexOutOfBoundsException ibe) {
		  assertEquals("Posição inválida!", ibe.getMessage());
	  }
  }

  @Test
  void cadastraComitivaComPosicaoValidaNoLimiteInferior() {
	sistema.cadastraComitiva(0, "LCC", 10, "(83) 99999-0000");
	assertEquals(this.sistema.exibeComitiva(0).toString(), "ID: 0\nComitiva: LCC\nIntegrantes: 10\nContato: (83) 99999-0000");
  }

  @Test
  void cadastraComitivaComPosicaoValidaNoLimiteSuperior() {
	sistema.cadastraComitiva(99, "LCC", 10, "(83) 99999-0000");
	assertEquals(this.sistema.exibeComitiva(99).toString(), "ID: 99\nComitiva: LCC\nIntegrantes: 10\nContato: (83) 99999-0000");
  }
  
  @Test
  void cadastraComitivaJaExistente() {
	sistema.cadastraComitiva(99, "LCC", 10, "(83) 99999-0000");
	assertEquals(sistema.cadastraComitiva(99, "LCC", 10, "(83) 99999-0000"), "Esta comitiva já existe!");
  }
  
  @Test
  void cadastraLocalJaExistente() {
	sistema.cadastraLocal("LCC", "UFCG", "1010");
	assertEquals(sistema.cadastraLocal("LCC", "UFCG", "1010"), "Este local já existe!");
  }
  
  @Test
  void cadastraComitivaEVerificaSeOutraNaoExiste() {
	sistema.cadastraComitiva(99, "LCC", 10, "(83) 99999-0000");
	assertEquals(this.sistema.exibeComitiva(2), "Esta comitiva não existe!");
  }
  
  @Test
  void verificaSeLocalEstaCadastrado() {
	  assertEquals(this.sistema.exibeLocal("CAA"), "CAA - Exatas - 1010");
  }
  
  @Test
  void verificaSeLocalNaoEstaCadastrado() {
	  assertEquals(this.sistema.exibeLocal("BG"), "O local BG não foi encontrado!");
  }
  
  @Test
  void verificaSeComitivaFoiCadastradaEmLocalComPosicaoInvalidaInferior() {
	  LULASistema sis = new LULASistema();
	  sistema.cadastraLocal("LCC", "UFCG", "1010");
	  sistema.cadastraComitiva(0, "BG", 10, "Descrição");
	  sis.cadastraComitivaEmLocal("LCC", 0);
	  assertEquals(sis.cadastraComitivaEmLocal("LCC", -1), "Posição inválida!");
	  
  }
  
  @Test
  void verificaSeComitivaFoiCadastradaEmLocalComPosicaoInvalidaSuperior() {
	  LULASistema sis = new LULASistema();
	  sistema.cadastraLocal("LCC", "UFCG", "1010");
	  sistema.cadastraComitiva(0, "BG", 10, "Descrição");
	  sis.cadastraComitivaEmLocal("LCC", 0);
	  assertEquals(sis.cadastraComitivaEmLocal("LCC", 100), "Posição inválida!");
	  
  }
 
}