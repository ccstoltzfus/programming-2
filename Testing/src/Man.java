import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Actor
{
    private Bomb bomb;
    private boolean isMan1, bombReady;//, alive;
    
    //Uses the "col" and "row" from the Actor class
    public Man()
    {
        col = 0;
        row = 0;
        direction = 90;
        image = null;
        isMan1 = true;
        bombReady = true;
        alive = true;
    }
    
    public Man(int newRow, int newCol, Grid myGrid)
    {
    	row = newRow;
    	col = newCol;
    	direction = 270;
    	image = null;
    	isMan1 = false;
    	putSelfInGrid(myGrid, row, col);
    	bombReady = true;
    	alive = true;
    }
    
    public Bomb getBomb()
    {
    	return bomb;
    }
    
    public void killBomb()
    {
    	bomb.removeSelfFromGrid();
    	bomb = null;
    }
    
    public boolean getIsMan1()
    {
    	return isMan1;
    }
    
    public void dropBomb()
    {
    		if(getBomb() == null)
    		{
    			if(direction == 0 && row > 0 && !(getGrid().get(row-1, col) instanceof Actor) && isMan1 == true) bomb = new Bomb(row-1, col, grid, true);
    			if(direction == 90 && col < 8 && !(getGrid().get(row, col+1) instanceof Actor) && isMan1 == true) bomb = new Bomb(row, col + 1, grid, true);
    			if(direction == 180 && row < 8 && !(getGrid().get(row+1, col) instanceof Actor) && isMan1 == true) bomb = new Bomb(row + 1, col, grid, true);
    			if(direction == 270 && col > 0 && !(getGrid().get(row, col-1) instanceof Actor) && isMan1 == true) bomb = new Bomb(row, col - 1, grid, true);
    			if(direction == 0 && row > 0 && !(getGrid().get(row-1, col) instanceof Actor) && isMan1 == false) bomb = new Bomb(row-1, col, grid, false);
    			if(direction == 90 && col < 8 && !(getGrid().get(row, col+1) instanceof Actor) && isMan1 == false) bomb = new Bomb(row, col + 1, grid, false);
    			if(direction == 180 && row < 8 && !(getGrid().get(row+1, col) instanceof Actor) && isMan1 == false) bomb = new Bomb(row + 1, col, grid, false);
    			if(direction == 270 && col > 0 && !(getGrid().get(row, col-1) instanceof Actor) && isMan1 == false) bomb = new Bomb(row, col - 1, grid, false);
    		}
			if(bomb != null) bomb.getWatch().start();
    }
    
    public void paint(Graphics g)
    {
    	if(alive)
    	{
    		File file;
    		if(direction == 0 && isMan1 == true) file = new File("Man1-b.png");
    		else if(direction == 90 && isMan1 == true) file = new File("Man1-r.png");
    		else if(direction == 180 && isMan1 == true) file = new File("Man1-f.png");
    		else if(direction == 270 && isMan1 == true) file = new File("Man1-l.png");
    		else if(direction == 0 && isMan1 == false) file = new File("Man2-b.png");
    		else if(direction == 90 && isMan1 == false) file = new File("Man2-r.png");
    		else if(direction == 180 && isMan1 == false) file = new File("Man2-f.png");
    		else if(direction == 270 && isMan1 == false) file = new File("Man2-l.png");
    		else file = null;
    		try
    		{
    			image=ImageIO.read(file);
    		}
    		catch(Exception e) {e.printStackTrace();}
    		g.drawImage(image, 6 + 50 * col, 2 + 50 * row, null);
    	}
    }
}