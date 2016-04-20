import processing.core.*;

public class MidLine
{
	int i;
	PApplet ml;
	
    MidLine()
    {
      
    }
    
    MidLine(PApplet m)
    {
    	ml = m;
    }
    
    public void display()
    {
        for (i = 0; i < ml.height+50; i += 50)
        {
            ml.fill(ml.random(50,255));
            ml.noStroke();
            ml.rectMode(PApplet.CENTER);
            ml.rect(ml.width/2, i, 7, 30);
        }
    }
    
}