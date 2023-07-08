package EJ_05;

public class Nodo {
	private Character valor;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo(){
		this.valor = null;
		this.izquierdo=null;
		this.derecho=null;
	}
	
	public Nodo(Character valor){
		this.valor = valor;
		this.izquierdo=null;
		this.derecho=null;
	}
	
	public Nodo(Character valor, Nodo izquierdo, Nodo derecho){
		this.valor = valor;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	public Character getValor() {
		return valor;
	}

	public void setValor(Character valor) {
		this.valor = valor;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}
	
	@Override
	public String toString(){
		return "[Nodo " + valor + "]";
	}
}
