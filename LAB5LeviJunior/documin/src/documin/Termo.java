package documin;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Termo que implementa a interface Elemento e contém propriedades, prioridade e o valor do Titulo.  
 * 
 * @author Levi Júnior
 *
 */
public class Termo implements Elemento {
	private HashMap<String, String> propriedades;
	private int prioridade;
	private String valor;
	@SuppressWarnings("unused")
	private String separador;
	
	/**
	 * Constrói o Termo com valor, prioridade, separador do valor e ordem para as represnetações dp Termo. 
	 * 
	 * @param valor valor do Termo.
	 * @param prioridade prioridade do Termo.
	 * @param separador separador do valor do Termo.
	 * @param ordem ordem do Termo. 
	 */
	public Termo(String valor, int prioridade, String separador, String ordem) {
		this.propriedades = new HashMap<>();
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades.put("separador", separador);
		this.propriedades.put("ordem", ordem);
	}
	
	/**
	 * Gera a representação completa do Termo de acordo com a ordem para o valor.
	 * 
	 *  @return Retorna a representação completa dp Termo. 
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		if (this.propriedades.get("ordem").equals("ALFABÉTICA")) {
			return OrdenaPorOrdemAlfabetica();
		} else
		if (this.propriedades.get("ordem").equals("NENHUM")) {
			return semOrdemAlfabetica();
		}
		return "ORDEM NÃO ENCONTRADA!";
	}

	private String semOrdemAlfabetica() {
		String[] palavras = valor.split(this.propriedades.get("separador"));
		for (int indice = 0; indice < palavras.length; indice ++) {
			palavras[indice] = palavras[indice].strip();
		};
		String representacao = "Total termos: " + palavras.length + "\n- ";
		String representacao2 = "";
		for (int i = 0; i < palavras.length; i++) {
			if (i != palavras.length - 1) {
				representacao2 += palavras[i] + ", ";
			}
			else {
				representacao2 += palavras[i];
			}
		}
		return representacao + representacao2.strip();
	}
	
	private String OrdenaPorOrdemAlfabetica() {
		String[] palavras = valor.split(this.propriedades.get("separador"));
		for (int indice = 0; indice < palavras.length; indice ++) {
			palavras[indice] = palavras[indice].strip();
		};
		Arrays.sort(palavras);
		String representacao = "Total termos: " + palavras.length + "\n- ";
		String representacao2 = "";
		for (int i = 0; i < palavras.length; i++) {
			if (i != palavras.length - 1) {
				representacao2 += palavras[i] + ", ";
			}
			else {
				representacao2 += palavras[i];
			}
		}
		return representacao + representacao2.strip();
	}
	
	/**
	 * Gera a representação resumida do Termo de acordo com a ordem para o valor.
	 * 
	 *  @return Retorna a representação resumida dp Termo. 
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String[] palavras = valor.split(this.propriedades.get("separador"));
		for (int indice = 0; indice < palavras.length; indice ++) {
			palavras[indice] = palavras[indice].strip();
		}
		if (this.propriedades.get("ordem").equals("NENHUM")) {
			palavras = valor.replace(" ", "").split(this.propriedades.get("separador"));
		} else
		if (this.propriedades.get("ordem").equals("ALFABÉTICA")) {
			Arrays.sort(palavras);
		} else
		if (this.propriedades.get("ordem").equals("TAMANHO")) {
			palavras = ordenarPalavrasTamanho(palavras);
		}
		
		
		String representacao = "";
		for (int i = 0; i < palavras.length; i++) {
			if (i != palavras.length - 1) {
				representacao += palavras[i] + " " + this.propriedades.get("separador") + " ";
			}
			else {
				representacao += palavras[i];
			}
		}
		return representacao.strip();
	}
	
	private String[] ordenarPalavrasTamanho(String[] palavra) {
		String[] palavras = palavra;
	    for (int x = 0; x < palavras.length; x ++) {
	    	for (int i = palavras.length - 1; i > 0; i --) {
	    		String atual = palavras[i];
	    		String anterior = palavras[i - 1];
	    		if (atual.length() > anterior.length()) {
	    			palavras[i - 1] = atual;
	    			palavras[i] = anterior;
	    		}
	    	}
	    }
		return palavras;
	}

	/**
	 * Pega a prioridade do Termo. 
	 * 
	 * @return Retorna a prioridade do Termo. 
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

}
