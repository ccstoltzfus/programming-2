import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int counter;
    private boolean willExplode;
    private Image image2;
    private boolean man1s;
    private StopWatch watch;
    private boolean isAlive;
    private boolean hasExploded;
    
    public Bomb()
    {
        counter = 0;
        grid = null;
        image = null;
        image2 = null;
        willExplode = false;
        isAlive = true;
        hasExploded = false;
        watch = new StopWatch();
        File file = new File("bomb.jpg");
        try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
    }
    
    public Bomb(Grid myGrid)
    {
    	counter = 0;
        row = 0;
        col = 0;
        grid = myGrid;
        image = null;
        image2 = null;
        willExplode = false;
        isAlive = true;
        hasExploded = false;
        watch = new StopWatch();
        File file = new File("bomb.jpg");
        try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
    }
    
    public Bomb(int newRow, int newCol, Grid myGrid, boolean isMan1)
    {
    	row = newRow;
    	col = newCol;
    	counter = 0;
    	man1s = isMan1;
    	image = null;
    	willExplode = false;
    	isAlive = true;
        hasExploded = false;
    	watch = new StopWatch();
        File file = new File("bomb.png");
        try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
        putSelfInGrid(myGrid, row, col);
    }
    
    public void increase()
    {
        counter++;
    }
    
    public boolean getIsMan1s()
    {
    	return man1s;
    }
    
    public StopWatch getWatch()
    {
    	return watch;
    }
    
    public void explode()
    {
        willExplode = true;
        //isAlive = false;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public void paint(Graphics g)
    {
    	if(isAlive) g.drawImage(image, 50 * col, 50 * row, null);
    	if(willExplode)
    	{
    		File file;
    		boolean explosionTall = false;
    		boolean explosionWide = false;
    		boolean explosion = false;
    		if(getGrid().get(row, col-1) instanceof Rock || getGrid().get(row, col+1) instanceof Rock) explosionTall = true;
    		else if(getGrid().get(row-1, col) instanceof Rock || getGrid().get(row+1, col) instanceof Rock) explosionWide = true;
    		else explosion = true;
    		
    		if(explosionTall) file = new File("ExplosionTall.png");
    		else if(explosionWide) file = new File("ExplosionWide.png");
    		else file = new File("Explosion.png");
    		
        	try
            {
            	image2 = ImageIO.read(file);
            }
            catch(Exception e) {e.printStackTrace();}
    		g.drawImage(image2, 50 * col - 98, 50 * row - 100, null);
    		
    		if(hasExploded == false && willExplode)
    		{
    			if(explosionTall && row > 0) getGrid().remove(row-1, col);
    			if(explosionTall && row > 1) getGrid().remove(row-2, col);
    			if(explosionTall && row < 8) getGrid().remove(row+1, col);
    			if(explosionTall && row < 7) getGrid().remove(row+2, col);
    			if(explosionWide && col > 0) getGrid().remove(row, col-1);
    			if(explosionWide && col > 1) getGrid().remove(row, col-2);
    			if(explosionWide && col < 8) getGrid().remove(row, col+1);
    			if(explosionWide && col < 7) getGrid().remove(row, col+2);
    			
    			if(explosion && row > 0) getGrid().remove(row-1, col);
    			if(explosion && row > 1) getGrid().remove(row-2, col);
    			if(explosion && row < 8) getGrid().remove(row+1, col);
    			if(explosion && row < 7) getGrid().remove(row+2, col);
    			if(explosion && col > 0) getGrid().remove(row, col-1);
    			if(explosion && col > 1) getGrid().remove(row, col-2);
    			if(explosion && col < 8) getGrid().remove(row, col+1);
    			if(explosion && col < 7) getGrid().remove(row, col+2);
    			
    			hasExploded = true;
    		}
    	}
    }
}