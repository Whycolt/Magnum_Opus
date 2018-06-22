
public class Block {

	protected int type;
	//type -> 0 = empty, 1 = solid, 2 = enemy, 3 = player, 4 = door. 
	
	public int x,y,z;
	public boolean walkable, climbable;
	
	public Block(Coordinates c){
		x = c.x;
		y = c.y;
		z = c.z;
		walkable = false;
		climbable = false;
	}
	
	public Coordinates getco(){
		return new  Coordinates(x, y, z);
	}
	
	public Block(int type){
		type = type;
	}
	
	public boolean isWalkable(){
		return walkable;
	}
	
	public boolean isClimbable(){
		return climbable;
	}
	
	public boolean isEmpty(){
		return type == 0;
	}
	
	public int getType(){
		return type;
	}
	
	public Block clone(int x, int y, int z){
		if (type == 0)
			return new Empty_Block(new Coordinates(x, y, z));
		if (type == 1)
			return new Space(new Coordinates(x, y, z));
		if (type == 2)
			return new Player(new Coordinates(x, y, z));
		return new Block(new Coordinates(x, y, z));
	}
}
