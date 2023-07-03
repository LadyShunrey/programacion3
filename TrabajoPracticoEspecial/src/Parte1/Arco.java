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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verticeDestino == null) ? 0 : verticeDestino.hashCode());
		result = prime * result + ((verticeOrigen == null) ? 0 : verticeOrigen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco<T> other = (Arco<T>) obj;
		if (verticeDestino == null) {
			if (other.verticeDestino != null)
				return false;
		} else if (!verticeDestino.equals(other.verticeDestino))
			return false;
		if (verticeOrigen == null) {
			if (other.verticeOrigen != null)
				return false;
		} else if (!verticeOrigen.equals(other.verticeOrigen))
			return false;
		return true;
	}	

	public String toString() {
		return "[ " + verticeOrigen + ", " + verticeDestino + ": "+etiqueta+ "]";
	}
	
	

}
