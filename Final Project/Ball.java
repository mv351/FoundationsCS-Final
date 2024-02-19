import javax.swing.*;
import java.awt.*;

public class Ball extends Circle implements Animatable {

   private int dX;
   private int dY;
   
   public Ball() {
      super(10,200,0,Color.BLACK);
      dX=0;
      dY=1;
   }
   
   public Ball(int xValue) {
      super(10,xValue,0,Color.BLACK);
      dX=0;
      dY=1;
   }
   
   public int getDX() {
      return dX;
   }
   public int getDY() {
      return dY;
   }
   
   public void setDX(int dXValue) {
      dX = dXValue;
   }
   public void setDY(int dYValue) {
      dY = dYValue;
   }
   
   public boolean isTouching(ArrowBowl ab) {
      int bowlX = ab.getX();
      int bowlY = ab.getY();
      int bowlWidth = ab.getWidth();
      int bowlHeight = ab.getHeight();
      int ballX = getX();
      int ballY = getY();
      if (ballY + getRadius() >= bowlY && ballY - getRadius() <= bowlY + bowlHeight) {
         if (ballX + getRadius() >= bowlX && ballX - getRadius() <= bowlX + bowlWidth) {
            return true;
         }
      }
      return false;
   }
   
   public void step() {
      if (getY() >= 500 || getY() <= -10000000) {
         setY(-10000000);
      } else {
         setY(getY() + dY);
      }
   } 
   
}