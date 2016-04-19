// OOP Assignment #3
// DT228/2 >> 2015-2016
// Program based on the classic game of PONG / PingPong in real life
import processing.core.*;

public class PingPong extends PApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2417473051777472017L;
	
	// declare constructors
	Ball ball;
	LeftPaddle lPaddle;
	RightPaddle rPaddle;
	MidLine mLine;
	
	// declare variables
	float speedX = -4;
	
	int scoreP1 = 0;
	int scoreP2 = 0;
	
	boolean p1Win = false;
	boolean p2Win = false;
	
	boolean click = false;
	
	public void setup()
	{
	    size(displayWidth,displayHeight);
	    smooth();
	    frameRate(30);
	    
	    ball = new Ball(this, 400, 250);
	    lPaddle = new LeftPaddle(this, 60, height/2);
	    rPaddle = new RightPaddle(this, width - 50, height/2);
	    mLine = new MidLine(this);
	    
	}
	
	public void draw()
	{
	    if (click)
	    {
	        if (p1Win)
	        {
	            textAlign(CENTER);
	            fill(255);
	            textSize(50);
	            text("Player 1 wins!", width/2, height/2);
	            textSize(25);
	            text("press 'R' to restart", width/2, height/2 + 40);
	            
	            if (keyPressed)
	            {
	                if (key == 'r')
	                {
	                    p1Win = false;
	                    scoreP1 = 0;
	                    scoreP2 = 0;
	                }
	            }
	        }
	        else if (p2Win)
	        {
	            textAlign(CENTER);
	            fill(255);
	            textSize(50);
	            text("Player 2 wins!",width/2, height/2);
	            textSize(25);
	            text("press 'R' to restart", width/2, height/2 + 40);
	            textSize(25);
	             
	            if (keyPressed)
	            {
	                if (key == 'r')
	                {
	                    p2Win = false;
	                    scoreP1 = 0;
	                    scoreP2 = 0;
	                }
	            }
	        }
	        
	        else
	        {
	            background(0);
	            
	            mLine.display();
	            
	            ball.display();
	            ball.move(speedX);
	            
	            lPaddle.display();
	            rPaddle.display();
	            lPaddle.move(false, false);
	            rPaddle.move(false, false);
	            
	            if (lPaddle.intersect(ball))
	            {
	               speedX = (float) (speedX * -1.15);
	               ball.x = lPaddle.x + lPaddle.w + ball.r;
	               lPaddle.c = color(255, 0, 0);
	            }
	            
	            if (rPaddle.intersect(ball))
	            {
	                speedX = (float) (speedX * -1.15);
	                ball.x = rPaddle.x - rPaddle.w - ball.r;
	                rPaddle.c = color(255, 0, 0);
	            }
	            else
	            {
	               rPaddle.c = color(255); 
	            }
	            
	            if (ball.outRight())
	            {
	                ball.x = width/2;
	                speedX = random(-4, -3);
	                scoreP1++;
	            }
	            
	            if (ball.outLeft())
	            {
	                ball.x = width/2;
	                speedX = random(3,4);
	                scoreP2++;
	            }
	            
	            textAlign(CENTER);
	            textSize(20);
	            fill(255);
	            text("Player One: " + scoreP1, 200, 50);
	            text("Player Two: " + scoreP2, 600, 50);
	            
	            if (scoreP1 == 5)
	            {
	                p1Win = true;
	            }
	            else
	            {
	                p1Win = false;
	            }
	            if (scoreP2 == 5)
	            {
	                p2Win = true;
	            }
	            else
	            {
	                p2Win = false;
	            }
	        }
	    }
	    
	    else
	    {
	        background(0);
	        
	        fill(255);
	        textSize(160);
	        text("P     N G", width/2 + 50, height/2);
	        textSize(30);
	        text("Click to begin!", width/2 - 100, height/2+100);
	        fill(3, 255, 29);
	        textSize(180);
	        fill(255, 0, 0);
	        ellipse(width/2 + 270, height/2 - 55, 55*2, 55*2);
	        textSize(160);
	        text("P  !  N G", width/2 - 670, height/2);
	        fill(255);
	        textAlign(LEFT);
	        textSize(15);
	        text("Player 1: up = 'W', down = 'S'", 40, height - 70);
	        text("Player 2: up = 'UP arrow', down = 'DOWN arrow'", 40, height - 50);
	        text("Score 5 points to win! :)",width*1/2, height);
	    }
	}
	
	public void mousePressed()
	{
	    click = true;
	}
	
	// main function, --present activate full screen
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "PingPong" });
	  }
	
}