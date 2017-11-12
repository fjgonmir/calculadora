package es.vistas.calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.calculadora.interfaces.Operaciones;
import es.calculadora.modelo.OperacionesImpl;

public class Calculadora extends JFrame{

	private JPanel contenedor;
	private JPanel panelNumeros;
	private JPanel panelEspecial;
	private JTextField pantalla;
	private Operaciones calculo = new OperacionesImpl();
	private boolean esOperacion = true;

	public Calculadora() throws HeadlessException {
		//creo el marco
		new JFrame();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,300);
		setResizable(false);
		//creo el contenedor
		this.contenedor = (JPanel) this.getContentPane();
		contenedor.setLayout(new BorderLayout());
		//creo la pantalla
		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		pantalla.setBackground(Color.WHITE);
		this.contenedor.add("North", pantalla);
		//creo el panel de numeros
		this.panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		//crea el panel de caracteres especiales
		this.panelEspecial = new JPanel();
		panelEspecial.setLayout(new GridLayout(6, 1));
		panelEspecial.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		//creo los botones numericos
		for (int i = 1; i <= 9; i++) {
			crearBotones(""+i);
			
		}
		crearBotones(""+0);
		
		//crea botones especiales
		crearBotonesEspeciales("+");
		crearBotonesEspeciales("-");
		crearBotonesEspeciales("x");
		crearBotonesEspeciales("/");
		crearBotonesEspeciales("=");
		crearBotonesEspeciales("C");
		//añado el panel de numeros y el de los caracteres especiales
		contenedor.add("Center", panelNumeros);
		contenedor.add("East", panelEspecial);
		
		validate();//se encarga de validar a los componentes
	
	}
	
	//crea los botones especiales y los anade a el panel de los caracteres especiales
	private void crearBotonesEspeciales(String caracter) {
		JButton btn = new JButton(caracter);
		btn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			try {
				realizarOperacion((JButton)e.getSource());
			} catch (NumberFormatException e2) {
				;
			}
			
		}

		});
		this.panelEspecial.add(btn);
		
	}
	
	//realiza las operaciones de la calculadora
	private void realizarOperacion(JButton btn) {
		int numero;
		switch (btn.getText()) {
		case "+":
			numero = Integer.parseInt(pantalla.getText());
			calculo.suma(numero);
			numero = ((OperacionesImpl)calculo).getValor();
			pantalla.setText(""+numero);
			break;
		case "-":
			numero = Integer.parseInt(pantalla.getText());
			calculo.resta(numero);
			numero = ((OperacionesImpl)calculo).getValor();
			pantalla.setText(""+numero);
			break;
		case "x":
			numero = Integer.parseInt(pantalla.getText());
			calculo.Multiplicacion(numero);
			numero = ((OperacionesImpl)calculo).getValor();
			pantalla.setText(""+numero);
			break;
		case "/":
			numero = Integer.parseInt(pantalla.getText());
			calculo.division(numero);
			numero = ((OperacionesImpl)calculo).getValor();
			pantalla.setText(""+numero);
			break;
		case "C":
			((OperacionesImpl)calculo).setValor();
			pantalla.setText(""+((OperacionesImpl)calculo).getValor());
			break;

		default:
			break;
		}
		esOperacion = true;
	}

	public void crearBotones(String i) {
		JButton b1= new JButton(i);
		b1.setVerticalAlignment(AbstractButton.CENTER);
		b1.setHorizontalAlignment(AbstractButton.CENTER);
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				mostrarPantalla((JButton)e.getSource());
			}
		});
		this.panelNumeros.add(b1);
	}
	
	//muestra los numeros en pantalla
	public void mostrarPantalla(JButton btn) {
		
		if (pantalla.getText().equals("0") || esOperacion) {
			pantalla.setText(btn.getText());
		}else {
			pantalla.setText(pantalla.getText()+btn.getText());
		}
		esOperacion = false;
		
	}
	
	
	
}
