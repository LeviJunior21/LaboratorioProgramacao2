package documin;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Sistema de Documento onde se faz a criação e o armazenamento de elementos.
 * 
 * @author Levi Júnior
 *
 */
public class DocumentoSistema {
	private ArrayList<Elemento> elementos;
	private int tamanho;
	private String titulo;
	private boolean temAtalho;
	
	/**
	 * Constrói o documento com título e tamanho.. 
	 * 
	 * @param titulo titulo do documento.
	 * @param tamanho tamanho do documento. 
	 * @throws IllegalArgumentException Lança um erro quando o tamanho é menor ou igual a 0 e 
	 * o título for inválido. 
	 */
	public DocumentoSistema(String titulo, int tamanho) {
		if (titulo != null) {
			if (!titulo.equals("")) {
				if (!temApenasEspacos(titulo)) {
					if (tamanho > 0) {
						this.elementos = new ArrayList<>();
						this.titulo = titulo;
						this.tamanho = tamanho;
						this.temAtalho = false;
					}
					else {
						throw new IllegalArgumentException("TAMANHO INVÁLIDO");
					}
				}
				else {
					throw new IllegalArgumentException("ERRO: STRING COM APENAS ESPAÇOS!");
				}
			}
			else {
				throw new IllegalArgumentException("ERRO: STRING VAZIA!");
			}
		}
		else {
			throw new IllegalArgumentException("ERRO: STRING NULL!");
		}
	}
	
	/**
	 * Constrói o documento a partir do nome recebido e com tamanho infinito.
	 * 
	 * @param titulo titulo do documento.
	 * @throws IllegalArgumentException Lança um erro quando o título recebido for inválido. 
	 */
	public DocumentoSistema(String titulo) {
		if (titulo != null) {
			if (!titulo.equals("")) {
				if (!temApenasEspacos(titulo)) {
					this.elementos = new ArrayList<>();
					this.titulo = titulo;
					this.tamanho = Integer.MAX_VALUE;
					this.temAtalho = false;
				}
				else {
					throw new IllegalArgumentException("ERRO: STRING COM APENAS ESPAÇOS!");
				}
			}
			else {
				throw new IllegalArgumentException("ERRO: STRING VAZIA!");
			}
		}
		else {
			throw new IllegalArgumentException("ERRO: STRING NULL!");
		}
	}
	
	private boolean temApenasEspacos(String texto) {
		for(String i: texto.split("")) {
			if (i != " ") {
				return false;
			}
		}
		return true;
	}
	
	private boolean atingiuTamanhoLimite() {
		if (this.tamanho == this.elementos.size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Pega o heshCide do titulo do documenro.
	 */
	public int hashCode() {
		return this.titulo.hashCode();
	}
	
	/**
	 * Pega o titulo do documento.
	 * 
	 * @return retorna o título do documento. 
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Verifica se o documento é igual a partir do seu titulo.
	 */
	@SuppressWarnings("unlikely-arg-type")
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else
		if (this.getClass() != obj.getClass()) {
			return false;
		} 
		DocumentoSistema doc = (DocumentoSistema) obj;
		return doc.equals(doc.getTitulo());
	}
	
	/**
	 * Constrói o Texto a partir do valor (string) e a prioridade(int).
	 * 
	 * @param valor valor do Texto.
	 * @param prioridade prioridade do Texto.
	 * @return retorna o índice inteiro onde está armazenado o texto no ArrayList de elementos.
	 */
	public int criarTexto(String valor, int prioridade) {
		if (!atingiuTamanhoLimite()) {
			Elemento texto = new Texto(valor, prioridade);
			this.elementos.add(texto);
			return this.elementos.indexOf(texto) + 1;
		}
		else {
			return -1;
		}
    }
    
	/**
	 * Cria um Titulo a partir do valor(String), prioridade(int), nivel(int) e linkavel(boolean) e armazena na lista de elementos. 
	 * 
	 * @param valor valor do Titulo.
	 * @param prioridade prioridade do Titulo.
	 * @param nivel nivel do Titulo.
	 * @param linkavel diz se o titulo é ou não linkavel.
	 * @return Retorna o indice onde o titulo foi adicionado no ArrayList de elementos. 
	 */
    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
    	if (!atingiuTamanhoLimite()) {
			Elemento titulo = new Titulo(valor, prioridade, nivel, linkavel);
			this.elementos.add(titulo);
			return this.elementos.indexOf(titulo) + 1;
		}
		return -1;
    }
    
    /**
     * Cria uma lista e adiciona ao ArrayList de elementos. 
     * 
     * @param valorLista valor da Lista.
     * @param prioridade prioridade da Lista.
     * @param separador separador do valor da Lista.
     * @param charLista caractere inicial da representacao dos valores da Lista.
     * @return Retorna a posição inteira de onde está alocada a Lista no ArrayList de elementos. 
     */
    public int criarLista(String valorLista, int prioridade, String separador, String charLista) {
		if (!atingiuTamanhoLimite()) {
			Elemento lista = new Lista(valorLista, prioridade, separador, charLista);
			this.elementos.add(lista);
			return this.elementos.indexOf(lista) + 1;
		}
		return -1;
	}
    
    /**
     * Cria um Termo e adiciona no ArrayList de elementos. 
     * 
     * @param valorTermos valores do Termo. 
     * @param prioridade prioridade do Termo.
     * @param separador separador dos valores do Termo.
     * @param ordem ordem da representacao do valor do Termo. 
     * @return Retorna a posição de onde está alocado o Termo no ArrayList de elementos. 
     */
    public int criarTermos(String valorTermos, int prioridade, String separador, String ordem) {
    	if (!atingiuTamanhoLimite()) {
    		Elemento termo = new Termo(valorTermos, prioridade, separador, ordem);
    		this.elementos.add(termo);
    		return this.elementos.indexOf(termo) + 1;
    	}
    	return -1;
   	}
    
    /**
     * Cria um Atalho e adiciona no ArrayList de elementos. 
     * 
     * @param valor valores do Atalho.
     * @param media média do Atalho. 
     * @param representacaoCompleta concatenacao de todas as representações completas do documento. 
     * @param representacaoresumida concatenação de todas as representações resumidas do documento.
     * @return Retorna a posição de onde está alocado o Atalho no ArrayList de elementos. 
     */
    public int criarAtalho(String valor, double media, String representacaoCompleta, String representacaoresumida) {
    	if (!atingiuTamanhoLimite() || !this.temAtalho) {
   			Atalho atalho = new Atalho(valor, media, representacaoCompleta, representacaoresumida);
    		this.elementos.add(atalho);
    		this.temAtalho = true;
    		return this.elementos.indexOf(atalho) + 1;
    	}
    	return -1;
   	}
    
    /**
     * Retorna a representação completa do objeto que implementa a interface Elemento. 
     * @param elementoPosicao posição do elemento.
     * @return Retorna a representação completa do elemento. 
     * @throws NoSuchElementException lança um erro quando não é encontrado o elemento. 
     */
    public String pegarRepresentacaoCompleta(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		return "Posição inválida.";
    	}
    	else {
    		return this.elementos.get(elementoPosicao - 1).gerarRepresentacaoCompleta();
    	}
    }
    
    /**
     * Retorna a representação resumida do objeto que implementa a interface Elemento. 
     * @param elementoPosicao posição do elemento.
     * @return Retorna a representação resumida do elemento. 
     * @throws NoSuchElementException lança um erro quando não é encontrado o elemento. 
     */
    public String pegarRepresentacaoResumida(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		return "Posição inválida.";
    	}
		return this.elementos.get(elementoPosicao - 1).gerarRepresentacaoResumida();
    }
    
    /**
     * Apaga o elemento criado no ArrayList de elementos.
     * 
     * @param elementoPosicaoção do elemento no ArrayList.
     */
    public void apagarElemento(int elementoPosicao) {
    	this.elementos.remove(elementoPosicao - 1);
    }
    
    /**
     * Troca o elemento pelo pela posição inferior a ele.
     * 
     * @param elementoPosicao posição que deseja trocar.
     */
    public void moverParaCima(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		throw new NoSuchElementException("Elemento não encontrado nesta posição.");
    	} else
    	if ((elementoPosicao - 1) > 0 || (elementoPosicao - 1) < this.elementos.size()) {
			Elemento elemento1 = this.elementos.get(elementoPosicao - 1);
			Elemento elemento2 = this.elementos.get(elementoPosicao - 2);
		
			this.elementos.set(elementoPosicao - 2, elemento1);
			this.elementos.set(elementoPosicao - 1, elemento2); 
		}
    }
    
    /**
     * Troca o elemento pelo pela posição superior a ele.
     * 
     * @param elementoPosicao posição que deseja trocar.
     */
    public void moverParaBaixo(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		throw new NoSuchElementException("Elemento não encontrado nesta posição.");
    	} else
        if (elementoPosicao - 1 >= 0 || elementoPosicao - 1 < (this.elementos.size() - 1)) {
			Elemento elemento1 = this.elementos.get(elementoPosicao - 1);
			Elemento elemento2 = this.elementos.get(elementoPosicao);
		
			this.elementos.set(elementoPosicao, elemento1);
			this.elementos.set(elementoPosicao - 1, elemento2);
		}
    }

    /**
     * Conta a quantidade de elementos cadastrados. 
     * @return Retorna a quantidade de elementos cadastrados. 
     */
	public int contarElementos() {
		return this.elementos.size();
	}

	/**
	 * Retorna um array de todas as representações completas cadastradas no ArrayList de elementos.   
	 * 
	 * @return Retorna um array de todas as representações completas cadastradas no ArrayList de elementos. 
	 */
	public String[] exibirDocumento() {
		String[] todasRepresentacoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			todasRepresentacoes[i] = this.elementos.get(i).gerarRepresentacaoCompleta() + "\n\n";
		}
		return todasRepresentacoes;
	}
	
	/**
	 * Retorna a concatenação de todas as representações completas dos elementos com prioridades de tamanho 4 ou 5. 
	 * 
	 * @return Retorna uma String com a concatenação de todas as representações completas dos elementos com prioridades de tamanho 4 ou 5. 
	 */
	public String[] getRepresentacoesCompletas() {
		ArrayList<String> representacao = new ArrayList<>();
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getPrioridade() == 4 || this.elementos.get(i).getPrioridade() == 5) {
				if (this.elementos.get(i) != null) {
					representacao.add(this.elementos.get(i).gerarRepresentacaoCompleta() + "\n");
				}
			}
		}
		
		String[] representacao2 = new String[representacao.size()];
		for (int s = 0; s < representacao.size(); s++) {
			representacao2[s] = representacao.get(s);
		}
		return representacao2;
	}
	
	/**
	 * Retorna a concatenação de todas as representações resumidas dos elementos com prioridades de tamanho 4 ou 5. 
	 * 
	 * @return Retorna uma String com a concatenação de todas as representações resumidas dos elementos com prioridades de tamanho 4 ou 5. 
	 */
	public String[] getRepresentacoesResumidas() {
		ArrayList<String> representacao = new ArrayList<>();
		for (int t = 0; t < this.elementos.size(); t++) {
			if (this.elementos.get(t) != null) {
				representacao.add(this.elementos.get(t).gerarRepresentacaoResumida() + "\n");
			}
		}
		String[] representacao2 = new String[representacao.size()];
		for (int s = 0; s < representacao.size(); s++) {
			representacao2[s] = representacao.get(s);
		}
		
		return representacao2;
	}
	
	/**
	 * Calcula a média com base em todos os elementos cadastrados. 
	 * 
	 * @return Retorna a média sobre todos os elementos cadastrados. 
	 */
	public double calculaMedia() {
		double soma = 0;
		if (this.elementos.size() == 0) {
			return 0;
		}
		for (Elemento elemento: this.elementos) {
			soma += elemento.getPrioridade();
		}
		return soma/this.elementos.size();
	}
	
	/**
	 * Verifica se temAtalho criado.
	 * @return Retorna um valor booleano se há atalho ou não cadastrado no ArrayList de elementos. 
	 */
	public boolean temAtalho() {
		return this.temAtalho;
	}

	/**
	 * Pega todas as representações completas de todos os elementos cadastrados na lista de elementos e retorna a lista.
	 * 
	 * @return Retorna todas as visões de representações completas do documento. 
	 */
	public String[] getVisaoCompleta() {
		String[] visoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			visoes[i] = this.elementos.get(i).gerarRepresentacaoCompleta();
		}
		return visoes;
	}

	/**
	 * Pega todas as representações resumiasde todos os elementos cadastrados na lista de elementos e retorna a lista.
	 * 
	 * @return Retorna todas as visões de representações resumidas do documento. 
	 */
	public String[] getVisaoResumida() {
		String[] visoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			visoes[i] = this.elementos.get(i).gerarRepresentacaoResumida();
		}
		return visoes;
	}

	/**
	 * Pega todas as representações resumdas de todos os elementos Título cadastrados na lista de elementos e retorna a lista.
	 * 
	 * @return Retorna todas as visões de representações completas do documento. 
	 */
	public String[] getVisaoTitulo() {
		ArrayList<String> visoes = new ArrayList<>();
		Titulo titulo = new Titulo(null, 1, 1, true);
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getClass() == (titulo.getClass())) {
				visoes.add(this.elementos.get(i).gerarRepresentacaoResumida());
			}
		}
		String[] visao = new String[visoes.size()];
		for (int v = 0; v < visoes.size(); v++) {
			visao[v] = visoes.get(v);
		}
		return visao;
	}

	/**
	 * Pega todas as representações completas de todos os elementos cadastradosna lisgta a partir da prioridade e retorna a lista.
	 * 
	 * @return Retorna todas as visões de representações completas do documento. 
	 */
	public String[] getVisaoPrioridade(int prioridade) {
		ArrayList<String> prioridades = new ArrayList<>();
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getPrioridade() >= prioridade) {
				prioridades.add(this.elementos.get(i).gerarRepresentacaoCompleta());
			}
		}
		String[] todasPrioridades = new String[prioridades.size()];
		for (int p = 0; p < prioridades.size(); p ++) {
			todasPrioridades[p] = prioridades.get(p);
		}
		return todasPrioridades;
	}
	
 }
