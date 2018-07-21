//package Aula12;

import static java.lang.System.*;
import java.util.Scanner;
import Aula12.p2utils.*;

public class P121 {

    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	HashTable<Integer> ht = new HashTable<>(20);

	for (int i = 0; i < 30; i++) {
	    ht.set("" + i, i * i);
	}

	String[] k = ht.keys();
	for (int i = 0; i < k.length; i++) {
	    out.print(k[i] + " ");
	}
	out.println();
	out.println("------------------------");

	out.println(ht);
    }

}
