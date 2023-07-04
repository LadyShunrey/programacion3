package Redoing;

import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T>{
	
	private Nodo<T> primerNodo;
	private int size;

	//insertFront
	public void insertFront(T nuevoNodo){
		Nodo<T> temporal = new Nodo<T> (nuevoNodo, null);
		temporal.setNext(this.primerNodo);
		this.primerNodo = temporal;
	}
	
	//extractFront
	public Nodo<T> extractFront(){
		return this.primerNodo;
	}
	
	//isEmpty
	public boolean isEmpty(){
		if(this.primerNodo == null){
			return true;
		}
		return false;
	}
	
	//size
	public int getSize(){
		return this.size;
	}
	
	//toString
	@Override
	public String toString(){
		String result = "Esta lista tiene estos nodos: \n";
		if(isEmpty()){
			result += "Está vacía";
		}
		if(!isEmpty()){
			result += primerNodo.getInfo();
			Nodo<T> head = new Nodo<T>(null, null);
			head = this.primerNodo;
			while(head.getNext()!=null){
				result += head.getInfo();
				head = head.getNext();
			}
		}
		return result;
	}
	
	//Tget(index)
	public T get(int index){
		int posicion = 0;
		Nodo<T>head = new Nodo<T>(null, null);
		head = this.primerNodo;
		while(head.getNext()!=null){
			if(posicion == index){
				return head.getInfo();
			}
			head = head.getNext();
		}
		return null;
	}
	
	//ordenar lista del punto EJ_06
	public void ordenarListaDescendente(ListaVinculada<T> listaParaOrdenar){
		Nodo<T> head = new Nodo<T>(null, null);
		head = listaParaOrdenar.primerNodo.getNext();
		Nodo<T> oldNext = new Nodo<T>(null, null);
		oldNext = head.getNext();
		Nodo<T> nuevoUltimoNodo = new Nodo<T>(null, null);
		nuevoUltimoNodo = listaParaOrdenar.primerNodo;
		nuevoUltimoNodo.setNext(null);
		Nodo<T> nodoAnterior = new Nodo<T>(null, null);
		nodoAnterior = nuevoUltimoNodo;
		while(oldNext != null){
			head.setNext(nodoAnterior);
			nodoAnterior = head;
			head = oldNext;
			oldNext = head.getNext();
		}
		head.setNext(nodoAnterior);
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

