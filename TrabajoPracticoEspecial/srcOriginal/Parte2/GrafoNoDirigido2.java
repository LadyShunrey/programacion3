package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Parte1.Arco;
import Parte1.ArcoAbstracto;
import Parte1.ArcoDirigido;
import Parte1.GrafoAbstracto;

public class GrafoNoDirigido2<T> extends GrafoAbstracto<T> {
	
	public GrafoNoDirigido2(){
		super.compGrafo = new HashMap<T,ArrayList<ArcoAbstracto<T>>>();
		super.cantArcos=0;
	}
	
	@Override
	public void agregarArco(T verticeId1, T verticeId2, int etiqueta) {
//		super.agregarArco(verticeId1, verticeId2, etiqueta);
//		super.agregarArco(verticeId2, verticeId1, etiqueta);
		
		ArcoAbstracto<T> a = new ArcoNoDirigido<T>(verticeId1, verticeId2, etiqueta);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<ArcoAbstracto<T>>arcos =compGrafo.get(verticeId1);
			if(!arcos.contains(a) && a.getVerticeDestino()==verticeId2) {
				compGrafo.get(verticeId1).add(a);
				cantArcos++;
			}
		}
	}
	
	@Override
	public void borrarArco(T verticeId1, T verticeId2) {
//		super.borrarArco(verticeId1, verticeId2);
//		super.borrarArco(verticeId2, verticeId1);
		
		ArcoAbstracto<T> a = new ArcoNoDirigido<T>(verticeId1, verticeId2, null);
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
	
	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}
}
