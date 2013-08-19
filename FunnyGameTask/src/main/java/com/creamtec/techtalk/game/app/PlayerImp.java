package com.creamtec.techtalk.game.app;

import java.awt.Point;

import com.creamtec.techtalk.game.api.Icon;
import com.creamtec.techtalk.game.api.Player;

public class PlayerImp implements Player {

	private Point position;
	
	private Icon icon;
	
	private long score;
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	@Override
	public Icon getIcon() {
		return icon;
	}

	public void setScore(long score) {
		this.score = score;
	}
	
	@Override
	public long getScore() {
		return score;
	}
	
}
