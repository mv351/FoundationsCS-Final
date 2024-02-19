import javax.swing.*;
import java.awt.*;

public class Rectangle {
   
   private int width;
   private int height;
   private int x;
   private int y;
   private Color c;
   
   
   public Rectangle()
   {
      width = 20;
      height = 40;
      x = 10;
      y = 10;
      c = Color.BLACK;
   }
   
   public Rectangle(int widthValue, int heightValue, int xValue, int yValue, Color cValue)
   {
      width = widthValue;
      height = heightValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accessors
   public int getWidth()
   {
      return width;
   }
   public int getHeight()
   {
      return height;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Color getColor()
   {
      return c;
   }
   
   //modifiers
   public void setWidth(int widthValue)
   {
      width = widthValue;
   }
   public void setHeight(int heightValue)
   {
      height = heightValue;
   }
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setColor(Color cValue)
   {
      c = cValue;
   }
   
   public void drawMe(Graphics g)
   {
      g.setColor(c);
      g.fillRect(x, y, width, height);
   }
   
   public String toString()
   {
      return "Rectangle at " + x + ", " + y + " with width length " + width + " and height length of " + height + " and color set to " + c;
   }
}