package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Parte1.Arco;

public class BacktrackTEST<T> {
	
	private ArrayList<Arco<T>> redSubterraneo;
	public int longitudRedSubterraneo;
	public int contadorBack;
	
	public BacktrackTEST(){
		this.redSubterraneo = new ArrayList<>();
		this.longitudRedSubterraneo = Integer.MAX_VALUE; /*Esto es un número muy, muy grande*/
		this.contadorBack = 0;
	}
	
	public boolean backtracking(GrafoNoDirigido<T> grafo, ArrayList<Arco<T>> arcosDisponibles, ArrayList<Arco<T>> solucionParcial, int longitudActual, Map<String, Integer> nodosVisitados){
		
//
//		  - Obtengo la lista de TODOS los arcos del grafo
		Iterator<Arco<T>> iteradorDeArcos = grafo.obtenerArcos();
//		  - Mi condicion de solucion es que haya visitado al menos una vez cada nodo
//		     . Vamos a llevar un Mapa que sera: Map<T,Integer> y tiene todos los nodos cargados 
//		     . Cada vez que agregamos un arco a la solucion, le sumamos 1 a los nodos de origen y destino
//		     . Para evaluar si termine, me fijo que todos los keys esten con un nro>0
//		     . Cuando sacamos un arco de la solucion, le restamos 1 a los nodos origen y destino      
//		       
		  
		if (solucion(nodosVisitados)){
			return true;
		}
		else {
			while (!arcosDisponibles.isEmpty()) {
//			     - pido proximo arco
				Arco<T> tunel = iteradorDeArcos.next();
				if (!poda(longitudActual)){  
//			        - agrego arco a la lista solucion parcial
					if(!solucionParcial.contains(tunel)){
						solucionParcial.add(tunel);
						arcosDisponibles.remove(tunel);
						longitudActual += tunel.getEtiqueta();
					}
//			        - quito arco de la lista de disponibles (ojo con la ida y vuelta)
//			        - longitudActual += arco.loingitud
//			        
//			         - sumar 1 a nodo origen visitado
//			         - sumar 1 a nodo destino visitado
//			         
			        boolean result = backtracking(grafo, arcosDisponibles, solucionParcial, longitudActual, nodosVisitados);
//			         
			        if (result) {
//			          - comparo longitudActual con mejorLongitud
			        	
//			          - si la actual es mejor, reemplazamos la mejorSolucion con la actual y la mejorLongitud con la actual
			        }
//			         
//			         - quito el arco de la lista de solucion parcial
//			         - devuelvo el arco a la lista de soluciones disponibles //OJO con el iterador
//			         - longitudActual -= arco.longitud;
		      }
		   }
		   return false; //ya no hay mas arcos q probar
		 }
	}
	
	public boolean poda(int longitudActual) {
		if(longitudActual>longitudRedSubterraneo){
			return true;
		}
		else{
			return false;	
		}
	}

	public boolean solucion(Map<String, Integer> nodosVisitados){
//	     . Para evaluar si termine, me fijo que todos los keys esten con un nro>0
		int cantidadDeStrings = 0; //Cantidad de estaciones
		int cantidadDeEstacionesVisitadas = 0;
		
		for(String nodo: nodosVisitados){
			int valor = nodo.getKey();
			(if valor>0){
				//esta visitado
				//hago visitado++
				cantidadDeNodosVisitados++;
			}
		}
		if(cantidadDeEstacionesVisitados==cantidadDeEstacionesVisitadas){
			return true;
		}
		
		return false;
	}
}



//itero las estaciones
	//agarro la primer estación
	//pido una estacion adyacente
	//guardo el valor del tunel
	//pido otra estacion adyacente
	//comparo el valor del tunel con la que tengo guardada
	//si es más corto actualizo el valor guardado por ese
	//recurso
	
	
	//buscar algoritmo PRIM

