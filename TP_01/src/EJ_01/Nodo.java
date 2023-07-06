package EJ_01;

public class Nodo<T> {
	protected T info;
	protected Nodo<T> next;
	
	public Nodo(){
		info = null;
		next = null;
	}
	
	public Nodo(T info, Nodo<T> next){
		this.info = info;
		this.next = next;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
	public Nodo<T> getNext() {
		return next;
	}
	
	public T getInfo() {
		return info;
	}
	
	public String toString(){
		return "Nodo: [" + info +"]";
	}
}
