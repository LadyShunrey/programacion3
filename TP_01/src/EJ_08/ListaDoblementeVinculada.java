package EJ_08;

import EJ_01.ListaVinculada;
import EJ_01.Nodo;

/*Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente
vinculada.*/

public class ListaDoblementeVinculada<T> extends ListaVinculada<T>{
	private NodoDoblementeVinculado<T> primerNodo;

	public ListaDoblementeVinculada() {
		primerNodo=null;
		super.size = 0;
	}
	
	public void insertFront(NodoDoblementeVinculado<T> nodoNuevo){
		NodoDoblementeVinculado<T> nuevo = new NodoDoblementeVinculado<>(nodoNuevo.getInfo(), nodoNuevo.getNext());
		if(primerNodo!=null){
			nuevo.setNext(primerNodo);
			nuevo.setAnterior(null);
			primerNodo.setAnterior(nuevo);
		}	
		primerNodo = nuevo;
		super.size++;
	}
	
	@Override
	public String toString(){
		String result;
		result = "Mi lista tiene estos elementos: ";
//		Iterator<T> iteradorLista = this.iterator();
		Nodo<T> head = primerNodo;
		if(primerNodo!=null){
			result += "[" + primerNodo.getInfo() + "]";
			while(head.getNext()!=null){
				head = head.getNext();
				result += ", ["+head.getInfo() + "]";	
			}	
		}
		return result +=".";
	}
	
	public T get(int index){
		T elementoARetornar = null;
		int posicion = -1;
		Nodo<T> head = primerNodo;
		if(index<=size()){
			while(posicion!=index && head!=null){
				posicion++;
				if(posicion==index){
					return head.getInfo();
				}
				head = head.getNext();
			}
		}
		return elementoARetornar;
	}
	
	public NodoDoblementeVinculado<T> getPrimerNodo(){
		return primerNodo;
	}
}
