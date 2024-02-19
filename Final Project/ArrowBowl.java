import java.awt.*;

public class ArrowBowl extends Rectangle implements Animatable {

   private int dX;
   private int dY;
      
   public ArrowBowl() {
      super(100, 50, 250, 475, Color.WHITE);
      dX = 0;
      dY = 0;
   }
   
   public ArrowBowl(int widthValue, int heightValue, int xValue, int yValue, Color cValue) {
      super(widthValue, heightValue, xValue, yValue, cValue);
      dX = 0;
      dY = 0;
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
   
   public void step() {
      setX(getX() + dX);
   }
   
}