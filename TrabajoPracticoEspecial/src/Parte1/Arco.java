package Parte1;

public abstract class Arco<T> {
	
	protected T verticeOrigen;
	protected T verticeDestino;
	protected Integer etiqueta;

	public Arco(T verticeOrigen, T verticeDestino, Integer etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
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

	public abstract boolean equals(Arco<T> a);

	public String toString() {
		return "[ " + verticeOrigen + ", " + verticeDestino + " ]";
	}

}
