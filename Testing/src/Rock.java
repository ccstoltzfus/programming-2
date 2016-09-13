import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
	//Uses the "col" and "row" from the Actor class
    public Rock(int newRow, int newCol)
    {
        row = newRow;
        col = newCol;
        image = null;
        File file;
    	file = new File("Rock.png");
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