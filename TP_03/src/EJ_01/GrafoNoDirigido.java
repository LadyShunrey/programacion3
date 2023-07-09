package EJ_01;

import java.util.HashMap;
import java.util.Map;

public class GrafoNoDirigido extends Grafo{
	
	public GrafoNoDirigido() {
        super.grafo = new HashMap<>();
    }
	
	public void agregarArco(String verticeOrigen, String verticeDestino, int longitud) {
		super.agregarArco(verticeOrigen, verticeDestino, longitud);
        
        Map<String, Integer> arcosDestino = grafo.get(verticeDestino);
        arcosDestino.put(verticeOrigen, longitud);
	}
	
}
