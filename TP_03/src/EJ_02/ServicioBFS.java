package EJ_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import EJ_01.Grafo;

public class ServicioBFS {
	
	private Grafo grafo;
	private Map<String, String> colores;
	
	public ServicioBFS(Grafo grafo){
		this.grafo = grafo;
		colores = new HashMap<>();
	}
	
	public void bfs(){
		ArrayList<String> vertices = new ArrayList<>();
		Iterator<String> iteradorVertices = grafo.obtenerTodosLosVertices();
		while(iteradorVertices.hasNext()){
			String vertice = iteradorVertices.next();
			if(!vertices.contains(vertice)){
				vertices.add(vertice);
			}
			colores.put(vertice, "BLANCO");
			System.out.println("Pongo de color: "+ colores.get(vertice) +" el vértice: " + vertice);
		}
		
		for(String vertice: vertices){
			System.out.println("el vertice " + vertice + " está de color " + colores.get(vertice));
			if(colores.get(vertice).equals("BLANCO")){
				System.out.println("como el vertice " + vertice + " está blanco lo vamos a visitar");
				bfsVisit(vertice);
			}
		}
	}
	
	public void bfsVisit(String vertice){
		
	}
}
