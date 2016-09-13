import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Class Game - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class Game extends Applet implements KeyListener, Runnable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Grid grid;
    private Man man1, man2;
    private Graphics buffer;
    private Image offscreen;
    private Thread animation;
    private Screen man1DeathScreen, man2DeathScreen;
    private boolean done, going;
    
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
    	/*grid = new Grid();
        man1 = new Man();
        man1.putSelfInGrid(grid, man1.getRow(), man1.getCol());
        man2 = new Man(8, 8, man1.getGrid());
        addKeyListener(this);
        offscreen = createImage(450,450);
        buffer = offscreen.getGraphics();
        counter = 0;
        man1DeathScreen = new Screen(1);
        man2DeathScreen = new Screen(2);
        done = false;
        going = true;*/
    	startNewGame();
    	addKeyListener(this);
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void paint(Graphics g)
    {
    	if(going)
    	{
    		grid.paint(buffer);
    	}
    	else
    	{
    		man2DeathScreen.paint(buffer);
    		man1DeathScreen.paint(buffer);
    	}
    	g.drawImage(offscreen, 0, 0, this);
    }
    
    public void start()
    {
    	if(animation == null)
    	{
    		animation = new Thread(this, "ThreadDemo");
    		animation.start();
    	}
    }
    
    public void run()
    {
    	Thread myThread = Thread.currentThread();
    	while(animation == myThread)
    	{
    		repaint();
    		if(man1.getBomb() != null)
    		{
    			if(man1.getBomb().getWatch().getTime() > 2.0)
    			{
    				man1.getBomb().explode();
    			}
    			if(man1.getBomb().getWatch().getTime() > 2.5)
    			{
    				man1.killBomb();
    			}
    		}
    		if(man2.getBomb() != null)
    		{
    			if(man2.getBomb().getWatch().getTime() > 2.0)
    			{
    				man2.getBomb().explode();
    			}
    			if(man2.getBomb().getWatch().getTime() > 2.5)
    			{
    				man2.killBomb();
    			}
    		}
    		try
            {
                Thread.sleep(100);
            } catch (InterruptedException e){}
    	}
    }
    
    public void keyPressed(KeyEvent e)
    {
    	//if(going)
    	//{
    		switch(e.getKeyCode())
    		{
            	case KeyEvent.VK_LEFT: man1.moveLeft(); break;
            	case KeyEvent.VK_RIGHT: man1.moveRight(); break;
            	case KeyEvent.VK_UP: man1.moveUp(); break;
            	case KeyEvent.VK_DOWN: man1.moveDown(); break;
            	case KeyEvent.VK_SPACE: man1.dropBomb(); break;
            	case 65: man2.moveLeft(); break;
            	case 68: man2.moveRight(); break;
            	case 87: man2.moveUp(); break;
            	case 83: man2.moveDown(); break;
            	case 81: man2.dropBomb(); break;
            	case 27: System.exit(0);
            	case 85: startNewGame();
        	}
    	//}
        repaint();
    }
    
    public void keyReleased(KeyEvent e){}
    
    public void keyTyped(KeyEvent e){}
    
    public void update(Graphics g)
    {
    	paint(g);
    	if(man2.getAlive() == false) 
    	{
    		done = true;
    		going = false;
    		man2DeathScreen.start();
    	}
    	else if(man1.getAlive() == false)
    	{
    		done = true;
    		going = false;
    		man1DeathScreen.start();
    	}
    }
    
    public void startNewGame()
	{
		grid = new Grid();
        man1 = new Man();
        man1.putSelfInGrid(grid, 0, 0);
        man2 = new Man(8, 8, man1.getGrid());
        //addKeyListener(this);
        offscreen = createImage(450,450);
        buffer = offscreen.getGraphics();
        man1DeathScreen = new Screen(2);
        man2DeathScreen = new Screen(1);
        done = false;
        going = true;
	}
}