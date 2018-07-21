import java.io.*;
import java.util.Scanner;
public class P77 {
	
	public static void main (String args[]) throws IOException {
		Scanner se = new Scanner(System.in);
		String f;
		System.out.print("Nome do Ficheiro a ler?");
		f = se.nextLine();
		File fin = new File(f);
		Scanner sc = new Scanner(fin);
		LinkedList<String> l1 = new LinkedList<String>();
		LinkedList<String> l2 = new LinkedList<String>();
		LinkedList<String> l3 = new LinkedList<String>();
	
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			if(s.length()<20)
				l1.addLast(s);
			else if(s.length()> 20 && s.length()<40)
				l2.addLast(s);
			else if(s.length()>40)
				l3.addLast(s);
		}
		while(!l1.isEmpty()){
			System.out.println(l1.first());
			l1.removeFirst();
		}
		while(!l2.isEmpty()){
			System.out.println(l2.first());
			l2.removeFirst();
		}
		while(!l3.isEmpty()){
			System.out.println(l3.first());
			l3.removeFirst();
		}
	}
}
