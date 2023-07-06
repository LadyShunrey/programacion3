package EJ_04;
import EJ_01.*;

public class Main {

	public static void main(String[] args) {
		Nodo<Integer> cinco = new Nodo<>(5, null);
		Nodo<Integer> cuatro = new Nodo<>(4, null);
		Nodo<Integer> tres = new Nodo<>(3, null);
		Nodo<Integer> dos = new Nodo<>(2, null);
		Nodo<Integer> uno = new Nodo<>(1, null);

		ListaVinculada<Integer> listaVinculada = new ListaVinculada<>();
		
		listaVinculada.insertFront(cinco);
		listaVinculada.insertFront(cuatro);
		listaVinculada.insertFront(tres);
		listaVinculada.insertFront(dos);
		listaVinculada.insertFront(uno);
		
		System.out.println(listaVinculada);
		System.out.println("El valor 3 está en la posicion: " + listaVinculada.indexOf(3));
		
		System.out.println("El valor 6 debería dar -1 porque no está en la lista: " + listaVinculada.indexOf(6));
	}

}
