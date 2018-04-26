import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Battle{

	static Scanner input = new Scanner(System.in);  // Reading from System.in
	
	public Field f;
	public Container c;
	public int in;
	
	public Battle(Frame c){
		this.c = c;
		c.setFocusable(true);
		c.setVisible(true);
		Game_Controller con = new Game_Controller(this);
		c.addKeyListener(con);
		Map map = new Map(5,5,2);
		Map_Gen.stanGen(map);
		Image i = new Image();
		i.LoadAll();
		f = new Field(map,i);
		c.add(f);
		f.repaint();
		Block player = new Player(new Coordinates(0,0,1));
		map.addBlock(player);
		map.moveBlock(player.getco(), 4,4,1);
		this.in = -1;
		while (in != 8){
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
			if (in == 4){
				f.viewX += 100;
			}
			if (in == 5){
				f.viewX += -100;;
			}
			if (in == 6){
				f.viewY += 100;;
			}
			if (in == 7){
				f.viewY += -100;;
			}	
			in = -1;
			f.repaint();
		}
	}
	
}
