import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestComitiva {

  @Test
  void cadastrandoComitivas() {
    Comitiva comitiva = new Comitiva(1, "BG", 10, "99565678");
    assertEquals(comitiva.toString(), "ID: 1\nComitiva: BG\nIntegrantes: 10\nContato: 99565678");
  }
  
  @Test
  void cadastrandoComitivasComOLimiteInferior() {
    Comitiva comitiva = new Comitiva(0, "CAA", 10, "99565678");
    assertEquals(comitiva.toString(), "ID: 0\nComitiva: CAA\nIntegrantes: 10\nContato: 99565678");
  }
  
  @Test
  void cadastrandoComitivasComOLimiteSuperior() {
    Comitiva comitiva = new Comitiva(99, "CAA", 10, "99565678");
    assertEquals(comitiva.toString(), "ID: 99\nComitiva: CAA\nIntegrantes: 10\nContato: 99565678");
  }	
  
  @Test
  void cadastrandoComitivasComOLimiteAbaixoDoInferior() {
	 try {
		 new Comitiva(-1, "CAA", 10, "99565678");
	 }
	 catch (IndexOutOfBoundsException ibe) {
		 assertEquals(ibe.getMessage(), "Posição inválida!");
	 }
  }	
  
  @Test
  void cadastrandoComitivasComOLimiteAcimaDoSuperior() {
	 try {
		 new Comitiva(100, "CAA", 10, "99565678");
	 }
	 catch (IndexOutOfBoundsException ibe) {
		 assertEquals(ibe.getMessage(), "Posição inválida!");
	 }
  }	
}