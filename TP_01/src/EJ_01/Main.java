package EJ_01;

public class Main {
	
	public static void main(String[] args) {
		
		Nodo<String> ultimo = new Nodo<>("ultimo", null);
		Nodo<String> segundo = new Nodo<>("segundo", ultimo);
		Nodo<String> primero = new Nodo<>("primero", segundo);
		
		System.out.println("\n"+"*********************************************");
		System.out.println("**************** EJERCICIO 1 ****************");
		System.out.println("*********************************************"+ "\n");
		System.out.println("Hago estos Nodos: ");
		
		System.out.println(primero);
		System.out.println(segundo);
		System.out.println(ultimo);
		
		ListaVinculada<String> listaVinculada = new ListaVinculada<>();
		
		System.out.println("\n"+"*********************************************"+ "\n");
		System.out.println("Chequeo que la lista esté vacía: ");
		System.out.println("Lista vacía?: " + listaVinculada.isEmpty());
		
		System.out.println("\n"+"*********************************************"+ "\n");
		System.out.println("Los agrego a esta ListaVinculada: ");
		
		listaVinculada.insertFront(ultimo);
		listaVinculada.insertFront(segundo);
		listaVinculada.insertFront(primero);
		System.out.println(listaVinculada);
		
		System.out.println("\n"+"*********************************************"+ "\n");
		System.out.println("Este es para probar el .size()");
		System.out.println("El tamaño de mi ListaVinculada es: " + listaVinculada.size());
		System.out.println("Lista vacía?: " + listaVinculada.isEmpty());
		
		System.out.println("\n"+"*********************************************"+ "\n");
		System.out.println("Agrego un nuevoPrimer Nodo para probar el insertFront: ");
		Nodo<String> nuevoPrimero = new Nodo<>("nuevoPrimeo (es el cero)", null);
		listaVinculada.insertFront(nuevoPrimero);
		System.out.println("La ListaVinculada queda: ");
		System.out.println(listaVinculada);
		System.out.println("El tamaño de la lista ahora es: "+listaVinculada.size());
		
		System.out.println("\n"+"*********************************************"+ "\n");
		System.out.println("Devolver el nodo en la posicion 0 es el: " + listaVinculada.get(0));
		System.out.println("Devolver el nodo en la posicion 2 es el: " + listaVinculada.get(2));
		
		System.out.println("\n"+ "*********************************************"+ "\n");
		System.out.println("Hago este nodo para borrar: ");
		Nodo<String> paraBorrar = new Nodo<>("Para borrar", null);
		System.out.println(paraBorrar);
		listaVinculada.insertFront(paraBorrar);
		System.out.println("La ListaVinculada queda: " + listaVinculada);
		System.out.println("El tamaño de la lista ahora es: "+listaVinculada.size());
		System.out.println("Nodo en la posicion 0 es el: "+listaVinculada.get(0) + "\n");
		System.out.println("Lo estoy borrando al: " + listaVinculada.extractFront()+ "\n");
		System.out.println("La ListaVinculada queda: " + listaVinculada);
		System.out.println("El tamaño de la lista ahora es: "+listaVinculada.size());
		System.out.println("Nodo en la posicion 0 es el: "+listaVinculada.get(0));
	}

}
