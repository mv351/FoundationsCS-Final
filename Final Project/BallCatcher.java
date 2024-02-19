import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class BallCatcher {

   public static void main(String[] args){
      
      JFrame frame = new JFrame("Ball Catcher!");
      frame.setSize(900, 650);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BallCatcherPanel());
      frame.setVisible(true);
      
   }

}

class BallCatcherPanel extends JPanel {

   static int prevHS;
   static int currScore;
   
   private BufferedImage myImage;
   private Graphics myBuffer;

   public static final int FRAME_WIDTH = 750;
   public static final int FRAME_LENGTH = 500;
   private static final Color BACKGROUND = new Color(204, 204, 204);

   private Timer t;
   
   private int frames;

   private ArrayList<Animatable> animationObjects;

   private boolean left;
   private boolean right;

   private ArrowBowl b;
   private ArrayList<Ball> balls;
   private Random random;

   private Score score;
   
   public BallCatcherPanel() {
   
      myImage = new BufferedImage(FRAME_WIDTH, FRAME_LENGTH, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
   
      animationObjects = new ArrayList<Animatable>();
   
      b = new ArrowBowl();
      animationObjects.add(b);
   
      balls = new ArrayList<Ball>();
      random = new Random();
   
      t = new Timer(5, new AnimationListener());
      t.start();
   
      addKeyListener(new Key());
      setFocusable(true);
   
      left = false;
      right = false;
      
      score = new Score(0);
      
   }

   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }

   public void animate() {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
      for (Animatable animationObject : animationObjects) {
         animationObject.step();
         animationObject.drawMe(myBuffer);
      }
      for (int i = 0; i < balls.size(); i++) {
         Ball ball = balls.get(i);
         ball.step();
         if (ball.isTouching(b)) {
            balls.remove(i);
            i--;
            score.setScore(score.getScore()+1);
            System.out.println("Current score is: " + score.getScore());
         } else {
            ball.drawMe(myBuffer);
         }
      }
      myBuffer.setColor(Color.BLACK);
      myBuffer.setFont(new Font("Serif", Font.BOLD, 30));
      String b = ""+frames;
      myBuffer.drawString(b,35,50);
      if(frames ==  2500){
         int finalScore = score.getScore();
         t.stop();
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Serif", Font.BOLD, 30));
         String abc = "Your Final Score is: " + finalScore;
         myBuffer.drawString(abc,400,50);
         System.out.println("Final score is: " + finalScore);
         try {
            file();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      frames++;
      repaint();
   }

   public void file() throws Exception {
      Scanner infile = new Scanner( new File("HighScore.txt") ); 
      prevHS = Integer.parseInt(infile.nextLine());
      infile.close();
      currScore = score.getScore();
      PrintWriter outfile = new PrintWriter( new FileWriter("HighScore.txt") );
      if(currScore > prevHS){
         outfile.println(""+currScore);
         myBuffer.setColor(Color.BLUE);
         myBuffer.setFont(new Font("Serif", Font.BOLD, 30));
         String str = "Congrats! You beat your previous High Score of " + prevHS;
         myBuffer.drawString(str,20,250);
      } else {
         outfile.println(""+prevHS);
      }
      outfile.close();
      //System.exit(0);
   }
   
   private class AnimationListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (random.nextInt(100) < 0.05) {
            Ball newBall = new Ball(random.nextInt(FRAME_WIDTH));
            balls.add(newBall);
            animationObjects.add(newBall);
         }
         animate();
      }
   }

   private class Key extends KeyAdapter {
   
      public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_LEFT && !left) {
            b.setDX(b.getDX() - 3);
            b.step();
            left = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_RIGHT && !right) {
            b.setDX(b.getDX() + 3);
            b.step();
            right = true;
         }
      }
   
      public void keyReleased(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            b.setDX(b.getDX() + 3);
            b.step();
            left = false;
         }
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            b.setDX(b.getDX() - 3);
            b.step();
            right = false;
         }
      }
      
   }
   
}
