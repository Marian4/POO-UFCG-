package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		Contato contato = this.contatos[posicao];
		if(contato == null){
			return "Posição inválida!";
		}
		else{
			if (contatoInFavs(posicao)){
				return "\n<3 "+this.contatos[posicao].getDados();
			}
			else{
				return "\n"+this.contatos[posicao].getDados();
			}
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao<1 || posicao>100){
			return "Posição inválida!";
		}
		Contato contato = new Contato(posicao, nome, sobrenome, telefone);
		for (int i=0; i<this.contatos.length; i++){
			if(this.contatos[i] != null && this.contatos[i].getNome().equals(contato.getNome())){
				return "Contato já existente";
			}
		}
		this.contatos[posicao] = contato;
		return "Contato cadastrado com sucesso!";
	}

	public Contato[] getFavs(){
		return this.favoritos;
	}

	public String addFav(int posicaoContato, int posicaoFav){
		if (contatoInFavs(posicaoContato)){
			return "Este contato já foi favoritado.";
		}
		this.favoritos[posicaoFav] = this.contatos[posicaoContato];
		return "Favorito adicionado com sucesso";
	}

	public boolean contatoInFavs(int posicaoContato){
		for (int i=0; i<this.favoritos.length; i++){
			if (this.favoritos[i] != null && this.favoritos[i].equals(this.contatos[posicaoContato])){
				return true;
			}
		}
		return false;
	}

	public void addTag(int posicaoContato, int posicaoTag, String tag){
		this.contatos[posicaoContato].setTags(posicaoTag, tag);
	}

}
