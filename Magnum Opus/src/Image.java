import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Image {
  
	public ArrayList<BufferedImage> num;
	public BufferedImage l;
	
	public Image(){

	}
	
	public void LoadAll(){
		num = new ArrayList<BufferedImage>();
		String filePath = new File("").getAbsolutePath() + "/src/";
		try{
			num.add(ImageIO.read(new File(filePath +"empty2.png")));
			num.add(ImageIO.read(new File(filePath +"block.png")));
			num.add(ImageIO.read(new File(filePath +"player.png")));
			num.add(ImageIO.read(new File(filePath +"ladder.png")));
			num.add(ImageIO.read(new File(filePath +"Door.png")));
		} catch(Exception e){
			System.out.print(e);
		}
	}
	
}
