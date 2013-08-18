package com.creamtec.techtalk.game.app;

import java.awt.Point;

import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.Icon;

public class FeedImp implements Feed {

	
	private Point position;
	
	private int type;
	
	private Icon icon;

	public FeedImp() {
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
