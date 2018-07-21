import java.util.*;
public class ex13 {
	static Scanner sc = new Scanner(System.in); 
	public static void main (String args[]) {
		int cont = 1;
		System.out.println("Introduza um numero que quer verificar se e primo:");
		int num = sc.nextInt();
		for(int i = 1; i < num; i++){
			if(num % i == 0){
				cont++;
			}
		}
		if(cont == 2){ 
			System.out.println("O numero e primo.");
		}
		else System.out.println("O numero nao e primo.");
	}
}

