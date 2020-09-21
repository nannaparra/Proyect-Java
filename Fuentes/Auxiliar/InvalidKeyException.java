package Auxiliar;
/**
 * Modela un acceso a una clave invalida.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class InvalidKeyException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public InvalidKeyException (String err){
		super(err);
	}
}