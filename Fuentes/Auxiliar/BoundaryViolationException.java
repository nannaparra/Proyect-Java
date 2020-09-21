package Auxiliar;
/**
 * Modela un acceso por fuera de los limites de la estructura.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class BoundaryViolationException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}