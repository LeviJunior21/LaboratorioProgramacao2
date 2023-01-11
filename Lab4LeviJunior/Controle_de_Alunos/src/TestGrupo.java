import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestGrupo {

	@Test
	void test_cadastraGrupoIlimitadoComSucesso() {
		new Grupo("UFCG");
	}

	@Test
	void test_cadastraGrupoLiimitadoComSucesso() {
		new Grupo("UFCG", 10);
	}
	
	@Test
	void test_cadastraGrupoIlimitadoComParametroVazio() {
		try {
			new Grupo("");
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "PARÂMETRO VAZIO RECEBIDO!");
		}
	}
	
	@Test
	void test_cadastraGrupoIlimitadoComParametroNull() {
		try {
			new Grupo(null);
		}
		catch(NullPointerException npe) {
			assertEquals(npe.getMessage(), "PARÂMETRO NULL RECEBIDO!");
		}
	}
	
	@Test
	void test_cadastraGrupoLimitadoComParametroVazio() {
		try {
			new Grupo("", 1);
		}
		catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "PARÂMETRO VAZIO RECEBIDO!");
		}
	}
	
	@Test
	void test_cadastraGrupoLimitadoComParametroNull() {
		try {
			new Grupo(null, 1);
		}
		catch(NullPointerException npe) {
			assertEquals(npe.getMessage(), "PARÂMETRO NULL RECEBIDO!");
		}
	}
	
	@Test
	void test_cadastraGrupoLimitadoComTamanhoInvalido() {
		try {
			new Grupo("UFCG", -1);
		}
		catch(IndexOutOfBoundsException ibe) {
			assertEquals(ibe.getMessage(), "TAMANHO DO GRUPO INVÁLIDO!");
		}
	}
	
	@Test
	void test_criaGrupoEVerificaNomeGrupo() {
		Grupo grupo = new Grupo("UFCG");
		assertEquals(grupo.getNome(), "UFCG");
	}
	

	@Test
	void test_criaGrupoEVerificaOResumoDoGrupoDeTamanhoIlimitado() {
		Grupo grupo = new Grupo("UFCG");
		assertEquals(grupo.toString(), "- UFCG 0/Ilimitado");
	}
	
	@Test
	void test_criaGrupoEVerificaOResumoDoGrupoDeTamanhoLimitado() {
		Grupo grupo = new Grupo("UFCG", 1);
		assertEquals(grupo.toString(), "- UFCG 0/1");
	}
	
	@Test
	void test_criaGrupoEVerificaSeAlunoEstaCadastradoGrupoDeTamanhoLimitado() {
		Grupo grupo = new Grupo("UFCG", 1);
		Aluno aluno = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		assertEquals(grupo.cadastraAluno("1111", aluno), "ALUNO ALOCADO!");
		assertEquals(grupo.existeAluno("1111"), true);
	}
	
	@Test
	void test_tentaCadastrarAlunoEmGrupoCheio() {
		Grupo grupo = new Grupo("UASC", 1);
		Aluno aluno1 = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		Aluno aluno2= new Aluno("1112", "Eliane Cristina", "Ciencias da Computacao");
		assertEquals(grupo.cadastraAluno("1111", aluno1), "ALUNO ALOCADO!");
		assertEquals(grupo.cadastraAluno("1112", aluno2), "GRUPO CHEIO!");
	}
	
	@Test
	void test_tentaCadastrarAlunoJaCadastrado() {
		Grupo grupo = new Grupo("UASC", 2);
		Aluno aluno1 = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		assertEquals(grupo.cadastraAluno("1111", aluno1), "ALUNO ALOCADO!");
		assertEquals(grupo.cadastraAluno("1111", aluno1), "ALUNO NÃO CADASTRADO!");
	}
	
	@Test
	void test_verificaCursosCadastradosEmGrupo() {
		Grupo grupo = new Grupo("UFCG", 2);
		Aluno aluno1 = new Aluno("1111", "Matheus Gaudencio", "Ciencias da Computacao");
		Aluno aluno2 = new Aluno("1112", "Eliane Cristina", "Engenharia Mecanica");
		assertEquals(grupo.cadastraAluno("1111", aluno1), "ALUNO ALOCADO!");
		assertEquals(grupo.cadastraAluno("1112", aluno2), "ALUNO ALOCADO!");
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Engenharia Mecanica: 1");
		lista.add("Ciencias da Computacao: 1");
		assertEquals(grupo.cursosCadastrados(), lista);
	}
}