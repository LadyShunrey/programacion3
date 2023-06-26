package Parte1;

public class Arco<T> {
	private T verticeOrigen;
	private T verticeDestino;
	private Integer etiqueta;
	
	public Arco(T verticeOrigen, T verticeDestino, Integer etiqueta) {
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
	
	public boolean equals(Arco<T> a) {
		if(a.verticeOrigen==this.verticeOrigen && a.getVerticeDestino()==this.getVerticeDestino()) {
			return true;
		}else {
			return false;
		}
	}
		
	public String toString() {
		return "El vertice origen es [ vertice origen = " + verticeOrigen + "] \n El vertice destino del arco es [ vertice destino = " + verticeDestino + " ] \n La distancia entre estos vértices es [ distancia = " + etiqueta + " ]";
	}
}
