package EJ_05;

/*A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
 *iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
 *hora de recorrer la lista de principio a fin si se cuenta con un iterador?
*/

public class EJ_05 {
/*
 * HECHO EN EL EJ_01
 * 
 * public class ListaVinculada<T> implements Iterable<T>{
 * 		@Override
	public Iterator<T> iterator() {
		return new ListaVinculadaIterator();
	}

	private class ListaVinculadaIterator implements Iterator<T>{
		
		private Nodo<T> head;
		
		public ListaVinculadaIterator(){
			head = primerNodo;
		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public T next() {
			if(hasNext()){
				T elemento = head.getInfo();
				head = head.getNext();
				return elemento;
			}
			else{
				return null;
			}
		}
		
	}
 * }
 * 
 * 
 * */
}
