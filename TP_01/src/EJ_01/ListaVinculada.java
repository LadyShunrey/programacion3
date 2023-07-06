package EJ_01;

import java.util.Iterator;

//import java.util.Iterator;

/*Hacer lo métodos:
 * - insertFront
 * - extractFront
 * - isEmpty
 * - size
 * - toString
 * - T get(index)
 * */
public class ListaVinculada<T> implements Iterable<T>{
	
	private Nodo<T> primerNodo;
	protected int size;

	public ListaVinculada(){
		this.primerNodo = null;
		this.size = 0;
	}
	
	//insertFront
	public void insertFront(Nodo<T> nodoNuevo){
		Nodo<T> nuevo = new Nodo<>(nodoNuevo.getInfo(), nodoNuevo.getNext());
		if(primerNodo!=null){
			nuevo.setNext(primerNodo);
		}	
		primerNodo = nuevo;
		size++;
	}
	
	//extractFront
	public T extractFront(){
		T elementoEliminado = null;
		if(!isEmpty()){
			Nodo<T> paraEliminar = primerNodo;
			primerNodo = primerNodo.getNext();
			elementoEliminado = paraEliminar.getInfo();
			size--;	
		}
		
		return elementoEliminado;
	}
	
	//isEmpty
	public boolean isEmpty(){
		return primerNodo==null;
	}
	
	//size
	public int size(){
		return this.size;
	}
	
	//toString
	@Override
	public String toString(){
		String result;
		result = "Mi lista tiene estos elementos: ";
//		Iterator<T> iteradorLista = this.iterator();
		Nodo<T> head = primerNodo;
		if(primerNodo!=null){
			result += "[" + primerNodo.getInfo() + "]";
			while(head.getNext()!=null){
				head = head.getNext();
				result += ", ["+head.getInfo() + "]";	
			}	
		}
		return result +=".";
	}
	
	//T get(index)
	public T get(int index){
		T elementoARetornar = null;
		int posicion = -1;
		Nodo<T> head = primerNodo;
		if(index<=size()){
			while(posicion!=index && head!=null){
				posicion++;
				if(posicion==index){
					return head.getInfo();
				}
				head = head.getNext();
			}
		}
		return elementoARetornar;
	}
	
	public Nodo<T> getPrimerNodo(){
		return primerNodo;
	}
	
	public void setPrimerNodo(Nodo<T> primerNodo){
		this.primerNodo = primerNodo;
	}
	
	//indexOf EJERCICIO 4
	public int indexOf(T elemento){
		int posicion = -1; //este podria llamarse noEncontro
		int iterador = 0; //este podria ser posicion
		Nodo<T> head = primerNodo;
		while(posicion==-1 && head!=null){
			if (head.getInfo()==elemento){
				posicion=iterador; //esto podria ser return iterador(que se llamaria posicion)
			}
			head = head.getNext();
			iterador++;
		}
		return posicion;
	}

	//EJERCICIO 5
	
	@Override
	public Iterator<T> iterator() {
		return new ListaVinculadaIterator();
	}

	private class ListaVinculadaIterator implements Iterator<T>{
		
		private Nodo<T> head;
		
		public ListaVinculadaIterator(){
			head = primerNodo;
		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public T next() {
			if(hasNext()){
				T elemento = head.getInfo();
				head = head.getNext();
				return elemento;
			}
			else{
				return null;
			}
		}
		
	}
}


