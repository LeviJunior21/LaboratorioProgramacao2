package documin;

public class Atalho implements Elemento {
	private String representacaoCompleta;
	private String representacaoResumo;
	private double media;
	@SuppressWarnings("unused")
	private String valor;
	
	/**
	 * Constrói o Atalho para servir de elemento do documento de outro documento. 
	 * 
	 * @param valor texto do atalho.
	 * @param media media de todos elementos cadastrados de outro documento.
	 * @param representacaoCompleta representacao completa de todos os elementos de outro documento.
	 * @param representacaoResumida representacao resumida de todos os elementos de outro documento.
	 */
	public Atalho(String valor, double media, String representacaoCompleta, String representacaoResumida) {
		this.representacaoCompleta = representacaoCompleta;
		this.representacaoResumo = representacaoResumida;
		this.media = media;
		this.valor = valor;
	}

	/**
	 * Retorna a representação completa de todos os elementos de outro documento.
	 * 
	 * @return Retorna a representação completa de todos os elementos de outro documento. 
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		return this.representacaoCompleta;
	}

	/**
	 * Retorna a representação resumida de todos os elementos de outro documento.
	 * 
	 * @return Retorna a representação resumida de todos os elementos de outro documento. 
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		return this.representacaoResumo;
	}

	/**
	 * Retorna a média das prioridades de todos os elementos cadastardos em um documento. 
	 * 
	 * @return retorna a média das prioridades de todos os elementos cadastrados em um documento. 
	 */
	@Override
	public int getPrioridade() {
		return (int) this.media;
	}
	
}
