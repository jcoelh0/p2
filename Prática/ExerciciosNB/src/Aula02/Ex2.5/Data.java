import java.util.*;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}
	
	public Data(){
		Calendar hoje = Calendar.getInstance();
		dia = hoje.get(Calendar.DATE);
		mes = hoje.get(Calendar.MONTH) + 1;
		ano = hoje.get(Calendar.YEAR);
	}
	
	public int dia(){
		return dia;
	}
	public int mes(){
		return mes;
	}
	public int ano(){
		return ano;
	}
	
	public String nomeMes(){
		String s = "";
		switch(mes){
			case 1:
				s = "Janeiro";
				break;
			case 2:
				s = "Fevereiro";
				break;
			case 3:
				s = "Marco";
				break;
			case 4:
				s = "Abril";
				break;
			case 5:
				s = "Maio";
				break;
			case 6:
				s = "Junho";
				break;
		}
		return s;
	}
	
	public static void igualA(){
		
	}
	
	public static void menorDoQue(){
		
	}
	
	public static void maiorDoQue(){
		
	}
	
	
	public void imprimirData() {
		System.out.printf("%2d-%2d-%4d\n",dia,mes,ano);
	}
	
	public static boolean bissexto(Data a){
			if((a.ano % 4 == 0) && (a.ano % 100 != 0) || (a.ano % 400 == 0)){
			return true;
		}else return false;
	}
	
	public static int diasMes(Data a){
		switch(a.mes){
			case 1:case 3:case 5:case 7:case 8:case 10: case 12:
				return 31;
			case 2:
				if(bissexto(a))
					return 29;
				else return 28;
			default :
				return 30;
		}
	}
	
	public static boolean dataValida(Data a){
		if(a.ano < 0 || a.ano > 9999){
			return false;
		}
		if(a.mes < 1 || a.mes > 12){
			return false;
		}
		if(a.dia < 1 || a.dia > 31 || diasMes(a) != a.dia){
			return false;
		}
		return true;
	}
	
	
}



