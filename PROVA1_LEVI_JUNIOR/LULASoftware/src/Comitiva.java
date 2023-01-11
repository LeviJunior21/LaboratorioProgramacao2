public class Comitiva {

  private int id;
  private String descricao;
  private int numeroPessoas;
  private String telefone;

  /**
   * Constrói a Comitiva com o id, a descrição, o número de pessoas e o telefone para contato respectivamente. 
   * 
   * @param id id da comitiva.
   * @param descricao descricao da comitiva.
   * @param numeroPessoas numero de pessoas pertencentes a comitiva. 
   * @param telefone telefone para contato da comitiva. 
   * @throws IndexOutOfBoundsException lança um erro quando o id não está entre o intervalo fechado 0 e 99. 
   */
  public Comitiva(int id, String descricao, int numeroPessoas, String telefone) {
    if (id >= 0 && id <= 99) {
      this.id = id;
      this.descricao = descricao;
      this.numeroPessoas = numeroPessoas;
      this.telefone = telefone;
    } else {
      throw new IndexOutOfBoundsException("Posição inválida!");
    }
  }

  /**
   * Retorna o hashCode da descrição desta comitiva.
   * 
   * @return Retorna o inteiro do hashCode da descricao da comitiva. 
   */
  public int hashCode() {
    return this.descricao.hashCode();
  }

  /**
   * Verifica se o objeto Comitiva é igual ao obeto criado pelo nome.
   * 
   * @return Retorna um booleano se o objeto Comitiva é igual pelo nome ou não. 
   */
  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    } else if (this.getClass() != o.getClass()) {
      return false;
    } else {
      Comitiva local = (Comitiva) o;
      return this.descricao.equals(local.descricao);
    }
  }
  
  /**
   * Retorna um texto contendo as informações da comitiva.
   * 
   * @return Retorna uma String contendo o ID, a comitiva, a quantidade de pessoas, e o contato da Comitiva.
   */
  public String toString() {
    String fraseComitiva = "";
    fraseComitiva += "ID: " + this.id + "\n";
    fraseComitiva += "Comitiva: " + this.descricao + "\n";
    fraseComitiva += "Integrantes: " + this.numeroPessoas + "\n";
    fraseComitiva += "Contato: " + this.telefone;
    return fraseComitiva;
  }

}
