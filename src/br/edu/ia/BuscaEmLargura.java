package br.edu.ia;

import java.util.ArrayList;
import java.util.List;

public class BuscaEmLargura<T extends Comparable<T>> {
	
	private List<No> fila = new ArrayList<>();

	public void executar(Arvore<T> arvore, T valor) {
		No<T> noRaiz = arvore.getRaiz(); //pega valor da raiz
		No<T> noRaizEsquerda = noRaiz.getEsquerda();
		No<T> noRaizDireita = noRaiz.getDireita();
		
		fila.add(noRaizEsquerda);
		fila.add(noRaizDireita);
				
		for (int i = 0; i < arvore.listaArvore().size(); i++) {
			No<T> noAtual = (No<T>) fila.get(i);
			//se o nó atual for o valor procurado **VISITA**
			//fila.remove(i);
			if(noAtual.getValor() == valor){				
				//retornar caminho para raíz
				System.out.println("Valor encontrado. O pai dele é: " + noAtual.getPai().getValor());
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
