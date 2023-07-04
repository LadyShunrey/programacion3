package Redoing;

import Redoing.Nodo;

public class EJ_04<T> {
	
	private Nodo<T> primerNodo;

	public int indexOf(T buscado){
		int indexOf = -1;
		int indice = 0;
		Nodo<T> head = new Nodo <T>(null, null);
		head = this.primerNodo;
		while((head != null) && (indexOf == -1)){
			if(head.getInfo() == buscado){
				indexOf = indice;
			}
			indice ++;
			head = head.getNext();
		}
		return indexOf;
	}
}
