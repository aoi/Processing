package practice;

import processing.core.PApplet;

public class BounceBall extends PApplet{
	
	float GRAVITY = 3;
	float FRICTION = (float) 0.8;

	float x, y;
	float spx, spy; // ���̂̑��x
	float radius;
	int ball_color;
	
	/**
	 * �R���X�g���N�^
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
		// �����o�ϐ��̏�����
		x = _x;
		y = _y;
		spx = _spx;
		spy = _spy;
		radius = _radius;
		ball_color = _ball_color;
	}
	
	public int getBallColor() { return this.ball_color; }
	
	/**
	 * �{�[���𓮂������\�b�h.
	 */
	public void move() {
		spy += GRAVITY;
		x += spx;
		y += spy;
		this.bounce();
	}
	
	/**
	 * �{�[����`�����\�b�h.
	 */
	public void draw() {
		noStroke();
		fill(ball_color);
		ellipse(x, y, radius*2, radius*2);
	}
	
	/**
	 * ���˕Ԃ蔻�胁�\�b�h.
	 */
	public void bounce() {
		// �{�[���̑傫���ƃJ���o�X�̑傫�����璵�˕Ԃ�g���`
		float bounceMinX = radius;
		float bounceMaxX = _papplet.width - radius;
		float bounceMaxY = _papplet.height - radius;
		
		if (x < bounceMinX || x > bounceMaxX) {
			spx = -spx * FRICTION; // ���x���t��
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
