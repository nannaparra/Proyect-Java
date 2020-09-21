package TDAPila;
import Auxiliar.*;

/**
 * Interface Stack
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public interface Stack<E> {

	/**
	 * Consulta si la pila está vacía.
	 * @return Verdadero si la pila está vacía, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Inserta un elemento en el tope de la pila.
	 * @param element Elemento a insertar en la pila.
	 */
	public void push(E item);
	
	/**
	 * Remueve el elemento que se encuentra en el tope de la pila.
	 * @return Elemento removido.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E pop() throws EmptyStackException;
	
	/**
	 * Examina el elemento que se encuentra en el tope de la pila.
	 * @return Elemento que se encuentra en el tope de la pila.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E top() throws EmptyStackException;
	
	/**
	 * Consulta la cantidad de elementos de la pila.
	 * @return Cantidad de elementos de la pila.
	 */
	public int size();
	
}
