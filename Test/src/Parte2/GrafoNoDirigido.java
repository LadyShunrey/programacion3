package Parte2;

import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;
import Parte1.GrafoDirigido;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {
	
	

	@Override
	public void agregarArco(T verticeId1, T verticeId2, Integer etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}

	@Override
	public void borrarArco(T verticeId1, T verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}

	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}

	@Override
	public boolean existeArco(T verticeId1, T verticeId2) {
		boolean existe = false;
		Iterator<Arco<T>> it = this.obtenerArcos();
		while (!existe && it.hasNext()) {
			Arco<T> arco = it.next();
			if ((arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2))
					|| (arco.getVerticeOrigen().equals(verticeId2) && arco.getVerticeDestino().equals(verticeId1))) {
				existe = true;
			}
		}
		return existe;
	}

}
