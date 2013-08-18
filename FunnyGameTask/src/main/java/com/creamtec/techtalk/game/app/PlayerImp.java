package com.creamtec.techtalk.game.app;

import java.awt.Point;

import com.creamtec.techtalk.game.api.Icon;
import com.creamtec.techtalk.game.api.Player;

public class PlayerImp implements Player {

	private Point position;
	
	private Icon icon;
	
	private long score;
	
	
	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

	@Override
	public long getScore() {
		return score;
	}
	
}
