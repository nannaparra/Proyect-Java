package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Auxiliar.*;

/**
 * Clase ElementIterator.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Crea un iterador para la lista pasado por parametro.
	 * @param l recibe una lista.
	 */
	public ElementIterator (PositionList <E> l ) {
		try{				
			list=l;
			if (list.isEmpty()) cursor = null;
			else cursor = list.first();			
		}catch(EmptyListException e){System.out.println("e:"+e.getMessage());}			
	}
		
	/**
	 * Consulta si el iterador tiene siguiente elemento.
	 * @return true si tiene siguiente, false en caso contrario.
	 */
	public boolean hasNext() {
		return cursor !=null;
		}
	
	/**
	 * Retorna el siguiente elemento del iterador.
	 * @return siguiente elemento del iterador.
	 * @throws NoSuchElementException si no tiene siguiente.
	 */
	public E next() throws NoSuchElementException  {
		if (cursor == null)	throw new NoSuchElementException ("no tiene siguiente");
		E toReturn = cursor.element();
		try{
			if(cursor==list.last())
				cursor=null;
			else
				cursor=list.next(cursor);
		}catch(EmptyListException e){System.out.println(e.getMessage());}
		catch(BoundaryViolationException b){System.out.println(b.getMessage());}
		catch(InvalidPositionException i){System.out.println(i.getMessage());}
		return toReturn;
	}
}