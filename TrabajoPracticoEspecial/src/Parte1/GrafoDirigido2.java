package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido2<T> extends GrafoAbstracto<T> {

	public GrafoDirigido2() {
		super.compGrafo = new HashMap<T, ArrayList<Arco<T>>>();
		super.cantArcos = 0;
	}

	@Override
	public void agregarArco(T verticeId1, T verticeId2, Integer etiqueta) {
		Arco<T> a = new ArcoDirigido<T>(verticeId1, verticeId2, etiqueta);
		if (compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			if (!arcos.contains(a) && a.getVerticeDestino() == verticeId2) {
				compGrafo.get(verticeId1).add(a);
				cantArcos++;
			}
		}
	}

	// Complejidad : O(m) m-> cantidad de arcos
	@Override
	public void borrarArco(T verticeId1, T verticeId2) {
		Arco<T> a = new ArcoDirigido<T>(verticeId1, verticeId2, null);
		if (compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			Iterator<Arco<T>> iterator = arcos.iterator();
			while (iterator.hasNext()) {
				Arco<T> arco = iterator.next();
				if (a.equals(arco)) {
					iterator.remove();
					cantArcos--;
				}
			}
		}
	}

	@Override
	public boolean existeArco(T verticeId1, T verticeId2) {
		boolean existe = false;
		Arco<T> a = new ArcoDirigido<T>(verticeId1, verticeId2, null);
		for (Arco<T> ar : compGrafo.get(verticeId1)) {
			if (a.equals(ar)) {
				existe = true;
			} else {
				existe = false;
			}
		}
		return existe;
	}

	@Override
	public Arco<T> obtenerArco(T verticeId1, T verticeId2) {
		if (compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeDestino().equals(verticeId2)) { // FIXME FIXME para que ande tambien en GND
					return arco;
				}
			}
		}
		return null;
	}

}
