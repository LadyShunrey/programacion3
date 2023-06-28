package Parte2;
import java.util.ArrayList;

import Parte1.Arco;
import Parte1.GrafoDirigido;

public class GrafoNoDirigido<T> extends GrafoDirigido<T>{
		
		public void agregarArco(T verticeId1, T verticeId2, int etiqueta) {
			super.agregarArco(verticeId1, verticeId2, etiqueta);
			super.agregarArco(verticeId2, verticeId1, etiqueta);
		}
		
		@Override
		public void borrarArco(T verticeId1, T verticeId2) {
			super.borrarArco(verticeId1, verticeId2);
			super.borrarArco(verticeId2, verticeId1);
		}
		
		@Override
		public int cantidadArcos() {
			return super.cantidadArcos() / 2;
		}
		
		@Override
		public boolean existeArco(ArrayList<Arco<T>> grafo, T verticeId1, T verticeId2) {
			boolean existe = false;
			for(Arco<T> arco: grafo) {
				if((arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2)) ||
			            (arco.getVerticeOrigen().equals(verticeId2) && arco.getVerticeDestino().equals(verticeId1))) {
					existe=true;
				}else {
					existe=false;
				}
			}
			return existe;
		}


}
