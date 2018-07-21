package Aula04;

import java.util.*;

public class p42 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
	int min = 0, max = 20;
	int tentativa;
	System.out.println("Adivinha o numero!");
	if (args.length == 2) {
	    min = Integer.parseInt(args[0]);
	    max = Integer.parseInt(args[1]);
	}
	GuessGame game = new GuessGame(min, max);
	for (int i = 1; true; i++) {
	    System.out.print("Introduza a tentativa numero " + i + ": ");
	    tentativa = sc.nextInt();
	    game.play(tentativa);
	    if (game.finished() == false) {
		if (game.attemptIsHigher() == true) {
		    System.out.println("O valor certo esta mais abaixo.");
		} else {
		    System.out.println("O valor certo esta mais acima.");
		}
	    } else {
		System.out.println("Boa! Acertou no numero em " + game.numAttempts() + " tentativas.");
		break;
	    }
	}
    }
}
