package EJ_08;

import EJ_01.*;

public class NodoDoblementeVinculado<T> extends Nodo<T>{
	private NodoDoblementeVinculado<T> next;
	
	private NodoDoblementeVinculado<T> anterior;
	
	public NodoDoblementeVinculado(){
		super.setInfo(null);
		super.setNext(null);
		this.anterior = null;
	}
	
	public NodoDoblementeVinculado(T info, NodoDoblementeVinculado<T> next){
		super.setInfo(info);
		setNext(next);
		this.anterior = null;
	}
	
	public NodoDoblementeVinculado(T info, NodoDoblementeVinculado<T> next, NodoDoblementeVinculado<T> anterior){
		super.setInfo(info);
		setNext(next);
		this.anterior = anterior;
	}
	
	public void setAnterior(NodoDoblementeVinculado<T> anterior) {
		this.anterior = anterior;
	}
	
	public NodoDoblementeVinculado<T> getAnterior() {
		return anterior;
	}
	
	public void setNext(NodoDoblementeVinculado<T> next) {
		this.next = next;
	}
	
	public NodoDoblementeVinculado<T> getNext() {
		return next;
	}
}
