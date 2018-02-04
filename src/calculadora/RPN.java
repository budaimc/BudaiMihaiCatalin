package calculadora;
/**
 * <p>
 * Clase que añade y quita elementos de la pila y que calcula el resutado de la expresion RPN. 
 * </p>
 * Tiene 3 metodos:
 * <ul>
 * <li>pushPila</li>
 * <li>popPila</li>
 * <li>resultado</li>
 * </ul>
 * 
 * <p>
 * Este programa, RPN.java es una calculadora de notación inversa polaca que utiliza una pila.
 * </p>
 * 
 * @author MIHAI CATALIN BUDAI
 * @since 01/01/2018
 * @version 1.0
 *
 */
public class RPN {
	/**
	 * 	Este metodo añade datos a la pila.
	 * @param nuevo_dato
	 */
	private void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	} 
	/**
	 * Este metodo quita datos de la pila.
	 * @return dato_arriba
	 */
	private double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	/**
	 *
	 * Metodo constructor que espera un String
	 * @param commando
	 * 					Sera la cadena de la expresion RPN
	 */
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	/**
	 *  Metodo que calcula la expresión en notación RPN que le pasamos por parametro.
	 * @return val
	 * 					Devuelve el resultado de la expresion RPN
	 * @throws IllegalArgumentException
	 * 					Excepcion generada por este metodo.
	 */
	public double resultado( ) {
		for(int i = 0; i < commando.length( ); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				// obtener un string a partir del numero

				String temp = "";

				for(j = 0; (j < 100) && (Character.isDigit(commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.charAt(i));
				}

				// convertir a double y añadir a la pila
				numero = Double.parseDouble(temp);
				pushPila(numero);
			} else if(commando.charAt(i) == '+') {
				b = popPila( );
				a = popPila( );
				pushPila(a + b);
			} else if(commando.charAt(i) == '-') {
				b = popPila( );
				a = popPila( );
				pushPila(a - b);
			} else if(commando.charAt(i) == '*') {
				b = popPila( );
				a = popPila( );
				pushPila(a * b);
			} else if(commando.charAt(i) == '/') {
				b = popPila( );
				a = popPila( );
				pushPila(a / b);
			} else if(commando.charAt(i) == '^') {
				b = popPila( );
				a = popPila( );
				pushPila(Math.pow(a, b));
			} else if(commando.charAt(i) == '%') {
				b = popPila( );
				a = popPila( );
				pushPila(a%b);
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	private String commando;
	private NodoPila arriba;
	private double a;
	private double b;
	private int j;
}