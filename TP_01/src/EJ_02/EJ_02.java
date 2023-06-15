package EJ_02;

public class EJ_02 {
	//Comparar las complejidades entre una Lista y un Array para cada caso

	//1) insertar al principio
	
	// Lista O(1) porque accede una sola vez, lo mismo con el Array
	
	//2) Buscar un elemento en una posición
	
	// El array va a seguir siendo O(1) porque accede una sola vez por 
	//la posicion. Sin embargo la Lista va a ser O(n) ya que va a depender 
	//de la cantidad de elementos
	
	//3) Determinar la cantidad de elementos
	
	// En la Lista va a ser O(n) ya que depende de la cantidad de elementos, 
	//excepto que llevemos una variable size, en ese caso es O(1). En el Array va
	//a ser O(n) porque hay que ir uno por uno, a menos que tengamos declarado 
	//el temaño del array como una variable global, ahí es O(1)
}
