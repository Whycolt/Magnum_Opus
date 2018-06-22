
public class Ladder extends Block{

	public Ladder(Coordinates c){
		super(c);
		type = 3;
		walkable = true;
		climbable = true;
	}
}
