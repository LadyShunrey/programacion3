package Parte1;

public class ArcoDirigido<T> extends ArcoAbstracto<T>{
	
	public ArcoDirigido(T verticeOrigen, T verticeDestino, Integer etiqueta) {
		super(verticeOrigen, verticeDestino, etiqueta);
	}

	@Override
	public boolean equals(ArcoAbstracto<T> a) {
		if(a.verticeOrigen==this.verticeOrigen && a.getVerticeDestino()==this.getVerticeDestino()) {
			return true;
		}
		else {
			return false;
		}
	}
}
