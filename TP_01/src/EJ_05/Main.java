package EJ_05;

import java.util.Iterator;

import EJ_01.ListaVinculada;
import EJ_01.Nodo;

public class Main {

	public static void main(String[] args) {
		
		Nodo<Integer> seis = new Nodo<>(6, null);
		Nodo<Integer> cinco = new Nodo<>(5, null);
		Nodo<Integer> cuatro = new Nodo<>(4, null);
		Nodo<Integer> tres = new Nodo<>(3, null);
		Nodo<Integer> dos = new Nodo<>(2, null);
		Nodo<Integer> uno = new Nodo<>(1, null);

		ListaVinculada<Integer> listaVinculada = new ListaVinculada<>();
		
		listaVinculada.insertFront(seis);
		listaVinculada.insertFront(cinco);
		listaVinculada.insertFront(cuatro);
		listaVinculada.insertFront(tres);
		listaVinculada.insertFront(dos);
		listaVinculada.insertFront(uno);
		
		System.out.println(listaVinculada);
		
		System.out.println("Itero la lista con el Iterator");
		
		Iterator<Integer> iteradorLista = listaVinculada.iterator();
		while(iteradorLista.hasNext()){
			System.out.println(iteradorLista.next());	
		}
	}
}
