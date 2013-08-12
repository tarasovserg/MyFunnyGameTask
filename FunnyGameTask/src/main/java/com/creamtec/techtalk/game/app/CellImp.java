package com.creamtec.techtalk.game.app;

import java.awt.Color;
import java.awt.Point;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.CellBorder;
import com.creamtec.techtalk.game.api.Icon;

public class CellImp implements Cell{

	private CellBorder border;
	
	private Point position;
	
	private int type;
	
	private Color backgroundColor;
	
	private Icon icon;
	
	CellImp() {
		//default value initialize
		backgroundColor = Color.BLACK;
		
		
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public int getType() {
		return type;
	}

	public void setBorder(CellBorder border) {
		this.border = border;
	}
	
	@Override
	public CellBorder getBorder() {
		return border;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
	
	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
