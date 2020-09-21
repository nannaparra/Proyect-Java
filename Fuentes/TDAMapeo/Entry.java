package TDAMapeo;

/**
 * Interface Entry.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 */
public interface Entry <K,V>{
	
	  /**
	   * Retorna la clave de la entrada.
	   * @return clave de la entrada.
	   */
    public K getKey();
    
    /**
     * Retorna el valor de la entrada.
     * @return valor de la entrada.
     */
    public V getValue();
}
