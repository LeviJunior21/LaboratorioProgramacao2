package agenda;

/**
 * Contato onde, o contato possui nome, sobrenome e telefone.
 * 
 * @author LeviJunior
 *
 */
public class Contato {
	/**
	 * Nome do contato.
	*/
	private String nome;
	/**
	 * SObrenome do contato.
	*/
	private String sobrenome;
	/**
	 * Telefone do contato.
	*/
	private String telefone;
	
	/**
	* Constrói o contato com some, sobrenome e o telefone do usuário.
	* @param nome nome do contato.
	* @param sobrenome sobrenome do contato.
	* @param telefone telefone do contato criado.
	* @throws NullPointerException se o parâmetro recebido for null.
	* @throws IllegalArgumentException Se o parâmetro recebido for String vazia ou posição inválida.
	*/ 
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome != null && sobrenome != null && telefone != null ) {
			if (!nome.equals("") && !sobrenome.equals("") && !telefone.equals("")) {
				this.nome = nome;
				this.sobrenome = sobrenome; 
				this.telefone = telefone;
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
	
	/**
	* Retorna o contato formatado com nome, sobrenome e telefone. 
	* @return Retorna o nome contato formatadoo com nome, sobrenome e telefone. 
	*/
	public String toString() {
		return nome + " " + sobrenome + "\n" + telefone;
	}
	
	/**
	* Retorna o nome do contato. 
	* @return Retorna o nome do contato criado.
	*/
	public String getNome() {
		return this.nome;
	}
	
	/**
	* Retorna o sobrenome do contato. 
	* @return Retorna o sobrenome do contato criado.
	*/
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	* Retorna o número do telefone. 
	* @return Retorna o telefone do contato criado.
	*/
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	* Retorna o nome completo. 
	* @return Retorna o nome completo do contato.
	*/
	public String getNomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
	
	/**
	* Troca o número do telefone.
	* @param telefone novo telefone do contato.
	* @throws IllegalArgumentException se o telefone é vazio.
	* @throws NullPointerException se o telefone é do tipo null. 
	*/
	public void setTelefone(String telefone) {
		if (telefone != null) {
			if (!telefone.equals("")) {
				this.telefone = telefone;
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
				throw new NullPointerException("TELEFONE INVÁLIDO!");
			}
			catch (Exception e) {
				System.out.println("TELEFONE INVÁLIDO!");
			}
		}
	}
}
