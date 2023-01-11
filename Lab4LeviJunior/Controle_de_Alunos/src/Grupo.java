import java.util.ArrayList;
import java.util.HashMap;

/**
 * Grupo de alunos. O grupo contém nome, tamanho e um HashMap de alunos.
 * 
 * @author LeviJunior
 *
 */
public class Grupo {
    private String nome;
    private int tamanho;
    private boolean existeLimite;
    private HashMap<String, Aluno> alunos; 

    /**
     * Constrói o grupo e atribui o seu nome recebido e o seu tamanho sem definir limite.
     * 
     * @param nome nome do grupo.
     */
    public Grupo(String nome) {
    	if (nome != null) {
    		if (!nome.equals("")) {
    			this.nome = nome;
    			this.existeLimite = false;
    			this.tamanho = Integer.MAX_VALUE;
    			this.alunos = new HashMap<>();
    		}
    		else {
    			throw new IllegalArgumentException("PARÂMETRO VAZIO RECEBIDO!");
    		}
    	}
    	else {
    		throw new NullPointerException("PARÂMETRO NULL RECEBIDO!");
    	}
    }

    /**
     * Constrói o grupo e atribui o seu nome e o tamanho do limite de alunos no grupo.
     * 
     * @param nome nome do grupo.
     * @param tamanho numero de integrantes do grupo.
     * @throws NullPointerException Retorna um erro caso receba um parâmetro null.
     * @throws IllegalArgumentException Retorna um erro caso o parâmetro recebido for vazio ou tamanho inválido.
     */
    public Grupo(String nome, int tamanho) {
    	if (nome == null) {
    		throw new NullPointerException("PARÂMETRO NULL RECEBIDO!");
    	} else
    	if (nome.equals("")) {
			throw new IllegalArgumentException("PARÂMETRO VAZIO RECEBIDO!");
    	} else 
    	if (tamanho <= 0) {
    		throw new IndexOutOfBoundsException("TAMANHO DO GRUPO INVÁLIDO!");
    	}
    	else {
    		this.nome = nome;
    		this.tamanho = tamanho;
    		this.existeLimite = true;
    		this.alunos = new HashMap<>(tamanho); 
    	}
    }

    /**
     * Cadastra o aluno no grupo.
     * 
     * @param matricula matrícula do aluno.
     * @param aluno Onjeto do aluno.
     * @return Retorna uma String se o cadastro foi feito ou não.
     */
    public String cadastraAluno(String matricula, Aluno aluno) {
    	if (this.tamanho == this.alunos.size()) {
    		return "GRUPO CHEIO!";
    	} else
    	if (!this.alunos.containsKey(matricula)) {
    		this.alunos.put(matricula, aluno);
    		return "ALUNO ALOCADO!";
    	}
    	return "ALUNO NÃO CADASTRADO!";
    }
    
    /**
     * Verifica se o aluno já está cadastrado no grupo.
     * 
     * @param matricula matricula do aluno.
     * @return Retorna um valor booleano se o aluno está participando ou não no grupo.
     */
    public boolean existeAluno(String matricula) {
    	return this.alunos.containsKey(matricula);
    }

    /**
     * Verifica se o grupo criado é igual ao grupo já existente.
     * 
     * @param o Objeto do grupo.
     * @return Retorna um booleano se o grupo é igual ou não a outro objeto grupo. 
     */
    @Override
    public boolean equals(Object o) {
    	if (o == null) {
    		return false;
    	} else
    	if (this.getClass() != o.getClass()) {
    		return false;
    	}
    	else {
    		Grupo grupo = (Grupo) o;
    		return this.nome.equals(grupo.nome);
    	}
    }
    
    /**
     * Retorna o hashCode sobre o nome do grupo.
     * 
     * @return Retorna um inteiro do hashCode em relação ao nome do grupo. 
     */
    @Override
    public int hashCode() {
    	return this.nome.hashCode();
    }

    /**
     * Retorna uma String sobre o resumo do grupo.
     * 
     * @return Retorna uma String sobre o nome do grupo e quantos alunos existem cadastrados.
     * Além disso ele nos dá o tamanho máximo do grupo. 
     */
    public String toString() {
    	return "- " + this.nome + " " + this.alunos.size() + "/" + (this.existeLimite? this.tamanho: "Ilimitado"); 
    }
    
    /**
     * Retorna o nome do grupo.
     * 
     * @return Retorna uma String com o nome do grupo.
     */
    public String getNome() {
    	return this.nome;
    }

    /**
     * Retorna um ArrayList de String com o nome do grupo e os cursos dos alunos existentes nele e sua respectiva quantidade alunos em 
     * cada grupo. 
     * 
     * @return Retorna um ArrayList de String onde para cada grupo mostra os cursos dos alunos cadastrados e sua respectiva quantidade de 
     * aluno para cada grupo.
     */
    public ArrayList<String> cursosCadastrados() {
    	ArrayList<String> cursosAlunos = new ArrayList<String>();
    	ArrayList<String> passou = new ArrayList<String>();
    	for (String aluno: this.alunos.keySet()) {
    		String nomeCurso = this.alunos.get(aluno).getCurso();
    		int contador = 0;
    		if (!passou.contains(nomeCurso)) {
    			passou.add(nomeCurso);
	    		for (String alunoI: this.alunos.keySet()) {
	    			if (this.alunos.get(alunoI).getCurso().equals(nomeCurso)) {
	    				contador ++;
	    			}
	    		}
	    		cursosAlunos.add(nomeCurso + ": " + contador);
    		}
    	}
    	return cursosAlunos;
    }
}
