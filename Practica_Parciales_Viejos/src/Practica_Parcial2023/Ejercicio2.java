package Practica_Parcial2023;

public class Ejercicio2 {
	//matriz cuadrada de NxN
	//cada celda numero entero NO NEGATIVO (>=0)
	//celdaOrigen y celdaDestino
	//encontrar el camino de mayor costo
	//costoActual = costoActual + celdaActual.getValor() y aparte mayorCosto = costoActual (if costoActual>mayorCosto && llegué a celdaDestino)
	//solucion es un array de celdas que empieza en celdaOrigen y termina cuando llego a celdaDestino
	//arriba, abajo, izq, der.
	//no puedo pasar dos veces por la misma celda
	//paso a la celda siguiente solo si celdaActual.getValor()<celdaSiguiente.getValor();
	
	//si hay que usar greedy usaría la estrategia de buscar la celda contigua que tenga el mayor valor.
	
	//pido la lista de celdas adyacentes, itero la lista, guardo la mayor celda, y después me fijo si es mayor que yo, si es mayor me paso a esa, sino es mayor terminé
	
	
	//public class Greedy{
	
	
		//ArrayList<Celda> caminoMayor;
	
	
		//public Greedy(ArrayList<Celda> celdasCandidatas){
			//this.caminoMayor = new ArrayList<>();
		//}
	
	
		//public greedy(ArrayList<Celda> celdasCandidatas, ArrayList<Celda> caminoActual, Celda celdaActual){ /*celdasCandidatas arranca con todas, caminoActual con la origen y la celdaActual va a ser la origen*/
			//if (!solucion(caminoActual)){
				//if(celdasCandidatas.isEmpty() == true){
					//no hay solución
					//terminé
				//}
				//else{
					//armo la solucion
					//Celda seleccionada: seleccionar (celdaActual, celdasCandidatas);
					//if seleccionada!= null {
						//celdasCandidatas.remove(seleccionada)
						//if ((factible(seleccionada)) || (seleccionada.equals(celdaDestino))){
							//caminoActual.add(seleccionada);
						//}
						//else{
							//greedy (caminoActual, seleccionada);
						//}
					//}
					//else{
						//greedy (caminoActual, seleccionada);
					//}
				//}
			//}
			//else{
				//caminoMayor.addAll(caminoActual);
				//terminé
			//}
		//}
		
	
		//public boolean solucion(caminoActual){
			//si mi caminoMayor.contains(celdaOrigen) && caminoMayor.contains(celdaDestino);
			//solucion va a devolver true cuando al analizar el array camino el mismo contenga la celdaOrigen y la celdaDestino
		//}
	
		//public Celda seleccionar(Celda celdaActual, ArrayList<Celda> candidatas){
			//Celda celdaSiguiente = null;
			//mayorValor = celdaActual.getValor();
			//si hay una celdaAdyacente... candidatas.obtenerAdyacentes(celdaActual);
				//pido la siguiente
				//pido el valor de la misma
				//si el valor de esta es más grande que el valor de celdaActual O BIEN es la celdaDestino
					//si la siguiente == celdaDestino
						//return celdaSiguiente = siguienteCelda;
					//else{
						//actualizo mayorValor = siguienteCelda.getValor();
						//celdaSiguiente = siguienteCelda;
					//}
			//return celdaSiguiente
		//}
	
		//public boolean factible(){
			//no sé qué hacer acá la verdad
		//}
	
		//public ArrayList<Celda> getCaminoMayor{
			//return caminoMayor;
		//}
	//}
}
