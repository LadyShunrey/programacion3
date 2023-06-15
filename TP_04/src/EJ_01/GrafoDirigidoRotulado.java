package EJ_01;

import java.util.HashMap;
import java.util.Map;

public class GrafoDirigidoRotulado {
	private Map<String, Map<String, Integer>> grafoRotulado;
	
	public GrafoDirigidoRotulado() {
        this.grafoRotulado = new HashMap<>();
    }
	
	public void agregarVertice(String vertice) {
        grafoRotulado.put(vertice, new HashMap<>());
    }
	
	public void agregarArco(String verticeOrigen, String verticeDestino, int longitud) {
		agregarVertice(verticeOrigen);
        agregarVertice(verticeDestino);
        
        Map<String, Integer> arcosOrigen = grafoRotulado.get(verticeOrigen);
        arcosOrigen.put(verticeDestino, longitud);
	}
}
