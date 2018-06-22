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

	public Field f;
	public Container c;
	public int in, cont;
	
	public Battle(Frame c){
		c = c;
		c.setFocusable(true);
		c.setVisible(true);
		Game_Controller con = new Game_Controller(this);
		c.addKeyListener(con);
		c.addMouseListener(con);
		Map map = new Map(10,10,3);
		Map_Gen.stanGen(map);
		Image i = new Image();
		i.LoadAll();
		f = new Field(map,i);
		c.add(f);
		f.repaint();
		Block player = new Player(new Coordinates(0,0,1));
		map.addBlock(player);
		map.moveBlock(player.getco(), 2,2,1);
		map.addBlock(new Ladder(new Coordinates(0,0,1)));
		map.addBlock(new Ladder(new Coordinates(7,7,1)));
		map.addBlock(new Space(new Coordinates(1,0,1)));
		map.addBlock(new Space(new Coordinates(3,1,1)));
		map.addBlock(new Space(new Coordinates(2,0,1)));
		map.addBlock(new Space(new Coordinates(3,0,1)));
		map.addBlock(new Space(new Coordinates(4,0,1)));
		map.addBlock(new Space(new Coordinates(5,0,1)));
		map.addBlock(new Space(new Coordinates(6,0,1)));
		map.addBlock(new Space(new Coordinates(7,0,1)));
		map.addBlock(new Space(new Coordinates(8,0,1)));
		map.addBlock(new Space(new Coordinates(9,0,1)));
		map.addBlock(new Door(new Coordinates(3,2,1)));
		map.addBlock(new Space(new Coordinates(4,4,1)));
		in = -1;
		cont = 0;
		while (cont != 2){
			if (in == 0){
				cont = map.moveBlock(player.getco(),player.x-1,player.y,player.z);
			}
			if (in == 1){
				cont = map.moveBlock(player.getco(),player.x+1,player.y,player.z);
			}
			if (in == 2){
				cont = map.moveBlock(player.getco(),player.x,player.y-1,player.z);
			}
			if (in == 3){
				cont = map.moveBlock(player.getco(),player.x,player.y+1,player.z);
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
