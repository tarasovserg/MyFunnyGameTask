package com.creamtec.techtalk.game.app;

import java.awt.Color;

import com.creamtec.techtalk.game.api.CellBorder;

public class CellBorderImp implements CellBorder {

	private boolean hasTop, hasRigth, hasBottom, hasLeft;
	
	private Color color;
	
	private int thickness;
	
	public CellBorderImp() {
		//default thickness and color
		color = Color.BLACK;
		thickness = 5;
	}
	
	public void setTop(boolean hasTop) {
		this.hasTop = hasTop;
	}
	
	@Override
	public boolean hasTop() {
		return hasTop;
	}

	public void setRigth(boolean hasRigth) {
		this.hasRigth = hasRigth;
	}
	
	@Override
	public boolean hasRight() {
		return hasRigth;
	}

	public void setBottom(boolean hasBottom) {
		this.hasBottom = hasBottom;
	}
	
	@Override
	public boolean hasBottom() {
		return hasBottom;
	}

	public void setLeft(boolean hasLeft) {
		this.hasLeft = hasLeft;
	}
	
	@Override
	public boolean hasLeft() {
		return hasLeft;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	@Override
	public int getThickness() {
		return thickness;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public Color getColor() {
		return color;
	}

}
