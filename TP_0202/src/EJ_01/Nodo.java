package EJ_01;

public class Nodo {
	
	private Integer clave;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo(Integer num){
		this.clave = num;
		this.izquierdo = null;
		this.derecho = null;
	}
	
	public Integer getClave(){
		return clave;
	}
	
	public Nodo getNodoIzquierdo(){
		return izquierdo;
	}
	
	public Nodo getNodoDerecho(){
		return derecho;
	}
	
	public void setClave(Integer num){
		this.clave = num;
	}
	
	public void setNodoIzquierdo(Integer num){
		this.izquierdo = new Nodo(num);
	}
	
	public void setNodoDerecho(Integer num){
		this.derecho = new Nodo(num);
	}
}
