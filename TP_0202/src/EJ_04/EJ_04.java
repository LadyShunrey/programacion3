package EJ_04;

import EJ_01.Nodo;

/*Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando
como entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos
valores que el de la derecha.*/

public class EJ_04 {

	public static void main(String[] args) {

		//Hojas
		Nodo veinte = new Nodo(20);
		Nodo nueveH = new Nodo(9);
		Nodo menosCinco = new Nodo(-5);
		Nodo siete = new Nodo(7);
		Nodo catorce = new Nodo(14);
		
		//Nodos internos
		Nodo nueveI = new Nodo(null, null, nueveH);
		Nodo menosDoce = new Nodo(null, siete, menosCinco);
		
		Nodo once = new Nodo(null, nueveI, veinte);
		Nodo menosVeintiSeis = new Nodo(null, catorce, menosDoce);
		
		//Raiz
		Nodo treintaysiete = new Nodo(null, menosVeintiSeis, once);
		
		System.out.println(veinte +""+ nueveH+""+menosCinco+""+siete+""+catorce+""+nueveI+""+menosDoce+""+once+""+menosVeintiSeis+""+treintaysiete);
		
		llenarNodosVacios(treintaysiete);
		
		System.out.println(veinte +""+ nueveH+""+menosCinco+""+siete+""+catorce+""+nueveI+""+menosDoce+""+once+""+menosVeintiSeis+""+treintaysiete);
	}

	public static void llenarNodosVacios(Nodo raiz){
		if(raiz.getIzquierdo()!=null){
			llenarNodosVacios(raiz.getIzquierdo());	
		}
		if(raiz.getDerecho()!=null){
			llenarNodosVacios(raiz.getDerecho());	
		}
		if(raiz.getValor()==null){
			Integer derecho = null;
			Integer izquierdo = null;
			if(raiz.getDerecho()!=null){
				if(raiz.getDerecho().getValor()!=null){
					derecho = raiz.getDerecho().getValor();
				}
				if(raiz.getDerecho().getValor()==null){
					derecho = 0;
				}
			}
			if(raiz.getDerecho()==null){
				derecho = 0;
			}
			
			if(raiz.getIzquierdo()!=null){
				if(raiz.getIzquierdo().getValor()!=null){
					izquierdo = raiz.getIzquierdo().getValor();
				}	
				if(raiz.getIzquierdo().getValor()==null){
					izquierdo = 0;
				}	
			}
			if(raiz.getIzquierdo()==null){
				izquierdo = 0;
			}
			
			raiz.setValor(derecho-izquierdo);
		}
		
	}
}
