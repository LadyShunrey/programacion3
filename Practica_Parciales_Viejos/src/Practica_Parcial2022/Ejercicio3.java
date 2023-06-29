package Practica_Parcial2022;
//backtracking del ejercicio 2

public class Ejercicio3 {
	//INICIO en E0
	//Siguiente nivel del arbol puede ser E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, 11 12 13
	
	//En cada nivel voy pidiendo el resultado de la distancia entre su nivel anterior y este actual y voy llevando una variable suma del camino actual.
	//me guardo el actual por si es solucion
	//si cantidad de staciones hasta ahora > x, llamo PODAR();
	//si largo del camino actual > K, llamo PODAR(); y aparte agrego el último que no se pase de K a la solucion
	//PODA si llego a E13 podar() porque termine
	//lleva la cuenta de la menor cantidad de estaciones hasta ahora como X.
	
	
	//Siguiente nivel del arbol puede ser
	//E1: E2, E3, E4, E5, E6, E7, E8, E9, E10, 11 12 13
	//E2: E3, E4, E5, E6, E7, E8, E9, E10, 11 12 13
	//E3: E4, E5, E6, E7, E8, E9, E10, 11 12 13
	//E4: E5, E6, E7, E8, E9, E10, 11 12 13
	//[.......]
	
	//Siguiente nivel del arbol puede ser
	//E1, E2: E3, E4, E5, E6, E7, E8, E9, E10, 11 12 13
	//E1, E3: E4, E5, E6, E7, E8, E9, E10, 11 12 13
	//E1, E4: E5, E6, E7, E8, E9, E10, 11 12 13
	//E1, E5: E6, E7, E8, E9, E10, 11 12 13
	//E1, E6: E7, E8, E9, E10, 11 12 13
	
}
