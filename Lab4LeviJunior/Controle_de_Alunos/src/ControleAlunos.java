import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controlador de alunos e grupos da UFCG. 
 * 
 * @author LeviJunior
 *
 */
public class ControleAlunos {
	private HashMap<String, Aluno> alunos;
    private HashMap<String, Grupo> grupos;
    private ArrayList<Aluno> registraResposta;

    public ControleAlunos() {
    	this.alunos = new HashMap<>();
    	this.grupos = new HashMap<>(); 
    	this.registraResposta = new ArrayList<Aluno>();
    }
    
    /**
     * Cadastra o aluno com a chave matricula e constrói o aluno com matricula nome e o curso.
     * 
     * @param matricula matricula do aluno.
     * @param nome nome do aluno.
     * @param curso curso do aluno.
     * @theow IllegalArgumentException Retorna um erro caso um dos parâmetros seja vazio.
     * @return Retorna uma mensagem sobre a situação do cadastro.
     */
    public String cadastraAluno(String matricula, String nome, String curso) {
    	try {
    		Aluno aluno = new Aluno(matricula, nome, curso);
    		if (!existeAluno(matricula)) {
    			this.alunos.put(matricula, aluno);
    			return "CADASTRO REALIZADO!";
    		}
    		else {
    			return "MATRÍCULA JÁ CADASTRADA!"; 
    		}
    	}
    	catch (IllegalArgumentException iae) {
    		return iae.getMessage();
    	}
    	catch (NullPointerException npe) {
    		return npe.getMessage();
    	}
    }

    private boolean existeAluno(String matricula) {
    	return alunos.containsKey(matricula);
    }
    
    /**
     * Cadastra o grupo caso ele não esteja cadastrado na lista de grupos.
     * 
     * @param nome nome do grupo.
     * @param tamanho tamanho da lista de alunos pertencentes ao grupo.
     * @return Retorna uma frase sobre se o cadastro foi feito, se já foi cadastrado ou ocorreu algum erro.
     */
    public String cadastraGrupo(String nome, int tamanho) {
    	try {
    		Grupo grupo = new Grupo(nome, tamanho);
        	if (!existeGrupo(nome)) {
        		this.grupos.put(nome, grupo);
        		return "CADASTRO REALIZADO!";
       		}
        	else {
       			return "GRUPO JÁ CADASTRADO!";
        	}
    	}
    	catch(NullPointerException npe) {
    		return npe.getMessage();
    	}
    	catch(IllegalArgumentException iae) {
    		return iae.getMessage();
    	}
    }

    private boolean existeGrupo(String grupo) {
    	return this.grupos.containsKey(grupo);
    }
    
    /**
     * Cadastra o grupo com apenas o nome do grupo. Seu tamanho da quantidade de alunos suportado no grupo será ilimitado.
     * 
     * @param nome nome do grupo.
     * @return Retorna uma String sobre a situação do cadastro do grupo. 
     */
    public String cadastraGrupo(String nome) {
    	try {
    		Grupo grupo = new Grupo(nome);
    		if (!existeGrupo(nome)) {
    			this.grupos.put(nome, grupo);
    			return "CADASTRO REALIZADO!";
    		}
    		else {
    			return "GRUPO JÁ CADASTRADO!";
    		}
    	}
    	catch(NullPointerException npe) {
    		return npe.getMessage();
    	}
    	catch(IllegalArgumentException iae) {
    		return iae.getMessage();
    	}
    }
    
    /**
     * Verifica a pertinencia do aluno a um determinado grupo criado.
     * 
     * @param matricula matrícula do aluno.
     * @param grupo nome do grupo criado.
     * @return Retorna uma String se o aluno pertence ou não ao grupo, ou se o aluno ou o grupo
     * não estão cadastrados ainda.
     */
    public String verificarPertinencia(String matricula, String grupo) {
    	Grupo gp = this.grupos.get(grupo);
    	if (!existeAluno(matricula)) {
    		return "ALUNO NÃO CADASTRADO!";
    	}
    	if (gp != null) {
    		if (gp.existeAluno(matricula)) {
	   			return "ALUNO PERTENCE AO GRUPO!";
    		}
    		else {
    			return "ALUNO NÃO PERTENCE AO GRUPO!";
    		}
    	}
    	else {
    		return "GRUPO NÃO CADASTRADO!";
    	}
    }

    /**
     * Exibe um resumo sobre o aluno.
     * 
     * @param matrícula matricula do aluno.
     * @return Retorna a matricula nome e curso caso do aluno caso ele exista na lista de alunos. 
     * Caso contrário ele retorna NÃO CADASTRADO!
     */
    public String exibirAluno(String matricula) {
    	if (this.alunos.containsKey(matricula)) {
    		return this.alunos.get(matricula).toString();
    	}
    	else {
    		return "ALUNO NÃO CADASTRADO!";
    	}
    }

    /**
     * Verifica se o aluno está cadastrado em um determinado grupo.
     * 
     * @param nome nome do aluno.
     * @param matricula matricula do aluno.
     * @return Retorna um valor booleano se o aluno participa ou não de um determinado grupo.
     */
    public boolean participaGrupo(String nome, String matricula) {
    	if (this.grupos.get(nome) != null) {
    		if (this.grupos.get(nome).existeAluno(matricula)) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Registra a resposta do aluno a partir da sua matricula.
     * 
     * @param matricula matriciula do aluno. 
     * @return Retorna um valor booleano se a resposta foi cadastrada.  
     */
    public boolean registraRespostaAluno(String matricula) {
    	if (this.alunos.containsKey(matricula)) {
    		this.registraResposta.add(this.alunos.get(matricula));
    		return true;
    	}
    	return false;
    }

    /**
     * Imprime todas as respostas cadastradas do aluno em todos os grupos. 
     * 
     * @param matricula matricula do aluno.
     * @return Retorna uma String sobre as respostas do aluno em vários grupos.
     */
    public String imprimeTodasRespostas() {
    	String respostas = "";
    	int contador = 1;
    	for (Aluno aluno: this.registraResposta) {
    		respostas += contador + ". " + aluno.toString() + '\n';
    		contador ++;
    	}
    	return respostas;
    }
    
    /**
     * Lista todos os alunos onde o aluno está alocado.
     * 
     * @param matricula matrícula do aluno.
     * @return Retorna um array de String com as informações nome e tamanho sobre cada grupo onde o aluno está alocado.
     */
    public ArrayList<String> listarGruposAluno(String matricula) {
    	ArrayList<String> lista = new ArrayList<>();
    	for (String grupo: this.grupos.keySet()) {
    		if (this.grupos.get(grupo).existeAluno(matricula)) {
    			lista.add(this.grupos.get(grupo).toString());
    		}
    	}
    	return lista;
    }

    /**
     * Aloca o aluno em um determinado grupo criado.
     * 
     * @param matricula matrícula do aluno.
     * @param nomeGrupo nome do grupo.
     * @return Retorna uma String se o aluno foi ou não cadastrado e caso o aluno ou grupo não exista então 
     * é retornado que o aluno ou o grupo não existe.
     */
    public String alocarAlunoGrupo(String matricula, String nomeGrupo) {
    	if (existeAluno(matricula)) {
    		for(String grupo: this.grupos.keySet()) {
    			if (this.grupos.get(grupo).getNome().equals(nomeGrupo)) {
    				return this.grupos.get(grupo).cadastraAluno(matricula, this.alunos.get(matricula));
    			}
    		}
    	}
    	else {
    		return "ALUNO NÃO CADASTRADO!";
    	}
    return "GRUPO NÃO CADASTRADO!";
    }
    
    
    /**
     * Mostra as estatisticas de alunos sem grupos, aluno(s) cadastrados em mais grupos e os cursos dos alunos em cada grupo cadastrado. 
     * 
     * @return Retorna um HashMap de ArrayList de Strings contendo todas as informações sobre os alunos sem grupo, os aluno(s) cadastrados em mais grupos e 
     * os cursos dos alunos em cada grupo cadastrado. A chave do hashMap deve ser usada para imprimir ArrayList num laço de repetição para Strings. 
     */
    public String mostrarEstatisticas() {    	
    	String conteudo = "\nAlunos em mais grupos:\n";
    	for (Aluno alunoSG: alunosMaisGrupos()) {
    		conteudo += alunoSG.toString() + "\n";
    	}
    	
    	conteudo += "\nCursos dos alunos em cada grupo:\n";
    	for (String curso: cursoGrupos()) {
    		conteudo += curso + "\n";
    	}
    	
    	conteudo += "\nAlunos sem grupos:\n";
    	for (Aluno alunoSG: alunosSemGrupos()) {
    		conteudo += alunoSG.toString() + "\n";
    	}    	
    	
    	return conteudo;
    }
    
    private ArrayList<String> cursoGrupos() {
    	ArrayList<String> cursoDosGrupos = new ArrayList<String>();
    	for (String grupo: this.grupos.keySet()) {
    		ArrayList<String> cursoCad = this.grupos.get(grupo).cursosCadastrados();
    		String nomeCurso = grupo + ":\n";
    		for (String i: cursoCad) {
    			nomeCurso += "    -" + i + "\n";
    		}
    		cursoDosGrupos.add(nomeCurso);
    	}
    	return cursoDosGrupos;
    }
    
    private ArrayList<Aluno> alunosSemGrupos() {
    	ArrayList<Aluno> alunosSemGP = new ArrayList<Aluno>();
    	for (String aluno: this.alunos.keySet()) {
    		if (contaAlunoEmGrupos(aluno) == 0) {
    			alunosSemGP.add(this.alunos.get(aluno));
    		}
    	}
    	return alunosSemGP;
    }
    
    private ArrayList<Aluno> alunosMaisGrupos() {
    	ArrayList<Aluno> alunosMaisGP = new ArrayList<Aluno>();
    	int referencia = 0;
    	for (String aluno: this.alunos.keySet()) {
    		int contador = contaAlunoEmGrupos(aluno);
    		if (contador > referencia) {
    			referencia = contador;
    			alunosMaisGP.removeAll(alunosMaisGP);
    			alunosMaisGP.add(this.alunos.get(aluno));
    		} else 
    		if (contador == referencia && contador != 0) {
    			alunosMaisGP.add(this.alunos.get(aluno));
    		}
    	}
    	return alunosMaisGP;
    }
    
    private int contaAlunoEmGrupos(String aluno) {
    	int contador = 0;
    	for (String grupo: this.grupos.keySet()) {
			if (this.grupos.get(grupo).existeAluno(aluno)) {
				contador ++;
			}
		}
    	return contador;
    }
}
