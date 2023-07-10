package EJ_02;

import java.util.Iterator;

import EJ_01.GrafoDirigido;
import EJ_01.GrafoNoDirigido;

/*Implemente los recorridos Depth-First-Search y Breadth-First-Search.
*/

public class Main {

	public static void main(String[] args) {
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		
		GrafoNoDirigido grafoND = new GrafoNoDirigido();
		
		grafoND.agregarVertice(a);
		grafoND.agregarVertice(b);
		grafoND.agregarVertice(c);
		grafoND.agregarVertice(d);
		
		//agregar arcos sino es un grafo todo desconexo	
		grafoND.agregarArco(a, b, 0);
		grafoND.agregarArco(a, c, 0);
		grafoND.agregarArco(b, c, 0);
		grafoND.agregarArco(b, d, 0);
		
		Iterator<String> iteradorVertices = grafoND.obtenerTodosLosVertices();
		
		while(iteradorVertices.hasNext()){
			System.out.println(iteradorVertices.next());
		}
		
		GrafoDirigido grafoD = new GrafoDirigido();
		
		grafoD.agregarVertice(a);
		grafoD.agregarVertice(b);
		grafoD.agregarVertice(c);
		grafoD.agregarVertice(d);
		
		//agregar arcos sino es un grafo todo desconexo
		grafoD.agregarArco(a, b, 0);
		grafoD.agregarArco(a, c, 0);
		grafoD.agregarArco(c, b, 0);
		grafoD.agregarArco(b, d, 0);
		
		ServicioDFS servicioDFS = new ServicioDFS(grafoD);
		servicioDFS.dfs();
	}

}
