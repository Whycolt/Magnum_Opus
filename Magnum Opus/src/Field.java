import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.color.*;

public class Field extends JPanel{
	
	public Image item;
	public Map map;
	public int viewX, viewY, viewZ, blockType;;
	
	public Field(Map m, Image i){
		setLayout(null);
		setSize(1100, 700);
		setBackground(Color.WHITE);
		map = m;
		item = i;
		viewX = 500;
		viewY = -150;
		viewZ = 0;
		this.repaint();
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		for (int z = 0; z<map.getZ(); z++){
			for (int x = 0; x < map.getX()+map.getY(); x++){
				for (int y = 0; y <= x; y++){
					if (x-y < map.getX() && y < map.getY()){
						blockType = map.getBlock(x-y,y,z).getType();
						if(blockType != 0){
						g.drawImage(item.num.get(blockType), viewX+124*y-124*(x-y), viewY+61*x-100*z, null);
						}
					}
				}
			}
		}	
	}
	
}
