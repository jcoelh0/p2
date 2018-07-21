package E20;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class Restaurante1 {

    public static void main(String[] args) throws IOException {
	HashTable<Integer> despensa = new HashTable<>(1000);
	Queue<HashTable<Integer>> pedidos = new Queue<HashTable<Integer>>();  // fila de pedidos

	for (int i = 0; i < args.length; i++) {
	    File f = new File(args[i]);
	    readData(f, despensa, pedidos);
	}

	out.println("Comida em stock:");
	String[] ingr = despensa.keys();
	for (int k = 0; k < ingr.length; k++) {
	    int quant = despensa.get(ingr[k]);
	    out.printf("%s: %d\n", ingr[k], quant);
	}

	// FALTA despejar pedidos não servidos
    }

    public static void readData(File f,
	    HashTable<Integer> despensa,
	    Queue<HashTable<Integer>> pedidos) throws IOException {
	// FALTA proteger com try catch
	Scanner scf = new Scanner(f);
	while (scf.hasNextLine()) {
	    String line = scf.nextLine();
	    String[] parts = line.split(" +");
	    switch (parts[0]) {
		case "entrada:": // abastecer despensa
		    String ingredient = parts[1];
		    int quant = 0;
		    if (despensa.contains(ingredient)) {
			quant = despensa.get(ingredient);
		    }
		    despensa.set(ingredient, quant + 1);
		    break;
		case "saida:": // registar pedido
		    HashTable<Integer> pedido = new HashTable<Integer>(parts.length);
		    for (int j = 1; j < parts.length; j++) {
			String[] pp = parts[j].split(":");
			pedido.set(pp[0], Integer.parseInt(pp[1]));
		    }
		    pedidos.in(pedido);
		    break;
		default:
		    err.printf("%s: formato inválido\n", f);
		    exit(1);
	    } // switch
	    // processar pedido
	    processarPedidos(despensa, pedidos);
	}
	scf.close();
    }

    // Processa 0 ou mais pedidos que possam ser satisfeitos
    public static void processarPedidos(HashTable<Integer> despensa,
	    Queue<HashTable<Integer>> pedidos) {
	HashTable<Integer> pedido;
	while (!pedidos.isEmpty()) {
	    pedido = pedidos.peek(); // próximo pedido

	    // Se há suficiente para o próximo pedido, desiste!
	    if (!gotEnough(despensa, pedido)) {
		break;
	    }

	    // Se há, processa o pedido!
	    pedidos.out();
	    out.printf("Refeição servida:");
	    String[] ingr = pedido.keys();
	    for (int k = 0; k < ingr.length; k++) {
		int quant = despensa.get(ingr[k]);
		int quantPed = pedido.get(ingr[k]);
		despensa.set(ingr[k], quant - quantPed);
		out.printf(" %s:%d", ingr[k], quantPed);
	    }
	    out.println();
	}
    }

    public static boolean gotEnough(HashTable<Integer> despensa,
	    HashTable<Integer> pedido) {
	String[] ingr = pedido.keys();
	for (int k = 0; k < ingr.length; k++) { // por cada ingrediente do pedido
	    int quant = 0;
	    if (despensa.contains(ingr[k])) // se há na despensa,
	    {
		quant = despensa.get(ingr[k]);  // que quantidade?
	    }
	    int quantPed = pedido.get(ingr[k]);
	    if (quantPed > quant) // é suficiente?
	    {
		return false;
	    }
	}
	return true;
    }
}
