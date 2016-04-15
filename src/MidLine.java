import processing.core.PApplet;

public class MidLine
{
	PApplet ml;
	
	MidLine()
	{
	
	}
	
	 MidLine(PApplet m)
	 {
	      ml = m;
	 }
	    
	 void display()
	 {
	      for (int i = 0; i < ml.height + 50; i += 50)
	      {
	          ml.fill(255);
	          ml.noStroke();
	          ml.rectMode(PApplet.CENTER);
	          ml.rect(ml.width/2, i, 7, 30);
	      }
	 }
}
