package Parte2;

import Parte1.ArcoAbstracto;

public class ArcoNoDirigido<T> extends ArcoAbstracto<T> {

	public ArcoNoDirigido(T verticeOrigen, T verticeDestino,
			Integer etiqueta) {
		super(verticeOrigen, verticeDestino, etiqueta);
	}

	@Override
	public boolean equals(ArcoAbstracto<T> arco) {
		if((arco.getVerticeOrigen()==this.verticeOrigen && arco.getVerticeDestino()==this.getVerticeDestino()) ||
				(arco.getVerticeOrigen()==this.getVerticeDestino() && arco.getVerticeDestino()==this.verticeOrigen)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}