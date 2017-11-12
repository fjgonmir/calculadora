package es.calculadora.modelo;

import javax.swing.JButton;

import es.calculadora.interfaces.Operaciones;

public class OperacionesImpl implements Operaciones{

	private int valor;
	
	//constructor
	public OperacionesImpl() {
		this.valor = 0;
	}
	
	//getter and setter
	public int getValor() {
		return valor;
	}

	public void setValor() {
		this.valor = 0;
	}



	@Override
	public void suma(int numero) {
		this.valor += numero;
	}

	@Override
	public void resta(int numero) {
		this.valor -= numero;
		
	}

	@Override
	public void Multiplicacion(int numero) {
		this.valor *= numero;
		
	}

	@Override
	public void division(int numero) {
		this.valor /= numero;
		
	}

	@Override
	public int numero(JButton btn) {
		int entero = 0;
		entero = Integer.parseInt(btn.getText());
		return entero;
	}

}
