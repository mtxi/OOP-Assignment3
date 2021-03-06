import processing.core.*;

public class Score
{
	PApplet score;
	float x;
	float y;
	
	int Size = 15;
	
	Score(PApplet sc)
	{
		score = sc;
		
	}
	
	public void display()
	{
		// red circles represent each score
		for (int i = 0; i < PingPong.scoreP1; i++)
		{
			x = (float) (Size*i*2 + score.width/1.4);
			y = 43;
			score.stroke(2);
			score.fill(245, 7, 11);
			score.ellipse(x-(score.width/2) - 80,y,Size*2,Size*2);
		}
		
		for (int i = 0; i < PingPong.scoreP2; i++)
		{
			x = (float) (Size*i*2 + score.width/1.4);
			y = 43;
			score.stroke(2);
			score.fill(245, 7, 11);
			score.ellipse(x - 70,y,Size*2,Size*2);
			
		}
	}
}
