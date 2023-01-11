import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAluno {

	@Test
	void test_criaAlunoComSucesso() {
		new Aluno("1111","Matheus Gaudencio", "Ciencias da Computacao");
	}
	
	@Test
	void test_cadastraAlunoComParametroVazio() {
		try {
			new Aluno("1111","", "Ciencias da Computacao");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "PARÂMETRO VAZIO RECEBIDO!");
		}
	}
	
	@Test
	void test_cadastraAlunoComParametroNull() {
		try {
			new Aluno("1111", null, "Ciencias da Computacao");
		}
		catch(NullPointerException npe) {
			assertEquals(npe.getMessage(), "PARÂMETRO NULL RECEBIDO!");
		}
	}

	@Test
	void test_cadastraAlunoEVerificaSuasInformacoes() {
		Aluno aluno = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		assertEquals(aluno.toString(), "Aluno: 1111 - Matheus Gaudencio - Ciencias da Computacao");
	}
	
	@Test
	void test_cadastraAlunoEVerificaSeuCurso() {
		Aluno aluno = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		assertEquals(aluno.getCurso(), "Ciencias da Computacao");
	}
	
}
