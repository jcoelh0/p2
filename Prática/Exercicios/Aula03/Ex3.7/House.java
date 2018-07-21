
public class House {
	
	private String houseType;
	private int sizeExtension, size;
	private Room[] rooms;
	
	
	public House(String houseType){
		this(houseType,8,4);
	}
	
	public House(String houseType, int maxSize, int sizeExtension){
		this.houseType = houseType;
		this.sizeExtension = sizeExtension;
		rooms = new Room[maxSize];
		size = 0;
	}
	
	public int addRoom(Room r){
		if (size == rooms.length){
			Room[] newRooms = new Room[rooms.length + sizeExtension];
			System.arraycopy(rooms, 0, newRooms, 0, rooms.length);
			rooms = newRooms;
		}
		rooms[size] = r;
		size++;
		return size - 1;	
	}
	
	public int size(){
		return size;
	}
	
	public int maxSize(){
		return rooms.length;
	}
	
	public Room room(int i){
		return rooms[i];
	}
	
	public double area(){
		double area = 0;
		for(int i = 0; i < size; i++){
			area += rooms[i].area();
		}
		return area;
	}
	public RoomTypeCount[] getRoomTypeCounts(){ 
		RoomTypeCount[] rtc = new RoomTypeCount[size]; 
		int nt = 0;
		boolean encontrei = false;	
		for(int r = 0; r < size; r++){
			for(int t = 0; t < nt && !encontrei; t++){
				if(rtc[t].roomType.equals(rooms[r].roomType())){
					rtc[t].count++;
					encontrei = true;
				}
			}
			if(!encontrei){
				rtc[nt] = new RoomTypeCount();
				rtc[nt].roomType = rooms[r].roomType();
				rtc[nt].count = 1;
				nt++;
			}
			
		}
		RoomTypeCount[] newrtc = new RoomTypeCount[nt];
		System.arraycopy(rtc,0,newrtc,0,nt);
		return newrtc;
	}
	
	public double averageRoomDistance(){
		double media = 0;
		for(int i = 0; i < sizeExtension; i++){
			media =+ rooms[i].geomCenter().distTo(rooms[i+1].geomCenter());
		}
		media = media/sizeExtension;
		return media;
	}
}


