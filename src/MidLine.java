import processing.core.PApplet;

public class MidLine
{
	PApplet ml;
	int c = this.color(255);
	
	 MidLine()
	{
	
	}
	    
	 void display()
	 {
	      for (int i = 0; i < 800; i += 50)
	      {
	          ml.fill(c);
	          ml.noStroke();
	          ml.rectMode(PApplet.CENTER);
	          ml.rect(ml.width/2, i, 7, 30);
	      }
	 }

	public int color(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}