package com.creamtec.techtalk.game.app;

import java.awt.Graphics;
import java.awt.Image;

import com.creamtec.techtalk.game.api.Icon;

public class IconImp implements Icon {

	private int width, heigth;
	
	private Image img;
	
	
	IconImp(Image img) {
		this.img = img;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return heigth;
	}

	@Override
	public void drawIcon(Graphics g, int x, int y) {
		x = x - (width / 2);
		y = y - (heigth / 2);
		g.drawImage(img, x, y, width, heigth, null);
	}

}
