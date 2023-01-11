package documin;

/**
 * Interface Elemento 
 * 
 * @author Levi Júnior 
 *
 */
public interface Elemento {

	/**
	 * Gera uma representação completa do documento. 
	 * 
	 * @return Retorna uma String com a representação completa do documento. 
	 */
	public String gerarRepresentacaoCompleta();
	
	/**
	 * Gera uma representação resumida do documento. 
	 * 
	 * @return Retorna uma String com a representação resumida do documento. 
	 */
	public String gerarRepresentacaoResumida();
	
	/**
	 * Pega a prioridade do documento cadastrado. 
	 * 
	 * @return Retorna um inteiro representando a prioridade do docuemento. 
	 */
	public int getPrioridade();
}
