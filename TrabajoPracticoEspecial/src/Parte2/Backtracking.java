package Parte2;
import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Backtracking<T> {
	
	//arrayList de soluciones
	private ArrayList<Arco<T>> redSubterraneo;
	private int longitudRedSubterraneo;
	
	public Backtracking(){
		this.redSubterraneo = new ArrayList<>();
		longitudRedSubterraneo = Integer.MAX_VALUE; /*Esto es un número muy, muy grande*/
	}
	
	//poda: si el camino que llevo es mas largo que el camino parcial tengo guardado como más corto podo toda esa rama.
	public boolean poda(int sumaCaminoHastaAhora){
		return sumaCaminoHastaAhora >= longitudRedSubterraneo;
	}
	
	//metodo void backtracking que agrega elementos a la redsubterraneo
	public boolean backtracking(GrafoNoDirigido<T> grafo, T estacionActual, int metrosDeRedActualEnConstruccion, ArrayList<Arco<T>> solucionEnConstruccion){
		//boolean result = false;
		//if llegue a la solucion return true
		if(grafo.cantidadVertices()-1 == solucionEnConstruccion.size()){
			//terminé
			return true;
		}
		
		//else hago todo lo demás
		else{

			//traigo toda la lista de adyacentes de la estación en la que estoy
			Iterator<T> iteradorDeEstaciones = grafo.obtenerAdyacentes(estacionActual);
			while(iteradorDeEstaciones.hasNext()){
				//elijo una siguiente
				T estacionSiguiente = iteradorDeEstaciones.next();
				Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionSiguiente, estacionActual);
				//si no tengo ese arco en la solucion me fijo si se puede agregar
				if(!solucionEnConstruccion.contains(tunelEntreLasEstaciones)){
					int longitudDelTunel = tunelEntreLasEstaciones.getEtiqueta();
					//si no lo podo lo agrego a la solucion potencial
					if(!poda(metrosDeRedActualEnConstruccion+longitudDelTunel)){
						solucionEnConstruccion.add(tunelEntreLasEstaciones);
						//sumo ese arco a mi suma solucion parcial
						metrosDeRedActualEnConstruccion += longitudDelTunel;
						boolean result = backtracking(grafo, estacionSiguiente, metrosDeRedActualEnConstruccion, solucionEnConstruccion);
						if (result){
							if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
//									//actualizo mejorRedHastaAhora
								longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
//									//mi red se vuelve la potencial: redSubterraneo = solucionPotencialEnConstruccion;
//									redSubterraneo = solucionEnConstruccion;
//									//creo que hay que hacer redSubte.clear y después redSubte addAll
								redSubterraneo.clear();
								redSubterraneo.addAll(solucionEnConstruccion);
							}
						}
						solucionEnConstruccion.remove(tunelEntreLasEstaciones);
						metrosDeRedActualEnConstruccion -= longitudDelTunel;
					}	
				}
			} /*cierro while*/
			return false;
		}
	}
//			
//			
//			
	
	//suma solucion parcial
//	int metrosDeTunelConstruidosHastaAhora = metrosDeRedActualEnConstruccion;	
//	
//	//armo la solucionparcial
//	ArrayList <Arco<T>> solucionPotencialEnConstruccion = solucionEnConstruccion;
//			//armo toda la lista de estaciones
//			Iterator<T> iteradorDeEstaciones = grafo.obtenerVertices();
//			
//			//si estacionActual viene vacío es porque todavía no empecé y es la primer estación del grafoInicial
//			if(estacionActual==null){
//				estacionActual = iteradorDeEstaciones.next();	
//			}
//			
//			
//			//pido una adyacente (si hay)
//			T estacionSiguiente;
//			if (iteradorDeEstaciones.hasNext()){
//				estacionSiguiente = iteradorDeEstaciones.next();
//				
//				//agrego esa estacion a la solucion
//				
//				//pido el tunel y su longitud
//				Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionActual, estacionSiguiente);
//				int longitudDelTunel = tunelEntreLasEstaciones.getEtiqueta();
//				
//				//sumo ese arco a mi suma solucion parcial
//				metrosDeTunelConstruidosHastaAhora += longitudDelTunel;
//				
//				//si no lo podo lo agrego a la solucion potencial
//				if(!poda(metrosDeTunelConstruidosHastaAhora)){
//					solucionPotencialEnConstruccion.add(tunelEntreLasEstaciones);
//				}
//				
//				//si lo podo sigo recursionando por el siguiente nodo
//				if (poda(metrosDeTunelConstruidosHastaAhora)){
//					backtracking(grafo, estacionActual, metrosDeTunelConstruidosHastaAhora, solucionPotencialEnConstruccion);
//					//si ya resolvio cortamos devolvemos la solucion
//					//
//				}
//				
//			}
//			else{
//				///*if(estacionSiguiente == null*/)
//				/*Llegué a una solución posible?*/
//				//si iteré todas las estaciones posibles, es decir, si mi conjunto solucion tiene todas las estaciones
//					//sí es igual o menor que la mejor
//					if(metrosDeTunelConstruidosHastaAhora<=longitudRedSubterraneo){
//						//actualizo mejorRedHastaAhora
//						longitudRedSubterraneo = metrosDeTunelConstruidosHastaAhora;
//						//mi red se vuelve la potencial: redSubterraneo = solucionPotencialEnConstruccion;
//						//creo que hay que hacer redSubte.clear y después redSubte addAll
//						redSubterraneo.clear();
//						redSubterraneo.addAll(solucionPotencialEnConstruccion);
//					}
//						
//				
//				return false;
//
//			}
//		
		
		
		
		
		
		
		
		//if cumple condicion, cual condicion? todas las estaciones visitadas? Cómo las marco?
			//es una posible solución?
			//SI:
				//agrego el valor a camino parcial
				//sumar el camino parcial
				//poda?
			//NO: 
				//hago back de los hijos

		
		
		
		
		
		
		/*If cumple Condición de Corte:
   			¿e es una posible solución?
     		SI:
       			operar con la solución
       			Ej.: fijarse si es la mejor hasta el momento, o
      			agregarla a una lista de soluciones, o imprimir, etc ,etc
    		NO:
      			Para cada hijo c del estado actual e:
      			Backtraking(c) /// EXPLORAR recursivamente a partir de c
      			
      	}
      	 if ( SOLUCION (e))
       		OperarSobreSolución (e, sol);
  		 else {
     		int nrohijo = 1;
     		estado siguiente;
     		while ( HIJOS (nrohijo, e, siguiente ) )
     			{ if ( !PODA ( siguiente, sol) )
			       { AgregarASolucionActual(siguiente, sol);
			         BACK ( siguiente, sol);
			         QuitarDeSolucionActual(siguiente, sol);
			    	}
       				nrohijo++;
    			}
			}

*/
	
	
	//factible?
	
	//metodo que devuelve el arraylist de red de subterraneo
	public ArrayList<Arco<T>> getRedSubterraneo(){
		return redSubterraneo;
	}
	

}

//estado inicial? Armo el grafo y todos en blanco?
//espacio de búsqueda: candidatos
