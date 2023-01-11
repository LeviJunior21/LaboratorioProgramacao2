package Lab_LeviJunior;
import java.util.Arrays;

/**
 * Representação do Registro de Resumos onde são alocados u número x de resumos
 * na memória.
 * 
 * @author Levi Júnior
 */
public class RegistroResumos {
  private String[] todosResumos;
  private String[] todosTipos;
  private int posicao;
  private String[] todosResumosAumentado;

  /**
   * Constrói um registro de resumos e instancia um array de resumos com o número
   * de resumos recebidos pelo parâmetro.
   * 
   * @param numeroDeResumos número de resumos.
   **/
  public RegistroResumos(int numeroDeResumos) {
    this.todosResumos = new String[numeroDeResumos];
    this.todosResumosAumentado = new String[0];
  }

  /**
   * Retorna um array de resumos das disciplinas.
   * 
   * @return Retorna um array de resumos de todas as disciplinas.
   **/
  public String[] pegaResumos() {
    return this.todosResumos;
  }

  /**
   * Conta quantos resumos foram alocados no array de resumos.
   * 
   * @return Retorna a quantidade de resumos alocados no array de notas.
   **/
  public int conta() { // Conta quantos tipos não null existem no array de resumos
    int contadorNaoNull = 0;
    for (int indice = 0; indice < this.todosResumos.length; indice++) {
      if (todosResumos[indice] != null) {
        contadorNaoNull += 1;
      }
    }
    return contadorNaoNull;
  }

  /**
   * Adiciona o texto com tipo e a frase sobre cada um dos temas e resumos que são
   * passados como argumentos.
   * 
   * @param tema   tema abordado.
   * @param resumo texto explicando o tema abordado.
   * 
   * @return Retorna o tema do resumo e um texto explicando o tema abordado.
   **/
  public void adiciona(String tema, String resumo) { // Adiciona um tema no array de resumos
    if (this.posicao == this.todosResumos.length) { // Verificando se atingiu o limite do array
      this.posicao = 0; // Se atingiu, starta como 0 para a próxima frase substituir na prosição do
                        // indice da posição
    }
    this.todosResumos[this.posicao] = tema + ": " + resumo;
    this.posicao += 1; // Incrementando a posição para adicionar a frase em uma determinada posição do
                       // intervalo fechado do array de resumos.
  }

  /**
   * Verifica se o tema existe ou não no array de resumo.
   * 
   * param tema tema do conteúdo.
   * 
   * @return Retorna um booleano.
   **/
  public boolean temResumo(String tema) { // Verificando se existem os resumos de um determinado tema
    for (String tipo : this.todosTipos) {
      if (tipo.equals(tema)) {
        return true;
      }
    }
    return false;
  }

  private void adicionaFrase(String frase) { // Criando uma cópia do array de resumos e adicionando ao último elemento a frase recebida.
    String[] novoArray = new String[this.todosResumosAumentado.length + 1];
    for (int indice = 0; indice < this.todosResumosAumentado.length; indice++) {
      novoArray[indice] = this.todosResumosAumentado[indice];
    }
    this.todosResumosAumentado = novoArray;
    this.todosResumosAumentado[this.todosResumosAumentado.length - 1] = frase;
  }

  /**
   * Busca frases que tem a palavra chave passada na lista de resumos e mostra as
   * frases que essa palavra está incluisa.
   * 
   * @param chaveDeBusca palavra chave da frase.
   * 
   * @return Retorna um array de resumos que contém a palavra chave
   **/
  public String[] busca(String chaveDeBusca) { // Buscando
    for (int i = 0; i < this.todosResumos.length; i++) {
      if (this.todosResumos[i] != null && this.todosResumos[i].contains(chaveDeBusca)) {
        adicionaFrase(this.todosResumos[i]);
      }
    }
    Arrays.sort(this.todosResumosAumentado);
    return this.todosResumosAumentado;
  }

  /**
   * Este método é usado para imprimir os resumos das disciplinas e é retornado
   * uma string com todos os textos sobre cada resumo.
   * O texto retornado contém o número de resumos e os tipos alocados na lista de
   * resumos.
   * 
   * @retrun Retorna a frase completa com o número de resumos cadastrados e os
   *         tipos.
   **/
  public String imprimeResumos() {
    int numeroResumosNaoNull = 0;
    for (String resumo : todosResumos) { // Verificando na lno array de resumos se existem frases não null
      if (resumo != null) {
        numeroResumosNaoNull += 1;
      }
    }

    String[] tipos = new String[numeroResumosNaoNull];
    for (int n = 0; n < numeroResumosNaoNull; n++) {
      tipos[n] = todosResumos[n].split(":")[0]; // Pegando os tipos contidos nas frases
    }

    String numeroResumos = String.valueOf(numeroResumosNaoNull);
    String fraseResumos = "- " + numeroResumos + " resumo(s) cadastrado(s)\n";
    String fraseTipos = "- " + (String.join(" | ", tipos));
    String fraseCompleta = fraseResumos + fraseTipos;
    this.todosTipos = tipos;

    return fraseCompleta;
  }
}
