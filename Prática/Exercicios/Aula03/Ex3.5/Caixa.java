//~ Pretende-se construir um mo´dulo reutiliza´vel que implemente a caixa de uma loja. 
//~ Este mo´dulo deve permitir: o armazenamento de diferentes valores de moedas (e notas), 
//~ mostrar as moedas existentes, colocar moedas e retirar dinheiro. Para simplificar o problema, 
//~ considere que todos os valores est˜ao em cˆentimos (utilize o tipo long para o representar). 


import java.util.*;
public class Caixa{
	private long md = 0;
	static Scanner sc = new Scanner(System.in);
	
	public Caixa(long moeda){
		md = moeda;
	}
	
	
	public void adicionaMoeda(long moeda){
		int op;
		do{	
			System.out.println("0- Sair");
			System.out.println("Que moeda pretende adicionar?");
			System.out.println("1- 1cent");
			System.out.println("2- 2cent");
			System.out.println("3- 5cent");
			System.out.println("4- 10cent");
			System.out.println("5- 20cent");
			System.out.println("6- 50cent");
			System.out.println("7- 100cent");
			System.out.println("8- 200cent");
			System.out.println("Que nota pretende adicionar?");
			System.out.println("9-  500cent");
			System.out.println("10- 1000cent");
			System.out.println("11- 2000cent");
			System.out.println("12- 5000cent");
			System.out.println("13- 10000cent");
			System.out.println("14- 20000cent");
			System.out.println("15- 50000cent");
			op = sc.nextInt();
			switch(op){
				case 0:
					
					break;
				case 1:
					moeda += 1;
					break;
				case 2:
					moeda += 2;
					break;
				case 3:
					moeda += 5;
					break;
				case 4:
					moeda += 10;
					break;
				case 5:
					moeda += 20;
					break;
				case 6:
					moeda += 50;
					break;
				case 7:
					moeda += 100;
					break;
				case 8:
					moeda += 200;
					break;
				case 9:
					moeda += 500;
					break;
				case 10:
					moeda += 1000;
					break;
				case 11:
					moeda += 2000;
					break;
				case 12:
					moeda += 5000;
					break;
				case 13:
					moeda += 10000;
					break;
				case 14:
					moeda += 20000;
					break;
				case 15:
					md = 50000 + moeda;
					break;
			}
		}while(op != 0);
		//~ return moeda;
	}
	
	public long[] retiraDinheiro(long valorMin){
		
		
		
		return null;
	}
	
	public long[] moedas(){
		
		return null;
	}
	
	public long total(){
		return md;
	}
}
