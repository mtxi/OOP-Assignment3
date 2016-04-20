import processing.core.*;

public class RightPaddle 
{

  float x;
  float y;
  float w = 20;
  float h = 120;
  int c;
  PApplet rp;

  boolean goUp = false;
  boolean goDown = false;

  boolean intersect = false;

  
  RightPaddle(PApplet r, float x_, float y_)
  {
	  rp = r;
	  c = rp.color(54,183,115);
	  x = x_;
	  y = y_;
  }
  public void display() 
  {
    rp.fill(c);
    rp.rectMode(PApplet.CENTER);
    rp.noStroke();

    rp.rect(x, y, w, h);
    y = PApplet.constrain(y, 0+h/2, rp.height-h/2);
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
