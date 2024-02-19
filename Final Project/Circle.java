import javax.swing.*;
import java.awt.*;

public class Circle {

   private int r;
   private int x; 
   private int y; 
   private Color c;
   
   public Circle() {
      r = 10;
      x = 200;
      y = 20;
      c = Color.BLACK;
   }
   
   public Circle(int rValue, int xValue, int yValue, Color cValue) {
      r = rValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accesors
   public int getRadius() {
      return r;
   }
   public int getX() {
      return x;
   }
   public int getY() {
      return y;
   }
   public Color getColor() {
      return c;
   }
   
   //modifers
   public void setRadius(int rValue) {
      r = rValue;
   }
   public void setX(int xValue) {
      x = xValue;
   }
   public void setY(int yValue) {
      y = yValue;
   }
   public void setColor(Color cValue) {
      c = cValue;
   }
   
   public void drawMe(Graphics g) {
      g.setColor(c);
      g.fillOval(x-r, y-r, r*2, r*2);
   }
   
   public String toString() {
      return "Circle at " + x + ", " + y + " with radius " + r + " and color set to " + c;
   }
}