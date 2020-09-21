package Auxiliar;

/**
 * Modela un acceso a una pila vacia.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class EmptyStackException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public EmptyStackException (String err){
		super (err);
	}
}