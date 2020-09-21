package Auxiliar;
/**
 * Modela un acceso a un árbol vacio.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class EmptyTreeException extends Exception{
	
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public EmptyTreeException (String err){
		super(err);
	}

}