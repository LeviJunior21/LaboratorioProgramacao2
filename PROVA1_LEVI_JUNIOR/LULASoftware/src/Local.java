public class Local {

  private String nome;
  private String identificador;
  private String ramal;
  private Comitiva[] comitivas;
  /**
   * Constrói o local com seu nome, identificador e o ramal respectivamente.
   * 
   * @param nome nome nome do local.
   * @param identificador identificador textual do local;.
   * @param ramal ramal do local.
   */
  public Local(String nome, String identificador, String ramal) {
    this.nome = nome;
    this.identificador = identificador;
    this.ramal = ramal;  
    this.comitivas = new Comitiva[100];
  }

  /**
   * Imprime o local com seu nome, identificador textual e o ramal.
   * 
   * @return Retorna um texto com o nome, o identificador e o ramal do local.
   */
  public String toString() {
    String fraseLocal = "";
    fraseLocal += this.nome;
    fraseLocal += " - ";
    fraseLocal += this.identificador;
    fraseLocal += " - ";
    fraseLocal += this.ramal;
    return fraseLocal;
  }

  public String[] getComitivas() {
	  int quantidadeComitivas = contaComitivas();
	  int contador = 0;
	  String[] todasComitivas = new String[quantidadeComitivas];
	  for (int i = 0; i < this.comitivas.length; i++) {
		  if (comitivas[i] != null) {
			  todasComitivas[contador] = this.comitivas[i].toString();
			  contador += 1;
		  }
	  }
	  return todasComitivas;
  }
  
  public int contaComitivas() {
	  int contador = 0;
	  for (int i = 0; i < this.comitivas.length; i++) {
		  if (this.comitivas[i] != null) {
			  contador += 1;
		  }
	  }
	  return contador;
  }
  
  public void cadastraComitiva(Comitiva comitiva, int posicao) {
	  if (posicao >= 0 && posicao <= 99) {
		  this.comitivas[posicao] = comitiva;
	  }
	  else {
		  throw new IndexOutOfBoundsException("Posição inválida");
	  }
  }
  
  /**
   * Retorna o nome do local.
   * 
   * @return Retorna o nome do local.
   */
  public String getNome() {
    return this.nome;
  }
    
  /**
   * Retorna o hashCode do nome deste Local.
   * 
   * @return Retorna o inteiro do hashCode do nome do local. 
   */
  public int hashCode() {
    return this.nome.hashCode();
  }

  /**
   * Verifica se o objeto Local é igual ao obeto criado pelo nome.
   * 
   * @return Retorna um booleano se o objeto Local é igual pelo nome ou não. 
   */
  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    } else if (this.getClass() != o.getClass()) {
      return false;
    } else {
      Local local = (Local) o;
      return this.nome.equals(local.nome);
    }
  }
}