package Aula10.Aula10atualizada;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.*;
import p2utils.*;

public class pal {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
	File ficheiro = new File("C:\\Users\\jcoel\\Desktop\\Universidade\\Semestre2\\P2\\ExerciciosNB\\src\\Aula10\\Aula10atualizada\\textopal.txt");
	Scanner fin = new Scanner(ficheiro);
	System.out.println("Ficheiro e Scanner criado");
	while (fin.hasNextLine()) {
	    Stack<Character> contrario = new Stack<>();
	    Queue<Character> certo = new Queue<>();
	    String s = fin.nextLine();
	    int i = 0;
	    while (i < s.length()) {
		char x = s.charAt(i);
		contrario.push(x);
		certo.in(x);
		i++;
	    }
	    String contrario_s = contrario.toString();
	    String certo_s = certo.toString();
	    if (contrario_s.equals(certo_s)) {
		System.out.println("é palindromo");
	    }
	}
    }
}
