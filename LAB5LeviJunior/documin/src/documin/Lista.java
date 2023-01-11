package documin;

import java.util.HashMap;

/**
  * Lista que implementa a interface Elemento e contém propriedades, prioridade e o valor da Lista. 
 */
public class Lista implements Elemento {
	private HashMap <String, String> propriedades;
    private String valorLista;    
    private int prioridade; 

    /**
     * Constrói a Lista e atribui o valor da lista, prioridade, separador e o caractere da representação da lista. 
     * 
     * @param valorLista Valor da lista.
     * @param prioridade prioridade da Lista.
     * @param separador separador do valor da lista. 
     * @param charLista caractere de inicialização para a representação da Lista. 
     */
    public Lista(String valorLista, int prioridade, String separador, String charLista) {
    	this.propriedades = new HashMap<>();
    	this.propriedades.put("separador", separador);
    	this.propriedades.put("caractereDeLista", charLista);
    	this.valorLista = valorLista;
    	this.prioridade = prioridade;
    }

    /**
     * Gera uma representação completa para a Lista. 
     * 
     * @return Retorna a representação completa da Lista.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
		String representacao = "";
		String[] palavras = valorLista.replace(this.propriedades.get("separador"), ",").split(",");
		for (int i = 0; i < palavras.length; i++) {
			representacao += this.propriedades.get("caractereDeLista") + " " + palavras[i].strip() + "\n";
		}
		return representacao.strip();
	}
	
    /**
     * Gera uma representação resumida para a Lista. 
     * 
     * @return Retorna a representação resumida da Lista.
     */
    @Override
    public String gerarRepresentacaoResumida() {
    	String representacao = "";
		String[] palavras = valorLista.replace(this.propriedades.get("separador"), ",").split(",");
		for (int i = 0; i < palavras.length; i++) {
			if (i == 0) {
				representacao += palavras[i].strip();
			}
			else {
				representacao += ", " + palavras[i].strip();
			}
		}
		return representacao;
	}
	
    /**
     * Pega a prioridade da Lista. 
     * 
     * @return Retorna a prioridade da Lista. 
     */
    @Override
	public int getPrioridade() {
		return this.prioridade;
	}
	
}
