package Parte1;

public abstract class ArcoAbstracto<T> {
	protected T verticeOrigen;
	protected T verticeDestino;
	protected Integer etiqueta;
	
	public ArcoAbstracto(T verticeOrigen, T verticeDestino, Integer etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta ;
	}
	public T getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public T getVerticeDestino() {
		return verticeDestino;
	}
	public Integer getEtiqueta() {
		return etiqueta;
	}
	
	public abstract boolean equals(ArcoAbstracto<T> a);
		
	public String toString() {
		return "["+verticeOrigen + "->" + verticeDestino + " distancia: " + etiqueta + " ]";
	}
}
