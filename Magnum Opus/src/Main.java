import java.util.Scanner;


public class Main {

	static Scanner input = new Scanner(System.in);  // Reading from System.in
	
	public static void main(String[] args){
		Map map = new Map(10,10,1);
		Consol_Visualize con = new Consol_Visualize(map);
		con.draw();
		Block player = new Player(new Coordinates(0,0,0));
		map.addBlock(player);
		con.draw();
		map.moveBlock(player.getco(), 4,4,0);
		con.draw();
		int in = -1;
		while (in != 4){
			in = input.nextInt();
			System.out.print(player.x);
			System.out.print(player.y);
			System.out.println(player.z);
			if (in == 0){
				map.moveBlock(player.getco(),player.x-1,player.y,player.z);
			}
			if (in == 1){
				map.moveBlock(player.getco(),player.x+1,player.y,player.z);
			}
			if (in == 2){
				map.moveBlock(player.getco(),player.x,player.y-1,player.z);
			}
			if (in == 3){
				map.moveBlock(player.getco(),player.x,player.y+1,player.z);
			}
			con.draw();	
		}
	}
	
}
