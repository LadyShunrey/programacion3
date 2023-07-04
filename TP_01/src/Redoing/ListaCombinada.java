package Redoing;

import java.util.Iterator;

import Redoing.ListaVinculada;

public class ListaCombinada<T> {
	
	private ListaVinculada<T> lista1;
	private ListaVinculada<T> lista2;
	private ListaVinculada<T> listaCombinada;
	
	public ListaCombinada(ListaVinculada<T> listaA, ListaVinculada<T> listaB){
		this.lista1 = listaA;
		this.lista2 = listaB;
		lista1.ordenarListaDescendente(lista1);
		lista2.ordenarListaDescendente(lista2);
		combinarListas(lista1, lista2);
	}
	
	public void combinarListas(ListaVinculada<T> lista1, ListaVinculada<T> lista2){
		Iterator<T> iterador1 = lista1.iterator();
		Iterator<T> iterador2 = lista2.iterator();
		//iterar lista 1
		//por cada elemento iterar la lista 2 siempre que el elemento sea menor,
		//ahi mover la 1 y volver a iterar la 2
		boolean cortar = false;
		while(iterador1.hasNext()==true){
			cortar = false;
			T nodoActual = iterador1.next();
			while(iterador2.hasNext()==true && cortar == false){
				T nodoComparado = iterador2.next();
				if(nodoActual == nodoComparado){
					listaCombinada.insertFront(nodoComparado);
					//corto si encuentro
					cortar = true;
				}
			}
		}
	}
}
