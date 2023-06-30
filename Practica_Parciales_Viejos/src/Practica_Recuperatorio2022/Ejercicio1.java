package Practica_Recuperatorio2022;

public class Ejercicio1 {
	//tengo un arbol binario de búsqueda
	//hay que verifica si se cumple que la diferencia entre un nodo interno y su hijo (siempre y cuando este hijo no sea una hoja)
	//no sea mayor a un valor K
	
	//Idea:
	//recorro el arbol, en cada nodo me fijo si tiene hijos, chequeo si estos hijos tiene hijos y calculo la diferencia de valor a ver
	//si es mayor a k
	
	//Desarrollo
	//me paro en root
	//pido un hijo de root
	//si no es null
		//pregunto si tiene nieto
		//si tiene nieto entonces hijo es un nodo interno
			//pido valor de nodo y valor de hijo y comparo con K
			//si la diferencia entre nodo y su hijo es menor a K
				//devuelvo true
			//si la diferencia entre nodo y su hijo es mayor a K
				//devuelvo false
		//si no tiene nieto es una hoja y no hago nada
	
	//Código
	
	//public class ArbolBinarioBusqueda(){
	
		//public ArbolBinarioBusqueda{.....}
	
		//public boolean diferenciaEsMenorAValorK(int nodo){
			//boolean resultado = false;
			//int hijo = nodo.getHijoIzquierdo();
			//if(hijo!=null){
				//int nieto = hijo.getHijoIzquierdo();
				//if(nieto==null){
					//nieto = hijo.getHijoDerecho();
				//}
				//if(nieto!=null){
					//K entre hijo y nodo
				//}
			//}
		//}
	//}
}
