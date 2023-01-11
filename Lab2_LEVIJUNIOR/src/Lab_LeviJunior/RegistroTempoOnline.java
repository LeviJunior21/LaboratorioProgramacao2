package Lab_LeviJunior;
/**
 * Representação dos registro da tempo de estudos do aluno para a disciplina
 * cursada. Além disso, o usuário tem a opação de construir uma classe com o
 * nome da disciplina comum tempo padrão de 120 horas ou o usuário poderá
 * construir um objeto com o nome da disciplina e instanciar as hora
 *  * 
 * 
 * @author Levi Júnior
 */
public class RegistroTempoOnline {
  private String disciplina;
  private int cargaHoraria;
  private int horasDecorridas;

  /**
   * Constrói o registro do tempo online para estudos e atribui o nome da disciplina e a carga horária recebida aos métodos.
   * 
   * @param nomeDisciplina      nome da diciplina.
   * @param tempoOnlineEsperado tempo esperado para ser usado no estudo da
   *                            disciplina.
   **/
  public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
    this.disciplina = nomeDisciplina;
    this.cargaHoraria = tempoOnlineEsperado;
  }

  /**
   * Constrói registro do tempo online do aluno para estudos e atribui o nome da disciplina recebida e 120 para ser usado no
   * estudo da disciplina.
   * 
   * @param nomeDisciplina nome da diciplina.
   **/
  public RegistroTempoOnline(String nomeDisciplina) {
    this.disciplina = nomeDisciplina;
    this.cargaHoraria = 60 * 2;
  }

  /**
   * Instância um incremento do parâmetro recebido nas horas decorridas do estudo.
   * 
   * @param tempo tempo estudado para a disciplina.
   **/
  public void adicionaTempoOnline(int tempo) {
    this.horasDecorridas += tempo;
  }

  /**
   * Retorna um texto resumo sobre a situação do aluno.
   * 
   * @return texto sobre qual é a disciplina, as horas decorridas
   *         até o momento e o tempo dedicado a disciplina esperado,
   **/
  public String toString() {
    return this.disciplina + " " + this.horasDecorridas + "/" + this.cargaHoraria;
  }

  /**
   * Verifica se o aluno atingiu o tempo de estudo esperado.
   * 
   * @return booleano se atingiu a meta de estudos.
   **/
  public boolean atingiuMetaTempoOnline() {
    return this.horasDecorridas >= this.cargaHoraria;
  }
}
