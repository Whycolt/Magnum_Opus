import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game_Controller implements KeyListener, ActionListener, MouseListener{

	public Battle model;
	public int playerMove,dsx,dsy;
	
	public Game_Controller(Battle b){
		model = b;
		playerMove = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_W){
			model.in = 0;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_S){
			model.in = 1;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_A){
			model.in = 2;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_D){
			model.in = 3;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			model.in = 4;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			model.in = 5;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP){
			model.in = 6;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
			model.in = 7;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0){
		System.out.println("drag");
		model.f.viewX = dsx + (dsx - arg0.getX());
		dsx = arg0.getX();
		model.f.viewY = dsy + (dsy - arg0.getY());
		dsy = arg0.getY();
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("click");
		dsx = arg0.getX();
		dsy = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
