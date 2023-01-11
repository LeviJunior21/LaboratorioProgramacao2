package Lab_LeviJunior;
import java.util.Arrays;

/**
 * Representação das notas e situação de um estudante ao cursar uma determinada disciplina
 * pelo Controle Institucional de Situação Acadêmica.
 * 
 * @author Levi Júnior
 */

public class Disciplina {
  /**
   * Nome da disciplina cursada pelo aluno.
   */
  private String disciplina;
  /**
   * Array das notas obtidas pelo aluno.
   */
  private double[] notas;
  /**
   * Horas de estudo para a disciplina.
   */
  private int horas;
  /**
   * Array de pesos das notas para cada nota da disciplina.
   */
  private int[] pesos;

  /**
   * Constrói a disciplina e define a disciplina a ser cursada pelo aluno através
   * da disciplina recebida e atribui 4 notas e 4 pesos.
   * Além disso, é atribuido o número 1 em cada um dos pesos das notas.
   * 
   * @param nome da disciplina a ser cursada.
   **/
  public Disciplina(String nomeDisciplina) {
    this.disciplina = nomeDisciplina;
    this.notas = new double[4];
    this.pesos = new int[4];
    Arrays.fill(this.pesos, 1);
  }

  /**
   * Constrói a disciplina e define a disciplina a ser cursada pelo aluno e
   * atribui um determinado número de notas passados pelos parâmetros
   * respectivamente.
   * 
   * @param disciplina  nome da disciplina a ser cursada.
   * @param numeroNotas número de notas para a disciplina.
   **/
  public Disciplina(String disciplina, int numeroNotas) {
    this.disciplina = disciplina;
    this.notas = new double[numeroNotas];
    this.pesos = new int[numeroNotas];
    Arrays.fill(this.pesos, 1);
  }

  /**
   * Constrói e define a disciplina a ser cursada pelo aluno e atribui um
   * determinado número de notas e pesos passados pelos parâmetros
   * espectivamente.
   * 
   * @param disciplina  nome da disciplina a ser cursada.
   * @param numeroNotas número de notas.
   * @param pesos       array de pesos para as notas.
   **/
  public Disciplina(String disciplina, int numeroNotas, int[] pesos) {
    this.disciplina = disciplina;
    this.notas = new double[numeroNotas];
    this.pesos = pesos;
  }

  /**
   * Incrementa as horas estudadas pelo aluno na disciplina.
   * 
   * @param horas número de horas usadas de estudo para o incremento das horas estudadas.
   **/
  public void cadastraHoras(int horas) {
    this.horas = horas;
  }

  /**
   * Cadastra as notas do aluno em uma determinada posição das notas obtidas pelo
   * aluno.
   * 
   * @param nota      posição do índice da nota.
   * @param valorNota nota do aluno na disciplina.
   **/
  public void cadastraNota(int nota, double valorNota) {
    this.notas[nota - 1] = valorNota;
  }

  /**
   * Verifica se o aluno está aprovado na disciplina.
   * 
   * @return Retorna um booleano para identificar se o aluno está ou não aprovado.
   **/
  public boolean aprovado() {
    return getMedia() >= 7;
  }

  private double getMedia() {
    double somaNotas = 0;
    int pesosNotas = 0;
    for (int i = 0; i < this.pesos.length; i++) {
      somaNotas += this.pesos[i] * this.notas[i];
      pesosNotas += this.pesos[i];
    }
    return somaNotas / pesosNotas;
  }

  /**
   * Retorna uma string que é retornada com o nome da disciplina, as horas
   * cadastradas, a média na disciplina e um array de notas do aluno,
   * respectivamente.
   * 
   * @return retorna uma frase sobre a situação do aluno.
   **/
  public String toString() {
    return this.disciplina + " " + this.horas + " " + getMedia() + " " + Arrays.toString(this.notas);
  }
}
