import processing.core.PApplet;

public class Ball
{

	PApplet par;
	
	float x, y;
    float speedY = par.random(-4, -2);
    float r = 20;
    
    Ball(float a, float b)
    {
        this.x = a;
        this.y = b;
    }
    
    Ball(PApplet b)
    {
    	par = b;
    }
    
    void display()
    {
        par.noStroke();
        par.fill(3, 255, 29);
        par.ellipse(x, y, r*2, r*2);
    }
    
    void move(float spdX)
    {
        x += spdX;
        y += speedY;
        
        if ( y + r > par.height || y - r < 0 )
        {
            speedY *= -1;
        }
    }
    
    boolean outRight()
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
    
    boolean outLeft()
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
