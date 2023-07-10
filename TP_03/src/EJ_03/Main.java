package EJ_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import EJ_01.Grafo;
import EJ_01.GrafoDirigido;
import EJ_02.ServicioDFS;

/*Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
*/

public class Main {
	
	private static Map<String, String> colores = new HashMap<>();
	private static ArrayList<ArrayList<String>> todosLosCiclos = new ArrayList<>();

	public static void main(String[] args) {
		/*Solo agrego en el servicioDFS esto:
		 * else if(colores.get(verticeAdyacente).equals("AMARILLO")){
		 * System.out.println("Hay un ciclo! Desde " + vertice + " hasta " + verticeAdyacente);
		 * */
		
		/*No anda*/
		
		String a = "A";
		String b = "B";
		String c = "C";
		
		GrafoDirigido grafoD = new GrafoDirigido();
		
		grafoD.agregarVertice(a);
		grafoD.agregarVertice(b);
		grafoD.agregarVertice(c);
		
		//agregar arcos sino es un grafo todo desconexo
		grafoD.agregarArco(a, b, 0);
		grafoD.agregarArco(b, c, 0);
		grafoD.agregarArco(c, a, 0);
		
		ServicioDFS servicioDFS = new ServicioDFS(grafoD);
		servicioDFS.dfs();
	}
	
//	public static ArrayList<ArrayList<String>> ciclosEn(Grafo grafo){
//		ArrayList<String> unCiclo = new ArrayList<>();
//		
//		unCiclo = unCiclo(grafo);
//		return todosLosCiclos;
//	}
	
	public static void dfs(Grafo grafo){
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
				dfsVisit(vertice, grafo);
			}
		}
		
		
	}
		
	public static void dfsVisit(String vertice, Grafo grafo){
		colores.put(vertice, "AMARILLO");
		System.out.println("pongo en color: "+colores.get(vertice)+" el vertice: " + vertice);
		
		Iterator<String> iteradorAdyacentes = grafo.obtenerVerticesAdyacentes(vertice);
		while(iteradorAdyacentes.hasNext()){
			String verticeAdyacente = iteradorAdyacentes.next();
			System.out.println("Un adyacente de " + vertice + " es " + verticeAdyacente + " y el color de este adyacente es: " + colores.get(verticeAdyacente));
			if(colores.get(verticeAdyacente).equals("BLANCO")){
				System.out.println("como el vertice adyacente " + verticeAdyacente + " está blanco lo vamos a visitar");
				dfsVisit(verticeAdyacente, grafo);
			}
			else if(colores.get(verticeAdyacente).equals("AMARILLO")){
				System.out.println("Hay un ciclo! Desde " + vertice + " hasta " + verticeAdyacente);
				//guardar el verticeAdyacente
				encontreUnCiclo(verticeAdyacente, grafo);
			}
		}
		
		colores.put(vertice, "NEGRO");
		System.out.println("El vertice " + vertice + " ahora está de color " + colores.get(vertice));
	}
	
	public static void encontreUnCiclo(String verticeInicial, Grafo grafo){
		ArrayList<String> unCiclo = new ArrayList<>();
		//recorro el grafo desde este
		unCiclo.add(verticeInicial);
		//lo guardo en un array
		Iterator<String> iteradorVertices = grafo.obtenerVerticesAdyacentes(verticeInicial);
		//recorro los adyacentes y los voy guardando hasta llegar al que llega al amarillo
		while(iteradorVertices.hasNext()){
			String vertice = iteradorVertices.next();
			unCiclo.add(vertice);
		}
		
	}
	
//	public static ArrayList<String> unCiclo(Grafo grafo){
//		ArrayList<String> unCiclo = new ArrayList<>();
//		dfs(grafo);
//		return unCiclo;
//	}
}
