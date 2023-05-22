
public class Main {
	public static <T> void main(String[]args) {
		
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
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

		System.out.println("Nuestro grafo tiene: " + grafo.cantidadVertices() + " vertices");
		System.out.println("Nuestro grafo tiene: " + grafo.cantidadArcos() + " arcos");
		System.out.println("Existe el arco desde 1 a 2 directo?: " + grafo.existeArco(1, 2));
		
		System.out.println("Si no existe el arco desde 1 a 2 entonces vamos a buscar si existe una forma de llegar desde 1 hasta 2:");

		System.out.println("Servicio DFS:");
		ServicioDFS<Integer> DFS = new ServicioDFS<Integer>(grafo);
		System.out.println("Arco Tree DFS " + DFS.dfsForest());
		
		System.out.println("Servicio BFS:");
		ServicioBFS<Integer> BFS = new ServicioBFS<Integer>(grafo);
		System.out.println("Arco Tree BFS " + BFS.bfsForest());
		
		System.out.println("Servicio de Caminos:");
		ServicioCaminos<Integer> Camino = new ServicioCaminos<Integer>(grafo,1,2,3);
		System.out.println(Camino.caminos());

	}
}
