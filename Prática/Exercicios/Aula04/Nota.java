
public class Nota{
	private Data i, f;
	private String t;
	
	public Nota(Data inicio, Data fim, String texto){
		i = inicio;
		f = fim;
		t = texto;
	}
	
	public Nota(){
		
	}
	
	public Data inicio(){
		return i;
	}
	
	public Data fim(){
		return f;
	}
	
	public String texto(){
		return t;
	}
	
	public void escreve(){
		
			inicio().escreve();
			System.out.print(" <-> ");
			fim().escreve();
			System.out.print(": ");
			System.out.println(texto());
		
	}
	public void novaNota(Data inicio, Data fim, String texto){
		
	
	}
}
