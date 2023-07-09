package EJ_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Grafo implements GrafoMetodos{
	protected Map<String, Map<String, Integer>> grafo;
	
	public Grafo() {
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
	
	public Iterator<String> obtenerTodosLosVertices(){
	    ArrayList<String> vertices = new ArrayList<>();
	    
	    for (String origen : grafo.keySet()) {
	        if (!vertices.contains(origen)) {
	            vertices.add(origen);
	        }
	    }
	    return vertices.iterator();
	}
}
