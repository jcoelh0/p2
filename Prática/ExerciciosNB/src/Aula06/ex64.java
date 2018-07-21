package Aula06;

/**
 *
 * @author Joao
 */
public class ex64 {
	public static void main(String[] args) {
		invertString(args, 0);
	}
	
	public static void invertString(String[] args, int i){
		String s, result = "", Final = "";
		if(i >= 0 && i < args.length){
			s = args[i];
			for (int j=s.length()-1; j>=0; j--) {
				result = result + s.charAt(j);
			}
			Final = Final + result + " ";
			System.out.print(Final);
			invertString(args, (i+1));
		}
	}
}
