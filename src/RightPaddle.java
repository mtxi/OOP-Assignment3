import processing.core.PApplet;

public class RightPaddle
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
	  
	  public RightPaddle(PApplet r)
	  {
		  rp = r;
	  }
	  
	  public RightPaddle(float x_, float y_) 
	  {
	    x = x_;
	    y = y_;
	  }

	  public void display() 
	  {
	    rp.fill(c);
	    rp.rectMode(PApplet.CENTER);
	    rp.noStroke();

	    rp.rect(x, y, w, h);
	    float high = (rp.height-h)/2;
	    y = PApplet.constrain(y, 0+h/2, high);
	  }

	  public void move(boolean up_, boolean down_) 
	  {
	    goUp = up_;
	    goDown = down_;

	    if (rp.keyPressed) 
	    {
	      if (rp.key == PApplet.CODED) 
	      {
	        if (rp.keyCode == PApplet.UP) 
	        {
	          goUp = true;
	        }
	      }
	    }

	    if (goUp) 
	    {
	      y = y - 10;
	    }


	    if (rp.keyPressed) 
	    {
	      if (rp.key == PApplet.CODED) 
	      {
	        if (rp.keyCode == PApplet.DOWN) 
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

	  public boolean intersect(Ball b) 
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
