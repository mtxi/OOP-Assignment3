import processing.core.PApplet;

public class Ball
{
    float x, y;
    float r;
    float speedY;
    PApplet ball;
    
    Ball(PApplet ba, float a, float b)
    {
    	ball = ba;
    	speedY = ball.random(-3,-1);
    	x = a;
        y = b;
        r = 20;
    }
    
    public void display()
    {
        ball.noStroke();
        ball.fill(3, 255, 29);
        ball.ellipse(x, y, r*2, r*2);
    }
    
    public void move(float spdX)
    {
        x += spdX;
        y += speedY;
        
        if ( y + r > ball.height || y - r < 0 )
        {
            speedY *= -1.5;
        }
    }
    
    public boolean outRight()
    {
        if ( x - r > ball.width )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean outLeft()
    {
        if (x + r < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}