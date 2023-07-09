package EJ_01;

//import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map;

public interface GrafoMetodos {
	
	public void agregarVertice(String vertice);
	
	public void agregarArco(String verticeOrigen, String verticeDestino, int longitud);
	
	public Iterator<String> obtenerTodosLosVertices();

}
