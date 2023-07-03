package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GrafoDirigido2<T> extends GrafoAbstracto<T> {

	public GrafoDirigido2(){
		super.compGrafo = new HashMap<T,ArrayList<ArcoAbstracto<T>>>();	
		super.cantArcos=0;
	}

	public void agregarArco(T verticeId1, T verticeId2, int etiqueta){
		ArcoAbstracto<T> a = new ArcoDirigido<T>(verticeId1, verticeId2, etiqueta);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<ArcoAbstracto<T>>arcos =compGrafo.get(verticeId1);
			if(!arcos.contains(a) && a.getVerticeDestino()==verticeId2) {
				compGrafo.get(verticeId1).add(a);
				cantArcos++;
			}
		}
	}
	
	public void borrarArco(T verticeId1, T verticeId2){
		ArcoAbstracto<T> a = new ArcoDirigido<T>(verticeId1, verticeId2, null);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<ArcoAbstracto<T>>arcos =compGrafo.get(verticeId1);
			Iterator<ArcoAbstracto<T>> iterator = arcos.iterator();
			while(iterator.hasNext()) {
				ArcoAbstracto<T> arco= iterator.next();
				if(a.equals(arco)) {
					iterator.remove();
					cantArcos--;
				}
			}
		}	
	}
	
	
}
