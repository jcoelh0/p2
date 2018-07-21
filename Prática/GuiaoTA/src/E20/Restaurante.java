package E20;

import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class Restaurante {
    public static void main(String[] args) throws IOException {
	HashTable<Integer> lol = new HashTable<Integer>(1000);
	lerInfo(args, lol);
	System.out.println("Comida em stock:");
	String[] ingr = lol.keys();
	for (int i = 0; i < ingr.length; i++) {
	    int quantidade = lol.get(ingr[i]);
	    System.out.printf("%s: %d\n", ingr[i], quantidade);
	}
	
    }
    
    public static void lerInfo(String[] args, HashTable<Integer> lol) throws IOException{
	File f = new File(args[0]);
	Scanner fin = new Scanner(f);
	//vamos usar KeyValueList
	
	while(fin.hasNextLine()){
	    String linha = fin.nextLine();
	    String[] splited = linha.split("\\s+");
	    System.out.print(splited[0]+" "+splited[1]);
	    int quantidade = 0;
	    if(splited[0].equals("entrada:")){
		if(lol.contains(splited[1])){
		    quantidade = lol.get(splited[1]);
		}
	    lol.set(splited[1],quantidade+1);
	    }
	}
	fin.close();
    }
}
