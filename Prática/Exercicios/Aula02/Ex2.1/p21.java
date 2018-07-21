/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/

public class p21 {
	// Exemplo simples de utilização da class Complexo
	public static void main(String[] args) {
		double re = 5.0;
		double im = 6.0;
		
		if (args.length >= 1){
			re = Double.parseDouble(args[0]);
		}
		if(args.length >= 2){
			im = Double.parseDouble(args[1]);
		}
		Complexo a = new Complexo(re,im);
		// Vamos usar métodos de 'a'
		System.out.println("(" + a.real() + " + " + a.imag() + "i)");
		System.out.println("  parte real = " + a.real());
		System.out.println("  parte imaginaria = " + a.imag());
		System.out.println("  modulo = " + a.abs());
		System.out.printf("  fase   =  %2.2f\n", a.phase());
	}
}
