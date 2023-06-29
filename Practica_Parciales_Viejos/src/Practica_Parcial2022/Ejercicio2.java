package Practica_Parcial2022;
// Un camionero conduce desde Buenos Aires hasta Ushuaia.
// con el tanque lleno recorre K kilometros sin parar
//Tenemos las distancias entre las estaciones que hay en la ruta
//La ruta ya la tenemos dada
//Tenemos una lista vinculada E que tiene las estaciones en el orden de la ruta

public class Ejercicio2 {
	
	//a)Escribir el pseudocódigo
		//Lo que tiene que hacer el código:
			//aranco por una estacion
			//me muevo a la más lejana que alcance sin pasarme de k
			//si llegué a la última estación encontré una solución
			//sino llegué a destino vuelvo a calcular lo mismo desde la estación que esté
	
		//Desarrollo:
	
		//pido una estación E a la lista de estaciones y la guardo en estacionOrigen
		//si es la primera la agrego a la lista de soluciones si todavía no la agregué
		//si es la última la agrego a la lista de soluciones si todavía no la agregué y mi código termina ahi
	
		//pido la proxima siguiente estacion a la estacionOrigen con el nombre estacionPotencialSiguiente
		//guardo el valor de la estacionPotencialSiguiente por las dudas que sea una solución
		//creo otra estacionSiguiente y le asigno el valor de estacionPotencialSiguiente
	
		//mientras ditancia estacionOrigen, estacionPotencialSiguiente sea menor a K
			//pido la distancia entre estacionOrigen y estacionPotencialSiguiente
			//si es menor a k 
				//estacionSiguiente = estacionPotencialSiguiente
				//pido siguientePotencialEstacion = siguientePotencialEstacion.next()
		//agrego estacionSiguiente a la lista de soluciones
		//estacionOrigen = estacionSiguiente;
		//vuelvo a llamar el método con la nueva estacion de origen 
	
	//b) Cuáles son los candidatos del algoritmo? 
		//Todas las estaciones desde la E0 hasta la E13 son candidatos potenciales
	//c) Explique cual es la estrategia greedy de seleccion de candidatos
		//Buscar el candidato más lejano posible de dónde estoy sin pasarme de k

}
