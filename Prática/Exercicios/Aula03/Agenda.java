import java.lang.System.*;
public class Agenda{
	private int numNotas = 0;
	private Nota[] notas = new Nota[numNotas];
	
	public void novaNota(Nota a){
		Nota[] tmp = new Nota[numNotas + 1];
		if(notas.length > 0) System.arraycopy(notas,0,tmp,0,numNotas);
		notas = tmp;
		notas[numNotas] = a;
		ordenarDatas(notas);
		numNotas++;
		
		
	}
	
	public void ordenarDatas(Nota[] a){
		for(int i = 0; i < a.length - 1; i++){
			for(int j = i + 1; j < a.length; j++){
				if(a[i].inicio().maiorDoQue(a[j].inicio())){
					Nota tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					tmp = null;
				}
			}
		}
	}
	
	public Nota[] compromissos(Data n1, Data n2){
		int cont = 0;
		Nota[] todo = new Nota[cont];
		for(int i = 0; i < notas.length; i++){
			
			if(( notas[i].inicio().igualA(n2)||notas[i].inicio().igualA(n1) || (notas[i].inicio().maiorDoQue(n1) &&notas[i].inicio().menorDoQue(n2) ) || ( notas[i].fim().igualA(n1)||notas[i].fim().igualA(n2) ||(notas[i].fim().maiorDoQue(n1) &&notas[i].fim().menorDoQue(n2) ))       )){ 
				Nota[] tmp = new Nota[cont + 1];
				System.arraycopy(todo,0,tmp,0,cont);
				
				todo = tmp;
				todo[cont] = notas[i];
				cont++;
			}
		}
		return todo;
	}
	
	public void escreve(){
		System.out.println("Agenda:");
		for(int i = 0; i < numNotas; i++){
			notas[i].inicio().escreve();
			System.out.print(" <-> ");
			notas[i].fim().escreve();
			System.out.print(": ");
			System.out.println(notas[i].texto());
			
		}
	}
}
