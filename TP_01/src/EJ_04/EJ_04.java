package EJ_04;
/*
 * A la implementaci�n de la clase Lista realizada en el ejercicio 1, agregue un m�todo
 * indexOf, que reciba un elemento y retorne el �ndice donde est� almacenado ese elemento, o
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
