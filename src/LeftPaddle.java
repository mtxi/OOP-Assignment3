import processing.core.PApplet;

public class LeftPaddle
{
	PApplet lp;
	float x;
	  float y;
	  float w = 20;
	  float h = 100;
	  int c = lp.color(255);

	  boolean goUp = false;
	  boolean goDown = false;

	  boolean intersect = false;
	  
	  LeftPaddle(PApplet p)
	  {
		  lp = p;
	  }
	  
	  LeftPaddle(float x_, float y_) 
	  {
	    x = x_;
	    y = y_;
	  }

	  void display() 
	  {
	    lp.fill(c);
	    lp.rectMode(PApplet.CENTER);
	    lp.noStroke();

	    lp.rect(x, y, w, h);
	    y = PApplet.constrain(y, 0+h/2, lp.height-h/2);
	  }

	  void move(boolean up_, boolean down_) 
	  {
	    goUp = up_;
	    goDown = down_;

	    if (lp.keyPressed) 
	    {
	      if (lp.key == 'w' || lp.key == 'W') 
	      {
	        goUp = true;
	      }
	    }

	    if (goUp) 
	    {
	      y = y - 10;
	    }

	    if (lp.keyPressed) 
	    {
	      if (lp.key == 's' || lp.key == 'S') 
	      {
	        goDown = true;
	      }
	    }

	    if (goDown) 
	    {
	      y = y + 10;
	    }
	  }

	  boolean intersect(Ball b)
	  {
	    if (PApplet.dist(x+w/2, b.y, b.x, b.y) < b.r && b.y > y-h/2 && b.y < y+h/2) 
	    {
	      return true;
	    }
	    else 
	    {
	      return false;
	    }
	  }
	
}
