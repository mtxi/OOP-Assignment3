import processing.core.PApplet;

public class RightPaddle extends PApplet
{
	PApplet rp;
	float x;
	  float y;
	  float w = 20;
	  float h = 100;
	  int c = rp.color(255);

	  boolean goUp = false;
	  boolean goDown = false;

	  boolean intersect = false;

	  RightPaddle(float x_, float y_) 
	  {
	    x = x_;
	    y = y_;
	  }

	  void display() 
	  {
	    rp.fill(c);
	    rp.rectMode(CENTER);
	    rp.noStroke();

	    rp.rect(x, y, w, h);
	    float high = (rp.height-h)/2;
	    y = PApplet.constrain(y, 0+h/2, high);
	  }

	  void move(boolean up_, boolean down_) 
	  {
	    goUp = up_;
	    goDown = down_;

	    if (keyPressed) 
	    {
	      if (key == CODED) 
	      {
	        if (keyCode == UP) 
	        {
	          goUp = true;
	        }
	      }
	    }

	    if (goUp) 
	    {
	      y = y - 10;
	    }


	    if (keyPressed) 
	    {
	      if (key == CODED) 
	      {
	        if (keyCode == DOWN) 
	        {
	          goDown = true;
	        }
	      }
	    }

	    if (goDown) 
	    {
	      y = y + 10;
	    }
	  }

	  boolean intersect(Ball b) 
	  {
	    if (PApplet.dist(x-w/2, b.y, b.x, b.y) < b.r && b.y > y-h/2 && b.y < y+h/2) 
	    {
	      return true;
	    }
	    else 
	    {
	      return false;
	    }
	  }
}
