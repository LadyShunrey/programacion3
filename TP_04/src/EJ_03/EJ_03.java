package EJ_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M.
*/

public class EJ_03 {

	
	private static HashSet<HashSet<Integer>> solucion = new HashSet<HashSet<Integer>>();
	
	public static void main(String[] args) {
		//IDEA: Mi estado inicial es un arrayList vacio y mi estado final es un arrayList con máximo n elementos cuya suma es M (esta lista final puede ser de uno o n elementos)
		//mi estado intermedio es {1,5}=={5,1} {6} {1,2,3}=={1,3,2} [etc]
		
		//El arbol de exploracion
		//{1}				 		 {2}			{3}
		//{1,2}{1,3}{1,5}    		 {2,3}{2,5}		{3,5}
		//{1,2,3}{1,3,5}		 	 {2,3,5}
		
		//tengo conjunto de numeros arrayList no se repiten
		//todos los puedo poner en un subconjunto
		
		//1, 2 == 2, 1?
		
		Integer uno = 1;
		Integer dos = 2;
		Integer tres = 3;
		Integer cinco = 5;
		Integer seis = 6;
		
		ArrayList<Integer> conjunto = new ArrayList<>();
		conjunto.add(uno);
		conjunto.add(dos);
		conjunto.add(tres);
		conjunto.add(cinco);
		conjunto.add(seis);

		int tieneQueSumar = 6; //M
		int suma = 0;
		HashSet<Integer> solucionParcial = new HashSet<>();
		
//		Iterator<Integer> iteradorConjunto = conjunto.iterator();
//		while(iteradorConjunto.hasNext()){
//			System.out.println(conjunto);
//			Integer siguiente = iteradorConjunto.next();
		armarSubconjuntos(solucionParcial, conjunto, tieneQueSumar, suma);
//			conjunto.remove(siguiente);
//			iteradorConjunto = conjunto.iterator();
//		}
		
		System.out.println(solucion);
	}
	
	public static void armarSubconjuntos(HashSet<Integer> solucionParcial, ArrayList<Integer> conjunto, Integer tieneQueSumar, Integer suma){
		System.out.println(solucionParcial);
		
		if(suma==tieneQueSumar){
//			encontré solucion
//			ArrayList<Integer> aux = new ArrayList<>();
			HashSet<Integer> aux = new HashSet<>();
			for(Integer valor: solucionParcial){
				aux.add(valor);
			}
//			solucion.add(aux);
			
			
			solucion.add(aux);
//			solucion.add(solucionParcial);
		}
		else{			//si no podo
			for(int i = 0; i<conjunto.size(); i++){
				Integer numero = conjunto.get(i);
				if(!poda(tieneQueSumar, suma+numero)){
					//busco una solucion posible
					solucionParcial.add(numero);
					suma+=numero;
					conjunto.remove(i);
					armarSubconjuntos(solucionParcial, conjunto, tieneQueSumar, suma);
					solucionParcial.remove(numero);
					conjunto.add(i, numero);
					suma-=numero;
				}
			}
		}
	}
	
	public static boolean poda(Integer tieneQueSumar, Integer suma){
		return suma>tieneQueSumar;
	}
}
