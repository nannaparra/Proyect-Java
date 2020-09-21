package TDAArbol;
import TDALista.*;
import Auxiliar.*;

/**
 * Clase ANodo.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class ANodo<E> implements Position<E> {
	
	private E element;
	private ANodo<E> padre;
	private PositionList<ANodo<E>> hijos;
	
	/**
	 * Construye un nodo con su rotulo y el nodo padre.
	 * @param elemento elemento a asignar en el nodo.
	 * @param padre nodo a asignar como padre.
	 */
	public ANodo(E elemento, ANodo<E> p){
		element=elemento;
		padre=p;
		hijos=new ListaDoblementeEnlazada<ANodo<E>>();
		
	}
	
	/**
	 * Construye un nodo con su rotulo y nodo padre nulo.
	 * @param elemento elemento a asignar.
	 */
	public ANodo(E elemento){
		this(elemento, null);	
	}
	
	/**
	 * Contruye un nodo con rotulo nulo y nodo padre nulo.
	 */
	public ANodo(){
		this(null,null);
	}
	
	/**
	 * Retorna el elemento del nodo.
	 */
	public E element(){
		return element;
	}
	
	/**
	 * Retorna una coleccion con los hijos del nodo.
	 * @return coleccion con los hijos del nodo.
	 */
	public PositionList<ANodo<E>> getHijos(){
		return hijos;
	}
	
	/**
	 * Establecer el elemento del nodo.
	 * @param elemento elemento a asignar.
	 */
	public void setElemento(E e){
		element=e;
	}
	
	/**
	 * Retorna el padre del nodo.
	 * @return padre del nodo que recibe el mensaje.
	 */
	public ANodo<E> getPadre(){
		return padre;
	}
	
	/**
	 * Establece el padre del nodo.
	 * @param padre padre a asignar.
	 */
	public void setPadre(ANodo<E> p){
		padre=p;
	}

}
