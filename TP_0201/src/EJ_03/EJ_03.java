package EJ_03;
import java.util.Arrays;
import java.util.Random;

import EJ_01.*;
import EJ_02.*;

/*Implemente una funci�n que cree un arreglo de tama�o N con n�meros aleatorios. Corra los
algoritmos de los ejercicios 3 y 4, 10000 veces consecutivas cada uno, y compruebe el tiempo
de ejecuci�n. Haga lo mismo con el m�todo Arrays.sort(...) de Java, y compare los tiempos
obtenidos. Investigue c�mo est� implementado el Array.sort()*/

/*En arreglos grandes el ArraySort parece ser el m�s r�pido mientras que Burbujeo y Seleccion los peores
 * En arreglos chicos MergeSort es el que m�s tarda*/

public class EJ_03 {

	public static void main(String[] args) { 
        correrMilVecesAlgoritmos();	
	}
	
	public static void correrMilVecesAlgoritmos(){
		int n = 10; // Tama�o del arreglo
        int min = 0; // Valor m�nimo del rango
        int max = 100; // Valor m�ximo del rango
        
        int[] arreglo = generarArregloAleatorio(n, min, max);
        
        System.out.println("El arreglo1 es: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i] + "] ");	
		}
        
        Timer timerSeleccion = new Timer();
        Timer timerBurbujeo = new Timer();
        Timer timerMergeSort = new Timer();
        Timer timerQuickSort = new Timer();
        Timer timerArraySort = new Timer();
        
        timerSeleccion.start();
        for(int i=0;i < 1000;i++){
        	EJ_01.ordenarPorSeleccion(arreglo);
        }
		double tiempoSeleccion = timerSeleccion.stop();
		
		System.out.println("\n\nEl arreglo1 ORDENADO queda: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i]+"] ");	
		}
		
		timerBurbujeo.start();
		for(int i=0;i < 1000;i++){
			EJ_01.ordenarPorBurbujeo(arreglo);
		}
		double tiempoBurbujeo = timerBurbujeo.stop();
		
		System.out.println("\n\nEl arreglo1 ORDENADO queda: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i]+"] ");	
		}
		
		timerMergeSort.start();
		for(int i=0;i < 1000;i++){
			EJ_02.sort(arreglo);
		}
		double tiempoMergeSort = timerMergeSort.stop();
		
		System.out.println("\n\nEl arreglo1 ORDENADO queda: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i]+"] ");	
		}
		
		timerQuickSort.start();
		for(int i=0;i < 1000;i++){
			EJ_02.ordenarPorQuickSort(arreglo);
		}
		double tiempoQuickSort = timerQuickSort.stop();
		
		System.out.println("\n\nEl arreglo1 ORDENADO queda: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i]+"] ");	
		}
		
		timerArraySort.start();
		for(int i=0;i < 1000;i++){
			Arrays.sort(arreglo);
		}
		double tiempoArraysSort = timerArraySort.stop(); 
		
		System.out.println("\nEl tiempo de Seleccion es: " + tiempoSeleccion);
		System.out.println("\nEl tiempo de Burbujeo es: " + tiempoBurbujeo);
		System.out.println("\nEl tiempo de MergeSort es: " + tiempoMergeSort);
		System.out.println("\nEl tiempo de QuickSort es: " + tiempoQuickSort);
		System.out.println("\nEl tiempo de ArraySort es: " + tiempoArraysSort);
		
	}

	public static int[] generarArregloAleatorio(int n, int min, int max) {
        int[] arreglo = new int[n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(max - min + 1) + min;
        }
        
        return arreglo;
    }
	
}
