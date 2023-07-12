package EJ_02;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*Problema de la Mochila. Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un
peso positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El
objetivo es llenar la mochila de tal manera que se maximice el valor de los objetos transportados,
respetando la limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una
fracción xi (0 ≤ xi ≤ 1) del objeto i es ubicada en la mochila contribuye en xipi al peso total de la
mochila y en xivi al valor de la carga. Formalmente, el problema puede ser establecido como.
			     𝑛                                                                                 𝑛
Maximizar i = ∑xivi , con la restricción i = ∑xipi ≤ P donde vi>0, pi>0 y 0 ≤ xi ≤ 1 para 1 ≤ i ≤ n.
			  1                              1
Por ejemplo, para la instancia en n = 3 y P = 20
(v1, v2, v3) = (25, 24, 15)
(p1, p2, p3) = (18, 15, 10)
Algunas soluciones posibles son:
(x1, x2, x3) xipi xivi
(½, ⅓, ¼) 16.5 24.25
(1, 2/15, 0) 20 28.2
(0, ⅔, 1) 20 31
(0, 1, ½) 20 31.5
Puede observarse que (0, 1, ½) produce el mayor beneficio.
*/

public class EJ_02 {
	private static ArrayList<Elemento> laChila = new ArrayList<>();
	private static ArrayList<Elemento> elementosDisponibles = new ArrayList<>();
	private static double pesoMaximo = 20;
	
	//IDEA: Candidatos= n objetos, Solucion = mochila vacia
	public static void main(String[] args) {
		ArrayList<Elemento> armandoLaChila = new ArrayList<>();
		
		Elemento uno = new Elemento(18, 25);
		Elemento dos = new Elemento(15, 24);
		Elemento tres = new Elemento(10, 15);
		
		elementosDisponibles.add(uno);
		elementosDisponibles.add(dos);
		elementosDisponibles.add(tres);
		
		double pesoDeLaChila = 0;
		
		greedy(armandoLaChila, pesoDeLaChila);
	}
	
	//greedy
	public static void greedy(ArrayList<Elemento> armandoLaChila, double pesoDeLaChila){
		if(solucion(armandoLaChila)){
			//armo la solucion
			laChila.addAll(armandoLaChila);
		}
		else{
			//busco una solucion
			//selecciono el mejor candidato de los que tengo y lo saco del conjunto de candidatos
			Elemento elementoParaAgregar = seleccionar();
			//veo si es factible agregarlo
			if(esFactible(elementoParaAgregar, armandoLaChila, pesoDeLaChila)){
				if(elementoParaAgregar.getPeso()+pesoDeLaChila<=pesoMaximo){
					armandoLaChila.add(elementoParaAgregar);	
				}
				else{
					double cuantoFalta = pesoMaximo-pesoDeLaChila;
					double cuantoAgrego = (cuantoFalta * 100) / elementoParaAgregar.getPeso();
					elementoParaAgregar.setPeso(cuantoAgrego);
					//calcular el nuevo valor
					armandoLaChila.add(elementoParaAgregar);
					pesoDeLaChila+= elementoParaAgregar.getPeso();
				}
			}
			//greedy
			greedy(armandoLaChila, pesoDeLaChila);
		}
	}
	
	//solucion
	public static boolean solucion(ArrayList<Elemento> armandoLaChila){
		if(elementosDisponibles.isEmpty()){
			if(!armandoLaChila.isEmpty()){ //Qué pasaría si ningun elemento cumple y queda vacia?
				int suma = 0;
				for(Elemento elemento: armandoLaChila){
					suma+=elemento.getPeso();
				}
				if(suma<=pesoMaximo){
					return true;	
				}	
			}
		}
		return false;
	}
	
	//seleccionar
	public static Elemento seleccionar(){
		//agarro un candidato y guardo su valor
		double mayorValor = 0;
//		double menorPeso = 99999;
		Elemento mayorElemento = null;
		for(Elemento elemento: elementosDisponibles){
//			double peso = elemento.getPeso();
			double valor = elemento.getValor();
			if(valor>mayorValor){
				mayorElemento = elemento;
				mayorValor = elemento.getValor();
			}
		}
		//agarro otro y lo comparo
		//cuando termino me quedo con el mejor
		//borro el que elijo de la lista
		elementosDisponibles.remove(mayorElemento);
		return mayorElemento;
	}
	
	//factible
	public static boolean esFactible(Elemento elementoParaAgregar, ArrayList<Elemento> armandoLaChila, double pesoDeLaChila){
		return pesoDeLaChila<pesoMaximo;
	}
}
