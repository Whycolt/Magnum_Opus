import java.util.ArrayList;

public class Map{
//Map object for a level, contains blocks and stores block locations. 
	
	private ArrayList<ArrayList<ArrayList<Block>>> layout; 
	private int xMax, yMax, zMax;
	
	//constructor
	public Map(int xSize, int ySize, int zSize){
		this.xMax = xSize;
		this.yMax = ySize;
		this.zMax = zSize;
		this.layout = new ArrayList<ArrayList<ArrayList<Block>>>(xMax);
		for(int x = 0; x < xMax; x++){
			this.layout.add(new ArrayList<ArrayList<Block>>(yMax));
			for(int y = 0; y < yMax; y++){
				this.layout.get(x).add(new ArrayList<Block>(zMax));
				for(int z = 0; z < zMax; z++){
					this.layout.get(x).get(y).add(new Empty_Block(new Coordinates(x,y,z)));
				}
			}
		}
	}
	
	//Get max x
	public int getX(){
		return this.xMax;
	}
	
	//Get max y
	public int getY(){
		return this.yMax;
	}
	
	//Get max z
	public int getZ(){
		return this.zMax;
	}
	
	//get block by location
	public Block getBlock(Coordinates c){
		if (c.x >= this.xMax+1){
			System.out.println("getBlock: x >= xMax");
		}
		if (c.y >= this.yMax+1){
			System.out.println("getBlock: y >= yMax");
		}
		if (c.z >= this.zMax+1){
			System.out.println("getBlock: z >= zMax");
		}
		else
			return this.layout.get(c.x).get(c.y).get(c.z);
		return new Empty_Block(new Coordinates(-1,-1,-1));
	}
	
	public Block getBlock(int x, int y, int z){
		if (x >= this.xMax+1){
			System.out.println("getBlock: x >= xMax");
		}
		if (y >= this.yMax+1){
			System.out.println("getBlock: y >= yMax");
		}
		if (z >= this.zMax+1){
			System.out.println("getBlock: z >= zMax");
		}
		else
			return this.layout.get(x).get(y).get(z);
		return new Empty_Block(new Coordinates(-1,1,-1));
	}
	
	//check if block is movable, then move block
	public boolean moveBlock(Coordinates cstart, int x, int y, int z){
		if (x < 0 || x >= xMax || y < 0 || y >= yMax || z < 0 || z >= zMax){
			System.out.println("Target space is out of bounds");
		}
		else{
			Block start = this.getBlock(cstart);
			Block end = this.getBlock(new Coordinates(x,y,z));
			if (start.isEmpty()){
				System.out.println("moveBlock: start block is empty");
			}
			if  (!end.isEmpty()){
				System.out.println("moveBlock: target block is not empty");
			}
			else{
				Block temp = end.clone(cstart.x, cstart.y, cstart.z);
				start.x = x;
				start.y = y;
				start.z = z;
				this.addBlock(start);
				this.addBlock(temp);
				return true;
			}	
		}
		
		return false;
	}
	
	//Replace block at x,y,z with new block
	public void addBlock(Block block){
		this.layout.get(block.x).get(block.y).remove(block.z);
		this.layout.get(block.x).get(block.y).add(block.z, block);
	}
}
