import java.util.*;

public class ex11 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Introduza a operacao que quiser(multiplicacao, divisao, soma ou subtracao):");
		double valor1,valor2,resultado = 0;
		String oper;
		valor1 = sc.nextDouble();
		oper = sc.next().trim();
		valor2 = sc.nextDouble();
		
		if(oper.equals("+")){
			resultado = valor1 + valor2;
			System.out.println("O resultado e " + resultado);
		}
		if(oper.equals("*")){
			resultado = valor1 * valor2;
			System.out.println("O resultado e " + resultado);
		}
		if(oper.equals("-")){
			resultado = valor1 - valor2;
			System.out.println("O resultado e " + resultado);
		}
		if(oper.equals("/")){
			resultado = valor1 / valor2;
			System.out.println("O resultado e " + resultado);
		}
	}
}
