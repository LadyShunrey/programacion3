package EJ_01;

import java.util.HashMap;
import java.util.Map;

public class GrafoDirigido {
	private Map<String, Map<String, Integer>> grafo;
	
	public GrafoDirigido() {
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
	}
}
