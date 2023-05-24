
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ServicioCaminosARRUINADO<T> {
	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap <Arco<T>,Boolean> visitado;
	private HashMap <Integer, String> colores;
	
	public ServicioCaminosARRUINADO(Grafo<T> g ,int origen, int destino, int lim) {
		this.grafo = g;
		this.origen=origen;
		this.destino=destino;
		this.lim=lim;
		this.visitado= new HashMap<>();
		this.colores= new HashMap<>();

	}
	
	private void visitarVertices() {
		List<Integer> vertices = new ArrayList<>();
	    Iterator<Integer> iterator = grafo.obtenerVertices();
	    while (iterator.hasNext()) {
	        Integer vertice = iterator.next();
	        vertices.add(vertice);
	    }
	    
	    for (Integer vertice : vertices) {
	        colores.put(vertice, "blanco");
	    }
	}
	
//	Caminos: dado un origen, un destino y un lÃ­mite â€œlimâ€� retorna todos los caminos que, partiendo del
//	vÃ©rtice origen, llega al vÃ©rtice de destino sin pasar por mÃ¡s de â€œlimâ€� arcos. AclaraciÃ³n importante: en
//	un camino no se puede pasar 2 veces por el mismo arco
	
	public List<List<Integer>> caminos(){
		visitarVertices();
		Iterator <Integer> vertices = this.grafo.obtenerVertices();
//		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();	
		
//		List<Integer> v = new ArrayList<Integer>();		

		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			if(vertice==this.origen) {
				resultado.addAll(buscarCaminos(vertice));
			}
		}
//		
//		colores.put(vertice,"blanco");
//			v.add(vertice);

//		}while(arcos.hasNext()) {
//			Arco<T> arco = arcos.next();
//			visitado.put(arco, false);
//		} 
//		vertices = this.grafo.obtenerVertices();
//		while(vertices.hasNext()) {
//			Integer ver  = vertices.next();
//			if(ver==this.origen) {
//				resultado.addAll(buscarCaminos(this.origen));
//			}
//		}
		
		return resultado;
	}
	
	private List<List<Integer>> buscarCaminos(Integer v){
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		int cantidad =0;
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos(v);
		colores.put(v, "amarillo");
		
		if(v.equals(this.destino)) {
			ArrayList<Integer> unicoCamino = new ArrayList<>();
			unicoCamino.add(v);
			resultado.add(unicoCamino);
		}else {
			while(it.hasNext()) {
				Integer ady = it.next();
				Arco<T> arco = arcos.next();
				
				if(cantidad <= lim){
					if(visitado.get(arco)==false) {	
						List<List<Integer>> caminosParciales = new ArrayList<List<Integer>>();
						caminosParciales.addAll(buscarCaminos(ady));	
						visitado.put(arco, true);
                        cantidad++;
                        
                        if(ady==this.destino) {
    						for(List<Integer> caminoParcial : caminosParciales) {
    							caminoParcial.add(0, v);
    							resultado.add(caminoParcial);
    						}		
    					}
					}	
				}
			}
		}
		colores.put(v, "blanco");
		return resultado;
	}
}
