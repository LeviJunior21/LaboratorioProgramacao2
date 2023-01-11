package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Controlador de Documentos responável por realizar acões em um documento. 
 * 
 * @author Levi Júnior
 *
 */
public class DocumentoController {
	
	private HashMap<String, DocumentoSistema> documentos;
	private ArrayList<String[]> visoes;

	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}
	
	/**
	 * Cria documento de tamanho infinito para seus elementos em um Mapa de documento a partir do seu título.
	 * 
	 * @param tituloDoc Titulo do documento a ser cadastrado.
	 * @return retorna um valor booleano para verificar se foi feito o cadastro do documento. 
	 * Se rotornou true então foi cadastrado. Caso contrário, o documento não foi cadastrado.
	 */
	public boolean criarDocumento(String tituloDoc) {
		if (!this.documentos.containsKey(tituloDoc)) {
			documentos.put(tituloDoc, new DocumentoSistema(tituloDoc));
			this.visoes = new ArrayList<>();
			return true;
		}
		return false;
	}
	
	/**
	 * Cria um documento limitado para seus elementos em uma Mapa de documento a partir do seu título.
	 * 
	 * @param tituloDoc Titulo do documento a ser cadastrado.
	 * @param tamanho tamanho da lista de elemento.
	 * @return Se rotornou true então foi cadastrado. Caso contrário, o documento não foi cadastrado.
	 */
	public boolean criarDocumento(String tituloDoc, int tamanho) {
		if (!this.documentos.containsKey(tituloDoc)) {
			documentos.put(tituloDoc, new DocumentoSistema(tituloDoc, tamanho));
			return true;
		}
		return false;
	}
	
	/**
	 * Remove um documento cadastrado.
	 * 
	 * @param tituloDoc titulo do documento cadastrado para ser removido.
	 */
	public void removerDocumento(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	} 
		this.documentos.remove(tituloDoc);
	}
	
	/**
	 * Cria um atalho que é um documento em documento que ficará armazenado numa lista do sistema.
	 * 
	 * @param tituloDoc Titulo do documento cadastrado.
	 * @param tituloDocReferenciado Titulo do documento cadastrado.
	 * @return retorna a posição do Atalho onde ele está alocado no ArrayList. 
	 * @throws NoSuchElementException lança um erro caso não encontre o documento.
	 * @throws IllegalArgumentException lança um erro caso o documento já tenha um atalho cadastrado ou caractere inválido. 
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if(contemCaractereIndesejavel(tituloDoc) || contemCaractereIndesejavel(tituloDocReferenciado)) {
    		throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	} else
    	if (!existeDocumento(tituloDoc) || !existeDocumento(tituloDocReferenciado)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	} else
    	if (!this.documentos.get(tituloDoc).temAtalho()) {
    		DocumentoSistema doc = this.documentos.get(tituloDocReferenciado);
    		return this.documentos.get(tituloDoc).criarAtalho(
    			doc.getTitulo(), 
    			doc.calculaMedia(),
    			Arrays.toString(doc.getRepresentacoesCompletas()), 
    			Arrays.toString(doc.getRepresentacoesResumidas())
    		);
    	}
    	else {
    		throw new IllegalStateException("O DOCUMENTO JA TEM UM ATALHO");
    	}
    }
    
	/**
	 * Chama o método criarTexto passando titulo (String), valor (String) e prioridade (inteiro) 
	 * para o sistema onde ele é armazenado numa lista de elementos.  
	 * 
	 * @param tituloDoc titulo do elemento Texto.
	 * @param valor valor do elementodocumento texto.
	 * @param prioridade prioridade do elemento Texto.
	 * @return retorna a posicao do elemento Texto na lista.
	 * @throws NoSuchElementException lança um erro caso não encontre o documento.
	 * @throws IllegalArgumentException lança um erro caso o documento já tenha um atalho cadastrado ou caractere inválido. 
	 */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	if(contemCaractereIndesejavel(tituloDoc)) {
    		throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	} else
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	} 
    	return this.documentos.get(tituloDoc).criarTexto(valor, prioridade);
    }
    
    /**
     * Chama o método criarTitulo passando titulo (String), valor (String), prioridade (inteiro) 
	 * nivel (inteiro) e linkavel(booleano) para o sistema onde ele é armazenado numa lista de elementos.
     * 
     * @param tituloDoc titulo do elemento Titulo.
     * @param valor valor do elemento Titulo.
     * @param prioridade prioridade do elemento Titulo.
     * @param nivel nivel do elemento Titulo.
     * @param linkavel valor booleano se o elemento é ou não linkável.
     * @return retorna a posição do elemento na lista.
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
	 * @throws IllegalArgumentException lança um erro caso o documento já tenha um atalho cadastrado ou caractere inválido. 
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	if(contemCaractereIndesejavel(tituloDoc)) {
    		throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	} else
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}   		
    	return this.documentos.get(tituloDoc).criarTitulo(valor, prioridade, nivel, linkavel);
    }
    
    /**
     * Chama o método criarLista passando titulo (String), valorLista (String), prioridade (inteiro) 
	 * separador (String) e charLista(String) para o sistema onde ele é armazenado numa lista de elementos.
     * 
     * @param tituloDoc titulo do elemento Titulo.
     * @param valorLista valor do elemento Titulo.
     * @param prioridade prioridade do elemento Titulo.
     * @param separador do valor do atributo tituloDoc para elemento Titulo.
     * @param charLista caractere para inicializar a lista de valor.
     * @return retorna a posição do elemento na lista.
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
	 * @throws IllegalArgumentException lança um erro caso o documento tenha caractere inválido. 
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	if(contemCaractereIndesejavel(tituloDoc)) {
    		throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	} else
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).criarLista(valorLista, prioridade, separador, charLista);
    }
    
    /**
     * Chama o método criarTermo passando titulo (String), valorTermos (String), prioridade (inteiro) 
	 * separador (String) e ordem(String) para o sistema onde ele é armazenado numa lista de elementos.
     * 
     * @param tituloDoc titulo do elemento Titulo.
     * @param valorLista valor do elemento Titulo.
     * @param prioridade prioridade do elemento Titulo.
     * @param separador do valor do atributo tituloDoc para elemento Titulo.
     * @param ordem ordem a ser impressa nas suas representacoes. 
     * @return retorna a posição do elemento na lista.
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
	 * @throws IllegalArgumentException lança um erro caso o documento tenha caractere inválido. 
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	if(contemCaractereIndesejavel(tituloDoc)) {
    		throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	} else
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).criarTermos(valorTermos, prioridade, separador, ordem);
    }
    
    /**
     * Chama o método pegarRepresentacaoCompleta em um determinado documento cadastrado com uma determinada posição. 
     * 
     * @param tituloDoc titulo do documento cadastrado.
     * @param elementoPosicao posicao do elemento cadastrado.
     * @return retorna uma String da representacaoCompleta do elemento cadastrado no documento. 
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
    	
    }
    
    /**
     * Chama o método pegarRepresentacaoResumida em um determinado documento cadastrado com uma determinada posição. 
     * 
     * @param tituloDoc titulo do documento cadastrado.
     * @param elementoPosicao posicao do elemento cadastrado.
     * @return retorna uma String da representacaoresumida do elemento cadastrado no documento.
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
    }
    
    /**
     * Chama o método que apaga o elemento cadastrado em um documento. 
     * 
     * @param tituloDoc titulo do documento cadastrado.
     * @param elementoPosicao posicao do elemento no documento.
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
     */
    public void apagarElemento(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).apagarElemento(elementoPosicao);
    }
    
    /**
     * Troca o elemento na lista de elementos no documento. 
     * 
     * @param tituloDoc titulo do documento. 
     * @param elementoPosicao posicao do elemento a ser trocado. 
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).moverParaCima(elementoPosicao);
    }
    
    /**
     * Chama o método do documento que troca a posição elemento na lista de elementos no documento. 
     * 
     * @param tituloDoc titulo do documento. 
     * @param elementoPosicao posicao do elemento a ser trocado. 
     * @throws NoSuchElementException lança um erro caso não encontre o documento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).moverParaBaixo(elementoPosicao);
    }

    /**
     * Chama o método pegarRepresentacaoCompleta e retorna todas as representações dos elementos em um documento. 
     * 
     * @param titulo titulo do documento. 
     * @return retorna todas as representações dos elementos no documento. 
     */
	public String[] exibirDocumento(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		return this.documentos.get(tituloDoc).getRepresentacoesCompletas();
	}

	/**
	 * Chama o método contaElementos para retornar a quantidade de elementos cadastrados em um determinado documento.  
	 * 
	 * @param titulo titulo do documento.
	 * @return retorna a quantidade inteira de elementos cadastrados em um documento. 
	 */
	public int contarElementos(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		return this.documentos.get(tituloDoc).contarElementos();
	}
	
    private boolean existeDocumento(String tituloDoc) {
    	return this.documentos.containsKey(tituloDoc);
    }
    
    private boolean contemCaractereIndesejavel(String tituloDoc) {
    	if (tituloDoc.equals("")) {
    		return true;
    	}
    	for (String i: tituloDoc.split("")) {
    		if (!i.equals(" ")) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Cria uma visão completa a partir do titulo do documento e armazena na lista de visões. 
     * 
     * @param tituloDoc título do documento.
     * @return Retorna o índice onde foi adicionado a visão completa. 
     */
	public int criarVisaoCompleta(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoCompleta();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}
	
	/**
     * Cria uma visão resumida a partir do titulo do documento e armazena na lista de visões. 
     * 
     * @param tituloDoc título do documento.
     * @return Retorna o índice onde foi adicionado a visão resumida. 
     */
	public int criarVisaoResumida(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoResumida();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}

	/**
     * Cria uma visão resumida a partir do titulo do documento e armazena na lista de visões. 
     * 
     * @param tituloDoc título do documento.
     * @return Retorna o índice onde foi adicionado a visão do título. 
     */
	public int criarVisaoTitulo(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoTitulo();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}

	/**
     * Cria uma visão completa a partir da prioridade do titulo do documento e armazena na lista de visões. 
     * 
     * @param tituloDoc título do documento.
     * @return Retorna o índice onde foi adicionado a visão prioritária. 
     */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoPrioridade(prioridade);
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}
	
	/**
	 * Exibe uma lista de representações de uma visão a partir do índice da visão.
	 * 
	 * @param visaoId índice da visão do documento.
	 * @return Retorna uma lista das representações de uma visão. 
	 */
	public String[] exibirVisao(int visaoId) {
		return this.visoes.get(visaoId - 1);
	}

}
