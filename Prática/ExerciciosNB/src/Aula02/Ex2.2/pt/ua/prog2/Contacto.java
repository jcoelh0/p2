package pt.ua.prog2;

public class Contacto {
	private String nm = "";
	private String telef = "";
	private String eM = "";
	static private int numContactos = 0;
	
	public static void numCont(String nm){
		if(nm == null || nm.length() == 0 ){
			System.out.println("Contacto Invalido");
			System.exit(1);
		}
	}
	
	public Contacto(String nome, String telefone, String eMail) {
		nm = nome;
		telef = telefone;
		eM = eMail;
		numContactos++;
	}
	
	public Contacto(String nome, String telefone) {
		nm = nome;
		telef = telefone;
		numContactos++;
		
	}
	public Contacto(String telefone) {
		telef = telefone;
		numContactos++;
	}
	
	public String nome() {   
		return nm;
	} 
	public String telefone() {   
		return telef;
	} 
	public String eMail() { 
		return eM;
	}
	public static int numContactos() { 
		return numContactos;
	}
}

