package Auxiliar;
/**
 * Modela un acceso a una posicion invalida.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class InvalidPositionException extends Exception {
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}