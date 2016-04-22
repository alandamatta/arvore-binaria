package br.edu.ia;

import java.util.ArrayList;
import java.util.List;

public class Arvore<T extends Comparable<T>> {
	
	private No<T> raiz;
	
	
	//cria árvore vazia
	Arvore(){
		this.raiz = null;
	}
	
	//cria árvore nova (add nó raiz)
	Arvore(No<T> raiz){
		this.raiz = raiz;
	}
	
	public No<T> getRaiz() {
		return raiz;
	}
	
	public No<T> inserir(T valor){
		No<T> no = new No<>(valor);
		
		if(raiz == null){
			raiz = no;
			return no;
		}else{
			//arvore que estiver vazia deve inserir o nó no local correto
			return inserir(no, raiz);
		}
	}

	
	//metodo para localizar a posição que deverá inserir o nó --> recursividade
	private No<T> inserir(No<T> no, No<T> raizDaSubArvore) {
		if(raizDaSubArvore.compareTo(no.getValor()) >= 0){
			//menor que raiz, então insere a esquerda dela
			No<T> esquerda = raizDaSubArvore.getEsquerda();
			if(esquerda == null){
				raizDaSubArvore.setEsquerda(no);
				no.setPai(raizDaSubArvore);
			}else{
				return inserir(no, esquerda);//verifica mais à esquerda
			}
		}else{
			//maior que raiz, então insere a direita dela
			No<T> direita = raizDaSubArvore.getDireita();
			if(direita == null ){
				raizDaSubArvore.setDireita(no);
				no.setPai(raizDaSubArvore);
			}else{
				return inserir(no, direita);//verifica mais à direita
			}
		}
		return no; //nó inserido
	}
	
	private ArrayList<T> retornaLista(No<T> no){
		if(no == null){
			return new ArrayList<T>(); //lista vazia
		}else{
			//
			ArrayList<T> lista = retornaLista(no.getEsquerda());
			lista.add(no.getValor());
			lista.addAll(retornaLista(no.getDireita()));
			return lista;
		}
	}
	
	//pesquisa com recursividade
	@Override
	public String toString() {
		ArrayList<T> lista = retornaLista(raiz);
		String saida = "";
		for(T item : lista) saida += item + "-";
		return saida;
	}
	
	public No<T> pesquisar(T valor){
		if(raiz == null){
			return null;
		}else{
			return pesquisar(valor, raiz);
		}
	}
	
	private No<T> pesquisar(T valor, No<T> raizSubArvore){
		int compara = raizSubArvore.compareTo(valor);
		if(compara == 0){
			//valor encontrado
			return raizSubArvore;
		}else if(compara > 0){
			return pesquisar(valor, raizSubArvore.getEsquerda());
		}else{
			return pesquisar(valor, raizSubArvore.getDireita());
		}
	}
	
	public ArrayList<T> listaArvore(){
		return retornaLista(raiz);
	}
}
