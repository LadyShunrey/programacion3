package Practica_Parcial2023;

public class Ejercicio3 {
	//conjunto de N numeros ENTEROS
	//4 subconjuntos NO VACIOS
	//cada subconjunto es una particion de N (la union de los 4 subconjuntos es = N)
	//la suma de los 4 subconjuntos es = T
	//Por ej. N={5, 19, 3, 7, 9, 2, 1, -10} y T-9. Una solución sería (5,3,1} (7,2} {9} {19, -10}
	
	//estado inicial:
	// N={5, 19, 3, 7, 9, 2, 1, -10}
	// S={} {} {} {}
	
	//estados intermedios:
	//N={19, 3, 7, 9, 2, 1, -10} 	// N={19, 3, 7, 9, 2, 1, -10} 	// N={19, 3, 7, 9, 2, 1, -10} 	// N={19, 3, 7, 9, 2, 1, -10}
	// S={5} {} {} {}				// S={} {5} {} {}				// S={} {} {5} {}				// S={} {} {} {5}
	
	//N={3, 7, 9, 2, 1, -10} 	// N={3, 7, 9, 2, 1, -10} 	// N={3, 7, 9, 2, 1, -10} 	// N={3, 7, 9, 2, 1, -10}
	//S={5, 19} {} {} {}		// S={5} {19} {} {}			// S={5} {} {19} {}			// S={5} {} {} {19}
	
	//N={7, 9, 2, 1, -10} 	// N={7, 9, 2, 1, -10} 	// N={7, 9, 2, 1, -10} 	// N={7, 9, 2, 1, -10}
	//S={5, 19, 3} {} {} {}	// S={5,19} {3} {} {}	// S={5,19} {} {3} {}	// S={5,19} {} {} {3}
	
	
	//public ArrayList<ArrayList<int>> backtracking(ArrayList<int> conjuntoN, ArrayList<ArrayList<int>>solucionParcial){
		//if(solucion(solucionParcial, conjuntoN)){
			//return solucionParcial;
		//}
		//else{ //busco una solucion			
			//while(!conjuntoN.isEmpty()){
				//numeroActual = conjuntoN.iterator().next(); //agarro un numero 
				//conjuntoN.remove(numeroActual);
				//lo agrego a un subconjunto de solucionParcial pruebo de poner ese número en un subconjunto y recurso con el siguiente numero
				//for(ArrayList<int> subconjunto: solucionParcial){ //pido un subconjunto
					//if(!subconjunto.contains(numeroActual)){
						//subconjunto.add(numeroActual)
						//solucionParcial = backtracking(conjuntoN, solucionParcial);
					//}
				//}
			//}
		//}
		//if(!solucion(solucionParcial,conjuntoN) && (conjuntoN.isEmpty()) ){
			//no existe solucion
		//}
		//en qué momento me doy cuenta que no existe solucion
	//}
	
	//public boolean solucion(){
		//chequea si llegué a una posible solución
		//si conjuntoN está vacio
			//si solucionParcial tiene 4 subconjuntos && cada uno de ellos != null;
				//si cada uno de estos subconjuntos suma T
					//return true;
		//else{
			//return false;
		//}
	//}
}
