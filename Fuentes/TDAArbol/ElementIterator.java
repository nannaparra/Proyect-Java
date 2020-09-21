package TDAArbol;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Auxiliar.*;
import TDALista.*;

/**
 * Clase ElementIterator.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list; ; 
	protected Position<E> cursor;  
		
	/**
	 * Crea un iterador para la lista pasado por parametro
	 * @param l recibe una lista.
	 */
	public ElementIterator (PositionList <E> l ) {
			try{				
				list=l;
				if (l.isEmpty()) cursor = null;
				else cursor = l.first();			
			}catch(EmptyListException e){System.out.println("e:"+e.getMessage());}			
		}
		
	/**
	 * Consulta si el iterador tiene siguiente elemento.
	 * @return true si tiene siguiente, false en caso contrario.
	 */
	public boolean hasNext(){
		return cursor !=null; 
		}
	
	/**
	 * Retorna el siguiente elemento del iterador.
	 * @return siguiente elemento del iterador.
	 * @throws NoSuchElementException si no tiene siguiente.
	 */
	public E next () throws NoSuchElementException{
		
		if (cursor == null)	throw new NoSuchElementException ("no tiene siguiente");
			E toReturn = cursor.element();
			try{
			cursor = (cursor ==  list.last()) ? null : list.next(cursor);
			}catch(EmptyListException e){System.out.println("e:"+e.getMessage());} 
			catch (InvalidPositionException e) {e.printStackTrace();} 
			catch (BoundaryViolationException e) {e.printStackTrace();}
			
			return toReturn;
		}
}