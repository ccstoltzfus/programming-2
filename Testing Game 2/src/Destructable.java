import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

public class Destructable extends Actor
{
    public Destructable()
    {
    	grid = null;
    	row = 0;
    	col = 0;
    	image = null;
    	File file = new File("Destructable.png");
        try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
    }
    
    public Destructable(int myRow, int myCol)
    {
    	row = myRow;
    	col = myCol;
    	image = null;
    	File file = new File("Destructable.png");
        try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
    }
    
    public void moveRight(){}
    
    public void moveLeft(){}
    
    public void moveUp(){}
    
    public void moveDown(){}
    
    public void paint(Graphics g)
    {
    	g.drawImage(image, 50 * col, 50 * row, null);
    }
}