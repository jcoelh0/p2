/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiaota;
/**
 *
 * @author Joao
 */
public class E4 {

	public static void main(String[] args) {
		factors(args, 0);
	}

	public static void factors(String[] args, int i) {
		int argumento[] = new int[args.length];
		argumento[i] = Integer.parseInt(args[i]);
		String fatores = "";
		if (argumento[i] == 0) {
			fatores = "0   ";
		} else if (argumento[i] == 1) {
			fatores = "1   ";
		} else {
			for (int j = 2; j < argumento[i] + 1; j++) {

				if (argumento[i] % j == 0 && isPrime(j) == true) {
					argumento[i] = argumento[i] / j;
					fatores += j + " * ";
					j = 1;
				}
			}
		}
		i++;
		fatores = fatores.substring(0, fatores.length() - 3);
		System.out.printf("%s = %s\n", args[i - 1], fatores);
		if (args.length > i) {
			factors(args, i);
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) 
			if (n % i == 0) 
				return false;
		return true;
	}
}
