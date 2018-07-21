import java.util.*;
public class ex14 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.println("Bem vindo/a ao tradutor de portugues do dialecto do Alberto");
		System.out.println("Introduza as frases desejadas:");
		String a;
		do{
			a = sc.nextLine();
			if(a.equals("")) break;
			a = a.replace("r","");
			a = a.replace("R","");
			a = a.replace("L","U");
			a = a.replace("l","u");
			System.out.println(a);	
		}while(a != "");
	}
}

