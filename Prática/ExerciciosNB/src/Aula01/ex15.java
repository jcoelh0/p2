import java.util.*;
public class ex15 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int a[] = new int[1000];
		int n = 0;
		double soma = 0;
		double media = 0;
		System.out.println("Introduza um conjunto de numeros (0 para parar)");	
		do{
			a[n] = sc.nextInt();
			soma = soma + a[n];
			n++;
		}while(a[n-1] != 0);
		media = soma/(n-1);
		System.out.println("A soma dos numeros da lista e " + soma);
		if(n == 1){
			System.out.println("A media dos numeros da lista nao pode ser calculada.");
		}
		else{
			System.out.println("A media dos numeros da lista e " + media);
		}
	}
}

