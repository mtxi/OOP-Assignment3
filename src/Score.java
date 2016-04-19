import processing.core.*;

public class Score
{
	PApplet score;
	float x;
	float y;
	
	int Size;
	
	
	Score(PApplet sc, int Size)
	{
		score = sc;
		Size = 20;
		
	}
	
	
	public void display()
	{
		for (int i = 0; i < PingPong.scoreP1; i++)
		{
			x = (float) ((Size*i) + 200);
			y = 50;
			score.noStroke();
			score.fill(0);
			score.ellipse(x+300,y,Size*2,Size*2);
		}
		
		for (int i = 0; i < PingPong.scoreP2; i++)
		{
			x = (float) ((Size*i) + score.width/2);
			y = 2*score.width/3;
			score.noStroke();
			score.fill(255);
			score.ellipse(x+200,y+38,Size*2,Size*2);
			
		}
	}
}
