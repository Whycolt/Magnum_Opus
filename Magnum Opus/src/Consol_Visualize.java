
public class Consol_Visualize {

	public static void visualize(Map map){
		for (int z = map.getZ() - 1; z >= 0; z += -1){
			for (int x = 0; x < map.getX(); x++){
				for (int y = 0; y < map.getY(); y++){
					System.out.print(map.getBlock(x, y, z));
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	
	}
}
