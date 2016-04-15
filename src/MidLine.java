
public class MidLine 
{
	 MidLine()
	 {
	      
	 }
	    
	 void display()
	 {
	      for (int i = 0; i < height + 50; i += 50)
	      {
	          fill(255);
	          noStroke();
	          rectMode(CENTER);
	          rect(width/2, i, 7, 30);
	      }
	 }
}
