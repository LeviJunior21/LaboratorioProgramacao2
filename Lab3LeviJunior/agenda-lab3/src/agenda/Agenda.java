package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author LeviJunior
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos; //apenas uma simplificacao de contato
	private Contato[] favoritos; 
	/**
	 * Cria uma agenda. 
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		String[] todosContatos = new String[TAMANHO_AGENDA];
		for (int i = 1; i <= TAMANHO_AGENDA; i++) {
			if (contatos[i - 1] != null) {
				todosContatos[i - 1] = contatos[i - 1].toString();
			}
		}
		return todosContatos;
	}
	
	/**
	 * Troca o número de telefone do contato.
	 * @param posicao posição do contato.
	 * @telefone telefone a ser trocado.
	 * @throws IllegalArgumentException se a posição é inválida ou o telefone é inválido do tipo vazio.
	 * @throws NullPointerException se o contato é inválido recebendo null.
	 */
	public void trocarTelefone(int posicao, String telefone) {
		if (posicao > 100 || posicao < 1) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				System.out.println("POSIÇÃO INVÁLIDA!");
			}
		}
		if (telefone != null) {
			if (this.contatos[posicao - 1] != null) {
				if (posicao >= 1 && posicao <= 100) {
					if (!telefone.equals("")) {
						this.contatos[posicao - 1].setTelefone(telefone);
						System.out.println("NÚMERO ALTERADO!");
					}
					else {
						try {
							throw new IllegalArgumentException("TELEFONE INVÁLIDO!");
						}
						catch (Exception e) {
							System.out.println("TELEFONE INVÁLIDO!");
						}
					}
				}
				else {
					try {
						throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
					}
					catch (Exception e) {
						System.out.println("POSIÇÃO INVÁLIDA!");
					}
				}
			}
			else {
				try {
					throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
				}
				catch (Exception e) {
					System.out.println("POSIÇÃO INVÁLIDA!");					
				}
			}
		}
		else {
			try {
				throw new NullPointerException("CONTATO INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("CONTATO INVÁLIDO!");					
			}

		}
	}
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @throws IllegalArgumentException se a posição é inválida menor que 0 e maior que 100 ou o telefone é inválido do tipo vazio.
	 * @throws NullPointerException se a posicaoa do contato é inválido recebendo null.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		if (contatos[posicao - 1] == null) {
			try {
				throw new NullPointerException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				return "POSIÇÃO INVÁLIDA!";					
			}
		} else
		if (posicao < 1 || posicao > 100) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				return "POSIÇÃO INVÁLIDA!";
			}
		} else
		if (posicao >= 1 && posicao <= 100) {
			return hasFavorito(posicao) + contatos[posicao - 1].toString();
		}
		return "POSIÇÃO INVÁLIDA";
	}
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @throws IllegalArgumentException se a posição é inválida ou o telefone é inválido do tipo vazio.
	 * @return Nome completo do contato. String vazia se não há contato na posição.
	 */
	public String getNomeCompleto(int posicao) {
		if (posicao <= 0 || posicao > 100) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				return "";
			}
		} else 
		if (contatos[posicao - 1] == null) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				return "";
			}
		} else 
		if (posicao >= 1 && posicao <= 100) {
			return contatos[posicao - 1].getNomeCompleto();
		}
		else {
			return "";
		}
	}
	
	/**
	* Verifica se o contato é favorito na lista de favoritos. 
	* @param posição índice do contato observado para comparar se a posição contato está na lista de favoritos. 
	* @throws IllegalArgumentException se a posição é inválida ou o telefone é inválido do tipo vazio.
	* @throws NullPointerException se o contato é inválido recebendo null.
	* @return Retorna o emoji caso seja favotito ❤️ e caso não seja é retornado uma String vazia.
	*/
	public String hasFavorito(int posicao) {
		if (posicao > 100 || posicao < 1) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				return "";
			}
		}
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				if (contatos[posicao - 1].getNome().equals(favoritos[i].getNome())                && 
					contatos[posicao - 1].getSobrenome().equals(favoritos[i].getSobrenome())) {
						return  "❤️ ";
				}
			}
		}
		return "";
	}
	
	/**
	 * Remove o contato da lista de contato e da lista de favoritos. 
	 * @param posicao indice do contato a ser removido.
	*/
	public boolean removeContato(int posicao) {
		if (contatos[posicao - 1] != null) {
			if (posicao >= 1 && posicao <= 100) {
				for (int i = 0; i < this.favoritos.length; i++) {
					if (this.favoritos[i] != null) {
						if (this.contatos[posicao - 1].getNome().equals(this.favoritos[i].getNome())         && 
							this.contatos[posicao - 1].getSobrenome().equals(this.favoritos[i].getSobrenome())) {
							this.favoritos[i] = null;
						}
					}
				}
				this.contatos[posicao - 1] = null;
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
	* Cadastra o contato de uma determinada posição da listga de contatos em uma determinada posição da lista de favoritos. 
	* @param posicaoContato índice do contato da lista de contatos.
	* @param indiceFavorito índice da lista de favoritos para que seja armazenada o contato nos favoritos.
	* @throws NullPointerException se o parâmetro recebido for null.
	* @throws IllegalArgumentException Se o parâmetro recebido for String vazia ou posição inválida.
	* @return Retorna o emoji caso seja favotito ❤️ e caso não seja é retornado uma String vazia
	*/
	public void cadastraFavorito(int posicaoContato, int indiceFavorito) {
		if (this.contatos[posicaoContato - 1] != null) {
			if (posicaoContato >= 1 && posicaoContato <= 100 && indiceFavorito >= 1 && indiceFavorito <= 10) {
				if (!existeFavorito(posicaoContato)) {
					this.favoritos[indiceFavorito - 1] = this.contatos[posicaoContato - 1];
					System.out.println( "CONTATO FAVORITADO NA POSIÇÃO " + indiceFavorito + "!");
				}
				else {
					try {
						throw new IllegalArgumentException("JÁ EXISTE NOS FAVORITOS!");
					}
					catch (Exception e) {
						System.out.println("JÁ EXISTE NOS FAVORITOS!");
					}				
				}
			}
			else {
				try {
					throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
				}
				catch (Exception e) {
					System.out.println("POSIÇÃO INVÁLIDA!");
				}		
			}
		}
		else {
			try {
				throw new NullPointerException("CONTATO INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("CONTATO INVÁLIDO!");
			}	
		}
	}

	/**
	* Verifica se o contato já é favorito na lista de favoritos.  
	* @param posição índice do contato observado para comparar se a posição contato está na lista de favoritos. 
	* @return Retorna um booleano se o contato é ou não favorito.
	*/
	public boolean existeFavorito(int posicao) {
		if (contatos[posicao - 1] == null) {
			return false;
		} else
		if (posicao < 0 || posicao > 10) {
			return false;
		}
		else {
			for (int i = 1; i <= favoritos.length; i++) {
				if (favoritos[i - 1] != null) {
					if (favoritos[i - 1].getNome().equals(contatos[posicao - 1].getNome())              && 
						favoritos[i - 1].getSobrenome().equals(contatos[posicao - 1].getSobrenome())) {
							return true;
						}
				}
			}
			return false;
		}
	}
	
	/**
	* Lista todos os contatos favoritos da lista de favoritos. 
	*/
	public void mostrarFavoritos() {
		boolean existeAlgumFavorito = false;
		for (int i = 1; i<= favoritos.length; i++) {
			if (this.favoritos[i - 1] != null) {
				System.out.println((i) + " - " + this.favoritos[i - 1].toString());
				existeAlgumFavorito = true;
			}
		}
		if (!existeAlgumFavorito) {
			System.out.println("NÃO EXISTEM FAVORITOS!");
		}
	}

	/**
	* Remove um contato favorito na lista de favoritos. 
	* @param posicao posição do favorito a ser removido da lista de favoritos.
	* @throws IllegalArgumentException se a posição do contato é inválida.
	*/
	public void removerFavorito(int posicao) {
		if (posicao < 0 || posicao > 10) {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				System.out.println("POSIÇÃO INVÁLIDA!");
			}		
		} else 
		if (this.favoritos[posicao - 1] != null) {
			this.favoritos[posicao - 1] = null;
		}
		else {
			try {
				throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
			}
			catch (Exception e) {
				System.out.println("POSIÇÃO INVÁLIDA!");
			}			
		}
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @throws NullPointerException se o parâmetro recebido for null.
	 * @throws IllegalArgumentException Se o parâmetro recebido for String vazia ou posição inválida.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (nome != null && sobrenome != null && telefone != null) {
			if (posicao >= 1 && posicao <= 100) {
				if (!existeContato(nome, sobrenome)) {
						if (!nome.equals("") && !sobrenome.equals("") && !telefone.equals("")) { 
							this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
							System.out.println("CADASTRO REALIZADO");
						}
						else {
							try {
								throw new IllegalArgumentException("CONTATO VAZIO!");
							}
							catch (Exception e) {
								System.out.println("CONTATO VAZIO!");
							}	
						}
				}
				else {
					try {
						throw new IllegalArgumentException("CONTATO JÁ CADASTRADO!");
					}
					catch (Exception e) {
						System.out.println("CONTATO JÁ CADASTRADO!");
					}	
				}
			}
			else {
				try {
					throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
				}
				catch (Exception e) {
					System.out.println("POSIÇÃO INVÁLIDA!");
				}
			}
		}
		else {
			try {
				throw new NullPointerException("CONTATO INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("CONTATO INVÁLIDO!");
			}
		}
	}
	/**
	* Verifica se o contato existe na lista de contatos. 
	* @param nome nome do contato.
	* @param sobrenome sobrenome do contato.
	* @return Retorna um booleano se o nome e o sobrenome já está contido ou não na lista de contatos. 
	*/
	public boolean existeContato(String nome, String sobrenome) {
		if (nome == null || sobrenome == null) {
			return false;
		}
		else
		if (nome.equals("") || sobrenome.equals("")) {
			return false; 
		}
		else {
			for (int i = 1; i <= contatos.length; i++) {
				if (contatos[i - 1] != null) {
					if (contatos[i - 1].getNome().equals(nome)         && 
						contatos[i - 1].getSobrenome().equals(sobrenome)) {
						return true; 
					}
				}
			}
		return false;
		}
	}

	/**
	 * Faz uma busca na agenda de contatos pelo nome. Além disso ele também mostra o contato favorito.
	 * 
	 * @param nome nome do contato.
	 * @throws IllegalArgumentException se ao nome é vazio.
	 * @throws NullPointerException se o contato é inválido recebendo null.
	 */
	public void listaContatosPorNome(String nome) {
		if (nome != null) {
			if (!nome.equals("")) {
				int encontrados = 0;
				for (int i = 0; i < this.contatos.length; i++) {
					if (this.contatos[i] != null) {
						if (this.contatos[i].getNome().equals(nome)) {
							System.out.println((i + 1) + " - " + hasFavorito(i + 1) + " " + this.contatos[i].getNomeCompleto() + "\n"+ this.contatos[i].getTelefone());
							encontrados ++;
						}
					}
				}
				if (encontrados == 0) {
					try {
						throw new IllegalArgumentException("CONTATO NÃO ENCONTRADO COM ESSE NOME!");
					}
					catch (Exception e) {
						System.out.println("CONTATO NÃO ENCONTRADO COM ESSE NOME!");
					}	
				}
			}
			else {
				try {
					throw new IllegalArgumentException("CONTATO INVÁLIDO!");
				}
				catch (Exception e) {
					System.out.println("CONTATO INVÁLIDO!");
				}	
			}
		}
		else {
			try {
				throw new  NullPointerException("CONTATO INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("CONTATO INVÁLIDO!");
			}	
		}
	}
	
	/**
	 * Faz uma busca na agenda de contatos pelo sobrenome. Além disso ele também mostra o contato favorito. 
	 * 
	 * @param sobrenome sobrenome do contato.
	 * @throws IllegalArgumentException se o sobrenome é do tipo vazio.
	 * @throws NullPointerException se o sobrenome é inválido recebendo null.
	 */
	public void listaContatosPorSobrenome(String sobrenome) {
		if (sobrenome != null) {
			if (!sobrenome.equals("")) {
				int encontrados = 0;
				for (int i = 0; i < this.contatos.length; i++) {
					if (this.contatos[i] != null) {
						if (this.contatos[i].getSobrenome().equals(sobrenome)) {
							System.out.println((i + 1) + " - " + hasFavorito(i + 1) + " " + this.contatos[i].getNomeCompleto() + "\n"+ this.contatos[i].getTelefone());
							encontrados ++;
						}
					}
				}
				if (encontrados == 0) {
					try {
						throw new NullPointerException("CONTATO NÃO ENCONTRADO COM ESSE SOBRENOME!");
					}
					catch (Exception e) {
						System.out.println("CONTATO NÃO ENCONTRADO COM ESSE SOBRENOME!");					
					}
				}
			}
			else {
				try {
					throw new IllegalArgumentException("CONTATO INVÁLIDO!");
				}
				catch (Exception e) {
					System.out.println("CONTATO INVÁLIDO!");					
				}
			}
		}
		else {
			try {
				throw new NullPointerException("CONTATO INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("CONTATO INVÁLIDO!");					
			}
		}
	}
}
