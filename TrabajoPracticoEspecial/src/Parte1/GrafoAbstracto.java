package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class GrafoAbstracto<T> implements Grafo<T> {
	protected HashMap<T, ArrayList<Arco<T>>> compGrafo;
	protected int cantArcos;

	// Complejidad: O(1)
	public void agregarVertice(T verticeId) {
		compGrafo.putIfAbsent(verticeId, new ArrayList<Arco<T>>());
	}

	// Complejidad: O(m) m->cantidad de arcos
	public void borrarVertice(T verticeId) {
		// Borrar todos los arcos que tengan a este vertice como origen o destino
		Iterator<Arco<T>> it = this.obtenerArcos();
		while (it.hasNext()) {
			Arco<T> a = it.next();
			if (a.getVerticeDestino() == verticeId || a.getVerticeOrigen() == verticeId)
				it.remove();
			cantArcos--;
		}
		compGrafo.remove(verticeId);
	}

	public int cantidadArcos() {
		return cantArcos;
	}

	// Complejidad: O(1)
	public Iterator<T> obtenerVertices() {
		return compGrafo.keySet().iterator();
	}

	// Complejidad: O(1)
	public abstract void agregarArco(T verticeId1, T verticeId2, Integer etiqueta);

	// Complejidad : O(m) m-> cantidad de arcos
	public abstract void borrarArco(T verticeId1, T verticeId2);

	// Complejidad : O(1)
	public boolean contieneVertice(T verticeId) {
		return compGrafo.containsKey(verticeId);
	}

	// Complejidad : O(m) m-> cantidad de arcos
	public abstract boolean existeArco(T verticeId1, T verticeId2);

	// Complejidad : O(m ) m-> cantidad de arcos
	public abstract Arco<T> obtenerArco(T verticeId1, T verticeId2);

	// Complejidad: O(1)
	public int cantidadVertices() {
		return compGrafo.keySet().size();
	}

	// Complejidad : O(m) m-> cantidad de arcos
	public Iterator<T> obtenerAdyacentes(T verticeId) {
		ArrayList<T> ady = new ArrayList<>();
		if (compGrafo.containsKey(verticeId)) {
			for (Arco<T> arcos : compGrafo.get(verticeId)) {
				ady.add(arcos.getVerticeDestino());
			}
		}
		return ady.iterator();
	}

	// Complejidad : O(n+m) n->cantidad de vertices m-> cantidad de arcos
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (Entry<T, ArrayList<Arco<T>>> key : compGrafo.entrySet()) {
			arcos.addAll(key.getValue());
		}
		return arcos.iterator();
	}

	// Complejidad : O(n+m) n->cantidad de vertices m-> cantidad de arcos
	public Iterator<Arco<T>> obtenerArcos(List<T> vertices) {
		//Uso un set porque no permite duplicados
		Set<Arco<T>> set = new HashSet<>();
		for (T key : vertices) {
			set.addAll(compGrafo.get(key));
		}
		return set.iterator();
	}

	// Complejidad : O(1)
	public Iterator<Arco<T>> obtenerArcos(T verticeId) {
		ArrayList<Arco<T>> values = compGrafo.get(verticeId);
		return values.iterator();
	}

}
