package EJ_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import EJ_01.*;

public class ServicioDFS {
	
	private GrafoNoDirigido grafo;
	private Map<String, String> colores;
	
	public ServicioDFS(GrafoNoDirigido grafo){
		this.grafo = grafo;
		colores = new HashMap<>();
	}
	
	public void dfs(){
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
		//for each vertice u pertenece G->V{
		//	u->color= BLANCO;
		//	u.color
		//}
		int tiempo = 0;
		
		for(String vertice: vertices){
			if(colores.get(vertice).equals("BLANCO")){
				dfsVisit(vertice);
			}
		}
		
		//for each vertice u pertenece G->V{
		// if(u->color == BLANCO)
			//DFS_Visit(u)
		//}
	}
	//DFS_Visit(u){
		
	public void dfsVisit(String vertice){
	//	u->color= AMARILLO;
		colores.put(vertice, "AMARILLO");
		System.out.println("pongo en color: "+colores.get(vertice)+" el vertice: " + vertice);
		
	//tiempo = tiempo+1;
	//u->d = tiempo;
	//for each v e u->Adj[]
	//{

		Iterator<String> iteradorAdyacentes = grafo.obtenerVerticesAdyacentes(vertice);
		while(iteradorAdyacentes.hasNext()){
			String verticeAdyacente = iteradorAdyacentes.next();
			if(colores.get(verticeAdyacente).equals("BLANCO")){
				dfsVisit(verticeAdyacente);
			}
		}
	}
	
}
