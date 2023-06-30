package Practica_Recuperatorio2022;

public class Ejercicio4 {
	//Hashing
	//M=5
	//rp=2
	//rs=1
	//Pd=0.8
	
	//funcion (x) = x mod M
	
	//insertar: {15, 28, 21} en ese orden
	
	//indicar las operaciones
	
	//Primero calculamos el límite
	//L = M*rp*Pd
	//L = 5 * 2 * 0.8
	//L = 8 
	//La cantidad máxima de elementos es de 8
	
	//la tabla tiene 9 elementos por lo que estamos pasados del límite así que vamos a hacer una nueva tabla
	
	// El nuevo M = M * 2 + 1
	// M = 5 * 2 + 1
	// M = 11
	
	//el nuevo límite es de
	// L = M * Rp * Pd
	// L = 11 * 2 * 0,8
	// L = 17
	
	// Como el nuevo límite es 17 y tengo 9 elementos ya puedo insertar sin problema 
	//(de hecho voy a poder insertar los 3 sin tener que hacer rehash a la tabla)
	
	// 
}
