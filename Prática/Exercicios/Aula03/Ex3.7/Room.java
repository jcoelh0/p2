
public class Room {
	private String tipoQuarto;
	private Point cantoInf, cantoSup;
	
	public Room(Point infEsq, Point supDir, String Roomtype){
		tipoQuarto = Roomtype;
		cantoInf = infEsq;
		cantoSup = supDir;
	}
	
	public String roomType(){
		return tipoQuarto;
	}
	
	public Point bottomLeft(){
		return cantoInf;
	}
	
	public Point topRight(){
		return cantoSup;
	}
	
	public Point geomCenter(){
		return cantoInf.halfWayTo(cantoSup);
	}
	
	public double area(){
		double dx = cantoSup.x() - cantoInf.x();
		double dy = cantoSup.y() - cantoInf.y();
		return dx * dy;
	}
	
}

