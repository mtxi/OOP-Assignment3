import processing.core.*;

public class MainMenu {
	
	PApplet menu;
	PFont myFont;
	
	MainMenu(PApplet main)
	{
		menu = main;
		myFont = menu.createFont("GillSansMT", 48);
	}
	
	public void display()
	{
		menu.background(52, 50, 50);
        
        menu.textFont(myFont);
        menu.fill(255);
        menu.textSize(160);
        menu.text("P     N G", menu.width/2 + 50, menu.height/2);
        menu.textSize(30);
        menu.text("CLICK to start!", menu.width/2 - 100, menu.height/2+100);
        menu.fill(3, 255, 29);
        menu.textSize(180);
        menu.fill(255, 0, 0);
        menu.ellipse(menu.width/2 + 270, menu.height/2 - 55, 55*2, 55*2);
        menu.textSize(160);
        menu.text("P  !  N G", menu.width/2 - 670, menu.height/2);
        menu.fill(255);
        menu.textAlign(PApplet.LEFT);
        menu.textSize(20);
        menu.text("PLAYER CONTROLS", menu.width-500, menu.height - 160);
        
        menu.textSize(15);
        menu.text("PLAYER 1: up = 'W' || down = 'S'", menu.width-500, menu.height - 130);
        menu.text("PLAYER 2: up = 'UP arrow' || down = 'DOWN arrow'", menu.width-500, menu.height - 110);
        menu.text("Score 5 points to win! :)",menu.width*1/2, menu.height);
	}
}
