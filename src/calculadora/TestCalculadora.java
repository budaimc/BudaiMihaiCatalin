package calculadora;

import junit.framework.TestCase;
import org.junit.Test;
import calculadora.RPN;

public class TestCalculadora extends TestCase{
		
	RPN calc1 = new RPN("4 5 * 7 2 / - 3 %");
	RPN calc2 = new RPN("4 2 * 1 +");
	RPN calc3 = new RPN("2 2 3 * + 5 -");

	@Test
	public void testCalculadora(){
		
		double resultado1= calc1.resultado();
		double resultado2= calc2.resultado();
		double resultado3= calc3.resultado();
		
		double esperado1 = 1.5F;
		double esperado2 = 9F;
		double esperado3 = 3F;
		
	assertEquals(esperado1 , resultado1); //prueba valida
	assertEquals(esperado2 , resultado2); //prueba valida
	assertEquals(esperado3 , resultado3); //prueba valida
	
	assertEquals(0 , resultado1);    //prueba no valida
	assertEquals(36 , resultado2); //prueba  no valida
	assertEquals(13 , resultado3); //prueba no valida
	
	}
}