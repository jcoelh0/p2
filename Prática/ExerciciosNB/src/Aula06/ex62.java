package Aula06;
/**
 *
 * @author Joao
 */
public class ex62 {
	public static void main(String[] args) {
		recursivo(args, 0);
	}
	
	public static void recursivo(String[] args, int i) {
		if(i >= 0 && i < args.length){
			System.out.println(args[i]);
			recursivo(args, (i+1));
		}
	}
}
