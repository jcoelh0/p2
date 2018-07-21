/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class ex61 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Introduza o n: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(fibonacci(i));
			//n=-1;
		}
		
	}

	public static long fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
}
