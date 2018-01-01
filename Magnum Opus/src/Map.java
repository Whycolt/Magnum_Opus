import java.util.ArrayList;

public class Map{
//Map object for a level, contains blocks and stores block locations. 
	
	private ArrayList<Block> layout; 
	private int xMax, yMax, zMax;
	
	//constructor
	public Map(int xSize, int ySize, int zSize){
		int max = xSize*ySize*zSize;
		this.xMax = xSize;
		this.yMax = ySize;
		this.zMax = zSize;
		this.layout = new ArrayList<Block>();
		for(int i = 0; i < max; i++){
			this.layout.add(new Empty_Block()); 
		}
	}
	
	public int getX(){
		return this.xMax;
	}
	
	public int getY(){
		return this.yMax;
	}
	
	public int getZ(){
		return this.zMax;
	}
	
	//get block by location
	public Block getBlock(int x, int y, int z){
		if (x >= this.xMax){
			System.out.println("getBlock: x >= xMax");
		}
		if (y >= this.yMax){
			System.out.println("getBlock: y >= yMax");
		}
		if (z >= this.zMax){
			System.out.println("getBlock: z >= zMax");
		}
		else
			return this.layout.get(x*y*z+x*y+x);
		return new Empty_Block();
	}
	
	//check if block is movable, then move block
	public boolean moveBlock(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd){
		Block start = this.getBlock(xStart, yStart, zStart);
		Block end = this.getBlock(xEnd, yEnd, zEnd);
		if (start.isEmpty()){
			System.out.println("moveBlock: start block is empty");
		}
		if  (!end.isEmpty()){
			System.out.println("moveBlock: end block is not empty");
		}
		else{
			Block temp = end.clone();
			end = start;
			start = temp;
			return true;
			}
		return false;
	}
}
