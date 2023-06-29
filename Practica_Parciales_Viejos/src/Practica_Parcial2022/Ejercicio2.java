package Practica_Parcial2022;
// Un camionero conduce desde Buenos Aires hasta Ushuaia.
// con el tanque lleno recorre K kilometros sin parar
//Tenemos las distancias entre las estaciones que hay en la ruta
//La ruta ya la tenemos dada
//Tenemos una lista vinculada E que tiene las estaciones en el orden de la ruta

public class Ejercicio2 {
	
	//a)Escribir el pseudoc�digo
		//Lo que tiene que hacer el c�digo:
			//aranco por una estacion
			//me muevo a la m�s lejana que alcance sin pasarme de k
			//si llegu� a la �ltima estaci�n encontr� una soluci�n
			//sino llegu� a destino vuelvo a calcular lo mismo desde la estaci�n que est�
	
		//Desarrollo:
	
		//pido una estaci�n E a la lista de estaciones y la guardo en estacionOrigen
		//si es la primera la agrego a la lista de soluciones si todav�a no la agregu�
		//si es la �ltima la agrego a la lista de soluciones si todav�a no la agregu� y mi c�digo termina ahi
	
		//pido la proxima siguiente estacion a la estacionOrigen con el nombre estacionPotencialSiguiente
		//guardo el valor de la estacionPotencialSiguiente por las dudas que sea una soluci�n
		//creo otra estacionSiguiente y le asigno el valor de estacionPotencialSiguiente
	
		//mientras ditancia estacionOrigen, estacionPotencialSiguiente sea menor a K
			//pido la distancia entre estacionOrigen y estacionPotencialSiguiente
			//si es menor a k 
				//estacionSiguiente = estacionPotencialSiguiente
				//pido siguientePotencialEstacion = siguientePotencialEstacion.next()
		//agrego estacionSiguiente a la lista de soluciones
		//estacionOrigen = estacionSiguiente;
		//vuelvo a llamar el m�todo con la nueva estacion de origen 
	
	//b) Cu�les son los candidatos del algoritmo? 
		//Todas las estaciones desde la E0 hasta la E13 son candidatos potenciales
	//c) Explique cual es la estrategia greedy de seleccion de candidatos
		//Buscar el candidato m�s lejano posible de d�nde estoy sin pasarme de k

}
