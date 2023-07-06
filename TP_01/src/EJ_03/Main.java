package EJ_03;
import EJ_01.*;

public class Main {

	public static void main(String[] args) {
		
		Pila<Integer> pila = new Pila<Integer>();
//		Nodo<Integer> uno = new Nodo<Integer>(1,null);
//		Nodo<Integer> dos = new Nodo<Integer>(2,null);
//		Nodo<Integer> tres = new Nodo<Integer>(3,null);
		
		pila.push(6);
		pila.push(5);
		pila.push(4);
		pila.push(3);
		pila.push(2);
		pila.push(1);
		
		System.out.println(pila);
		System.out.println("La doy vuelta: ");
		pila.reverse();
		System.out.println(pila);
		
		System.out.println("El primero de la pila es: "+pila.top());
		System.out.println("Borramos el primero: "+pila.pop());
		System.out.println("Ahora el primero es: "+pila.top());
		
		System.out.println(pila);
	}

}
