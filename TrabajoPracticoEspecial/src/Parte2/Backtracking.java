package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Parte1.Arco;

public class Backtracking<T> {

	// arrayList de soluciones
	private ArrayList<Arco<T>> redSubterraneo;
	public int longitudRedSubterraneo;

	public Backtracking() {
		this.redSubterraneo = new ArrayList<>();
		longitudRedSubterraneo = 500; // Integer.MAX_VALUE; /*Esto es un número muy, muy grande*/
	}

	// metodo que devuelve el arraylist de red de subterraneo
	public ArrayList<Arco<T>> getRedSubterraneo() {
		return redSubterraneo;
	}

	// poda: si el camino que llevo es mas largo que el camino parcial tengo
	// guardado como más corto podo toda esa rama.
	public boolean poda(int sumaCaminoHastaAhora) {
		return sumaCaminoHastaAhora >= longitudRedSubterraneo;
	}

	// Alcanzo una solucion cuando la cantidad de vertices delk grafo es igual a la
	// cantidad de vertices visitados
	boolean esSolucion(GrafoNoDirigido2<T> grafo, List<T> visitadas) {
		return grafo.cantidadVertices() == visitadas.size();
	}

	List<Arco<T>> obtenerPosiblesArcos(GrafoNoDirigido2<T> grafo, List<T> visitadas, ArrayList<Arco<T>> arcosUsados) {

		// todos los arcos del grafo
		// que no esten usados previamente
		// pero no obtengo cualquiera, solo puedo usar arcos que lleguen o terminen en
		// mis vertices visitados

		ArrayList<Arco<T>> solucion = new ArrayList<>();
		// Obtengo los arcos de vertices visitados
		Iterator<Arco<T>> arcos = grafo.obtenerArcos(visitadas);

		while (arcos.hasNext()) {
			Arco<T> arco = arcos.next();
			if (!arcosUsados.contains(arco))
				solucion.add(arco);
		}
		return solucion;
	}

	// metodo void backtracking que agrega elementos a la redsubterraneo
	public boolean backtracking(GrafoNoDirigido2<T> grafo, T estacionActual, int metrosDeRedActualEnConstruccion,
			ArrayList<Arco<T>> solucionEnConstruccion, List<T> visitadas) {
		System.out.println("Entro a Backtracking");
		System.out.println("Red de subte en construccion: " + solucionEnConstruccion);
		System.out.println("Longitud de la red de subte en construccion: " + metrosDeRedActualEnConstruccion);

		// if llegue a la solucion return true
		if (esSolucion(grafo, visitadas)) {
			// terminé
			return true;
		}

		// else hago todo lo demás
		else {

			// traigo toda la lista de arcos adyacentes de la estación en la que estoy

			Iterator<Arco<T>> iteradorArcos = obtenerPosiblesArcos(grafo, visitadas, solucionEnConstruccion).iterator();

			while (iteradorArcos.hasNext()) {
				System.out.println("Entro al while");
				System.out.println("Red de subte en construccion: " + solucionEnConstruccion);
				System.out.println("Longitud de la red de subte en construccion: " + metrosDeRedActualEnConstruccion);
				// elijo un arco siguiente
				Arco<T> arcoSiguiente = iteradorArcos.next();
				// si no tengo ese arco en la solucion me fijo si se puede agregar

				if (!solucionEnConstruccion.contains(arcoSiguiente)
						&& !visitadas.contains(arcoSiguiente.getVerticeDestino())) {

					int longitudDelTunel = arcoSiguiente.getEtiqueta();
					// si no lo podo lo agrego a la solucion potencial
					if (!poda(metrosDeRedActualEnConstruccion + longitudDelTunel)) {
						solucionEnConstruccion.add(arcoSiguiente);
						// sumo ese arco a mi suma solucion parcial

						metrosDeRedActualEnConstruccion += longitudDelTunel;
						visitadas.add(arcoSiguiente.getVerticeDestino());
						boolean result = backtracking(grafo, arcoSiguiente.getVerticeDestino(),
								metrosDeRedActualEnConstruccion, solucionEnConstruccion, visitadas);

						if (result) {
							if (metrosDeRedActualEnConstruccion <= longitudRedSubterraneo) {
								// actualizo la mejor solucion
								longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
								redSubterraneo.clear();
								redSubterraneo.addAll(solucionEnConstruccion);

								System.out.println("Tengo un result=true");
								System.out.println("Red de subte en construccion: " + solucionEnConstruccion);
								System.out.println("Longitud de la red de subte en construccion: "
										+ metrosDeRedActualEnConstruccion);
							}
						}
						// Deshago la construcción de la solución
						solucionEnConstruccion.remove(arcoSiguiente);
						metrosDeRedActualEnConstruccion -= longitudDelTunel;
						visitadas.remove(arcoSiguiente.getVerticeDestino());

						System.out.println("Saco la última estacion y vuelvo en la recursión");
						System.out.println("Red de subte en construccion: " + solucionEnConstruccion);
						System.out.println(
								"Longitud de la red de subte en construccion: " + metrosDeRedActualEnConstruccion);
					}
				}
			} /* cierro while */
			return false;
		}
	}

}
