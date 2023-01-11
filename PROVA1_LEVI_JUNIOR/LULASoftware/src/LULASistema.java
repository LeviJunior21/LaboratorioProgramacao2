public class LULASistema {

  private Local[] locaisVisitacao;
  private Comitiva[] comitivas;
  private int iteradorLocal;

  /**
   * Constrói o objeto LULASistema e atribui 100 locais e 100 comitivas. 
   * Além disso ele tambpém atribui o número 0 ao iterador de locais para 
   * que possa cadastrar vários locais. 
   */
  public LULASistema() {
    this.locaisVisitacao = new Local[100];
    this.comitivas = new Comitiva[100];
    this.iteradorLocal = 0;
  }

  /**
   * Auxilia na construção do objeto local e o lança no array de locais.  
   * 
   * @param nome nome do local.
   * @param identificador identificador textual do local.
   * @param ramal ramal do local.
   * @return Retorna uma String se o local foi criado, ou já existe no array de locais existentes. 
   * @throws IndexOutOfBoundsException
   */
  public String cadastraLocal(String nome, String identificador, String ramal) throws IndexOutOfBoundsException {
     Local localCriado = new Local(nome, identificador, ramal);
     if (!existeLocal(localCriado)) {
       this.locaisVisitacao[iteradorLocal] = localCriado;
       this.iteradorLocal += 1;
       return "Local criado com sucesso!";
     }
     else {
       return "Este local já existe!";
     }
  }

  /**
   * 
   * @param id indice que será alocada a comitiva no array de comitivas. 
   * @param descricao descrição da comitiva.
   * @param numeroPessoas numero de pessoas da comitiva. 
   * @param telefone telefone para contato da comitiva.
   * @return Retorna uma String se a comitiva foi criada, ou já existe no array de comitivas existentes. 
   */
  public String cadastraComitiva(int id, String descricao, int numeroPessoas, String telefone) {
    try {
      Comitiva comitivaCriada = new Comitiva(id, descricao, numeroPessoas, telefone);
      if (!existeComitiva(comitivaCriada)) {
        this.comitivas[id] = comitivaCriada;
        return "Comitiva cadastrada com sucesso!";
      }
      else {
        return "Esta comitiva já existe!";
      }
    } catch(Exception e) {
      return e.getMessage();
    }
  }

  
  public String exibeComitiva(int identificador) {
    if (this.comitivas[identificador] != null) {
      return this.comitivas[identificador].toString();
    }
    return "Esta comitiva não existe!";
  }

  /**
   * Procura o local inserido pelo usuário na lista de locais e imprime o resumo sobre o local. 
   * @param local nome do local buscado.
   * @return Retorna uma String com um resumo sobre o local existente. Caso não encontre ele retorna uma mensagem 
   * avisando que não foi encontrado neste formato "O local LOCAL não foi encontrado!".
   */
  public String exibeLocal(String local) {
    for (int i = 0; i < this.locaisVisitacao.length; i++) {
      if (this.locaisVisitacao[i] != null) {
        if (this.locaisVisitacao[i].getNome().equals(local)) {
          return this.locaisVisitacao[i].toString(); 
        }
      }
    }
    return "O local " + local + " não foi encontrado!";
  }

  /**
   * Verifica se o Local que está sendo criada já existe dentre os locais já existentes.
   * 
   * @param comitiva O objeto comitiva criado. 
   * @return Retorna um booleano para determinar se o Local já foi criado ou não.
   */
  private boolean existeLocal(Local local) {
    for (int i = 0; i < this.locaisVisitacao.length; i++) {
      if (this.locaisVisitacao[i] != null) {
        if (this.locaisVisitacao[i].equals(local)) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Verifica se a comitiva que está sendo criada já existe dentre as comitivas já existentes.
   * 
   * @param comitiva O objeto comitiva criado. 
   * @return Retorna um booleano para determinar se a comitiva já foi criada ou não.
   */
  private boolean existeComitiva(Comitiva comitiva) {
    for (int i = 0; i < this.comitivas.length; i++) {
      if (this.comitivas[i] != null) {
        if (this.comitivas[i].equals(comitiva)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private int pegaIndiceLocal(String local) {
	    for (int i = 0; i < this.locaisVisitacao.length; i++) {
	      if (this.locaisVisitacao[i] != null) {
	        if (this.locaisVisitacao[i].getNome().equals(local)) {
	          return i;
	        }
	      }
	    }
	    return -1;
	  }
  
  public String cadastraComitivaEmLocal(String local, int posicao) {
	  try {
		  int indice = pegaIndiceLocal(local);
		  if (indice != -1 && posicao >= 0 && posicao <= 99) {
			  this.locaisVisitacao[indice].cadastraComitiva(this.comitivas[posicao], posicao);
			  return "Cadastrado com sucesso!";
		  }else 
		  if (indice == -1){
			  return "Posição inválida!";
		  }
		  else {
			  return "Posição inválida!";
		  }
	  }
	  catch (IndexOutOfBoundsException ibe) {
		  return ibe.getMessage();
	  }
  }
  
  public String[] exibeTodosLocais() {
	  String[] locais = new String[contaLocaisCadastrados()];
	  int contador = 0;
	  for (int i = 0; i < this.locaisVisitacao.length; i++) {
		  if (this.locaisVisitacao[i] != null) {
			  locais[contador] = this.locaisVisitacao[i].toString();
			  contador += 1;
		  }
	  }
	  return locais;
  }
  
  public String[] exibeTodasComitivas() {
	  String[] comitivas = new String[contaComitivasCadastradas()];
	  int contador = 0;
	  for (int i = 0; i < this.comitivas.length; i++) {
		  if (this.comitivas[i] != null) {
			  comitivas[contador] = this.comitivas[i].toString();
			  contador += 1;
		  }
	  }
	  return comitivas;
  }
  
  public String[] listaVisita(String local) {
	  int pos = pegaIndiceLocal(local);
	  return this.locaisVisitacao[pos].getComitivas();
  }
  
  private int contaLocaisCadastrados() {
	  int contador = 0;
	  for (int i = 0; i < this.locaisVisitacao.length; i++) {
		  if (this.locaisVisitacao[i] != null) {
			  contador += 1;
		  }
	  }
	  return contador;
  }
  
  private int contaComitivasCadastradas() {
	  int contador = 0;
	  for (int i = 0; i < this.comitivas.length; i++) {
		  if (this.comitivas[i] != null) {
			  contador += 1;
		  }
	  }
	  return contador;
  }
}
