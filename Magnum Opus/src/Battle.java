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
	
	public Battle(Frame c){
		this.c = c;
		c.setVisible(true);
		Map map = new Map(20,20,1);
		Image i = new Image();
		i.LoadAll();
		f = new Field(map,i);
		c.add(f);
		f.repaint();
		input.nextLine();
		Block player = new Player(new Coordinates(0,0,0));
		map.addBlock(player);
		map.moveBlock(player.getco(), 4,4,0);
		int in = -1;
		while (in != 8){
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
			f.repaint();
		}
	}
	
}
