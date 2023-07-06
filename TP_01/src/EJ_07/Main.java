package EJ_07;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> listaImpar = new ArrayList<>();
		ArrayList<Integer> listaPar = new ArrayList<>();
		
		listaImpar.add(15);
		listaImpar.add(7);
		listaImpar.add(8);
		listaImpar.add(17);
		listaImpar.add(9);
		listaImpar.add(3);
		listaImpar.add(3);
		listaImpar.add(15);
		
		System.out.println(listaImpar);
		
		listaPar.add(2);
		listaPar.add(4);
		listaPar.add(6);
		listaPar.add(8);
		listaPar.add(12);
		listaPar.add(20);
		listaPar.add(50);
		
		System.out.println(listaPar);
		
		ListaCombinadaExcluyente<Integer> listaCombinadaExcluyente = new ListaCombinadaExcluyente<Integer>(listaImpar, listaPar);
		
		System.out.println(listaCombinadaExcluyente);
	}
}


