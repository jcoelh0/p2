import java.util.*;
public class Menu {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		int k;
		long md = 0;
		do{
			System.out.println("1. Adicionar moedas");
			System.out.println("2. Retirar dinheiro");
			System.out.println("3. Ver moedas na carteira");
			System.out.println("4. Ver total da carteira");
			System.out.println("0. Termina");
			System.out.println();
			System.out.print("Opcao:");
			k = sc.nextInt();
			Caixa caixa = new Caixa(md);
			switch(k){
				case 1:
					caixa.adicionaMoeda(caixa.total());

					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					System.out.println(caixa.total());
					break;
				case 0:
					System.out.println("Obrigado!");
					break;
				default:
					System.out.println("Opcao invalida. Volte a introduzir um opcao.");
					break;
			}
		}while(k != 0);
	}
}
