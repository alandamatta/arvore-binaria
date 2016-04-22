package br.edu.ia;

import java.util.List;

public class Teste {

	public static void main(String[] args) {
		Arvore<Integer> a = new Arvore<>();
		a.inserir(12);
		a.inserir(14);
		a.inserir(6);
		a.inserir(11);
		a.inserir(9);
		a.inserir(17);
		a.inserir(6);
		a.inserir(3);
		a.inserir(5);
		a.inserir(13);
		a.inserir(19);
		
		System.out.println(a.toString());
		
	}

}
