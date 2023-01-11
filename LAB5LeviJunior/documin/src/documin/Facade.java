package documin;

/**
 * Facade faz a ação para o controlador. 
 * 
 * @author Levi Júnior
 *
 */
public class Facade {

    private DocumentoController documentoController;

    /**
     * Constrói o Facade e inicializa documento controller. 
     * 
     */
    public Facade() {
        this.documentoController = new DocumentoController();
    }

    /**
     * Faz uma ação para o documento controller para criar um documento e adicionar no Mapa de documentos a partir do seu titulo. 
     *  
     * @param titulo titulo do documento. 
     * @return Retorna um valor booleano se foi possível instaciar ou não um documento. 
     */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    
    /**
     * Faz uma ação para o documento controller para criar um documento e adicionar no Mapa de documentos a partir do seu título e seu tamanho.  
     * 
     * @param titulo titulo do documento.
     * @param tamanho tamanho dos elementos em um documento. 
     * @return retorna um valor booleano se foi possível criar o documento no Mapa de documentos do controlador. 
     */
    public boolean criarDocumento(String titulo, int tamanho) {
        return this.documentoController.criarDocumento(titulo, tamanho);
    }
    
    /**
     * Faz uma ação para o documento controller fazer uma ação no sistema de criar um Atalho e adiciona-lo no ArrayList de elementos.
     * O atalho é uma referencia de um outro documento criado.     
     * 
     * @param tituloDoc titulo do documento.
     * @param tituloDocReferenciado titulo de outro documento. 
     * @return Retorna o índice sobre a posição em que o Atalho foi adicionado no ArrayLisyt de elementos.  
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    /**
     * Faz uma ação para o documento controller fazer uma ação no sistema de criar um Texto e adiciona-lo no ArrayList de elementos.
     * 
     * @param tituloDoc titulo do documento.  
     * @param valor valor do documento. 
     * @param prioridade prioridade do documeto. 
     * @return Retorna o índice sobre a posição em que o Texto foi adicionado no ArrayLisyt de elementos. 
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
    }

    /** 
     * Faz uma ação para o documento controller fazer uma ação no sistema de criar um Titulo e adiciona-lo no ArrayList de elementos.
     * 
     * @param tituloDoc titulo do documento.  
     * @param valor valor do documento. 
     * @param prioridade prioridade do documeto. 
     * @param nivel nivel do documento. 
     * @param linkavel valor booleano sobre se o Titulo é linkavel. 
     * @return Retorna o índice sobre a posição em que o Titulo foi adicionado no ArrayLisyt de elementos. 
     */ 
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
    /**
     * Faz uma ação para o documento controller fazer uma ação no sistema de criar uma Lista e adiciona-lo no ArrayList de elementos.
     * 
     * @param tituloDoc titulo do documento.  
     * @param valor valor do documento. 
     * @param prioridade prioridade do documeto. 
     * @param separador separador do valor do documento. 
     * @param charLista caractere para iniciatilizar as linhas do valor. 
     * @return Retorna o índice sobre a posição em que a Lista foi adicionado no ArrayLisyt de elementos. 
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
    /**
     * Faz uma ação para o documento controller fazer uma ação no sistema de criar um Termo e adiciona-lo no ArrayList de elementos.
     * 
     * @param tituloDoc titulo do documento.  
     * @param valor valor do documento. 
     * @param prioridade prioridade do documeto. 
     * @param separador separador do valor do documento. 
     * @param ordem ordem em que a representacao será exibida. 
     * @return Retorna o índice sobre a posição em que o Termo foi adicionado no ArrayLisyt de elementos. 
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
    /**
     * Faz uma ação no documento controller para acessar o documento e a partir dele pegar
     * o elemento e chamar a representacao completa dp documeno na ArrayList de elementos.    
     * 
     * @param tituloDoc titulo do documento.
     * @param elementoPosicao posicao do elemento. 
     * @return Retorna a representação completa de um elemento cadastrado no sistema de documento. 
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }
    
    /**
     * Faz uma ação no documento controller para acessar o documento e a partir dele pegar
     * o elemento e chamar a representacao resumida dp documeno na ArrayList de elementos.    
     * 
     * @param tituloDoc titulo do documento.
     * @param elementoPosicao posicao do elemento. 
     * @return Retorna a representação resumida de um elemento cadastrado no sistema de documento. 
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    
    /**
     * Faz uma ação no controlador para acessar um documento pelo nome para chamar o método que apaga
     * um elemento cadastrado no ArrayList de documento. 
     * 
     * @param tituloDoc titulo do documento. 
     * @param elementoPosicao posicao do elemento cadastrado no sistema.  
     */
    public void apagarElemento(String tituloDoc, int elementoPosicao) {
    	this.documentoController.apagarElemento(tituloDoc, elementoPosicao); 
    }
    
    /**
     * Faz uma ação no controlador de documentos para que o um determinado sistema troque o elemento 
     * em uma determinada posição por uma posição inferior a ele. 
     * 
     * @param tituloDoc título do documento. 
     * @param elementoPosicao posição. 
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }
    
    /**
     * Faz uma ação no controlador de documentos para que o um determinado sistema troque o elemento 
     * em uma determinada posição por uma posição sucessor a ele. 
     * 
     * @param tituloDoc título do documento. 
     * @param elementoPosicao posição. 
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    
    /**
     * Faz uma ação para o contolador remover um documento cadastrado no controlador. 
     * 
     * @param titulo título do documento.
     */
    public void removerDocumento(String titulo) {
    	this.documentoController.removerDocumento(titulo);
    }
    
    /**
     * Faz uma ação para o controlador para acessar um detrminado documento para 
     * que possa contar o número de elementos cadastrados nele. 
     * 
     * @param titulo título do documento. 
     * @return Retorna a quantidade de elementos cadastrados em um documento. 
     */
    public int contarElementos(String titulo) {
    	return this.documentoController.contarElementos(titulo);
    }
    
    /**
     * Faz uma ação no controlador para acessar um determinado documento para que este retorne todas
     * as representaçoes completas e resumidas dos elementos caastrados. 
     * 
     * @param titulo titulo do documento. 
     * @return Retorna um array de todas as representações completas e resumidas de todos os elementos. 
     */
    public String[] exibirDocumento(String titulo) {
    	return this.documentoController.exibirDocumento(titulo);
    }
    
    /**
     * Cria uma visão completa de todos os documentos a partir dos elemetos de um documento.
     * 
     * @param tituloDoc título do documento.
     * @return Retorna a posição que está contida a visão. 
     */
    public int criarVisaoCompleta(String tituloDoc) {
		return this.documentoController.criarVisaoCompleta(tituloDoc);
    }
    
    /**
     * Cria uma visão resumida de todos os documentos a partir dos elementos de um documento.
     * 
     * @param tituloDoc título do documento.
     * @return Retorna a posição que está contida a visão. 
     */
    public int criarVisaoResumida(String tituloDoc) {
    	return this.documentoController.criarVisaoResumida(tituloDoc);
    }
    
    /**
     * Cria uma visão completa de todos os documentos a partir da prioridade dos elementos de um documento.
     * 
     * @param tituloDoc título do documento.
     * @return Retorna a posição que está contida a visão. 
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    
    /**
     * Cria uma visão resumida de todos os documentos do tipo Titulo a partir de um documento.
     * 
     * @param tituloDoc título do documento.
     * @return Retorna a posição que está contida a visão. 
     */
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.documentoController.criarVisaoTitulo(tituloDoc);
    }
    
    /**
     * Exibe a visão cadastradas a partir de um indice de visao. 
     * 
     * @param visaoId índice da visão.
     * @return Retorna uma lista de visão cadastrada. 
     */
    public String[] exibirVisao(int visaoId) {
    	return this.documentoController.exibirVisao(visaoId);
    }
}
