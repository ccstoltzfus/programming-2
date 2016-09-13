import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Screen 
{
	private Image image;
	private File file;
	private boolean start;
	
	public Screen(int i)
	{
		if(i == 1) file = new File("Player One Screen.png");
		if(i == 2) file = new File("Player Two Screen.png");
		if(i == 3) file = new File("menu.png");
		try
        {
        	image=ImageIO.read(file);
        }
        catch(Exception e) {e.printStackTrace();}
		start = false;
	}
	
	public void paint(Graphics g)
	{
		if(start) g.drawImage(image, 0, 0, null);
	}
	
	public void start()
	{
		start = true;
	}
	
	public void end()
	{
		start = false;
	}
	
	public boolean getStart()
	{
		return start;
	}
}
