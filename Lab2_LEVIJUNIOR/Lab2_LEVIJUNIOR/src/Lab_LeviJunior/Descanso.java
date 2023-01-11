package Lab_LeviJunior;
/**
 * Representação do controle de descanso do aluno onde, cada aluno possui um
 * número de créditos na disciplina por padrão de 120 horas mas esssas horas
 * também poderá ser instanciada pelo aluno.
 * 
 * @author Levi Júnior
 */

public class Descanso {
  /**
   * Horas de descanso em uma determinada disciplina.
   */
  private int horasDescanso;
  /**
   * Status do aluno se está cansado ou descansado (sempre inicia como cansado).
   */
  private boolean descansado;
  /**
   * Número de semanas estudadas pelo aluno na disciplina.
   */
  private int numeroSemanas;
  /**
   * Emoji que representa o sentimento do aluno para a disciplina.
   */
  private String emoji = "";

  /**
   * Número de semanas que foram usadas para o lazer.
   *
   * @param valor número inteiro para as semanas.
   **/
  public void defineNumeroSemanas(int valor) {
    this.numeroSemanas = valor;if (this.numeroSemanas != 0) {
      if ((this.horasDescanso / this.numeroSemanas >= 26) != descansado) {
        this.emoji = "";
        this.descansado = (this.horasDescanso / this.numeroSemanas >= 26);
      }
    }
  }

  /**
   * Número de horas usadas para o descanso do aluno.
   * 
   * @param valor número inteiro para representação das horas.
   **/
  public void defineHorasDescanso(int valor) {
    this.horasDescanso = valor;
    if (this.numeroSemanas != 0) {
      if ((this.horasDescanso / this.numeroSemanas >= 26) != descansado) {
        this.emoji = "";
        this.descansado = (this.horasDescanso / this.numeroSemanas >= 26);
      }
    }
  }

  /**
   * Definição do emoji para representar o estado atual do aluno.
   * 
   * @param emoji define o emoji sobre o estado atual do aluno.
   **/
  public void definirEmoji(String emoji) {
    if (!emoji.equals("")) {
      this.emoji = " - " + emoji;
    } else {
      this.emoji = "";
    }
  }

  /**
   * Obtenção do estado do aluno.
   * 
   * @return Retorna uma string de informações sobre se o aluno está cansado ou
   *         descansado e o emoji caso o aluno tenha definido.
   **/
  public String getStatusGeral() {
    if (this.numeroSemanas != 0) {
      this.descansado = (this.horasDescanso / this.numeroSemanas >= 26);
    }
    return (this.descansado) ? "descansado" + this.emoji : "cansado" + this.emoji;
  }
}
