package EJ_03;

import EJ_01.GrafoDirigido;
import EJ_02.ServicioDFS;

/*Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
*/

public class Main {

	public static void main(String[] args) {
		/*Solo agrego en el servicioDFS esto:
		 * else if(colores.get(verticeAdyacente).equals("AMARILLO")){
		 * System.out.println("Hay un ciclo! Desde " + vertice + " hasta " + verticeAdyacente);
		 * */
		
		/*No anda*/
		
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		
		GrafoDirigido grafoD = new GrafoDirigido();
		
		grafoD.agregarVertice(a);
		grafoD.agregarVertice(b);
		grafoD.agregarVertice(c);
//		grafoD.agregarVertice(d);
		
		//agregar arcos sino es un grafo todo desconexo
		grafoD.agregarArco(a, b, 0);
		grafoD.agregarArco(b, c, 0);
		grafoD.agregarArco(c, a, 0);
//		grafoD.agregarArco(b, a, 0);
//		grafoD.agregarArco(a, c, 0);
//		grafoD.agregarArco(c, b, 0);
//		grafoD.agregarArco(b, d, 0);
//		grafoD.agregarArco(d, c, 0);
		
		ServicioDFS servicioDFS = new ServicioDFS(grafoD);
		servicioDFS.dfs();
	}
}
