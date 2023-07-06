package EJ_07;

import java.util.ArrayList;
import java.util.Iterator;

/*Escriba una función que dadas dos listas construya otra con los elementos que están en la
primera pero no en la segunda.*/

public class ListaCombinadaExcluyente<T>{
	ArrayList<Integer> lista1;
	ArrayList<Integer> lista2;
	ArrayList<Integer> listaCombinadaExcluyente;
	
	public ListaCombinadaExcluyente(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		listaCombinadaExcluyente = new ArrayList<Integer>();
		this.combinar(lista1, lista2);
	}

	public void combinar(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		Iterator<Integer> iterador1 = lista1.iterator();
		Integer uno;
		while (iterador1.hasNext()){
			uno = iterador1.next();
			System.out.println(uno);	
			
			if(!lista2.contains(uno)){
				if(!listaCombinadaExcluyente.contains(uno)){
					listaCombinadaExcluyente.add(uno);	
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String result;
		result = "Mi lista tiene estos elementos: ";
		Iterator<Integer> iteradorLista = listaCombinadaExcluyente.iterator();
		Integer head = iteradorLista.next();
		if(head!=null){
			result += "[" + head + "]";
			while(iteradorLista.hasNext()){
				head = iteradorLista.next();
				result += ", ["+head+ "]";	
			}	
		}
		return result +=".";
	}
}
