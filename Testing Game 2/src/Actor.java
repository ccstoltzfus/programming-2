import java.awt.*;
import java.util.*;
/**
 * Write a description of class Actor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Actor
{
    int direction;
    int row;
    int col;
    Grid grid;
    Image image;
    boolean alive;
    
    public Actor()
    {
        direction = 0;
        row = 0;
        col = 0;
        image = null;
        grid = null;
        alive = true;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void setDirection(int newDirection)
    {
        direction = newDirection % 360;
        if(direction < 0)
        {
            direction += 360;
        }
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public Image getImage()
    {
        return image;
    }
    
    public Grid getGrid()
    {
        return grid;
    }
    
    public boolean getAlive()
    {
    	return alive;
    }
    
    public void moveRight()
    {
        if(col < 8 && (grid.get(row, col + 1) == null) && alive)// && direction == 90) 
        {
        	grid.moveTo(this, row, col+1);
        	col++;
        	/*grid.remove(row, col);
        	col++;
        	grid.put(this);*/
        }
        //else 
        direction = 90;
    }
    
    public void moveLeft()
    {
        if(col > 0 && (grid.get(row, col - 1) == null))// && direction == 270) 
    	{
        	grid.moveTo(this, row, col-1);
        	col--;
        	/*grid.remove(row,  col);
        	col--;
        	grid.put(this);*/
    	}
        //else 
        direction = 270;
    }
    
    public void moveUp()
    {
        if(row > 0 && (grid.get(row - 1, col) == null))// && direction == 0)
        {
        	grid.moveTo(this, row-1, col);
        	row--;
        	/*grid.remove(row,  col);
        	row--;
        	grid.put(this);*/
        }
        //else 
        direction = 0;
    }
    
    public void moveDown()
    {
        if(row < 8 && (grid.get(row + 1, col) == null))// && direction == 180)
        {
        	grid.moveTo(this, row+1, col);
        	row++;
        	/*grid.remove(row, col);
        	row++;
        	grid.put(this);*/
        }
        //else 
        direction = 180;
    }
    
    public void kill()
    {
    	alive = false;
    }
    
    public void putSelfInGrid(Grid gr, int newRow, int newCol)
    {
    	if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");
        Actor actor = gr.get(newRow, newCol);
        if(actor != null) actor.removeSelfFromGrid();
    	gr.put(this, newRow, newCol);
        grid = gr;
        row = newRow;
        col = newCol;
    }
    
    public void removeSelfFromGrid()
    {
    	if (grid == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
    	grid.remove(row, col);
    }
    
    public void paint(Graphics g) {}
}