package Proyecto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * Clase GUI.
 * @author Salina, Maria Gabriela y Parra, Nadina Guadalupe. Proyecto ED 2017.
 *
 */
public class GUI {

	private JFrame frmProyectoEd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Logica logica=new Logica();
	Carteles carteles=new Carteles();
	JPanel panelMenu;
	JButton btnCrearArbol;
	JButton btnAgregarNodo;
	JButton btnRecorridos;
	JButton btnAncestro;
	JButton btnEspejo;
	JButton btnMapeo;
	JPanel panel_crearArbol;
	JLabel lblIngreseElRotulo;
	JPanel panel_agregarNodo;
	JLabel lblNewLabel;
	JLabel lblElementoAAgregar;
	JPanel panel_recorridos;
	JRadioButton rdbtnpreOrden;
	JRadioButton rdbtnPosorden;
	JRadioButton rdbtnPorNiveles;
	JPanel panel_Ancestro;
	JLabel lblEntre;
	JLabel lblY;
	JLabel lblElAncestroMs;
	JPanel panel_Espejo;
	JPanel panel_Mapeo;
	JTextArea textAreaRecorrido;
	private JTextArea textArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextArea textArea_mapeo;
	private JTextArea textArea_Espejo;
	JScrollPane scrollPane_mapeo;
	JScrollPane scrollPane_espejo;
	private JScrollPane scrollPane_recorridos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmProyectoEd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicación.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		frmProyectoEd = new JFrame();
		frmProyectoEd.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmProyectoEd.setTitle("Proyecto ED 2017");
		frmProyectoEd.setBounds(100, 100, 520, 400);
		frmProyectoEd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoEd.getContentPane().setLayout(null);
		frmProyectoEd.setResizable(false);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 211, 362);
		frmProyectoEd.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		
		
		btnCrearArbol = new JButton("Crear Árbol");
		btnCrearArbol.setBounds(22, 11, 169, 34);
		panelMenu.add(btnCrearArbol);
		btnCrearArbol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int i=carteles.nuevoArbol();
				if(i==0){
					if(logica.arbolVacio()){
						btnAgregarNodo.setEnabled(false);
						btnRecorridos.setEnabled(false);
						btnAncestro.setEnabled(false);
						btnEspejo.setEnabled(false);
						btnMapeo.setEnabled(false);
				       panel_crearArbol.setVisible(true);
					   panel_recorridos.setVisible(false);
				       panel_Ancestro.setVisible(false);
					   panel_Espejo.setVisible(false);
					   panel_Mapeo.setVisible(false);
					   textAreaRecorrido.setText(null);
					   textField_3.setText(null);
					   textField_3.setEditable(true);
					   textField_4.setText(null);
					   textField_4.setEditable(true);
					   textArea.setText(null);
					   buttonGroup.clearSelection();
					   textArea_mapeo.setText(null);
					   
					}
					else{
						logica.borrarArbol();
						panel_crearArbol.setVisible(true);
						panel_recorridos.setVisible(false);
						panel_Ancestro.setVisible(false);
						panel_Espejo.setVisible(false);
						panel_Mapeo.setVisible(false);
						textAreaRecorrido.setText(null);
						textField_3.setText(null);
						textField_3.setEditable(true);
						textField_4.setText(null);
						textField_4.setEditable(true);
						textArea.setText(null);
						buttonGroup.clearSelection();
						textArea_mapeo.setText(null);
						btnAgregarNodo.setEnabled(false);
						btnRecorridos.setEnabled(false);
						btnAncestro.setEnabled(false);
						btnEspejo.setEnabled(false);
						btnMapeo.setEnabled(false);
				    }
			    }
			}
		});
		
		btnAgregarNodo = new JButton("Agregar Nodo");
		btnAgregarNodo.setBounds(22, 56, 169, 34);
		panelMenu.add(btnAgregarNodo);
		btnAgregarNodo.setEnabled(false);
		btnAgregarNodo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel_agregarNodo.setVisible(true);
				textField_1.setEditable(true);
				textField_1.setText(null);
				textField_2.setEditable(false);
				textField_2.setText(null);
				panel_recorridos.setVisible(false);
				panel_Ancestro.setVisible(false);
				panel_Espejo.setVisible(false);
				panel_Mapeo.setVisible(false);
				textAreaRecorrido.setText(null);
				textField_3.setText(null);
				textField_3.setEditable(true);
				textField_4.setText(null);
				textField_4.setEditable(true);
				textArea.setText(null);
				buttonGroup.clearSelection();
				textArea_mapeo.setText(null);
				
			}
		});
		
		
		btnRecorridos = new JButton("Mostrar Árbol");
		btnRecorridos.setBounds(22, 120, 169, 34);
		panelMenu.add(btnRecorridos);
		btnRecorridos.setEnabled(false);
		btnRecorridos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel_recorridos.setVisible(true);
				panel_agregarNodo.setVisible(false);
				panel_Ancestro.setVisible(false);
				panel_Espejo.setVisible(false);
				panel_Mapeo.setVisible(false);
				textField_3.setText(null);
				textField_3.setEditable(true);
				textField_4.setText(null);
				textField_4.setEditable(true);
				textArea.setText(null);
				buttonGroup.clearSelection();
				textAreaRecorrido.setText(null);
				textArea_mapeo.setText(null);
				
			}
		});
		
		btnAncestro = new JButton("Ancestro Común");
		btnAncestro.setBounds(22, 180, 169, 34);
		panelMenu.add(btnAncestro);
		btnAncestro.setEnabled(false);
		btnAncestro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel_Ancestro.setVisible(true);
				panel_recorridos.setVisible(false);
				panel_agregarNodo.setVisible(false);
				panel_Espejo.setVisible(false);
				panel_Mapeo.setVisible(false);
				panel_crearArbol.setVisible(false);
				textAreaRecorrido.setText(null);
				textField_3.setText(null);
				textField_3.setEditable(true);
				textField_4.setText(null);
				textField_4.setEditable(false);
				textArea.setText(null);
				buttonGroup.clearSelection();
				textArea_mapeo.setText(null);
			}
		});
		
		btnEspejo = new JButton("Espejo Multiplicativo");
		btnEspejo.setBounds(22, 248, 169, 34);
		panelMenu.add(btnEspejo);
		btnEspejo.setEnabled(false);
		btnEspejo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel_Mapeo.setVisible(false);
				panel_agregarNodo.setVisible(false);
				panel_recorridos.setVisible(false);
				panel_Ancestro.setVisible(false);
				panel_crearArbol.setVisible(false);
				textAreaRecorrido.setText(null);
				textField_3.setText(null);
				textField_3.setEditable(true);
				textField_4.setText(null);
				textArea.setText(null);
				buttonGroup.clearSelection();
				textArea_mapeo.setText(logica.mostrarMapeo());
				String s=carteles.cartelEspejo();
				if(logica.valorCorrecto(s)){
					panel_Espejo.setVisible(true);
					textArea_Espejo.setText(logica.CrearEspejoMultiplicativo(s));
					
				}
				else{
					carteles.valorIncorrecto();
				}
			}
			});
		
		
		btnMapeo = new JButton("Mapeo");
		btnMapeo.setBounds(22, 317, 169, 34);
		panelMenu.add(btnMapeo);
		btnMapeo.setEnabled(false);
		btnMapeo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel_Mapeo.setVisible(true);
				panel_agregarNodo.setVisible(false);
				panel_recorridos.setVisible(false);
				panel_Ancestro.setVisible(false);
				panel_Espejo.setVisible(false);
				panel_crearArbol.setVisible(false);
				textAreaRecorrido.setText(null);
				textField_3.setText(null);
				textField_3.setEditable(true);
				textField_4.setText(null);
				textArea.setText(null);
				buttonGroup.clearSelection();
				textArea_mapeo.setText(logica.mostrarMapeo());
			}
			});
		
		panel_crearArbol = new JPanel();
		panel_crearArbol.setBounds(217, 0, 297, 50);
		frmProyectoEd.getContentPane().add(panel_crearArbol);
		panel_crearArbol.setLayout(null);
		panel_crearArbol.setVisible(false);		
		
		
		textField = new JTextField();
		textField.setBounds(10, 21, 197, 20);
		panel_crearArbol.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(logica.valorCorrecto(textField.getText())){
				   logica.crearArbol(textField.getText());
				   textField.setText(null);
				   carteles.raizCreada();
				   panel_crearArbol.setVisible(false);
				   btnAgregarNodo.setEnabled(true);
				   btnRecorridos.setEnabled(true);
				   btnAncestro.setEnabled(true);
				   btnEspejo.setEnabled(true);
				   btnMapeo.setEnabled(true);
				}
				else{
					carteles.valorIncorrecto();
					textField.setText(null);
				}
			}
		});
		
		lblIngreseElRotulo = new JLabel("Ingrese el rotulo de la raiz");
		lblIngreseElRotulo.setBounds(10, 0, 197, 25);
		panel_crearArbol.add(lblIngreseElRotulo);
		
		
		panel_agregarNodo = new JPanel();
		panel_agregarNodo.setBounds(217, 50, 297, 50);
		frmProyectoEd.getContentPane().add(panel_agregarNodo);
		panel_agregarNodo.setLayout(null);
		panel_agregarNodo.setVisible(false);
		
		lblNewLabel = new JLabel("Agregar debajo de:");
		lblNewLabel.setBounds(10, 3, 153, 14);
		panel_agregarNodo.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 0, 86, 20);
		panel_agregarNodo.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(logica.valorCorrecto(textField_1.getText())){
				    if(logica.perteneceArbol(textField_1.getText())){
				        textField_1.setEditable(false);
				        textField_2.setEditable(true);
				    }
				    else{
					     carteles.noPertenece();
					     textField_1.setText(null);
					     textField_1.setEditable(true);
				    }	   
				}
				else{
					carteles.valorIncorrecto();
					textField_1.setText(null);
				    textField_1.setEditable(true);
				}
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 31, 86, 20);
		panel_agregarNodo.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(logica.valorCorrecto(textField_2.getText())){
				   logica.agregarNodo(textField_2.getText(),textField_1.getText());
				   textField_1.setText(null);
				   textField_2.setText(null);
				   carteles.nodoAgregado();
				   panel_agregarNodo.setVisible(false);
				}
				else{
					carteles.valorIncorrecto();
					textField_2.setText(null);
				}
				
			}
		});
		
		lblElementoAAgregar = new JLabel("Elemento a agregar:");
		lblElementoAAgregar.setBounds(10, 34, 153, 14);
		panel_agregarNodo.add(lblElementoAAgregar);
		
		panel_recorridos = new JPanel();
		panel_recorridos.setBounds(217, 100, 297, 82);
		frmProyectoEd.getContentPane().add(panel_recorridos);
		panel_recorridos.setLayout(null);
		panel_recorridos.setVisible(false);
		
		rdbtnpreOrden = new JRadioButton("preOrden");
		buttonGroup.add(rdbtnpreOrden);
		rdbtnpreOrden.setBounds(0, 0, 94, 23);
		panel_recorridos.add(rdbtnpreOrden);
		rdbtnpreOrden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				textAreaRecorrido.setVisible(true);
				textAreaRecorrido.setText(logica.mostrarPreorden());
			}
		});
		
		rdbtnPosorden = new JRadioButton("posOrden");
		buttonGroup.add(rdbtnPosorden);
		rdbtnPosorden.setBounds(96, 0, 85, 23);
		panel_recorridos.add(rdbtnPosorden);
		rdbtnPosorden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				textAreaRecorrido.setVisible(true);
				textAreaRecorrido.setText(logica.mostrarPosorden());
			}
		});
		
		
		rdbtnPorNiveles = new JRadioButton("por Niveles");
		buttonGroup.add(rdbtnPorNiveles);
		rdbtnPorNiveles.setBounds(183, 0, 98, 23);
		panel_recorridos.add(rdbtnPorNiveles);
		rdbtnPorNiveles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				textAreaRecorrido.setVisible(true);
				textAreaRecorrido.setText(logica.mostrarPorniveles());
			}
		});
		
		textAreaRecorrido = new JTextArea();
		textAreaRecorrido.setBounds(28, 30, 217, 20);
		panel_recorridos.add(textAreaRecorrido);
		textAreaRecorrido.setEditable(false);
		
		scrollPane_recorridos = new JScrollPane(textAreaRecorrido);
		scrollPane_recorridos.setBounds(28, 20, 217, 62);
		panel_recorridos.add(scrollPane_recorridos);
		
		panel_Ancestro = new JPanel();
		panel_Ancestro.setBounds(217, 181, 297, 56);
		frmProyectoEd.getContentPane().add(panel_Ancestro);
		panel_Ancestro.setLayout(null);
		panel_Ancestro.setVisible(false);
		
		lblEntre = new JLabel("Entre");
		lblEntre.setBounds(10, 3, 66, 14);
		panel_Ancestro.add(lblEntre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 0, 61, 20);
		panel_Ancestro.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(logica.valorCorrecto(textField_3.getText())){
				   if(logica.perteneceArbol(textField_3.getText())){
				      textField_3.setEditable(false);
				      textField_4.setEditable(true);
				   }
				   else{
					    carteles.noPertenece();
					    textField_3.setText(null);
					    textField_3.setEditable(true);
				   }
				}
				else{
					carteles.valorIncorrecto();
					textField_3.setText(null);
					textField_3.setEditable(true);
				}
			}
		});
		
		lblY = new JLabel("Y");
		lblY.setBounds(157, 3, 31, 14);
		panel_Ancestro.add(lblY);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(198, 0, 61, 20);
		panel_Ancestro.add(textField_4);
		textField_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(logica.valorCorrecto(textField_4.getText())){
				    textField_4.setEditable(false);
					if(logica.perteneceArbol(textField_4.getText()))
				       textArea.setText(logica.ancestro(textField_3.getText(),textField_4.getText()));
					else{
						carteles.noPertenece();
						textField_4.setText(null);
						textField_4.setEditable(true);
					}
				}
				else{
					carteles.valorIncorrecto();
					textField_4.setEditable(true);
					textField_4.setText(null);
				}
				
				
			}
		});
		
		textArea = new JTextArea();
		textArea.setBounds(221, 31, 41, 19);
		panel_Ancestro.add(textArea);
		textArea.setEditable(false);
		
		lblElAncestroMs = new JLabel("El ancestro común más cercano es:");
		lblElAncestroMs.setBounds(10, 36, 221, 14);
		panel_Ancestro.add(lblElAncestroMs);
		
		
		panel_Espejo = new JPanel();
		panel_Espejo.setBounds(217, 238, 287, 67);
		frmProyectoEd.getContentPane().add(panel_Espejo);
		panel_Espejo.setLayout(null);
		
		textArea_Espejo = new JTextArea();
		textArea_Espejo.setBounds(1, 1, 297, 65);
		panel_Espejo.add(textArea_Espejo);
		
		scrollPane_espejo = new JScrollPane(textArea_Espejo);
		scrollPane_espejo.setBounds(0, 0, 287, 67);
		panel_Espejo.add(scrollPane_espejo);
		panel_Espejo.setVisible(false);
		
		panel_Mapeo = new JPanel();
		panel_Mapeo.setBounds(217, 306, 287, 56);
		frmProyectoEd.getContentPane().add(panel_Mapeo);
		panel_Mapeo.setLayout(null);
		panel_Mapeo.setVisible(false);
		
		textArea_mapeo = new JTextArea();
		textArea_mapeo.setBounds(1, 1, 296, 54);
		panel_Mapeo.add(textArea_mapeo);
		textArea_mapeo.setEditable(false);
		
		scrollPane_mapeo = new JScrollPane(textArea_mapeo);
		scrollPane_mapeo.setBounds(0, 0, 287, 56);
		panel_Mapeo.add(scrollPane_mapeo);
	}
}
