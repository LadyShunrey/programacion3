package Redoing;

import java.util.HashMap;
import java.util.Map;

public class GrafoNoDirigido {
	private Map<String, Map<String, Integer>> grafo;
	
	public GrafoNoDirigido() {
        this.grafo = new HashMap<>();
    }
	
	public void agregarVertice(String vertice) {
        grafo.put(vertice, new HashMap<>());
    }
	
	public void agregarArco(String verticeOrigen, String verticeDestino, int longitud) {
		agregarVertice(verticeOrigen);
        agregarVertice(verticeDestino);
        
        Map<String, Integer> arcosOrigen = grafo.get(verticeOrigen);
        arcosOrigen.put(verticeDestino, longitud);
        Map<String, Integer> arcosDestino = grafo.get(verticeDestino);
        arcosDestino.put(verticeOrigen, longitud);
	}
	
}
