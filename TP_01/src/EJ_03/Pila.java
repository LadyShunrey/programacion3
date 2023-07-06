package EJ_03;
/*Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
elementos utilizando el método push(T o). Para retirar elementos de la colección se utiliza el
método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). Por
último, es posible invertir el orden de los elementos de la pila mediante el método reverse().*/


import EJ_01.ListaVinculada;
import EJ_01.Nodo;

//No sé si lo correcto es que la pila se componga por una lista o que extienda de lista...Pero CREO QUE puede ser cualquiera de las dos..
public class Pila<T> /*extends ListaVinculada<T>*/{
	
	private ListaVinculada<T> listaVinculada;
	
	public Pila(){
		this.listaVinculada = new ListaVinculada<>();
	}
	//push(T o)
	public void push(T nuevo){
		Nodo<T> nodoNuevo = new Nodo<>(nuevo,null);
		listaVinculada.insertFront(nodoNuevo); //heredando de Lista: super.insertFront(nodoNuevo);
	}
	
	//pop()
	public T pop(){
		T elementoEliminado;
		elementoEliminado = listaVinculada.extractFront();
		return elementoEliminado;
	}
	
	//top()
	public T top(){
		T primero;
		primero = listaVinculada.get(0);
		return primero;
	}
	
	//reverse()
	public void reverse(){
		Nodo<T> anterior = new Nodo<>();
		Nodo<T> actual = new Nodo<>();
		Nodo<T> siguiente = new Nodo<>();
		
		anterior = null;
		actual = listaVinculada.getPrimerNodo();
		siguiente = actual;
		
 		while(siguiente!=null){
			siguiente = actual.getNext();
			actual.setNext(anterior);
			anterior = actual;
			actual = siguiente;
		}
 		if(siguiente==null){
 			listaVinculada.setPrimerNodo(anterior);
 		}
	}
	
	@Override
	public String toString(){
		String result;
		result = "Mi pila tiene estos elementos: ";
//		Iterator<T> iteradorLista = this.iterator();
		Nodo<T> head = listaVinculada.getPrimerNodo();
		if(listaVinculada.getPrimerNodo()!=null){
			result += "[" + listaVinculada.getPrimerNodo().getInfo() + "]";
			while(head.getNext()!=null){
				head = head.getNext();
				result += ", ["+head.getInfo() + "]";	
			}	
		}
		return result +=".";
	}
}
