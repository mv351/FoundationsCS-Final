import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Score implements Animatable {
   
   int score;
   int x;
   
   public Score(int score){
      this.score=score;
      x=250;
   }
   
   public void setScore(int score){
      this.score=score;
   }
   public int getScore(){
      return score;
   }
   
   public void step(){
      //do nothing
   }
   
   public void drawMe(Graphics g){
      g.setFont(new Font("Serif", Font.BOLD, 30));
      g.setColor(Color.WHITE);
      g.drawString(Integer.toString(score), x, 40);
   }

}