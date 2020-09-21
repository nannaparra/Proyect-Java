package TDAPila;

/**
 * Clase Nodo.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class Nodo<E> {
	private E elem;
	private Nodo<E> siguiente;

	/**
	 * Construye un nodo con rotulo nulo y nodo siguiente nulo.
	 */
	public Nodo(){
	    elem=null;
	    siguiente=null;
	}
	
	/**
	 * Construye un nodo con su rotulo y nodo siguiente nulo.
	 * @param item elemento del nodo.
	 */
	public Nodo(E item){
		elem=item;
		siguiente=null;
	}
	
	/**
	 * Construye un nodo con su rotulo y el nodo siguiente.
	 * @param item elemento del nodo.
	 * @param sig nodo siguiente al nodo que se construye.
	 */
	public Nodo(E item, Nodo<E> sig){
		elem=item;
		siguiente=sig;
	}
	
	/**
	 * Retorna el elemento del nodo.
	 * @return elemento del nodo.
	 */
	public E getElemento(){
		return elem;
	}
	
	/**
	 * Establece el elemento del nodo.
	 * @param elemento elemento a asignar al nodo.
	 */
	public void setElemento(E elemento){
		elem=elemento;
	}
	
	/**
	 * Retorna el nodo siguiente al que recibe el mensaje.
	 * @return nodo siguiente al que recibe el mensaje.
	 */
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	
	/**
	 * Establece el nodo siguiente al que recibe el mensaje.
	 * @param sig nodo a establecer como siguiente.
	 */
	public void setSiguiente(Nodo<E> sig){
		siguiente=sig;
	}
}
