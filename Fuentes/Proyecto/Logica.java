package Proyecto;
import Auxiliar.*;
import TDAArbol.*;
import TDALista.*;
import TDAPila.*;
import TDAMapeo.*;
import TDACola.*;

/**
 * Clase Logica.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class Logica{
	
	Tree<Integer> arbol;
	
	/**
	 * Construye un objeto de la clase logica.
	 */
	public Logica(){
		arbol=new Arbol<Integer>();
		
	}
	
	/**
	 * Crea el árbol con un solo nodo.
	 * @param s Rótulo de la raíz.
	 */
	public void crearArbol(String s){
		try{
			int i=Integer.parseInt(s);
			arbol.createRoot(i);
		}catch (InvalidOperationException ioe){System.out.println(ioe.getMessage());}
	}
	
	/**
	 * Verifica si el arbol esta vacio.
	 * @return true si esta vacio, false en caso contrario.
	 */
	public boolean arbolVacio(){
		return arbol.isEmpty();
	}
	
	/**
	 * Borra el arbol actual y asigna uno nuevo vacio.
	 */
	public void borrarArbol(){
		Tree<Integer> nuevo=new Arbol<Integer>();
		arbol=nuevo;
	}
	
	/**
	 * Inserta un nodo especificando su rótulo R.
	 * @param h Rótulo del nodo.
	 * @param n Rótulo del nodo a agregar hijo.
	 */
	public void agregarNodo(String h,String n){
		try{
			int r=Integer.parseInt(h);
			int p=Integer.parseInt(n);
		    Position<Integer> padre=buscarNodo(p);
		    arbol.addLastChild(padre, r);
		}catch (InvalidPositionException ipe){System.out.println(ipe.getMessage());}
	}
	
	/**
	 * Retorna los rótulos de los nodos al recorrer el árbol en preorden.
	 * @return String con los rótulos de los nodos del árbol.
	 */
	public String mostrarPreorden(){
		String s="";
		try{
		s=preorden(arbol.root(),s);
		}catch(EmptyTreeException ete){System.out.println(ete.getMessage());}
		return s;
	}
	
	
	/**
	 * Retorna los rótulos de los nodos al recorrer el árbol en posorden.
	 * @return String con los rótulos de los nodos del árbol.
	 */
	public String mostrarPosorden(){
		String s="";
		try{
			s=posOrden(arbol.root(),s);
		}catch(EmptyTreeException ete){System.out.println(ete.getMessage());}
		return s;
	}
	
	/**
	 * Retorna los rótulos de los nodos al recorrer el árbol por niveles.
	 * @return String con los rótulos de los nodos del árbol.
	 */
	public String mostrarPorniveles(){
		return Porniveles(arbol);
	}	
	
	/**
	 * Retorna el ancestro común más cercano entre el nodo N1 y N2.
	 * @param R1 Rótulo del nodo N1.
	 * @param R2 Rótulo del nodo N2.
	 * @return String con el elemento del nodo ancestro.
	 */
	public String ancestro(String R1,String R2){
		int r1=Integer.parseInt(R1);
		int r2=Integer.parseInt(R2);
		int ult=0;
	    Position<Integer> N1=buscarNodo(r1);
		Position<Integer> N2=buscarNodo(r2);
		Stack<Integer> p1=new PilaEnlazada<Integer>();
		Stack<Integer> p2=new PilaEnlazada<Integer>();
		Position<Integer> posN1=N1;
		Position<Integer> posN2=N2;
		try{
				while(posN1!=arbol.root()){
					p1.push(posN1.element());
					posN1=arbol.parent(posN1);
				}
				while(posN2!=arbol.root()){
					p2.push(posN2.element());
					posN2=arbol.parent(posN2);
				}
				//La raiz es ancestro de todos los nodos.
				p1.push(arbol.root().element());
				p2.push(arbol.root().element());
				while(!p1.isEmpty() && !p2.isEmpty()){
					if(p1.top()==p2.top()){
						ult=p1.pop();
						p2.pop();
					}
					else{
						p1.pop();
						p2.pop();
					}
				}
				
		}catch(EmptyTreeException ete){System.out.println(ete.getMessage());}
		catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		catch(EmptyStackException ese){System.out.println(ese.getMessage());}
		Position<Integer> anc=buscarNodo(ult);
	    return (anc.element().toString());
	}
	
	/**
	 * Crea un nuevo árbol que represente el espejo multiplicativo del árbol original.
	 * @param kStr constante multiplicativa.
	 * @return string con el arbol espejado.
	 */	
	public String CrearEspejoMultiplicativo(String kStr){
		Integer k = Integer.parseInt(kStr); 
		Tree<Integer> nuevo=new Arbol<Integer>();
		try{
		if (!arbol.isEmpty()){
			nuevo.createRoot(arbol.root().element()*k.intValue());
			espejar(arbol,nuevo,arbol.root(),nuevo.root(),k);
		}
	    }catch(EmptyTreeException e){System.out.println(e.getMessage());}
		catch(InvalidOperationException e){System.out.println(e.getMessage());}
		String arb=Porniveles(nuevo);
		return arb;
	}

	/**
	 * Muestra un mapeo M con las entradas(R,<h,p>) en un string
	 * @return retorna un string con todas las entradas del mapeo.
	 */
	public String mostrarMapeo(){
		String s="";
		Map<Integer,PositionList<Integer>> m=mapeo();
		try{
		for(Entry<Integer,PositionList<Integer>> e:m.entries()){
			s+="("+e.getKey()+",<"+e.getValue().first().element()+","+e.getValue().last().element()+">) , ";
		}
		}catch(EmptyListException ele){System.out.println(ele.getMessage());}
		return s;
	}
	
	/**
	 * Controla si el valor ingresado pertenece al árbol.
	 * @param s valor del nodo.
	 * @return true si pertenece, false en caso contrario.
	 */
	public boolean perteneceArbol(String s){
		int n=Integer.parseInt(s);
		boolean pert=false;
		for(Position<Integer> r:arbol.positions()){
			if((r.element()).equals(n))
				pert=true;
		}
		return pert;
	}
	
	/**
	 * Controla que el valor ingresado sea un entero.
	 * @param s String ingresado por el usuario.
	 * @return true si es un entero, false en caso contrario.
	 */
	public boolean valorCorrecto(String s ){
		    try{
				int y=Integer.parseInt(s);
		        return true;
		    }
		    catch(NumberFormatException err ){}
		    return false;
		}
	
	/**
	 * Busca la posicion equivalente al rotulo ingresado.
	 * @param n rotulo del nodo a buscar.
	 * @return Posicion del nodo con rotulo n.
	 */
	private Position<Integer> buscarNodo(int n){
		Position<Integer> pos=null;
		for(Position<Integer> p:arbol.positions())
			if ((p.element()).equals(n))
			pos=p;
		return pos;
	}
	
	/**
	 * Recorre el arbol en preorden.
	 * @param r posicion del nodo
	 * @param s string que contiene los elementos del arbol
	 * @return string con los elementos del arbol.
	 */
	private String preorden(Position<Integer> r,String s){	
			s+="-"+r.element();
			try{
			for (Position<Integer> w : arbol.children(r))
			    s=preorden(w,s)+"";			
			}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		return s;
	}
	
	/**
	 * Muestra los rotulos del arbol recorrido en posorden.
	 * @param r Posicion del arbol.
	 * @param s String con los rotulos de los nodos del árbol.
	 * @return String con los rotulos de los nodos del arbol.
	 */
	private String posOrden(Position<Integer> r,String s){
		try{
			for(Position<Integer> w:arbol.children(r))
			    s=posOrden(w,s)+"";
		    s+="-"+r.element();
		}catch (InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		return s;
	}
	
	/**
	 * Recorre el árbol pasado como parametro por niveles.
	 * @param a arbol a recorrer.
	 * @return String con los rotulos de los elementos del arbol.
	 */
	private String Porniveles(Tree<Integer> a){
		Queue<Position<Integer>> cola = new ColaCircular<Position<Integer>>();
		String s="";
		try{
			if (!a.isEmpty()){
				Position<Integer> v=null;
		        Position<Integer> ant=a.root();		
	        	cola.enqueue(a.root());
	        	while(!cola.isEmpty()){
	        		v = cola.dequeue();
					if (profundidad(v,a)!=profundidad(ant,a))
			        	s+="\n";
			        if (v!=null)
			        {
			        	s+="-"+v.element();
			        	for (Position<Integer> w : a.children(v))
				             cola.enqueue(w);
		         		ant=v;
			        }
			        else{
			        	cola.enqueue(null);
						if (!cola.isEmpty())
			                 cola.enqueue(null);
			        }
					
	        	}
			}
		    else
			    s = "";
		}catch(InvalidPositionException e){System.out.println(e.getMessage()+" desde por niveles");}
		catch(EmptyTreeException e){System.out.println(e.getMessage());}
		catch(EmptyQueueException e){System.out.println(e.getMessage());}
		
		return s;
	}
	
	/**
	 * Crea un mapeo con los elementos del arbol y su altura y profundidad.
	 * @return retorna el mapeo.
	 */
	private Map<Integer,PositionList<Integer>> mapeo(){
		Map<Integer,PositionList<Integer>> M=new MapeoHashAbierto<Integer,PositionList<Integer>>();
		try{
		    for(Position<Integer> pos:arbol.positions())
			    M.put(pos.element(), listaMap(pos));
		}catch(InvalidKeyException ike){System.out.println(ike.getMessage());}
		return M;
		
	}
	
	/**
	 * Crea una lista para el mapeo con la altura y la profundidad de un nodo.
	 * @param R posicion del nodo.
	 * @return lista.
	 */
	private PositionList<Integer> listaMap(Position<Integer> R){
		PositionList<Integer> lista=new ListaDoblementeEnlazada<Integer>();
		lista.addLast(altura(R));
		lista.addLast(profundidad(R,arbol));
		return lista;
	}
	
	/**
	 * Calcula la altura de un nodo en el arbol.
	 * @param r posicion del nodo.
	 * @return la altura del nodo.
	 */
	private int altura(Position<Integer> r){
		int h=0;
		try{
			if(arbol.isExternal(r))
				return 0;
			else{
				h=0;
				for(Position<Integer> w:arbol.children(r)){
					h=Math.max(h, altura(w));
					return 1+h;
				}
			}
		}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		return h;
	}
	
	/**
	 * Calcula la profundidad del nodo en el arbol.
	 * @param r posicion del nodo.
	 * @param a arbol en el que se encuentra la posicion.
	 * @return profundidad del nodo.
	 */
	private int profundidad(Position<Integer> r, Tree<Integer> a){
		int cant=0;
		try{
		    if (a.isRoot(r))
			    cant=0;
		    else
			    cant=1+profundidad(a.parent(r),a);
		}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return cant;	
	}
	
	/**
	 * Crea el árbol espejado y multiplica los valores de sus elementos por k.
	 * @param T1 arbol original
	 * @param T2 arbol espejado
	 * @param r1 Posicion del nodo del arbol original.
	 * @param r2 Posicion del ultimo nodo ingresado al arbol espejado.
	 * @param k constante a multplicar.
	 */
	private void espejar(Tree<Integer> T1,Tree<Integer> T2, Position<Integer> r1,Position<Integer> r2,Integer k){
		try{
		    Position<Integer> p2 = null;
		    for (Position<Integer> p1 : T1.children(r1)){
			    p2 = T2.addFirstChild(r2,k.intValue()*p1.element().intValue());
			    espejar(T1,T2,p1,p2,k);
		    }
		}catch(InvalidPositionException e){System.out.println(e.getMessage());}
	}
	
}
