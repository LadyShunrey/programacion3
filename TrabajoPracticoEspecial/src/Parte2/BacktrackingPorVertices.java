package Parte2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import Parte1.Arco;

public class BacktrackingPorVertices<T> {

	// arrayList de soluciones
	private LinkedList<Arco<Integer>> redSubterraneo;
	public int longitudRedSubterraneo;
	public long contadorCiclos;
	public Map<Integer, Set<Arco<Integer>>> combinatorias;
	GrafoNoDirigido<Integer> grafo;
	private double tiempoBacktracking;

	private boolean soloPrimerNodo;

	public double getTiempoBacktracking() {
		return tiempoBacktracking;
	}

	public long getContadorCiclos() {
		return contadorCiclos;
	}

	public BacktrackingPorVertices(GrafoNoDirigido<Integer> grafo, int maxValue) {
		// Inicializacion
		this.redSubterraneo = new LinkedList<>();
		longitudRedSubterraneo = maxValue;
		contadorCiclos = 0;
		combinatorias = new HashMap<>();
		soloPrimerNodo = true;
		this.grafo = grafo;

		// Cargo todos los vertices en la lista de estaciones a visitar
		Iterator<Integer> itVertices = grafo.obtenerVertices();

		HashSet<Integer> sinVisitar = new HashSet<>();
//		Integer primeraEstacion = null;
		while (itVertices.hasNext()) {
			Integer v = itVertices.next();
			sinVisitar.add(v);
//			if (primeraEstacion == null)
//				primeraEstacion = v;
		}

		LinkedList<Arco<Integer>> solucion = new LinkedList<>();
		itVertices = grafo.obtenerVertices();
		Timer timerBacktracking = new Timer();
		timerBacktracking.start();
		while (itVertices.hasNext()) {
			Integer v = itVertices.next();
			//sinVisitar.remove(v);
			backtracking(solucion, 0, v, null, sinVisitar);
			sinVisitar.add(v);
			if (soloPrimerNodo)
				break;
		}
		tiempoBacktracking = timerBacktracking.stop();
		// Empiezo por el primero, no necesito probar de empezar por los demas
//		sinVisitar.remove(primeraEstacion);
//		backtracking(solucion, 0, primeraEstacion, null, sinVisitar);
//		tiempoBacktracking = timerBacktracking.stop();
	}

	public LinkedList<Arco<Integer>> getRedSubterraneo() {
		return redSubterraneo;
	}


	boolean esSolucion(HashSet<Integer> noVisitadas) {
		return noVisitadas.isEmpty();
	}
	
	// [[ 1, 3: 40], [ 3, 2: 30], [ 2, 5: 30], [ 2, 13: 40], [ 13, 9: 20], [ 13, 8: 40], [ 8, 4: 40], [ 8, 10: 50], [ 8, 11: 30], [ 11, 7: 30], [ 7, 6: 40], [ 6, 12: 60]]
    //  [ 1, 3: 40], [ 2, 3: 30], [ 2, 5: 30], [ 2, 13: 40], E4--->E8(40), E5--->E6(40), E5--->E11(30), E6--->E12(60), E7--->E11(30), E8--->E10(50), E8--->E11(30), E9--->E13(20)]


	public void backtracking(LinkedList<Arco<Integer>> solucionEnConstruccion, int metrosDeRedActualEnConstruccion,
			Integer estacionActual, Integer estacionAnterior, HashSet<Integer> noVisitadas) {

		noVisitadas.remove(estacionActual);
		this.contadorCiclos++;
		
		if (esSolucion(noVisitadas) && (metrosDeRedActualEnConstruccion < longitudRedSubterraneo)) {
			// actualizo la mejor solucion
			longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
			redSubterraneo = new LinkedList<>(solucionEnConstruccion);
			System.out.println(" *****************************************************************************");
			System.out.println(" ****************************** Tengo un result=true *************************");
			System.out.println("Red de subte en construccion: " + solucionEnConstruccion);
			System.out.println("Longitud de la red de subte en construccion: " + metrosDeRedActualEnConstruccion);
			System.out.println("Cantidad de iteraciones: " + contadorCiclos);
			System.out.println(" *****************************************************************************");
			System.out.println(" *****************************************************************************");
			return;
		}

		// Caso donde puedo volver para atrás (sin contar el arco)
		if (estacionAnterior != null) {
			backtracking(solucionEnConstruccion, metrosDeRedActualEnConstruccion, estacionAnterior, null,
					new HashSet<Integer>(noVisitadas));
		}

		// Iteramos por las estaciones restantes
		for (Integer estacion : noVisitadas) {

			Arco<Integer> arcoSiguiente = grafo.obtenerArco(estacionActual, estacion);

			int longitudDelTunel = arcoSiguiente.getEtiqueta();
			if (metrosDeRedActualEnConstruccion + arcoSiguiente.getEtiqueta() < this.longitudRedSubterraneo) { //poda
				solucionEnConstruccion.add(arcoSiguiente);
				noVisitadas.add(arcoSiguiente.getVerticeDestino());
				backtracking(solucionEnConstruccion, metrosDeRedActualEnConstruccion + longitudDelTunel, estacion,
						estacionActual, new HashSet<Integer>(noVisitadas));
				solucionEnConstruccion.remove(arcoSiguiente);
			}
		}

	}

}
