package br.edu.ia;

public class No<T extends Comparable<T>> implements Comparable<T> {

	T valor; //valor do nó
	No<T> esquerda; //nó da esquerda
	No<T> direita; //nó da direita
	No<T> pai; //nó pai, assim podemos ver a árvore de baixo p/ cima
	
	
	//Construtor
	No(T valor){
		this.valor = valor;
		esquerda = null;
		direita = null;
		pai = null;
	}
	
	No(T valor, No<T> pai){
		this.valor = valor;
		direita = null;
		esquerda = null;
		this.pai = pai;
	}
	
	//getters e setters
	
	
	
	@Override
	public int compareTo(T o) {
		return valor.compareTo(o);
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public No<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<T> esquerda) {
		this.esquerda = esquerda;
	}

	public No<T> getDireita() {
		return direita;
	}

	public void setDireita(No<T> direita) {
		this.direita = direita;
	}

	public No<T> getPai() {
		return pai;
	}

	public void setPai(No<T> pai) {
		this.pai = pai;
	}
}
