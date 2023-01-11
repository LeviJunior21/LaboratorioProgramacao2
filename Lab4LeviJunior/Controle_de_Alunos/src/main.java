import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface com os menus texto para manipular o controle de alunos.
 * 
 * @author LeviJunior
 *
 */
public class main {
	public static void main(String[] args) {
		
		ControleAlunos controle = new ControleAlunos();
		
		Scanner scanner = new Scanner(System.in);
		String frase = "\n(C)adastrar aluno\n"
					 + "(E)xibir aluno\n"
					 + "(N)ovo grupo\n"
					 + "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n"
					 + "(O)lhaí quais Grupos o Aluno Tá.\n"
					 + "(R)egistrar Aluno que Respondeu\n"
					 + "(I)mprimir Alunos que Responderam\n"
					 + "(M)ostrar Estatísticas\n"
					 + "(S)im, quero Fechar o Programa!";
				
		for(;;) {
			System.out.println(frase);
			System.out.print("\nOpção> ");
			String opcao = scanner.nextLine().toUpperCase();
			
			switch (opcao) {
				case "C":
					cadastraAluno(scanner, controle); 
					break;
				case "E":
					exibirAluno(scanner, controle);
					break;
				case "A":
					alocarAlunoGrupo(scanner, controle);
					break;
				case "N":
					novoGrupo(scanner, controle);
					break;
				case "O":
					listarGruposAluno(scanner, controle);
					break;
				case "R":
					registraResposta(scanner, controle);
					break;
				case "I":
					imprimirRespostas(controle);
					break;
				case "M":
					mostrarEstatisticas(controle);
					break;
				case "S":
					sai();
					break;
			}
		}
	}
	
	/**
	 * Cadastra o aluno na lista de alunos.
	 * 
	 * @param scanner Para captura da opção do usuário. 
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void cadastraAluno(Scanner scanner, ControleAlunos controle) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();
		String resultado = controle.cadastraAluno(matricula, nome, curso);
		System.out.println(resultado);
	}
	
	/**
	 * Exibe o aluno cadastrado contendo a matricula, nome e o curso.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void exibirAluno(Scanner scanner, ControleAlunos controle) {
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		String infoAluno = controle.exibirAluno(matricula);
		System.out.println(infoAluno);
	}
	
	/**
	 * Cadastra um novo grupo de alunos. 
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void novoGrupo(Scanner scanner, ControleAlunos controle) {
		System.out.print("Grupo: ");
		String nome = scanner.nextLine();
		System.out.print("Tamanho: ");
		String tamanho = scanner.nextLine();
		
		if (tamanho.equals("")) {
			String resultadoCadastro = controle.cadastraGrupo(nome);
			System.out.println(resultadoCadastro);
		} else 
		if (Integer.parseInt(tamanho) > 0){
			String resultadoCadastro = controle.cadastraGrupo(nome, Integer.parseInt(tamanho));
			System.out.println(resultadoCadastro);
		}
		else {
			System.out.println("TAMANHO INVÁLIDO!");
		}
	}
	
	/**
	 * Aloca o aluno em um determinado grupo cadastrado. 
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void alocarAlunoGrupo(Scanner scanner, ControleAlunos controle) {
		System.out.println("(A)locar Aluno ou (P)ertinência a Grupo? ");
		String entrada = scanner.nextLine().toUpperCase();
		if (entrada.equals("A")) {
			System.out.print("Matrícula: ");
			String matricula = scanner.nextLine(); 
			System.out.print("GRUPO: ");
			String grupo = scanner.nextLine(); 
			String resposta = controle.alocarAlunoGrupo(matricula, grupo);
			System.out.println(resposta);
		} else 
		if (entrada.equals("P")) {
			System.out.print("GRUPO: ");
			String grupo = scanner.nextLine();
			System.out.print("Aluno: ");
			String matricula = scanner.nextLine(); 
			String resposta = controle.verificarPertinencia(matricula, grupo);
			System.out.println(resposta);
		}
		else {
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Lista os grupos onde o aluno está cadastrado. Além disso, mostra quantos alunos se cadastraram e o limite do grupo. 
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void listarGruposAluno(Scanner scanner, ControleAlunos controle) {
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		ArrayList<String> listaGrupos = controle.listarGruposAluno(matricula);
		for (int i = 0; i < listaGrupos.size(); i++) {
			System.out.println(listaGrupos.get(i));
		}
	}
	
	/**
	 * Registra a resposta do aluno.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void registraResposta(Scanner scanner, ControleAlunos controle) {
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		boolean resultado = controle.registraRespostaAluno(matricula);
		if (resultado) {
			System.out.print("ALUNO REGISTRADO!\n");
		}
		else {
			System.out.print("ALUNO NÃO CADASTRADO!\n");
		}
	}
	
	/**
	 * Imprime as respostas de todos os alunos que responderam.
	 * 
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void imprimirRespostas(ControleAlunos controle) { 
		String resposta = controle.imprimeTodasRespostas();
		if (!resposta.equals("")) {
			System.out.println("\nAlunos:");
			System.out.println(resposta);
		}
	}
	
	/**
	 * Mostra a estatística sobre alunos que pertencem a mais grupos, numero de alunos de um determinado curso para cada grupo e os alunos que não tem grupo.  
	 * 
	 * @param controle O controle de alunos que estamos manipulando. 
	 */
	public static void mostrarEstatisticas(ControleAlunos controle) {
		String estatisticas = controle.mostrarEstatisticas();
		System.out.println(estatisticas);
	}
	
	/**
	 * Fecha o programa do controle de alunos.
	 */
	public static void sai() {
		System.out.print("Vlw flw!");
		System.exit(0);
	}
}
