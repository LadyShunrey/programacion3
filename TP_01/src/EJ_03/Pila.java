package EJ_03;

import EJ_01.Nodo;

public class Pila<T> {
	
	private Nodo<T> primerNodo;

	//push(T o)
	public void push(T nuevo){
		Nodo<T> nuevoNodo = new Nodo<T>(nuevo, null);
		nuevoNodo.setNext(this.primerNodo);
		this.primerNodo = nuevoNodo;
	}
	
	//pop()
	public void pop(){
		this.primerNodo = this.primerNodo.getNext();
	}
	
	//top()
	public T top(){
		return this.primerNodo.getInfo();
	}
	
	//reverse()
	public void reverse(){
		Nodo<T> head = new Nodo<T>(null, null);
		head = this.primerNodo.getNext();
		Nodo<T> oldNext = new Nodo<T>(null, null);
		oldNext = head.getNext();
		Nodo<T> nuevoUltimoNodo = new Nodo<T>(null, null);
		nuevoUltimoNodo = this.primerNodo;
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
}
