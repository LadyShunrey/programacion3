package Parte1;

public class Main {
	public static <T> void main(String[]args) {
		
		System.out.println("\n-------------GRAFO 1--------------\n");
		GrafoDirigido2<Integer> grafo = new GrafoDirigido2<>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);

		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(4, 2 ,null);
		grafo.agregarArco(3, 2, null);
		grafo.agregarArco(5, 2, null);
		grafo.agregarArco(5, 6, null);

		System.out.println("- Nuestro Grafo 1 tiene: " + grafo.cantidadVertices() + " vertices");
		System.out.println("- Nuestro Grafo 1 tiene: " + grafo.cantidadArcos() + " arcos");

		System.out.println("- Presentamos los distintos servicios de nuestro sistema:");
		
		System.out.println("- Servicio DFS:");
		ServicioDFS<Integer> DFS = new ServicioDFS<Integer>(grafo);
		System.out.println("- Arco Tree DFS " + DFS.dfsForest());
		
		System.out.println("- Servicio BFS:");
		ServicioBFS<Integer> BFS = new ServicioBFS<Integer>(grafo);
		System.out.println("- Arco Tree BFS " + BFS.bfsForest());
		
		System.out.println("- Existe el arco desde 1 a 2 directo?: " + grafo.existeArco(1, 2));
		System.out.println("- Si no existe el arco desde 1 a 2 entonces vamos a buscar si existe una forma de llegar desde 1 hasta 2:");
		System.out.println("- Servicio de Caminos:");
		ServicioCaminos<Integer> Camino = new ServicioCaminos<Integer>(grafo,1,2,3);
		System.out.println(Camino.caminos());
		
		System.out.println("\n----------------------------------");
		System.out.println("-------------GRAFO 2-------------- \n");
		
		GrafoDirigido2<Integer> grafo2 = new GrafoDirigido2<>();
		
		grafo2.agregarVertice(1);
		grafo2.agregarVertice(2);
		grafo2.agregarVertice(3);
		grafo2.agregarVertice(4);
		grafo2.agregarVertice(5);
		grafo2.agregarVertice(6);
		
		grafo2.agregarArco(1, 2, null);
		grafo2.agregarArco(2, 4, null);
		grafo2.agregarArco(1, 3, null);
		grafo2.agregarArco(3, 2, null);
		grafo2.agregarArco(2, 4, null);
		grafo2.agregarArco(1, 4, null);
		grafo2.agregarArco(2, 1, null);

		System.out.println("- Nuestro Grafo 2 tiene: " + grafo2.cantidadVertices() + " vertices");
		System.out.println("- Nuestro Grafo 2 tiene: " + grafo2.cantidadArcos() + " arcos");

		System.out.println("- Presentamos los distintos servicios de nuestro sistema:");
		
		System.out.println("- Servicio DFS:");
		ServicioDFS<Integer> DFS2 = new ServicioDFS<Integer>(grafo2);
		System.out.println("- Arco Tree DFS " + DFS2.dfsForest());
		
		System.out.println("- Servicio BFS:");
		ServicioBFS<Integer> BFS2 = new ServicioBFS<Integer>(grafo2);
		System.out.println("- Arco Tree BFS " + BFS2.bfsForest());
		
		System.out.println("- Existe el arco desde 1 a 4 directo?: " + grafo2.existeArco(1, 4));
		System.out.println("- Aunque exista el arco desde 1 a 4 directo, vamos a buscar si existen más formas de llegar desde 1 hasta 4:");
		System.out.println("- Servicio de Caminos:");
		ServicioCaminos<Integer> Camino2 = new ServicioCaminos<Integer>(grafo2,1,4,3);
		System.out.println(Camino2.caminos());
	}
}
