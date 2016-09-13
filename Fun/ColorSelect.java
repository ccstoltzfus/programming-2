import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
public class ColorSelect extends Applet
{  public void init()
   {  String input;
      // ask the user for red, green, blue values
   
      input = JOptionPane.showInputDialog("red:");
      red = Float.parseFloat(input);
      
      input = JOptionPane.showInputDialog("green:");
      green = Float.parseFloat(input);
      
      input = JOptionPane.showInputDialog("blue:");
      blue = Float.parseFloat(input);     
   }
   
   public void paint(Graphics g)
   {  final int SQUARE_LENGTH = 100;
   
      Graphics2D g2 = (Graphics2D)g;
      // select color into graphics context
   
      Color fillColor = new Color(red, green, blue);
      g2.setColor(fillColor);
      
      // construct and fill a square whose center is
      // the center of the window
      
      Rectangle square = new Rectangle(
         (getWidth() - SQUARE_LENGTH) / 2,
         (getHeight() - SQUARE_LENGTH) / 2,
         SQUARE_LENGTH,
         SQUARE_LENGTH);
         
      g2.fill(square);
   }
   
   private float red;
   private float green;
   private float blue;
}