package EJ_04;
/*
 * A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
 * indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
 * -1 si el elemento no existe en la lista.

 * */

public class EJ_04<T> {
	//lo paso al EJ_01
	public int indexOf(T elemento){
		int posicion = -1;
		
		//FUNCIONANDO EN EL EJ_04
		
		/*
		int iterador = 0; //este podria ser posicion
		Nodo<T> head = primerNodo;
		while(posicion==-1 || head!=null){
			if (head.getInfo()==elemento){
				posicion=iterador; //esto podria ser return iterador(que se llamaria posicion)
			}
			head = head.getNext();
			iterador++;
		}
		*/
		
		return posicion;
	}
}
