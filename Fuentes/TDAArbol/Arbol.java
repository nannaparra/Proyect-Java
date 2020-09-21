package TDAArbol;
import java.util.Iterator;

import Auxiliar.*;
import TDALista.*;


/**
 * Clase Arbol.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class Arbol<E> implements Tree<E>{
	
	protected int tamaño;
	protected ANodo<E> raiz;
	
	/**
	 * Construye un Arbol.
	 */
	public Arbol(){
	     tamaño=0;
	     raiz=null;
	}
	
	/**
	 * Construye un Arbol.
	 * @param root raiz a asignar.
	 */
	public Arbol(E root){
		raiz=new ANodo<E>(root);
		tamaño=1;
	}
	

	public int size(){
		return tamaño;	
	}
	
	
	public boolean isEmpty(){
		return (tamaño==0);
	}
	
	
	public Iterator<E> iterator(){
		PositionList<E> l=new ListaDoblementeEnlazada<E>();
		for(Position<E> p:positions())
			l.addLast(p.element());
		return l.iterator();
		
	}
	
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l=new ListaDoblementeEnlazada<Position<E>>();
		if(!isEmpty()) 
			pre(l, raiz);
		return l;
	}
	
	/**
	 * Recorre el árbol en preorden y guarda sus posiciones en una lista.
	 * @param l lista a donde se guardaran las posiciones.
	 * @param r nodo a insertar en la lista.
	 */
	private void pre(PositionList<Position<E>> l,ANodo<E> r){
		l.addLast(r);
		for(ANodo<E> h: r.getHijos())
			pre(l,h);
	}
	
	
	public E replace(Position<E> v, E e) throws InvalidPositionException{
		ANodo<E> nuevo=checkPosition(v);
		E aux=nuevo.element();
		nuevo.setElemento(e);
		return aux;
		
	}
	
	
	public Position<E> root() throws EmptyTreeException{
		if (isEmpty()) throw new EmptyTreeException("El arbol esta vacio.");
		return raiz;
	}
	
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException{
		ANodo<E> nuevo=checkPosition(v);
		if (nuevo==raiz) throw new BoundaryViolationException("La posicion dada corresponde a la raiz.");
		return(nuevo.getPadre());
		
	}
	
	
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
		ANodo<E> p=checkPosition(v);
		PositionList<Position<E>> lista=new ListaDoblementeEnlazada<Position<E>>();
		for(ANodo<E> n:p.getHijos())
			lista.addLast(n);
		return lista;
	}
	
	
	public boolean isInternal(Position<E> v) throws InvalidPositionException{
		ANodo<E> nodo=checkPosition(v);
		return (!(nodo.getHijos().isEmpty()));
	}
	
	
	public boolean isExternal(Position<E> v) throws InvalidPositionException{
		ANodo<E> nodo=checkPosition(v);
		return nodo.getHijos().isEmpty();
	}
	
	
	public boolean isRoot(Position<E> v) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("El arbol esta vacio");
		ANodo<E> nodo=checkPosition(v);
		return(nodo.equals(raiz));
	}
	
	
	public void createRoot(E e) throws InvalidOperationException{
		if(!isEmpty()) throw new InvalidOperationException("Arbol no vacio");
		raiz=new ANodo<E>(e);
		tamaño=1;
	}
	
	
	public Position<E> addFirstChild(Position<E> p, E e) throws	InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio.");
		ANodo<E> padre=checkPosition(p);
		ANodo<E> nodo=new ANodo<E>(e,padre);
		padre.getHijos().addFirst(nodo);
		tamaño++;
		return nodo;
	}
	
	
	public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio.");
		ANodo<E> padre=checkPosition(p);
		ANodo<E> nodo=new ANodo<E>(e,padre);
		padre.getHijos().addLast(nodo);
		tamaño++;
		return nodo;
	}
	
	
	public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio.");
		ANodo<E> padre=checkPosition(p);
		ANodo<E> hermanoDerecho=checkPosition(rb);
		if(!(hermanoDerecho.getPadre()).equals(padre)) throw new InvalidPositionException("rb no es hijo de p");
		ANodo<E> nuevo=new ANodo<E>(e,padre);
		PositionList<ANodo<E>> hijosPadre=padre.getHijos();
		boolean encontreUbicacion=false;
		try{
		    Position<ANodo<E>> posHijosPadre=hijosPadre.first();
		    while(posHijosPadre!=null && !encontreUbicacion){
			      if(hermanoDerecho!=posHijosPadre.element()){
			     	if(posHijosPadre!=hijosPadre.last())
					   posHijosPadre=hijosPadre.next(posHijosPadre);
				    else
					    posHijosPadre=null;
			        }
				  else
					  encontreUbicacion=true;
		     }
		     if(!encontreUbicacion) throw new InvalidPositionException("rb no es hijo de p");
		     hijosPadre.addBefore(posHijosPadre, nuevo);
		     tamaño++;
		}catch (EmptyListException ele){System.out.println(ele.getMessage());}
		catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return nuevo;
	}
	
	
	public Position<E> addAfter (Position<E> p, Position<E> lb, E e) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio.");
		ANodo<E> padre=checkPosition(p);
		ANodo<E> hermanoIzquierdo=checkPosition(lb);
		if(!(hermanoIzquierdo.getPadre()).equals(padre)) throw new InvalidPositionException("lb no es hijo de p");
		ANodo<E> nuevo=new ANodo<E>(e,padre);
		PositionList<ANodo<E>> hijosPadre=padre.getHijos();
		boolean encontreUbicacion=false;
		try{
		    Position<ANodo<E>> posHijosPadre=hijosPadre.first();
		    while(posHijosPadre!=null && !encontreUbicacion){
			     if(hermanoIzquierdo!=posHijosPadre.element()){
				   if(posHijosPadre!=hijosPadre.last())
					  posHijosPadre=hijosPadre.next(posHijosPadre);
				   else
					  posHijosPadre=null;
			      }
		        else
			        encontreUbicacion=true;
		     }
		     if(!encontreUbicacion) throw new InvalidPositionException("lb no es hijo de p");
		     hijosPadre.addAfter(posHijosPadre, nuevo);
		     tamaño++;
		}catch (EmptyListException ele){System.out.println(ele.getMessage());}
		catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return nuevo;
	}
	
	
	public void removeExternalNode (Position<E> p) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Arbol vacio");
		ANodo<E> n=checkPosition(p);
		if(!n.getHijos().isEmpty()) throw new InvalidPositionException("p no es hoja");
		try{
		   if(n.equals(root())){
			  raiz=null;
			  tamaño--;
		   }
	       else{	
		        ANodo<E> padre=n.getPadre();
	        	PositionList<ANodo<E>> hijosPadre=padre.getHijos();
	        	boolean encontre=false;
	        	Position<ANodo<E>> pos=hijosPadre.first();
	        	while(pos!=null && !encontre){
		           	  if(pos.element()==n) 
		           		  encontre=true;
			          else{
			        	  if(hijosPadre.last()!= pos)
			        		 pos=hijosPadre.next(pos);
			        	  else
			        		 pos=null;
			         }
	        	}
		    if(pos==null) throw new InvalidPositionException("p no aparece en la lista de "+"hijos de su padre-----árbol corrupto???");
	        hijosPadre.remove(pos);
		    tamaño--;
		}
	}catch (EmptyTreeException ete){System.out.println(ete.getMessage());}
	catch (EmptyListException ele){System.out.println(ele.getMessage());}
	catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
	catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
	}
	

	public void removeInternalNode (Position<E> p) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("El arbol esta vacio. ");
		ANodo<E> n=checkPosition(p);
		if(n==raiz && n.getHijos().size()>1) throw new InvalidPositionException("La raiz tiene hijos y no puede eliminarse");
		PositionList<ANodo<E>> hijos=n.getHijos();
		ANodo<E> padre=n.getPadre();
		if(hijos.isEmpty()) throw new InvalidPositionException("El nodo es externo.");
		try{
		    if (padre==null){
				raiz=hijos.first().element();
				raiz.setPadre(null);
				tamaño--;
		    }
		    else{
			     PositionList<ANodo<E>> hermanos=padre.getHijos();
			     Position<ANodo<E>> posAE=hermanos.first();
			     boolean encontre=false;
			     while(!encontre && posAE!=null){
			        if (n==posAE.element())
					    encontre=true;
				    else{
					     if (posAE==hermanos.last())
						     posAE=null;
					     else 
					    	 posAE=hermanos.next(posAE);
				    }
			        }
			     if(!encontre) throw new InvalidPositionException("El nodo no es parte de hermanos.");
			    while(!hijos.isEmpty()){
				       hijos.first().element().setPadre(padre);
				       hermanos.addBefore(posAE,hijos.first().element());
				       hijos.remove(hijos.first());					
			    }
			    n.setPadre(null);
			    hermanos.remove(posAE);
			    tamaño--;
	       }
		}catch(InvalidPositionException e1){e1.getMessage();}
		 catch (EmptyListException ele){System.out.println(ele.getMessage());}
	     catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
	}
	
	
	public void removeNode (Position<E> p) throws InvalidPositionException{
		ANodo<E> n=checkPosition(p);
		if(isEmpty()) throw new InvalidPositionException("Árbol vacío");
		if(n==raiz && n.getHijos().isEmpty()){
			raiz=null;
			tamaño--;
		    }
		else
			if(n==raiz && !n.getHijos().isEmpty()) throw new InvalidPositionException("No se puede eliminar la raiz porque tiene hijos.");
		else{
			if(isInternal(p))
				removeInternalNode(p);
			else
				removeExternalNode(p);	
		}
	}
	
	/**
	 * Chequeo que la posicion pasada por parametro sea valida y retorno el nodo.
	 * @param p posicion del arbol.
	 * @return nodo que se encuentra en esa posicion.
	 * @throws InvalidPositionException si la posicion es invalida.
	 */
	private ANodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try{
			if (p==null) throw new InvalidPositionException("La posicion no es valida.");
			return (ANodo<E>) p;
		}
		catch(ClassCastException e){throw new InvalidPositionException("La posicion no es valida");}
		}
}
