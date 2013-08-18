package com.creamtec.techtalk.game.app;

import java.awt.Point;


import com.creamtec.techtalk.game.api.Icon;
import com.creamtec.techtalk.game.api.Monster;

public class MonsterImp implements Monster {

	private Point position;
	private Icon icon;
	private int type;
	
	public MonsterImp() {
		type = 1;
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

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	@Override
	public Icon getIcon() {
		return icon;
	}

}
