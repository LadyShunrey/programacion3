package Parte2;

import java.util.ArrayList;
import java.util.HashMap;

import Parte1.Arco;
import Parte1.ArcoNoDirigido;
import Parte1.GrafoAbstracto;

public class GrafoNoDirigido<T> extends GrafoAbstracto<T> {

	public GrafoNoDirigido() {
		super.compGrafo = new HashMap<T, ArrayList<Arco<T>>>();
		super.cantArcos = 0;
	}

	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}

	private void internalAgregarArco(T verticeId1, T verticeId2, Integer etiqueta) {
		if (compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			Arco<T> a = new ArcoNoDirigido<T>(verticeId1, verticeId2, etiqueta);
			if (!arcos.contains(a)) {
				arcos.add(a);
				cantArcos++;
			}
		}
	}

	@Override
	public void agregarArco(T verticeId1, T verticeId2, Integer etiqueta) {
		internalAgregarArco(verticeId1, verticeId2, etiqueta);
		internalAgregarArco(verticeId2, verticeId1, etiqueta);
	}

	// Complejidad : O(m) m-> cantidad de arcos
	@Override
	public void borrarArco(T verticeId1, T verticeId2) {
		Arco<T> a = new ArcoNoDirigido<T>(verticeId1, verticeId2, null);
		if (compGrafo.containsKey(verticeId1) && compGrafo.containsKey(verticeId2)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			if (arcos.remove(a))
				cantArcos--;
			arcos = compGrafo.get(verticeId2);
			if (arcos.remove(a))
				cantArcos--;
		}
	}

	@Override
	public boolean existeArco(T verticeId1, T verticeId2) {
		boolean existe = false;
		Arco<T> a = new ArcoNoDirigido<T>(verticeId1, verticeId2, null);
		// No hace falta comparar en ambos sentidos, ya que no puedo argregar uno sin el
		// otro.  Si lo encuentro en una lista es suficiente
		if (compGrafo.get(verticeId1).contains(a))
			return true;
		return existe;
	}

	@Override
	public Arco<T> obtenerArco(T verticeId1, T verticeId2) {
		if (compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arcos = compGrafo.get(verticeId1);
			Arco<T> arco = new ArcoNoDirigido<T>(verticeId1, verticeId2, null);
			int pos = arcos.indexOf(arco);
			if (pos>0)
				return arcos.get(pos);
		}
		return null;
	}
	
	
}
