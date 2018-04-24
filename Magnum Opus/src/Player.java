
public class Player extends Block{

	public Player(Coordinates c){
		super(c);
		this.type = 3;
	}
	
	public String toString(){
		return "O";
	}
}
