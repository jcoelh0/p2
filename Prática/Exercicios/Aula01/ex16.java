import java.util.*;
public class ex16 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.println("Vamos jogar ao Adivinha o numero!");
		System.out.println("O jogo termina quando o numero correcto for indicado, sendo a pontuacao do jogador o numero de tentativas feito (portanto o valor 1 sera a pontuacao maxima)");
		int rdm = (int)(Math.random()*(100+1));
		int n = 0;
		System.out.println("Introduza um numero de 0 a 100:");
		int x;
		do{
			x = sc.nextInt();
			n++;
			if(x > rdm){
				System.out.println("O numero que pretende descobrir esta abaixo de " + x);
			}
			else if(x < rdm){
				System.out.println("O numero que pretende descobrir esta acima de " + x);
			}
		}while(x != rdm);
		System.out.println("Boa, ganhou o jogo! Teve uma pontuacao de " + n);
	}
}

