package EJ_03;

import java.util.ArrayList;

/*Maximizar el n�mero de actividades compatibles. Se tienen n actividades que necesitan utilizar un
recurso, tal como una sala de conferencias, en exclusi�n mutua. Cada actividad i tiene asociado
un tiempo de comienzo ci y un tiempo de finalizaci�n fi de utilizaci�n del recurso, con ci < fi. Si la
actividad i es seleccionada se llevar� a cabo durante el intervalo [ci, fi). Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
consiste en encontrar la cantidad m�xima de actividades compatibles entre s�.*/

public class EJ_03 {

	//puedo tratar los tiempos de los eventos como INTS?
	//por ejemplo inicio = 13 fin = 14
	
	//candidatos, conjunto de Evento con todos los eventos, solucion conjunto vacio de tipo Evento. Estrategia elegir el que empiece antes y termine antes
	public static ArrayList<Evento> eventosCandidatos = new ArrayList<>();
	public static ArrayList<Evento> eventosFinales = new ArrayList<>();
	
	public static void main(String[] args) {
		Evento uno = new Evento(10,12);
		Evento dos = new Evento(13,15);
		Evento tres = new Evento(16,18);
		
		Evento superpuesto = new Evento(13,16);
		Evento superpuesto2 = new Evento(10,15);
		Evento superpuesto3 = new Evento(15,17);
		
		eventosCandidatos.add(superpuesto3);
		eventosCandidatos.add(superpuesto2);
		eventosCandidatos.add(superpuesto);
		eventosCandidatos.add(tres);
		eventosCandidatos.add(dos);
		eventosCandidatos.add(uno);
		
		ArrayList<Evento> listaParcial = new ArrayList<>();
		
		System.out.println(eventosCandidatos);
		greedy(listaParcial);
		System.out.println(eventosFinales);
	}
	
	//greedy
	public static void greedy(ArrayList<Evento> listaParcial){
		//si solucion
		if(solucion()){
			//armo la solucion
			//es decir agrego mi solucionencontruccion a la solucion
			eventosFinales.addAll(listaParcial);
		}
		else{
			//seleccionar evento -> if not null factible()
			Evento eventoParaAgregar = seleccionar();
			if(eventoParaAgregar!=null){
				//if(factible(evento, lista)({
				if(factible(eventoParaAgregar, listaParcial)){
					//lo agrego a mi lista de eventos
					listaParcial.add(eventoParaAgregar);
				}
				greedy(listaParcial);
			}
		}
	}
	//solucion
	public static boolean solucion(){
		//cuando no tenga m�s eventos que considerar
		if(eventosCandidatos.isEmpty()){
			return true;
		}
		return false;
	}
		
	//seleccionar
	public static Evento seleccionar(){
		Evento seleccionado = null;
		int inicioMasTemprano = 23;
		int finMasTemprano = 99;
		int index = 0;
		//el evento que empiece m�s pronto
		for(Evento evento: eventosCandidatos){
			int inicio = evento.getComienzo();
			int fin = evento.getFin();
			if(inicio<=inicioMasTemprano){
				if(fin<finMasTemprano){
					inicioMasTemprano = inicio;
					finMasTemprano = fin;
					seleccionado = evento;
					index = eventosCandidatos.indexOf(evento);
				}
			}
		}
		//lo borro
		eventosCandidatos.remove(index);
		//devuelvo este evento
		return seleccionado;
	}
		
	//factible
	public static boolean factible(Evento evento, ArrayList<Evento> listaParcial){
		//si mi evento empieza despu�s de que termin� el anterior que tengo en la lista devuelvo true
		if(listaParcial.isEmpty()){
			return true;
		}
		else{
			int ultimaPos = listaParcial.size()-1;
			Evento ultimoAgregado = listaParcial.get(ultimaPos);
			if(ultimoAgregado.getFin()<evento.getComienzo()){
				return true;
			}
		}
		return false;
	}
}
