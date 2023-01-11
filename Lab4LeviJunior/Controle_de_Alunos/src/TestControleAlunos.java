import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestControleAlunos {

	ControleAlunos controle = new ControleAlunos();
	@BeforeEach
	void adicionaAlunosSemErros() {
		assertEquals(controle.cadastraAluno("250", "Gabriel Reyes", "Computação"), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraAluno("200", "Lili Camposh", "Computação"), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraAluno("202", "Angela Ziegler", "Medicina"), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica"), "CADASTRO REALIZADO!");
	}
	
	@Test
	void test_AdicionaGrupoIlimitadoSemRestricao() {
		assertEquals(controle.cadastraGrupo("Programação OO"), "CADASTRO REALIZADO!");
	}
	
	@Test
	void test_AdicionaGrupoComTamanhoSemRestricao() {
		assertEquals(controle.cadastraGrupo("Programação", 2), "CADASTRO REALIZADO!");
	}
	
	@Test
	void test_CadastraGrupoComNomeExistente() {
		assertEquals(controle.cadastraGrupo("Programação", 2), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("Programação"), "GRUPO JÁ CADASTRADO!");
	}
	
	@Test
	void test_AlocarAlunoAUmGrupo() {
		assertEquals(controle.cadastraGrupo("Programação OO"), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("200", "Programação OO"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("202", "Programação OO"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("200", "Programação OO"), "ALUNO NÃO CADASTRADO!");
	}

	@Test
	void test_AlocarAlunoQueNaoExiste() {
		assertEquals(controle.cadastraGrupo("Programação OO"), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("210", "Programação OO"), "ALUNO NÃO CADASTRADO!");
	}
	
	@Test
	void test_AlocarAlunoEmGrupoNaoCadastrado() {
		assertEquals(controle.cadastraGrupo("Programação OO"), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("200", "Programação"), "GRUPO NÃO CADASTRADO!");
	}	
	
	@Test
	void test_AlocarAlunoEmGrupoComRestricaoDeTamanho1() {
		assertEquals(controle.cadastraGrupo("Listas", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "Listas"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("202", "Listas"), "GRUPO CHEIO!");
	}	

	@Test
	void test_VerificarPertinenciaEmGrupoCadastrado() {
		assertEquals(controle.cadastraGrupo("Listas", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "Listas"), "ALUNO ALOCADO!");
		assertEquals(controle.verificarPertinencia("250", "Listas"), "ALUNO PERTENCE AO GRUPO!");
		assertEquals(controle.verificarPertinencia("202", "Listas"), "ALUNO NÃO PERTENCE AO GRUPO!");
	} 
	
	@Test
	void test_VerificarPertinenciaEmGrupoNaoCadastrado() {
		assertEquals(controle.verificarPertinencia("202", "Listas"), "GRUPO NÃO CADASTRADO!");
	} 
	
	@Test
	void test_VerificarPertinenciaDeAlunoNaoCadastrado() {
		assertEquals(controle.cadastraGrupo("Programação OO"), "CADASTRO REALIZADO!");
		assertEquals(controle.verificarPertinencia("100", "Programação OO"), "ALUNO NÃO CADASTRADO!");
	} 
	
	@Test
	void test_ExibeGrupoAlunosSemGrupo() {
		ArrayList<String> teste = new ArrayList<>();
		assertEquals(controle.listarGruposAluno("202"), teste);
	} 
	
	@Test
	void test_ExibeGruposEmAlunosEmGrupo() {
		assertEquals(controle.cadastraGrupo("Programação OO", 10), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("Listas", 10), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "Listas"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "Programação OO"), "ALUNO ALOCADO!");
		ArrayList<String> teste = new ArrayList<>();
		teste.add("- Programação OO 1/10");
		teste.add("- Listas 1/10");
		assertEquals(controle.listarGruposAluno("250"), teste);
	}
	
	@Test
	void test_ExibeGruposEmAlunosEmGrupoLimitado() {
		assertEquals(controle.cadastraGrupo("Programação OO", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("Listas", 10), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("200", "Listas"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "Programação OO"), "ALUNO ALOCADO!");
		ArrayList<String> teste = new ArrayList<>();
		teste.add("- Programação OO 1/1");
		assertEquals(controle.listarGruposAluno("250"), teste);
	}
	
	
	@Test
	void test_AdicionaAlunoJaCadastrado() {
		assertEquals(controle.cadastraAluno("250", "Gabriel Reyes", "Computação"), "MATRÍCULA JÁ CADASTRADA!");
	}
	
	@Test
	void test_CadastraGrupoSemTamanhoComNomeVazio() {
		assertEquals(controle.cadastraGrupo(""), "PARÂMETRO VAZIO RECEBIDO!");
	}
	
	@Test
	void test_CadastraGrupoSemTamanhoComNomeNull() {
			assertEquals(controle.cadastraGrupo(null), "PARÂMETRO NULL RECEBIDO!");
	}
	
	@Test
	void test_CadastraGrupoComTamanhoENomeVazio() {
			assertEquals(controle.cadastraGrupo("", 1), "PARÂMETRO VAZIO RECEBIDO!");
	}
	
	@Test
	void test_CadastraGrupoComTamanhoComNomeNull() {
		assertEquals(controle.cadastraGrupo(null, 1), "PARÂMETRO NULL RECEBIDO!");
	}
	
	@Test
	void test_CadastraGrupoComTamanhoComTamanhoInvalido() {
		try {
			controle.cadastraGrupo("Listas", -1);
		}
		catch(IndexOutOfBoundsException ibe) {
			assertEquals(ibe.getMessage(), "TAMANHO DO GRUPO INVÁLIDO!");
		}
	}
	
	@Test
	void test_ExibeAluno() {
		assertEquals(controle.exibirAluno("250"), "Aluno: 250 - Gabriel Reyes - Computação");
	}

	@Test
	void test_CadastraAlunoComNomeVazio() {
		assertEquals(controle.cadastraAluno("", "", ""), "PARÂMETRO VAZIO RECEBIDO!");
	}
	
	@Test
	void test_CadastraAlunoComNomeNull() {
		assertEquals(controle.cadastraAluno(null, "", ""), "PARÂMETRO NULL RECEBIDO!");	
	}
	
	@Test
	void verificaSeExisteAluno() {
		assertEquals(controle.exibirAluno("1010"), "ALUNO NÃO CADASTRADO!");
	}
	
	@Test
	void cadastraGrupuJaCadastrado() { 
		assertEquals(controle.cadastraGrupo("G1", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("G1", 1), "GRUPO JÁ CADASTRADO!");
	}
	
	@Test
	void verificaSeAlunoNaoEstaCadastradoEmGrupo() { 
		assertEquals(controle.cadastraGrupo("G1", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.participaGrupo("250", "G1"), false);
	}
	
	@Test
	void verificaSeAlunoEstaCadastradoEmGrupo() { 
		assertEquals(controle.cadastraGrupo("G1", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "G1"), "ALUNO ALOCADO!");
		assertEquals(controle.participaGrupo("G1", "250"), true);
	}
	
	@Test
	void tentaVerificarSeAlunoNaoExistenteNaoEstaParticipandoDoGrupo() { 
		assertEquals(controle.cadastraGrupo("G1", 1), "CADASTRO REALIZADO!");
		assertEquals(controle.participaGrupo("G1", "250"), false);
	}
	
	@Test
	void adicionaRespostaAlunoExistente() {
		assertEquals(controle.registraRespostaAluno("250"), true);
	}
	
	@Test
	void adicionaRespostaAlunoNaoExistente() {
		assertEquals(controle.registraRespostaAluno("400"), false);
	}
	
	@Test
	void imprimeRespostaCadastradasVazia() {
		assertEquals(controle.imprimeTodasRespostas(), "");
	}
	
	@Test
	void imprimeRespostaCadastradasExistentes() {
		assertEquals(controle.registraRespostaAluno("250"), true);
		assertEquals(controle.imprimeTodasRespostas(), "1. Aluno: 250 - Gabriel Reyes - Computação\n");
	}
	
	@Test
	void verificaEstatisticaDeDoisGruposSendoUmGrupoComUmAluno() {	
		assertEquals(controle.cadastraGrupo("UFCG"), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("UASC"), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "UFCG"), "ALUNO ALOCADO!");
		assertEquals(controle.mostrarEstatisticas(), 
				  "\n"
				  + "Alunos em mais grupos:\n"
				  + "Aluno: 250 - Gabriel Reyes - Computação\n"
				  + "\n"
				  + "Cursos dos alunos em cada grupo:\n"
				  + "UFCG:\n"
				  + "    -Computação: 1\n"
				  + "\n"
				  + "UASC:\n"
				  + "\n"
				  + "\n"
				  + "Alunos sem grupos:\n"
				  + "Aluno: 200 - Lili Camposh - Computação\n"
				  + "Aluno: 201 - Torbjorn Lindholm - Engenharia Mecânica\n"
				  + "Aluno: 202 - Angela Ziegler - Medicina\n"
				  
		);
	}
	
	@Test
	void verificaEstatisticaDoisAlunosEmMesmaQuantidadeGrupo() {	
		assertEquals(controle.cadastraGrupo("UFCG"), "CADASTRO REALIZADO!");
		assertEquals(controle.cadastraGrupo("UASC"), "CADASTRO REALIZADO!");
		assertEquals(controle.alocarAlunoGrupo("250", "UFCG"), "ALUNO ALOCADO!");
		assertEquals(controle.alocarAlunoGrupo("200", "UASC"), "ALUNO ALOCADO!");
		assertEquals(controle.mostrarEstatisticas(), 
				  "\n"
				  + "Alunos em mais grupos:\n"
				  + "Aluno: 200 - Lili Camposh - Computação\n"
				  + "Aluno: 250 - Gabriel Reyes - Computação\n"
				  + "\n"
				  + "Cursos dos alunos em cada grupo:\n"
				  + "UFCG:\n"
				  + "    -Computação: 1\n"
				  + "\n"
				  + "UASC:\n"
				  + "    -Computação: 1\n"
				  + "\n"
				  + "\n"
				  + "Alunos sem grupos:\n"
				  + "Aluno: 201 - Torbjorn Lindholm - Engenharia Mecânica\n"
				  + "Aluno: 202 - Angela Ziegler - Medicina\n"
		);
	}
	
	@Test
	 void participaGrupoInexistente() {
		assertEquals(controle.participaGrupo("CAA", "200"), false);
	}
 }
