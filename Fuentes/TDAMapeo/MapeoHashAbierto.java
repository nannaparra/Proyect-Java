package TDAMapeo;
import java.util.Iterator;

import Auxiliar.*;
import TDALista.*;

/**
 * Clase MapeoHashAbierto
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class MapeoHashAbierto<K,V> implements Map<K,V> {
	protected PositionList<Entrada<K,V>> [] map;
	protected Integer cant; //Cantidad de entradas.
	protected Integer tamaño; //Tamaño del arreglo.
	protected final float factor=0.9F;
	
	/**
	 * Construye un mapeo con hash abierto.
	 */
	public MapeoHashAbierto(){
		tamaño=29;
		map=(PositionList<Entrada<K,V>> []) new ListaDoblementeEnlazada[tamaño];
		for(int i=0;i<tamaño;i++){
			map[i]=new ListaDoblementeEnlazada<Entrada<K,V>>();
		}
		cant=0;
	}
	
	public int size(){
		return cant;
	}
	
	public boolean isEmpty(){
		return (cant==0);
	}
	
	public V get(K key) throws InvalidKeyException{
		if(key==null)throw new InvalidKeyException("Clave nula");
		V v=null;
		int i=funcionHash(key);
		PositionList<Entrada<K,V>> l=map[i];
		Iterator<Entrada<K,V>> it=l.iterator();
		boolean enc=false;
		while(it.hasNext()&&!enc){
			Entrada<K,V> e=it.next();
			if((e.getKey()).equals(key)){
				v=e.getValue();
				enc=true;
			}
		}
		return v;
	}
	
	public V put(K key,V value)throws InvalidKeyException{
		if(key==null)throw new InvalidKeyException("Clave nula");
		V v=null;
		int i=funcionHash(key);
		PositionList<Entrada<K,V>> l=map[i];
		for(Entrada<K,V> e:l)
			if((e.getKey()).equals(key)){
				v=e.getValue();
				e.setValue(value);
			}
		if(v==null){
			l.addLast(new Entrada<K,V>(key,value));
			cant++;
		}
		if((cant.floatValue()/tamaño.floatValue())>factor){
			agrandarArreglo();
		}
		return v;
	}
	
	public V remove(K key) throws InvalidKeyException{
		if(key==null)throw new InvalidKeyException("Clave nula");
		V v=null;
		int i=funcionHash(key);
		PositionList<Entrada<K,V>> l=map[i];
		try{
		    Position<Entrada<K,V>> p=l.first();
	        boolean enc=false;
	        while(p!=null &&!enc){
	            if(p.element().getKey().equals(key)){
	               v=p.element().getValue();
	               l.remove(p);
	               cant--;
	               enc=true;
	            }
	           else{
	               if(p==l.last())
	                  p=null;
	               else
	                  p=l.next(p);
	           }
	        } 
		}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(EmptyListException ele){System.out.println(ele.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return v;
	}
	
	public Iterable<K> keys(){
		PositionList<K> itK=new ListaDoblementeEnlazada<K>();
		for(int i=0;i<tamaño;i++){
			PositionList<Entrada<K,V>> l=map[i];
			for(Entrada<K,V> e:l)
				itK.addLast(e.getKey());
		}
		return itK;
	}
	
	public Iterable<V> values(){
		PositionList<V> itV=new ListaDoblementeEnlazada<V>();
		for(int i=0;i<tamaño;i++){
			PositionList<Entrada<K,V>> l=map[i];
			for(Entrada<K,V> e:l)
				itV.addLast(e.getValue());
		}
		return itV;
	}
	
	public Iterable<Entry<K,V>> entries(){
		PositionList<Entry<K,V>> itE=new ListaDoblementeEnlazada<Entry<K,V>>();
		for(int i=0;i<tamaño;i++){
			PositionList<Entrada<K,V>> l=map[i];
			for(Entrada<K,V> e:l)
				itE.addLast(e);
		}
		return itE;
	}
	
	/**
	 * Transforma una clave en un numero entero.
	 * @param key clave pasada como parametro.
	 * @return retorna la clave pasada a numero entero.
	 */
	private int funcionHash(K key){
		int i=(Math.abs(key.hashCode())%tamaño);
		return i;
	}
	
	/**
	 * Angranda el tamaño del arreglo.
	 */
	private void agrandarArreglo(){
		int nuevotamaño=sigPrimo(tamaño);
		try{
		PositionList<Entrada<K,V>> [] aux=(PositionList<Entrada<K,V>> [])new ListaDoblementeEnlazada[nuevotamaño];
		for(int i=0;i<nuevotamaño;i++){
			aux[i]=new ListaDoblementeEnlazada<Entrada<K,V>>();
		}
		Iterator<Entry<K,V>> it=entries().iterator();
		map=aux;
		cant=0;
		tamaño=nuevotamaño;
		    while(it.hasNext()){
			    Entry<K,V> e=it.next();
			    put(e.getKey(),e.getValue());
		    }
		}catch(InvalidKeyException ike){System.out.println(ike.getMessage());}
	}
	
	/**
	 * Busca el primo siguiente de un entero.
	 * @param tamaño entero pasado como parametro.
	 * @return retorna el numero primo.
	 */
	private int sigPrimo(int tamaño){
		int tam=tamaño*2;
		int cont=0;
		boolean encontre=false;
		while(!encontre){
			for(int i=1;i<=tam;i++){
				if((tam % i)==0)
					cont++;
			}
			if(cont==2)
				encontre=true;
			else{
				tam++;
				cont=0;
			}
		}
		return tam;
	}
	

}