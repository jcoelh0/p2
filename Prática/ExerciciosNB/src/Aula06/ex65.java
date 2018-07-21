package Aula06;


import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class ex65 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		File f = new File(args[0]);
		String files = f.getPath();
	/*	for (int i = 0; i < files; i++) {
			System.out.println(files);
		}*/
		System.out.println(f.listFiles());
		
	}
}
