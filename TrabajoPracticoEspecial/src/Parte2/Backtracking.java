package Parte2;
import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Backtracking<T> {
	
	//arrayList de soluciones
	private ArrayList<T> redSubterraneo;
	public int longitudRedSubterraneo;
	
	public Backtracking(){
		this.redSubterraneo = new ArrayList<>();
		longitudRedSubterraneo = Integer.MAX_VALUE; /*Esto es un n�mero muy, muy grande*/
	}
	
	//poda: si el camino que llevo es mas largo que el camino parcial tengo guardado como m�s corto podo toda esa rama.
	public boolean poda(int sumaCaminoHastaAhora){
		return sumaCaminoHastaAhora >= longitudRedSubterraneo;
	}
	
	//metodo void backtracking que agrega elementos a la redsubterraneo
	public boolean backtracking(GrafoNoDirigido<T> grafo, T estacionActual, int metrosDeRedActualEnConstruccion, ArrayList<T> solucionEnConstruccion){
		System.out.println("Entro a Backtracking");
		System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
		System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
		//boolean result = false;
		//if llegue a la solucion return true
		if(grafo.cantidadVertices() == solucionEnConstruccion.size()){
			//termin�
			return true;
		}
		
		//else hago todo lo dem�s
		else{

			//traigo toda la lista de adyacentes de la estaci�n en la que estoy
			Iterator<T> iteradorDeEstaciones = grafo.obtenerAdyacentes(estacionActual);
			while(iteradorDeEstaciones.hasNext()){
				System.out.println("Entro al while");
				System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
				System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
				//elijo una siguiente
				T estacionSiguiente = iteradorDeEstaciones.next();
				//si no tengo ese arco en la solucion me fijo si se puede agregar
				if(!solucionEnConstruccion.contains(estacionSiguiente)){
					Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionActual, estacionSiguiente);
					int longitudDelTunel = tunelEntreLasEstaciones.getEtiqueta();
					//si no lo podo lo agrego a la solucion potencial
					if(!poda(metrosDeRedActualEnConstruccion+longitudDelTunel)){
						solucionEnConstruccion.add(estacionSiguiente);
						//sumo ese arco a mi suma solucion parcial
						metrosDeRedActualEnConstruccion += longitudDelTunel;
						boolean result = backtracking(grafo, estacionSiguiente, metrosDeRedActualEnConstruccion, solucionEnConstruccion);
						if (result){
							if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
//									//actualizo mejorRedHastaAhora
								longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
//									//mi red se vuelve la potencial: redSubterraneo = solucionPotencialEnConstruccion;
//									redSubterraneo = solucionEnConstruccion;
//									//creo que hay que hacer redSubte.clear y despu�s redSubte addAll
								redSubterraneo.clear();
								redSubterraneo.addAll(solucionEnConstruccion);
//								redSubterraneo = new ArrayList<>(solucionEnConstruccion);
								System.out.println("Tengo un result=true");
								System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
								System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
							}
						}
						solucionEnConstruccion.remove(estacionSiguiente);
						metrosDeRedActualEnConstruccion -= longitudDelTunel;
						System.out.println("Saco la �ltima estacion y vuelvo en la recursi�n");
						System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
						System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
					}	
				}
			} /*cierro while*/
			return false;
		}
	}

	//metodo que devuelve el arraylist de red de subterraneo
	public ArrayList<T> getRedSubterraneo(){
		return redSubterraneo;
	}
	

}
