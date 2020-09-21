package TDALista;
import Auxiliar.*;

/**
 * Clase DNodo.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017 
 */
public class DNodo<E> implements Position<E> {
	protected E elemento;
	protected DNodo<E> ant;
	protected DNodo<E> sig;
	
	/**
	 * Construye un nodo con rotulo nulo, nodo anterior nulo y nodo siguiente nulo.
	 */
	public DNodo(){
		elemento=null;
		ant=null;
		sig=null;		
	}
	
	/**
	 * Construye un nodo con su rotulo, el nodo anterior y el nodo siguiente.
	 * @param e elemento a asignar en el nodo.
	 * @param anterior nodo anterior al nodo que creo.
	 * @param siguiente nodo siguiente al nodo que creo.
	 */
	public DNodo(E e,DNodo<E> anterior,DNodo<E> siguiente){
		elemento=e;
		ant=anterior;
		sig=siguiente;
	}
	
	
	public E element(){
		return elemento;
	}
	
	/**
	 * Establece el elemento del nodo.
	 * @param e elemento a asignar.
	 */
	public void setElement(E e){
		elemento=e;
	}
	
	/**
	 * Establece el nodo siguiente.
	 * @param siguiente nodo siguiente a establecer.
	 */
	public void setSiguiente(DNodo<E> siguiente){
		sig=siguiente;
	}
	
	/**
	 * Retorna el nodo siguiente al nodo que recibe el mensaje.
	 * @return nodo siguiente.
	 */
	public DNodo<E> getSiguiente(){
		return sig;
	}
	
	/**
	 * Establece el nodo anterior.
	 * @param anterior nodo anterior a establecer.
	 */
	public void setAnterior(DNodo<E> anterior){
		ant=anterior;
	}
	
	/**
	 * Retorna el nodo anterior al nodo que recibe el mensaje.
	 * @return nodo anterior.
	 */
	public DNodo<E> getAnterior(){
		return ant;
	}

}
