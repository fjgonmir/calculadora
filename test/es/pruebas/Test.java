package es.pruebas;

import es.calculadora.interfaces.Operaciones;
import es.calculadora.modelo.OperacionesImpl;

public class Test {

	public static void main(String[] args) {
		
		OperacionesImpl op = new OperacionesImpl();
		op.suma(1);
		op.suma(2);
		op.suma(1);
		op.division(2);
		System.out.println(op.getValor());

	}

}
