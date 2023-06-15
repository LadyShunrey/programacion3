package EJ_01;

public class Nodo<T> {
	private T contenido;
	private Nodo<T> siguiente;
	
	public Nodo(T nuevoNodo, Nodo<T> siguienteNodo) {
		this.contenido = nuevoNodo;
		this.siguiente = siguienteNodo;
	}
	
	public void setNext(Nodo<T> siguienteNodo){
		
	}

	public T getInfo() {
		return contenido;
	}

	public Nodo<T> getNext() {
		return siguiente;
	}
}
