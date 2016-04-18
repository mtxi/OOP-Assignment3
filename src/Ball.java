import processing.core.PApplet;

public class Ball
{

	PApplet par;
	
	float x, y = 0;
    float speedY = -4;
    float r = 20;
    
    public Ball(float a, float b)
    {
        x = a;
        y = b;
    }
    
    public Ball(PApplet b)
    {
    	par = b;
    }
    
    public void display()
    {
        par.noStroke();
        par.fill(3, 255, 29);
        par.ellipse(x, y, r*2, r*2);
    }
    
    public void move(float spdX)
    {
        x += spdX;
        y += speedY;
        
        if ( y + r > par.height || y - r < 0 )
        {
            speedY *= -1;
        }
    }
    
    public boolean outRight()
    {
        if ( x - r > par.width )
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