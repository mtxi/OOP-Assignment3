import processing.core.*;

public class LeftPaddle
{

  float x;
  float y;
  float w;
  float h;
  int c;
  PApplet lp;

  boolean goUp = false;
  boolean goDown = false;

  boolean intersect = false;

  
  LeftPaddle(PApplet l, float x_, float y_)
  {
	  lp = l;
	  w = 20;
	  h = 100;
	  c = lp.color(255);
	  x = x_;
	  y = y_;
  }

  public void display() 
  {
    lp.fill(c);
    lp.rectMode(PApplet.CENTER);
    lp.noStroke();

    lp.rect(x, y, w, h);
    y = PApplet.constrain(y, 0+h/2, lp.height-h/2);
  }

  public void move(boolean up_, boolean down_) 
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

  public boolean intersect(Ball b)
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
