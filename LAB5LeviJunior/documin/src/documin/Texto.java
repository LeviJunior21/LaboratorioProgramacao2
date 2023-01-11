package documin;

import java.util.HashMap;

/**
 * Texto que implementa a interface Elemento e contém propriedades, prioridade e o valor do Texto.  
 * 
 * @author Levi Júnior
 *
 */
public class Texto implements Elemento {
	private String valor; 
	private int prioridade;
	@SuppressWarnings("unused")
	private HashMap<String, String> propriedades;
	
	/**
	 * Constrói o Texto a partir do valor e a prioridade.
	 * 
	 * @param valor valor do Texto.
	 * @param prioridade prioridade do Texto.
	 */
	public Texto(String valor, int prioridade) {
		this.propriedades = new HashMap<>();
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	/**
	 * Gera uma representação completa do Texto.
	 * 
	 *  Retorna uma representação completa do Texto. 
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		return this.valor;
	}
	
	/**
	 * Gera uma representação resumida do Texto.
	 * 
	 * @return Retorna uma representação resumida do Texto. 
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		return this.valor;
	}
	
	/**
	 * Pega a prioridade do Texto. 
	 * 
	 * @return Retorna a prioridade do Texto. 
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
