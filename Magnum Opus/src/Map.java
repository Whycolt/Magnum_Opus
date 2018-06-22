import java.util.ArrayList;

public class Map{
//Map object for a level, contains blocks and stores block locations. 
	
	private ArrayList<ArrayList<ArrayList<Block>>> layout; 
	private int xMax, yMax, zMax;
	
	//constructor
	public Map(int xSize, int ySize, int zSize){
		xMax = xSize;
		yMax = ySize;
		zMax = zSize;
		layout = new ArrayList<ArrayList<ArrayList<Block>>>(xMax);
		for(int x = 0; x < xMax; x++){
			layout.add(new ArrayList<ArrayList<Block>>(yMax));
			for(int y = 0; y < yMax; y++){
				layout.get(x).add(new ArrayList<Block>(zMax));
				for(int z = 0; z < zMax; z++){
					layout.get(x).get(y).add(new Empty_Block(new Coordinates(x,y,z)));
				}
			}
		}
	}
	
	//Get max x
	public int getX(){
		return xMax;
	}
	
	//Get max y
	public int getY(){
		return yMax;
	}
	
	//Get max z
	public int getZ(){
		return zMax;
	}
	
	//get block by location
	public Block getBlock(Coordinates c){
		if (c.x >= xMax+1){
			System.out.println("getBlock: x >= xMax");
		}
		if (c.y >= yMax+1){
			System.out.println("getBlock: y >= yMax");
		}
		if (c.z >= zMax+1){
			System.out.println("getBlock: z >= zMax");
		}
		else
			return layout.get(c.x).get(c.y).get(c.z);
		return new Empty_Block(new Coordinates(-1,-1,-1));
	}
	
	public Block getBlock(int x, int y, int z){
		if (x >= xMax+1){
			System.out.println("getBlock: x >= xMax");
		}
		if (y >= yMax+1){
			System.out.println("getBlock: y >= yMax");
		}
		if (z >= zMax+1){
			System.out.println("getBlock: z >= zMax");
		}
		else
			return layout.get(x).get(y).get(z);
		return new Empty_Block(new Coordinates(-1,1,-1));
	}
	
	//check if block is movable, then move block
	public int moveBlock(Coordinates cstart, int x, int y, int z){
		if (x < 0 || x >= xMax || y < 0 || y >= yMax || z < 0 || z >= zMax){
			System.out.println("Target space is out of bounds");
		}
		else{
			Block start = getBlock(cstart);
			Block end = getBlock(new Coordinates(x,y,z));
			if (end.getType() == 4){
				return 2;
			}
			if (end.isClimbable()){
				return moveBlock(cstart, x, y, z+1);
			}
			Block under = getBlock(new Coordinates(x,y,z-1));
			if (getBlock(new Coordinates(cstart.x,cstart.y,cstart.z-1)).isClimbable() && under.isEmpty()){
				return moveBlock(cstart,x,y,z-1);
			}
			if (start.isEmpty()){
				System.out.println("moveBlock: start block is empty");
			}
			else if (!end.isEmpty()){
				System.out.println("moveBlock: target block is not empty");
			}
			else if (!under.isWalkable()){
				System.out.println("moveBlock: No place to walk on");
			}
			else{
				Block temp = end.clone(cstart.x, cstart.y, cstart.z);
				start.x = x;
				start.y = y;
				start.z = z;
				addBlock(start);
				addBlock(temp);
				return 0;
			}	
		}
		return 1;
	}
	
	//Replace block at x,y,z with new block
	public void addBlock(Block block){
		layout.get(block.x).get(block.y).remove(block.z);
		layout.get(block.x).get(block.y).add(block.z, block);
	}
}
