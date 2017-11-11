package es.calculadora.interfaces;

import javax.swing.JButton;

public interface Operaciones {

	
	void suma(int numero);//suma un numero a el valor actual
	void resta(int numero);//resta un numero al valor actual
	void Multiplicacion(int numero);//multiplica un numero al valor actual
	void division(int numero);//divide un numero al valor actual
	int numero(JButton btn);//convierte un String a un entero
	
}
