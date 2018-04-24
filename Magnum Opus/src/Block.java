
public class Block {

	protected int type;
	//type -> 0 = empty, 1 = solid, 2 = enemy, 3 = player, 4 = door. 
	
	public int x,y,z;
	
	public Block(Coordinates c){
		this.x = c.x;
		this.y = c.y;
		this.z = c.z;
	}
	
	public Coordinates getco(){
		return new  Coordinates(this.x, this.y, this.z);
	}
	
	public Block(int type){
		this.type = type;
	}
	
	public boolean isEmpty(){
		return this.type == 0;
	}
	
	public int getType(){
		return this.type;
	}
	
	public Block clone(int x, int y, int z){
		if (this.type == 0)
			return new Empty_Block(new Coordinates(x, y, z));
		if (this.type == 3)
			return new Player(new Coordinates(x, y, z));
		return new Block(new Coordinates(x, y, z));
	}
	
	public String toString(){
		return(" ");
	}
		
}
