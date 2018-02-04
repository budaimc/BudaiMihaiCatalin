package calculadora;
/**
 * Clase que crea la pila.
 * @author MIHAI CATALIN BUDAI
 * @since 01/01/2018
 * @version 1.0
 *
 */
public class NodoPila {
	/**
	 * Metodo constructor que espera un double y un objeto
	 * @param dato Variabe double que espera el constructor
	 * @param abajo Objeto que espera el constructor
	 */
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
	public NodoPila abajo;
	public double dato;
}