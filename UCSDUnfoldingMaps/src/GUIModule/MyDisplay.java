package GUIModule;

import processing.core.PApplet;

public class MyDisplay extends PApplet {
	
	public void setup(){
		size(400,400);
		background(66, 244, 235);
	}
	
	public void draw(){
		fill(244, 220, 65);
		ellipse(200, 200, 200, 200);
		fill(0,0,0);
		ellipse(150, 170, 20, 30);
		fill(0,0,0);
		ellipse(250, 170, 20, 30);
		arc(200, 230, 50, 30, 0, PI);
	}

}
