package br.edu.ia;

import java.util.ArrayList;

public class BuscaEmLargura<T extends Comparable<T>> {
	
	private ArrayList<No> fila = new ArrayList<No>();

	public void executar(Arvore<T> arvore, T valor) {
		No<T> noRaiz = arvore.getRaiz(); //pega valor da raiz
		No<T> noRaizEsquerda = noRaiz.getEsquerda();
		No<T> noRaizDireita = noRaiz.getDireita();
		System.out.println("ESQUERDA DA RAIZ: " + noRaiz.getEsquerda().getValor());
		fila.add(noRaizEsquerda);
		fila.add(noRaizDireita);
				
		for (int i = 0; i <= arvore.listaArvore().size(); i++) {
			No noAtual = fila.get(i);
			//se o nó atual for o valor procurado **VISITA**
			//fila.remove(i);
			if(noAtual.getValor() == valor){				
				//retornar caminho para raíz
				System.out.println("Valor encontrado. O pai dele é: " + noAtual.getPai().getValor());
				break;
			}
			if(noAtual.getEsquerda() != null){
				fila.add(noAtual.getEsquerda());
			}
			if(noAtual.getDireita() != null){
				fila.add(noAtual.getDireita());
			}
		}
	}
	
}
