package Estacionamento;
import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	
	Fila() {
		
		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	public void enfileirar(E item) {
		
		Celula<E> novaCelula = new Celula<E>(item);
		
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
	}
	
	public E desenfileirar() {
		
		E item = null;
		Celula<E> primeiro;
		
		item = consultarPrimeiro();
		
		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());
		
		primeiro.setProximo(null);
			
		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras)
			tras = frente;
		
		return item;
	}
	
	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na fila!");
		}

		return frente.getProximo().getItem();

	}
	
	public void imprimir() {
		
		Celula<E> aux;
		
		if (vazia())
			System.out.println("A fila está vazia!");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		} 	
	}
// 1. Implemente um método que concatene duas filas de elementos do tipo E.
	public void concatenar(Fila<E> fila){
		
		Celula<E> celulaAuxiliar = fila.tras.getAnterior();

		while(celulaAuxiliar != frente){
			enfileirar(celulaAuxiliar.getItem());
			celulaAuxiliar = celulaAuxiliar.getProximo();
		}
	}

// 2. 
	public int obterNumeroItens() {
		int tamanho = 0;
		Celula<E> aux = tras;
		 while(aux != frente){
			tamanho++;
			aux = aux.getAnterior();
		 }
		 return tamanho;
	}

// 3 
	public boolean verificarExistencia(E item){
		Celula<E> aux = tras;
		boolean existe = false;

		while(aux != frente){
			if(item == aux.getItem()){
				existe = true;
			}else{
				aux = aux.getAnterior();
			}
		}

		return existe;
	}

// 4
	public int obterNumItensAFrente(E item) throws Exception{
		if(verificarExistencia(item)){
			int numItens = 0;
			Celula<E> aux = tras;
			while(aux != frente){
				if(item == aux.getItem()){
					break;
				}else{
					numItens++;
					aux = aux.getAnterior();
				}
			}
			return numItens;

		}else{
			throw new Exception("Item não encontrado na fila");
		}
	}

// 5 
	public Fila<E> copiar(){
		try{
			Fila<E> filaCopia = new Fila<E>();
			Celula<E> aux = frente;
			while(aux != tras){
				filaCopia.enfileirar(aux..getProximo().getItem());
				aux = aux.getProximo();
			}
			return filaCopia;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
