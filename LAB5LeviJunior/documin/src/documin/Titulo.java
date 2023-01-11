package documin;

import java.util.HashMap;

/**
 * Titulo que implementa a interface Elemento e contém propriedades, prioridade e o valor do Titulo.  
 * 
 * @author Levi Júnior
 *
 */
public class Titulo implements Elemento {
	private HashMap<String, String> propriedades;
	private int prioridade;
	private String valor;
	
	/**
	 * Constrói o Titulo com valor, prioridade, nivel e o booleano linkavel. 
	 * 
	 * @param valor valor do Titulo.
	 * @param prioridade prioridade do Titulo. 
	 * @param nivel nivel do Titulo. 
	 * @param linkavel valor booleano do link Titulo. 
	 */
	public Titulo(String valor, int prioridade,  int nivel, boolean linkavel) {
		this.propriedades = new HashMap<>();
		this.propriedades.put("nivel", Integer.toString(nivel));
		this.propriedades.put("linkavel", linkavel? "true":"false");
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	/**
	 * Pega as propriedades do Titulo. 
	 * @return Retorna as propriedades do Titulo. 
	 */
	public String getPropriedades() {
		String textoPropriedades = "";
		textoPropriedades += this.valor + "\n";
		textoPropriedades += "Nível: " + this.propriedades.get("nivel") + "\n";
		textoPropriedades += "Linkável: " + this.propriedades.get("linkavel") +"\n";
		return textoPropriedades;
	}
	
	/**
	 * Gera uma representação competa do Titulo. 
	 * 
	 * @return Retorna a representação completa dp Titulo. 
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		String representacao = this.propriedades.get("nivel") + ". " + this.valor; 
		if (this.propriedades.get("linkavel").equals("true")) {
			representacao += " -- " + this.propriedades.get("nivel") + "-" + this.valor.replace(" ", "").toUpperCase();
		}
		return representacao;
	}
	
	/**
	 * Gera uma representação resumida do Titulo. 
	 * 
	 * @return Retorna a representação resumida dp Titulo. 
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String representacao = "";
		if (this.propriedades.get("linkavel").equals("true")) {
			representacao += this.propriedades.get("nivel") + ". " + this.valor.split(" ")[0];
		}
		else {
			representacao += this.propriedades.get("nivel") + ". " + this.valor;
		}
		return representacao;
	}
	
	/**
	 * Pega a prioridade do Titulo. 
	 * 
	 * @return Retorna a prioridade do Titulo. 
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

}
