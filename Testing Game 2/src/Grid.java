import java.awt.*;
/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid
{
    private int rows;
    private int cols;
    private int count;
    private Actor[][] actors;
    
    /**
     * Constructor for objects of class Grid
     */
    public Grid()
    {
        rows = 9;
        cols = 9;
        count = 0;
        actors = new Actor[rows][cols];
        for(int c = 1; c < rows; c += 2)
        {
        	for(int r = 1; r < cols; r += 2)
        	{
        		actors[r][c] = new Rock(r, c);
        	}
        }
        for(int c = 0; c < rows; c ++)
        {
        	for(int r = 0; r < cols; r ++)
        	{
        		if(Math.random()*100 < 75 && !(actors[r][c] instanceof Actor)) actors[r][c] = new Destructable(r, c);
        		actors[0][0] = null;
        		actors[1][0] = null;
        		actors[2][0] = null;
        		actors[0][1] = null;
        		actors[0][2] = null;
        		actors[8][8] = null;
        		actors[7][8] = null;
        		actors[6][8] = null;
        		actors[8][7] = null;
        		actors[8][6] = null;
        	}
        }
    }
    
    public Grid(int numRows, int numCols)
    {
    	rows = numRows;
    	cols = numCols;
    	count = 0;
    	actors = new Actor[rows][cols];
    }
    
    public void paint(Graphics g)
    {
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                if(count % 2 == 0)
                {
                    g.setColor(Color.CYAN);
                }
                else g.setColor(Color.BLUE);
                g.fillRect(r*50, c*50, 50, 50);
                count++;
            }
        }
        for(int r = 0; r < rows; r++)
        {
        	for(int c = 0; c < cols; c++)
            {
                if(actors[r][c] != null && actors[r][c].getAlive()) actors[r][c].paint(g);
            }
        }
        for(int r = 0; r < rows; r++)
        {
        	for(int c = 0; c < cols; c++)
            {
                if(actors[r][c] instanceof Rock) actors[r][c].paint(g);
            }
        }
        count = 0;
    }
    
    public int getNumRows()
    {
        return rows;
    }
    
    public int getNumCols()
    {
        return cols;
    }
    
    public void put(Actor actor, int row, int col)
    {
    	if(actors[row][col] == null) actors[row][col] = actor;
    }
    
    public void put(Actor actor)
    {
    	put(actor, actor.getRow(), actor.getCol());
    }
    
    public void moveTo(Actor actor, int newRow, int newCol)
    {
    	actors[actor.getRow()][actor.getCol()] = null;
    	actors[newRow][newCol] = actor;
    }
    
    public void remove(int row, int col)
    {
    	if(actors[row][col] != null) actors[row][col].kill();
    	actors[row][col] = null;
    }
    
    public Actor get(int row, int col)
    {
    	if(col < 0 || col > cols-1 || row < 0 || row > rows-1) return null;
    	return actors[row][col];
    }
}
