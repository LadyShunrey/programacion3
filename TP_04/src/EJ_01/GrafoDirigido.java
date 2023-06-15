package EJ_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrafoDirigido {
	private Map<String, ArrayList<String>> grafo;
	
	public GrafoDirigido() {
        this.grafo = new HashMap<>();
    }
	
	public void agregarVertice(String vertice) {
        grafo.put(vertice, new ArrayList<>());
    }
	
	public void agregarArco(String verticeOrigen, String verticeDestino) {
		agregarVertice(verticeOrigen);
        agregarVertice(verticeDestino);
        
        ArrayList<String> arcos = grafo.get(verticeOrigen);
        arcos.add(verticeDestino);
	}
	
	public String buscarVerticeEnElGrafo(String verticeBuscado) {
	    for (String vertice : grafo.keySet()) {
	        ArrayList<String> conexiones = grafo.get(vertice);
	        if (conexiones.contains(verticeBuscado)) {
	            return verticeBuscado;
	        }
	    }
	    return null;
	}
	
	public ArrayList<String> obtenerConexiones(String vertice) {
	    return grafo.get(vertice);
	}
}
