
public class Block {

	protected int type;
	//type -> 0 = empty, 1 = solid, 2 = enemy, 3 = player, 4 = door. 
	
	public Block(){
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
	
	public Block clone(){
		if (this.type == 0)
			return new Empty_Block();
		if (this.type == 3)
			return new Player();
		return new Block();
	}
	
	public String toString(){
		return(" ");
	}
		
}
