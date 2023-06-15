package EJ_05;

import java.util.Iterator;

import EJ_01.Nodo;

public class ListaIterable<T> implements Iterable<T>{
	
	private Nodo<T> primerNodo;
	
	public ListaIterable(){
		primerNodo = null;
	}

	@Override
	public Iterator<T> iterator(){
		IteradorLista iterador = new IteradorLista();
		return iterador;
	}
	
	private class IteradorLista implements Iterator<T>{
		private Nodo<T> nodoActual;
		
		public IteradorLista(){
			nodoActual = primerNodo;
		}
		
		@Override
		public boolean hasNext(){
			if(nodoActual!=null){
				return true;
			}
			return false;
		}
		
		@Override
		public T next(){
			T contenidoNodo = nodoActual.getInfo();
			nodoActual = nodoActual.getNext();
			return contenidoNodo;
		}
		
	}
}

//Existe alguna ventaja computacional a la hora de recorrer
//la lista de principio a fin si se cuenta con un iterador?

//No hay ninguna ventaja ya que sigue recorriendo la Lista de principio a fin.
//Sigue siendo O(n)
