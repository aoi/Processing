package practice;

import processing.core.PApplet;

public class BounceBallMain extends PApplet {

	int length = 100;
	
	BounceBall[] balls = new BounceBall[length];
	
	public void setup() {
		size(400, 400);
		colorMode(HSB, length);
		background(length, -1);
		frameRate(10);
		
		for (int i=0; i<length; i++) {
			balls[i] = new BounceBall(
					width/2, 10,
					random(-20, 20),
					random(-30, 0),
					random(5, 20),
					color(random(length),(float) (length * 0.6), length -1));
		}
	}

	public void draw() {
		fadeToWhite();
		
		for (int i=0; i<length; i++) {
			balls[i].move();
			balls[i].draw();
		}
	}
	
	/**
	 * 画面をフェードアウトする.
	 */
	private void fadeToWhite() {
		noStroke();
		fill(99, 30);
		rectMode(CORNER);
		rect(0, 0, width, height);
	}
	
}
