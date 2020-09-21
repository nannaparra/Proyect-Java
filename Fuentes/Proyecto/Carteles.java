package Proyecto;

import javax.swing.JOptionPane;

/**
 * Clase Carteles.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class Carteles {
	
	/**
	 * Construye un objeto de clase carteles.
	 */
	public Carteles(){
	}

	
	/**
	 * Muestra en pantalla un mensaje de error.
	 */
	public void noPertenece(){
		JOptionPane.showMessageDialog(null, "El valor ingresado no pertenece al árbol.", "Error Valor", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Muestra en pantalla un mensaje de informacion.
	 */
	public void raizCreada(){
		JOptionPane.showMessageDialog(null, "Se creo la raiz del árbol.", "Árbol", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Muestra en pantalla un mensaje de informacion.
	 */
	public void nodoAgregado(){
		JOptionPane.showMessageDialog(null, "Se agrego el nodo al árbol.", "Árbol", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Muestra en pantalla un mensaje de error.
	 */
	public void valorIncorrecto(){
		JOptionPane.showMessageDialog(null, "El valor ingresado no es un entero.", "Error Valor", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Muestra en pantalla un mensaje de opciones.
	 * @return i entero que indica que opcion se a tomado.
	 */
	public int nuevoArbol(){
		int i=JOptionPane.showConfirmDialog(null, "Quiere crear un nuevo árbol?", "Crear Árbol",JOptionPane.YES_NO_OPTION);
		return i;
	}
	
	/**
	 * Muestra en pantalla un cuadro de dialogo para ingresar un valor. 
	 * @return String con el valor.
	 */
	public String cartelEspejo(){
		String s=JOptionPane.showInputDialog(null,"Ingrese la constante a multiplicar");
		return s;
	}
	
}
