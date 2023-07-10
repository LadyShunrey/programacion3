package EJ_04;

import java.util.ArrayList;
import java.util.Iterator;

import EJ_01.Grafo;

/*Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
el grafo de entrada es acíclico.
*/

public class Main {
	private static ArrayList<String> mayorCamino = new ArrayList<>();

	public static void main(String[] args) {
		
	}
	
	public static void caminoMayorLongitud(Grafo grafo, String verticeInicial, String verticeFinal){
		Iterator<String> iteradorVertices = grafo.obtenerVerticesAdyacentes(verticeInicial); 
		while(iteradorVertices.hasNext()){
			String vertice = iteradorVertices.next();
			//algo recursivo que itere todo el grafo
			//algun array donde guardar posibles caminos
		}
	}
}
