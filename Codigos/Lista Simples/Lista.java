/**
 * @author pedropbazzo
 * Implementa��o de uma lista simplemeste encadeada.
 * @param <T> Tipo do valor
 */
public class Lista<T extends Comparable<T>> {
	
	/*O atributo primeiro guarda a refer�ncia do primeiro n�. Atrav�s dele podemos chegar a todos
	 * os n�s, sempre pulando para o pr�ximo. */
	private No<T> primeiro;
	
	public void inserirInicio(T  valor) {
		
		//Cria um novo n� com o valor passado
		No<T> novo_no = new No<T>(valor);
		novo_no.inserirProximo(primeiro);
		primeiro = novo_no;
	
	}
	
	public void inserirFinal(T  valor) {
		
		//Cria um novo n� com o valor passado
		No<T> novo_no = new No<T>(valor);
		//No auxiliar fica no inicio
		No<T> aux = primeiro;
		//se a lista estiver vazia
		if(aux == null){
			primeiro = novo_no;
	    //sen�o
		}else{
			//vou at� o final da lista
			while(aux.obterProximo() != null){	
				aux = aux.obterProximo();
			}
			
			aux.inserirProximo(novo_no);
		}
	
	}
	
	
	/**Inserindo um n� em ordem, passando o valor*/
	public void inserir(T  valor) {
		//Cria um novo n� com o valor passado
		No<T> novo_no = new No<T>(valor);
		
		/*Precisamos de dois n�s auxiliares, um para que possamos ligar o novo n� ao seu proximo 
		 * (vou chamar ele de P)e outro para conectar o n� anterior � P ao novo n�*/
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		/*At� que voc� encontre o local correto para n� ser inserido em ordem crescente
		 *v� para o pr�ximo n�. Devemos verificar aqui se j� chegou ao final da lista:
		 auxilia != null
		 */
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo( novo_no.obterValor() )) == -1  )
		{
			//auxiliar2 guarda o valor de auxiliar, antes dele pular para o pr�ximo
			auxiliar2 = auxiliar;
			//pula para o pr�ximo
			auxiliar = auxiliar.obterProximo();
		}
		
		//� o primeiro n�
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
			
		//o n� deve ficar antes do primeiro (� menor que ele)
		}else if(auxiliar == this.primeiro) {
			
			novo_no.inserirProximo(this.primeiro);
			this.primeiro = novo_no;
			
		//o n� deve ficar ap�s o primeiro
		}else {
			//liga o novo no ao P
			novo_no.inserirProximo(auxiliar);
			//liga o n� anteror � P ao novo n�
			auxiliar2.inserirProximo(novo_no);	
		}
	
	}
	
	/**Remove um n� no inicio*/
	public No<T> removerInicio() {
		No<T> aux = primeiro;
		primeiro = primeiro.obterProximo();
		return aux;
	}
	
	/**Remove um n� no final*/
	public No<T> removerFinal() {
		No<T> aux = primeiro;
		if(aux == null){
			System.out.println("Lista vazia");
			return null;
	    //sen�o
		}else{
			//vou at� o final da lista
			while(aux.obterProximo().obterProximo() != null){	
				aux = aux.obterProximo();
			}
			No<T> aux2 = aux.obterProximo();
			aux.inserirProximo(null);
			
			return aux2;
		}
	}
	
	
	
	/**Remove um n�, passando o valor*/
	public No<T> remover(T valor) {
		
		/*Precisamos de dois n�s auxiliares, um para que possamos ligar o novo n� ao seu proximo 
		 * (vou chamar ele de P)e outro para conectar o n� anterior � P ao novo n�*/
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		/*At� que voc� encontre o local correto para n� ser removido v� para o pr�ximo n�. 
		 Devemos verificar aqui se j� chegou ao final da lista: auxiliar != null
		 */
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			//auxiliar2 guarda o valor de auxiliar, antes dele pular para o pr�ximo
			auxiliar2 = auxiliar;
			//pula para o pr�ximo
			auxiliar = auxiliar.obterProximo();
		}
		
		//se o n� a ser removido for o primeiro
		if(auxiliar == this.primeiro) {
			
			No retorno = this.primeiro;
			this.primeiro = this.primeiro.obterProximo();
			return retorno;
		
		//remove o n� da lista, ligando o n� anterior ao pr�ximo do n� achado
		}else if(auxiliar != null)
			auxiliar2.inserirProximo(auxiliar.obterProximo());
	
		//retorna o n� (null ou o n� achado)
		return auxiliar;
		
	}
	
	/**Buscar um n�, passando o valor*/
	public No<T> buscar(T valor) {
		/*Precisamos de apenas um n�s auxiliar para chegar at� o n� desejado*/
		No<T> auxiliar = primeiro;
		 
		
		/*At� que voc� encontre o n� v� para o pr�ximo n�. Devemos verificar aqui se j� chegou ao final da lista:
		 auxilia != null*/
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			//pula para o pr�ximo
			auxiliar = auxiliar.obterProximo();
		}
		
	
		//retorna o n� (null ou o n� achado)
		return auxiliar;
	}
	
	//m�todo toString para exibir a lista
	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			//incrementa o valor
			s+= auxiliar.obterValor().toString() + " - ";
			//pula para o pr�ximo
			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}
