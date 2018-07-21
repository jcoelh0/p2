import java.util.*;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		
		int d = -1,m = -1,a = -1;
		int k = -1;
		Data data = new Data(5,5,2011);
		do{
			System.out.println("1. Cria novo objecto com a data actual"); 
			System.out.println("2. Cria novo objecto com uma qualquer data"); 
			System.out.println("3. Indica se a data e valida e ve se e bissexto"); 
			System.out.println("4. Escreve data"); 
			System.out.println("5. Escreve data por extenso"); 
			System.out.println("6. Dia anterior"); 
			System.out.println("7. Dia seguinte");
			System.out.println("0. Termina");
			System.out.println();
			System.out.println("NOTA: Se nao houver outra indicacao, todas as operacoes");
			System.out.println("      fazem-se sobre o ultimo objecto criado.");
			System.out.println("Ol\u00e1 ");
			System.out.print("Opcao:");
			k = sc.nextInt();
			sc.nextLine();
			
		
			switch(k){
				case 1:
					Data dt = new Data();
					//data.imprimirData();
					//a = dt.ano();
					break;
				case 2:
					
					break;
				case 3:
					if(data.bissexto(data)){
						System.out.println(data.ano() + " e bissexto");
					}else System.out.println(data.ano() + " nao e bissexto");
					break;
				case 4:
					//a = dt.registarData(d,m,a);
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 0:
					System.exit(1);
				default:
					
					break;
				
			}
		}while(k != 0);
	}
}

