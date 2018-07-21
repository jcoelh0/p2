import java.util.*;

public class Dataneves {
	private int dia,mes,ano;
	
	public void imprimirData(){
		System.out.print(dia+"-"+mes+"-"+ano);
	}
	
	public static boolean bissexto(Dataneves a){
		if(a.ano%4==0 && a.ano%100!=0)
			return true;
		else if(a.ano%400==0)
			return true;
		else return false;
	}
	
	public static int diasMes(Dataneves a){
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
	
	public static boolean dataValida(Dataneves a){
		if(a.ano<=0||a.ano>9999)
			return false;
		else if(a.mes<=0||a.mes>12)
			return false;
		else if (a.dia<1||a.dia>diasMes(a))
			return false;
		else return true;
	} 
	
	public Dataneves(){
		Calendar hoje = Calendar.getInstance();
		dia = hoje.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		mes = hoje.get(Calendar.MONTH);
		ano = hoje.get(Calendar.YEAR);
	}
	
	public Dataneves(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
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
		String[] meses = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		return meses[mes-1];
	}
	
	public void dataExtenso(){
		System.out.print(dia+" de "+nomeMes()+" de "+ano);
	}
	
	public void vaiParaAmanha(){
		if(dia<diasMes(this))
			dia++;
		else if(mes<12){
			dia=1;
			mes++;
		} else{
			dia=1;
			mes=1;
			ano++;
		}
	}
	
	public void vaiParaOntem(){
		if(dia>1)
			dia--;
		else if(mes>1){
			mes--;
			dia=diasMes(this);
		} else{
			dia=31;
			mes=12;
			ano--;
		}
	}
}
