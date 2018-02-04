package calculadora;
import java.util.Scanner;

/**
 * <p>
 * Clase que instancia un objeto de la clase RPN y le pasa como parametro la expresion que el usuario introduce por teclado.
 * </p>
 * @author MIHAI CATALIN BUDAI
 * @since 01/01/2018
 * @version 1.0
 *
 */

public class Calculadora {
	//metodo main
	public static void main(String args[]) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Introduce expresion Postfija o teclea \"fin\".");
			String linea = in.nextLine( );
			if(linea.equals("fin")) {
				System.out.println("Fin de programa");
				break;
			} else {
				RPN calc = new RPN(linea);
				System.out.printf("El resultado es %f\n", calc.resultado( ));
			}
		}
	}
}