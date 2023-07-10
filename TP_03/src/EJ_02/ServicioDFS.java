package EJ_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import EJ_01.*;

public class ServicioDFS {
	
	private Grafo grafo;
	private Map<String, String> colores;
	
	public ServicioDFS(Grafo grafo){
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
//		int tiempo = 0;
		
		for(String vertice: vertices){
			System.out.println("el vertice " + vertice + " está de color " + colores.get(vertice));
			if(colores.get(vertice).equals("BLANCO")){
				System.out.println("como el vertice " + vertice + " está blanco lo vamos a visitar");
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
			System.out.println("Un adyacente de " + vertice + " es " + verticeAdyacente + " y el color de este adyacente es: " + colores.get(verticeAdyacente));
			if(colores.get(verticeAdyacente).equals("BLANCO")){
				System.out.println("como el vertice adyacente " + verticeAdyacente + " está blanco lo vamos a visitar");
				dfsVisit(verticeAdyacente);
			}
		}
		//negro
		colores.put(vertice, "NEGRO");
		System.out.println("El vertice " + vertice + " ahora está de color " + colores.get(vertice));
	}
	
}
