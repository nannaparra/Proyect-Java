package TDALista;
import java.util.Iterator;

import Auxiliar.*;

/**
 * Clase Lista Doblemente Enlazada
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	
	protected DNodo<E> head,tail;
	protected int tamaño;
	
	/**
	 * Construye una lista con doble enlace.
	 */
	public ListaDoblementeEnlazada(){
		head=new DNodo<E>();
		tail=new DNodo<E>();
		tamaño=0;
		head.setSiguiente(tail);
		tail.setAnterior(head);
	}
	
    public int size(){
    	return tamaño;
    }
	
	public boolean isEmpty(){
		return (tamaño==0);
	}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("La lista esta vacia.");
		return head.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		if (isEmpty()) throw new EmptyListException("La lista esta vacia");
		return tail.getAnterior();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> aux=checkPosition(p);
		try{
		if (aux==first()) throw new BoundaryViolationException("El primer elemento no tiene previo");
		}catch(EmptyListException ele){System.out.println(ele.getMessage());}
		return (aux.getAnterior());
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> aux=checkPosition(p);
		try{
		if(aux==last()) throw new BoundaryViolationException("El ultimo elemento no tiene siguiente");
		}catch (EmptyListException ele){System.out.println(ele.getMessage());}
		return (aux.getSiguiente());
	}
	
	public void addFirst(E e){
		DNodo<E> nuevo=new DNodo<E>(e,head,head.getSiguiente());
		(head.getSiguiente()).setAnterior(nuevo);
		head.setSiguiente(nuevo);
		tamaño++;
	}
	
	public void addLast(E e){
		DNodo<E> nuevo=new DNodo<E>(e,tail.getAnterior(),tail);
		(tail.getAnterior()).setSiguiente(nuevo);
		tail.setAnterior(nuevo);
		tamaño++;
	}
	
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> aux=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,aux,aux.getSiguiente());
		(aux.getSiguiente()).setAnterior(nuevo);
		aux.setSiguiente(nuevo);
		tamaño++;	
	}
	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> aux=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,aux.getAnterior(),aux);
		(aux.getAnterior()).setSiguiente(nuevo);
		aux.setAnterior(nuevo);
		tamaño++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("La Posicion es invalida");
		DNodo<E> borrar=checkPosition(p);
		(borrar.getAnterior()).setSiguiente(borrar.getSiguiente());
		(borrar.getSiguiente()).setAnterior(borrar.getAnterior());
		E elem=borrar.element();
		tamaño--;
		borrar.setAnterior(null);
		borrar.setSiguiente(null);
		borrar.setElement(null);
		borrar=null;
		return(elem);		
	}

	public E set(Position<E> p, E e) throws InvalidPositionException{
		if(isEmpty())throw new InvalidPositionException("La Posicion es invalida.");
		DNodo<E> setear = checkPosition(p);
		E viejo = setear.element();
		setear.setElement(e);
		return viejo;	
	}
		
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
		
	public Iterable<Position<E>> positions(){			
		PositionList<Position<E>> lista=new ListaDoblementeEnlazada<Position<E>>();
		if(!this.isEmpty()){
		   DNodo<E> pos=head.getSiguiente();
		   while(pos!=tail){
		 	     lista.addLast(pos);
			     pos=pos.getSiguiente();
			   }
		    }
		return lista;
	}
	
	/**
	 * Metodo privado que chequea que la posición ingresada sea correcta y la convierte en nodo.
	 * @param p Posicion ingresada.
	 * @return nodo de la posición ingresada.
	 * @throws InvalidPositionException Si la posición es invalida.
	 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null) throw new InvalidPositionException("La posicion no es valida.");
		if (p==head) throw new InvalidPositionException("La cabeza no es una posicion valida.");
		if (p==tail) throw new InvalidPositionException("La cola no es una posicion valida.");
		try{
			DNodo<E> temp = (DNodo<E>) p;
			if ((temp.getAnterior() == null) || (temp.getSiguiente()==null))
					throw new InvalidPositionException("La posicion no es valida.");
			return temp;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("La posicion no es valida");
		}
     }  
		
	}
