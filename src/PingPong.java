
import processing.core.PApplet;

public class PingPong extends PApplet
{
	Ball ball;
	LeftPaddle lPaddle;
	RightPaddle rPaddle;
	MidLine mLine;
	float speedX = -4;
	
	int scoreP1 = 0;
	int scoreP2 = 0;
	
	boolean p1Win = false;
	boolean p2Win = false;
	
	boolean click = false;

	public void setup()
	{
		size(800,500);
		smooth();
		frameRate(30);
		
		ball = new Ball(400,250);
		lPaddle = new LeftPaddle(60, height/2);
		rPaddle = new RightPaddle(740, height/2);
		mLine = new MidLine();
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
	            text("Player 2 wins!", width/2, height/2);
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
	               speedX = speedX * -1.15;
	               ball.x = lPaddle.x + lPaddle.w + ball.r;
	               lPaddle.c = color(255, 0, 0);
	            }
	            
	            if (rPaddle.intersect(ball))
	            {
	                speedX = speed * -1.15;
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
	        textAlign(CENTER);
	        fill(255);
	        textSize(160);
	        text("P     N G", width/2, height/2);
	        textSize(2);
	        text("Click to begin!", width/2, height/2+80);
	        fill(3, 255, 29);
	        textSize(180);
	        text("0", width/4 + 102, height/2 + 5);
	        fill(255);
	        textAlign(LEFT);
	        textSize(15);
	        text("Player 1: up = 'W', down = 'S'", 40, height*0.87);
	        text("Player 2: up = 'UP arrow', down = 'DOWN arrow'", 40, height*0.92);
	        text("Score 5 points to win! :)",width*0.74, height*.92);
	    }
	}
	
	public void mousePressed()
	{
		click = true;
	}


	public static void main(String args[]) 
	{
	    String[] a = {"MAIN"};
	    PApplet.runSketch(a, new PingPong());
	    
	}

}
