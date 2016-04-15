
public class LeftPaddle 
{
	float x;
	  float y;
	  float w = 20;
	  float h = 100;
	  color c = color(255);

	  boolean goUp = false;
	  boolean goDown = false;

	  boolean intersect = false;

	  LeftPaddle(float x_, float y_) 
	  {
	    x = x_;
	    y = y_;
	  }

	  void display() 
	  {
	    fill(c);
	    rectMode(CENTER);
	    noStroke();

	    rect(x, y, w, h);
	    y = constrain(y, 0+h/2, height-h/2);
	  }

	  void move(boolean up_, boolean down_) 
	  {
	    goUp = up_;
	    goDown = down_;

	    if (keyPressed) 
	    {
	      if (key == 'w' || key == 'W') 
	      {
	        goUp = true;
	      }
	    }

	    if (goUp) 
	    {
	      y = y - 10;
	    }

	    if (keyPressed) 
	    {
	      if (key == 's' || key == 'S') 
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
	    if (dist(x+w/2, b.y, b.x, b.y) < b.r && b.y > y-h/2 && b.y < y+h/2) 
	    {
	      return true;
	    }
	    else 
	    {
	      return false;
	    }
	  }
	
}
