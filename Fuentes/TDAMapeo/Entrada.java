package TDAMapeo;

/**
 * Clase Entrada.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public class Entrada<K,V> implements Entry<K,V> {
	private K key;
	private V value;
	
	/**
	 * Construye una entrada.
	 * @param k clave de la entrada.
	 * @param v valor de la entrada.
	 */
	public Entrada(K k, V v){
		key=k;
		value=v;
	}
	
	
	public K getKey(){
		return key;
	}
	
	
	public V getValue(){
		return value;
	}
	
	/**
	 * Establece la clave de la entrada.
	 * @param k clave a asignar a la entrada.
	 */
	public void setKey(K k){
		key=k;
	}
	
	/**
	 * Establece el valor de la entrada.
	 * @param v valor a asignar a la entrada.
	 */
	public void setValue(V v){
		value=v;
	}

}
