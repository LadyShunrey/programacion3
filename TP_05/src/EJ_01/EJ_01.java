package EJ_01;

import java.util.ArrayList;

//conjunto C que tiene N tipos de monedas
//formar uan cantidad M epleando el minimo numero de ellas.
public class EJ_01 {
	static ArrayList<Billete> billetesDisponibles = new ArrayList<>();
	static int montoALlegar = 289;
	
	public static void greedy(ArrayList<Billete> candidatos){
		ArrayList<Billete> conjuntoSolucion = new ArrayList<>();
		while(!solucion(conjuntoSolucion)){ //el while no hace falta poner que sea hasta que el conjunto candidatos esté vacío porque el enunciado dice que es infinito
			//x seleccionar
			Billete seleccionado = seleccionar(candidatos, conjuntoSolucion);
			//billetesDisponibles.remove(seleccionado); //Este paso no es necesario porque el enunciado dice que tengo infinita cantidad de billetes de cada denominacion
			if(factible(conjuntoSolucion, seleccionado)){
				conjuntoSolucion.add(seleccionado);
			}
		}
		
		System.out.println(conjuntoSolucion);
	}
	
	public static Billete seleccionar(ArrayList<Billete> candidatos, ArrayList<Billete> solucion){
		//elijo el más grande que no se pase del número maximo
		Billete seleccionado = null;
		int cuantoTengo = 0;
		for(Billete billete: solucion){
			cuantoTengo += billete.getValorDelBillete();
		}
		int cuantoFaltaParaLlegar = montoALlegar - cuantoTengo;
		for(Billete billete: candidatos){ //asumo que estan ordenados de mayor a menor. Si no lo estuviera hay que ordenarlos? O cómo se resuelve?
			//cada billete me fijo si es el mas grande que puedo tomar en ese momento con lo que tenga sumado hasya ahora
			if(billete.getValorDelBillete()<= cuantoFaltaParaLlegar){
				seleccionado = billete;
				return seleccionado;
			}
		}
		return seleccionado;
	}
	
	public static boolean factible(ArrayList<Billete> solucion, Billete seleccionado){
		if(!solucion(solucion)){
			int suma = 0;
			for(Billete billete: solucion){
				//sumar
				suma += billete.getValorDelBillete();
			}
			//si suma + nuevo < numero buscado
			if((suma + seleccionado.getValorDelBillete()) <= montoALlegar){
				//sigo buscando
				return true;
			}
			//si suma + nuevo > numero buscado
			if((suma + seleccionado.getValorDelBillete()) <= montoALlegar){
				//rechazo
				return false;
			}
		}
		return false;
	}
	
	public static boolean solucion(ArrayList<Billete> solucion){
		//si los candidatos llegaron a la solucion
		int montoCandidatos = 0;
		for(Billete billete: solucion){
			montoCandidatos += billete.getValorDelBillete();
		}
		if((montoCandidatos<montoALlegar) || (montoCandidatos>montoALlegar)){
			return false;
		}
		if(montoCandidatos==montoALlegar){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Billete billete1 = new Billete(100);
		Billete billete2 = new Billete(100);
		Billete billete3 = new Billete(100);
		Billete billete4 = new Billete(25);
		Billete billete5 = new Billete(25);
		Billete billete6 = new Billete(25);
		Billete billete7 = new Billete(25);
		Billete billete8 = new Billete(10);
		Billete billete9 = new Billete(10);
		Billete billete10 = new Billete(1);
		Billete billete11 = new Billete(1);
		Billete billete12 = new Billete(1);
		Billete billete13 = new Billete(1);
		Billete billete14 = new Billete(1);
		
		billetesDisponibles.add(billete1);
		billetesDisponibles.add(billete2);
		billetesDisponibles.add(billete3);
		billetesDisponibles.add(billete4);
		billetesDisponibles.add(billete5);
		billetesDisponibles.add(billete6);
		billetesDisponibles.add(billete7);
		billetesDisponibles.add(billete8);
		billetesDisponibles.add(billete9);
		billetesDisponibles.add(billete10);
		billetesDisponibles.add(billete11);
		billetesDisponibles.add(billete12);
		billetesDisponibles.add(billete13);
		billetesDisponibles.add(billete14);
		
		greedy(billetesDisponibles);
	}
}
