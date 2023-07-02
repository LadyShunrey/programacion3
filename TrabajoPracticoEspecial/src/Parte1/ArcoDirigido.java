package Parte1;

public class ArcoDirigido<T> extends Arco<T> {

	public ArcoDirigido(T verticeOrigen, T verticeDestino, Integer etiqueta) {
		super(verticeOrigen, verticeDestino, etiqueta);
	}

	@Override
	public boolean equals(Arco<T> a) {
		return (a.verticeOrigen.equals(this.verticeOrigen) && a.getVerticeDestino().equals(this.getVerticeDestino()));
	}
}
