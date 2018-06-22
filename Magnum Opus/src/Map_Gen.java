
public class Map_Gen {
	
	public static void stanGen(Map m){
		for(int i = 0; i < m.getX(); i++){
			for(int j = 0; j < m.getY(); j++){
				m.addBlock(new Space(new Coordinates(i,j,0)));
			}
		}
		
	}
}
