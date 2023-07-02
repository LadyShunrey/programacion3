package Parte2;
import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Backtracking<T> {
	
	//arrayList de soluciones
	private ArrayList<Arco<T>> redSubterraneo;
	public int longitudRedSubterraneo;
	
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
		System.out.println("Entro a Backtracking");
		System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
		System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
		//boolean result = false;
		//if llegue a la solucion return true
		if(grafo.cantidadArcos() == solucionEnConstruccion.size()){
			//terminé
			return true;
		}
		
		//else hago todo lo demás
		else{

			//traigo toda la lista de adyacentes de la estación en la que estoy
			Iterator<T> iteradorDeEstaciones = grafo.obtenerAdyacentes(estacionActual);
			while(iteradorDeEstaciones.hasNext()){
				System.out.println("Entro al while");
				System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
				System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
				//elijo una siguiente
				T estacionSiguiente = iteradorDeEstaciones.next();
				//si no tengo ese arco en la solucion me fijo si se puede agregar
				
//				if(!existeArco(solucionEnConstruccion, estacionActual, estacionSiguiente)){
				if(!solucionEnConstruccion.contains(grafo.obtenerArco(estacionActual,estacionSiguiente))){
					Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionActual,estacionSiguiente);
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
//								redSubterraneo = new ArrayList<>(solucionEnConstruccion);
								System.out.println("Tengo un result=true");
								System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
								System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
							}
						}
						solucionEnConstruccion.remove(tunelEntreLasEstaciones);
						metrosDeRedActualEnConstruccion -= longitudDelTunel;
						System.out.println("Saco la última estacion y vuelvo en la recursión");
						System.out.println("Red de subte en construccion: "+solucionEnConstruccion);
						System.out.println("Longitud de la red de subte en construccion: "+metrosDeRedActualEnConstruccion);
					}	
				}
			} /*cierro while*/
			return false;
		}
	}

	//metodo que devuelve el arraylist de red de subterraneo
	public ArrayList<Arco<T>> getRedSubterraneo(){
		return redSubterraneo;
	}
	
//	public boolean existeArco(ArrayList<Arco<T>> grafo, T verticeId1, T verticeId2) {
//		boolean existe = false;
//		for(Arco<T> arco: grafo) {
//			if((arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2)) ||
//		            (arco.getVerticeOrigen().equals(verticeId2) && arco.getVerticeDestino().equals(verticeId1))) {
//				return true;
//			}else {
//				existe=false;
//			}
//		}
//		return existe;
//	}

}
