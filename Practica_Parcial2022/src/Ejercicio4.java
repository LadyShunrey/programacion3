
public class Ejercicio4 {
	//estructura de Hashing con M = 4, rp = 2, rs = 1 y pd = 0.74
	//se usa h(x) = x mod M
	//insertar el 13 y el 28
	
	//  			18
	//  			6		20
	// 8	25		2		12
	// 0	1		2	3	4
	
	//chequeo el límite
	//si agregando un elemento no me paso del límite
		//inserto el 13:
		//hago 13 mod 4 = 1
		//busco el balde uno y como tiene una ranura libre lo inerto
		//cantidad de elementos++
	//si me paso del límite creo una nueva tabla que tenga M*2+1
		//paso todos los elementos de la vieja tabla a la nueva
		//vuelvo a calcular el nuevo limite
	
	
	//rhoActual = Tengo 7 elementos / 4*2 = 87% con 7 elementos 
	//M*rp*rhoMAX = 4 * 2 * 0.74 = 5.92 = 5 elementos MAX
	//Ya estoy excedida de tamaño, así que agrandamos la tabla al doble
	
	
	//nueva tabla tiene M=8, rp2 y pd074
	
	// 			18		20
	// 8	25	2		12		6
	// 0	1	2	3	4	5	6	7
	
	//vuelvo a correr el codigo para insertar el 13
	//rhoActual = Tengo 7 elementos / 8*2 = 43%
	//M*rp*rhoMAX = 8 * 2 * 0.74 = 11.84 = 11 elementos MAX
	//7<11 entonces puedo insertar
	
	//Se puede insertar el 13 asi que la tabla queda:
	
	//		18		20
	// 8	25	2		12	13	6
	// 0	1	2	3	4	5	6	7
	
	//inserto el 28 porque no me paso del limite
	
	//		18		20	28
	// 8	25	2		12	13	6
	// 0	1	2	3	4	5	6	7
}
