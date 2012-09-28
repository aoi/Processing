package practice;

import processing.core.PApplet;

public class BounceBall extends PApplet{
	
	float GRAVITY = 3;
	float FRICTION = (float) 0.8;

	float x, y;
	float spx, spy; // 物体の速度
	float radius;
	int ball_color;
	
	/**
	 * コンストラクタ
	 * @param _x
	 * @param _y
	 * @param _spx
	 * @param _spy
	 * @param _radius
	 * @param _ball_color
	 */
	public BounceBall (
			float _x, float _y,
			float _spx, float _spy,
			float _radius,
			int _ball_color
	) {
		// メンバ変数の初期化
		x = _x;
		y = _y;
		spx = _spx;
		spy = _spy;
		radius = _radius;
		ball_color = _ball_color;
	}
	
	public int getBallColor() { return this.ball_color; }
	
	/**
	 * ボールを動かすメソッド.
	 */
	public void move() {
		spy += GRAVITY;
		x += spx;
		y += spy;
		this.bounce();
	}
	
	/**
	 * ボールを描くメソッド.
	 */
	public void draw() {
		noStroke();
		fill(ball_color);
		ellipse(x, y, radius*2, radius*2);
	}
	
	/**
	 * 跳ね返り判定メソッド.
	 */
	public void bounce() {
		// ボールの大きさとカンバスの大きさから跳ね返る枠を定義
		float bounceMinX = radius;
		float bounceMaxX = _papplet.width - radius;
		float bounceMaxY = _papplet.height - radius;
		
		if (x < bounceMinX || x > bounceMaxX) {
			spx = -spx * FRICTION; // 速度を逆に
			if (x < bounceMinX) {
				x = bounceMinX - (x - bounceMinX);
			}
			
			if (x > bounceMaxX) {
				x = bounceMaxX - (x - bounceMaxX);
			}
			
			if (y > bounceMaxY) {
				spy = -spy * FRICTION;
				if (y > bounceMaxY) {
					y = bounceMaxY - (y - bounceMaxY);
				}
			}
		}
	}
}
