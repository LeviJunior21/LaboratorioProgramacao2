package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author LeviJunior
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(F)avoritos\n"+
						"(A)dicionar Favorito\n"+
						"(R)emover Favorito\n"+
						"(E)xibir Contato\n" +  
						"(T)irar Contato\n" +
						"(B)uscar por Nome\n" +  
						"(V)erificar por Sobrenome\n" +
						"(M)udar Telefone\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavoritos(agenda, scanner);
			break;
		case "R":
			removeFavoritos(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		case "T":
			removerContato(agenda, scanner);
			break;
		case "B":
			buscarPorNome(agenda, scanner);
			break;
		case "V":
			buscarPorSobrenome(agenda, scanner);
			break;
		case "M":
			mudarTelefone(agenda, scanner);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	private static void mudarTelefone(Agenda agenda, Scanner scanner) {
		System.out.println("Trocar telefone:");
		System.out.print("Posição> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <= 100) {
			System.out.print("Telefone> ");
			String telefone = scanner.next();
			if (!telefone.equals("")) {
				agenda.trocarTelefone(posicao, telefone);
			}
			else {
				System.out.println("CONTATO INVÁLIDO!");
			}
		}
		else {
			System.out.println("POSIÇÃO INVÁLIDA!");

		}
	}

	/**
	 * Faz uma busca pelo nome na agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void buscarPorNome(Agenda agenda, Scanner scanner) {
		System.out.print("Nome> ");
		String nome = scanner.next();
		System.out.println("Buscando pelo nome " + nome+ "!\n");
		agenda.listaContatosPorNome(nome);
	}
	
	/**
	 * Faz uma busca pelo sobrenome na agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void buscarPorSobrenome(Agenda agenda, Scanner scanner) {
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.next();
		System.out.println("Buscando pelo sobrenome " + sobrenome+ "!\n");
		agenda.listaContatosPorSobrenome(sobrenome);
	}
	
	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i + 1, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <=100) {
			String contato = agenda.getContato(posicao);
			System.out.println("Dados do contato:\n" + contato);
		}
		else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}

	private static void removerContato(Agenda agenda, Scanner scanner) {
		System.out.println("Remover contato");
		System.out.print("Posição> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <= 100) {
			boolean resultado = agenda.removeContato(posicao);
			if (resultado) {
				System.out.println("CONTATO REMOVIDO!");
			}
			else {
				System.out.println("POSIÇÃO INVÁLIDA!");
			}
		}
		else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <= 100) {
			System.out.print("\nNome> ");
			scanner.nextLine();
			String nome = scanner.nextLine();
			if (nome.equals("")) {
				System.out.println("CONTATO INVALIDO");
				return;
			}
			System.out.print("\nSobrenome> ");
			String sobrenome = scanner.nextLine();
			if (sobrenome.equals("")) {
				System.out.println("CONTATO INVALIDO");
				return;
			}
			System.out.print("\nTelefone> ");
			String telefone = scanner.nextLine();
			if (telefone.equals("")) {
				System.out.println("CONTATO INVALIDO");
				return;
			}
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		}
		else {
			System.out.print("POSIÇÃO INVÁLIDA");
		}
		
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
	/**
	 * Chama o método que lista os favoritos.
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 */
	private static void listaFavoritos(Agenda agenda) {
		agenda.mostrarFavoritos();
	}
	
	/**
	 * Adiciona um contato na lista de favoritos da agenda. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt(); 
		if (contato >= 1 && contato <= 100) {
			System.out.print("Posição> ");
			int posicao = scanner.nextInt();
			if (posicao >= 1 && posicao <= 10) {
				agenda.cadastraFavorito(contato, posicao);
			}
			else {
				System.out.println("POSIÇÃO INVÁLIDA!");
			}
		}
		else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
		
		
	}

	/**
	 * Remove um contato na lista de favoritos da agenda. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void removeFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <= 10) {
			agenda.removerFavorito(posicao);
		}
		else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}
}
