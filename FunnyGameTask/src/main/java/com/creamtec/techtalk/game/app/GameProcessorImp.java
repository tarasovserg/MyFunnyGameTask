package com.creamtec.techtalk.game.app;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.GameProcessor;
import com.creamtec.techtalk.game.api.Monster;
import com.creamtec.techtalk.game.api.MonsterProcessor;
import com.creamtec.techtalk.game.api.MoveAction;
import com.creamtec.techtalk.game.api.Player;

public class GameProcessorImp implements GameProcessor{

	private boolean isAlive;
	
	private List<Cell> maze;
	
	private MonsterProcessorImp monsterProc;
	
	private FeedProcessorImp feedProc;
	
	private PlayerImp player;
	
	private Image img;
	
	@Override
	public boolean initialize(List<Cell> mazeDescription,
			MonsterProcessor monsterProcessor, FeedProcessor feedProcessor) {
		isAlive = true;
		maze = mazeDescription;
		monsterProc = (MonsterProcessorImp) monsterProcessor;
		feedProc = (FeedProcessorImp) feedProcessor;
		
		try {
			img = ImageIO.read(new File("feed1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		IconImp icon = new IconImp(img);
		
		player = new PlayerImp();
		player.setIcon(icon);
		player.setScore(0);
		player.setPosition(new Point(0, 0));
		return true;
	}

	private boolean checkForMonster(Point position) {
		for(Monster mon : monsterProc.getMonsters()) {
			if(mon.getPosition().x==position.x && mon.getPosition().y == position.y) return true;
		}
		return false;
	}
	
	private boolean checkForFeed(Point position) {
		for(Feed feed : feedProc.getFeed()) {
			if(feed.getPosition().x==position.x && feed.getPosition().y == position.y) return true;
		}
		return false;
	}
	
	private Cell getCellByPoint(Point position) {
		Cell cell = null;
		for(Cell cells: maze) {
			if(cells.getPosition().x == position.x && cells.getPosition().y == position.y) { 
				cell = cells;
				break;
			}
		}
		return cell;
	}
	
	private boolean checkWay(Point position, MoveAction mv) {
		Point way = new Point();
		way.x = position.x;
		way.y = position.y;
		switch(mv) {
			case UP :
				way.y--;
				if(getCellByPoint(way)!=null) {
					if(!getCellByPoint(way).getBorder().hasBottom() && !getCellByPoint(position).getBorder().hasTop()) return true;
				}
				break;
			case RIGHT:
				way.x++;
				if(getCellByPoint(way)!=null) {
					if(!getCellByPoint(way).getBorder().hasLeft() && !getCellByPoint(position).getBorder().hasRight()) return true;
				}
				break;
			case DOWN:
				way.y++;
				if(getCellByPoint(way)!=null) {
					if(!getCellByPoint(way).getBorder().hasTop() && !getCellByPoint(position).getBorder().hasBottom()) return true;
				}
				break;
			case LEFT:
				way.x--;
				if(getCellByPoint(way)!=null) {
					if(!getCellByPoint(way).getBorder().hasRight() && !getCellByPoint(position).getBorder().hasLeft()) return true;
				}
				break;
			default:
				break;
		}
		return false;
	}
	private void checkMove() {
		if(checkForMonster(player.getPosition())){
			isAlive = false;
		}
		if(checkForFeed(player.getPosition())){
			long score = player.getScore();
			score++;
			player.setScore(score);
		}
	}
	
	@Override
	public void movePlayer(MoveAction action) {
		if(!isAlive) return;
		switch (action) {
		case UP:
			System.out.println(checkWay(player.getPosition(), MoveAction.UP));
			if(checkWay(player.getPosition(), MoveAction.UP)) {
				player.getPosition().y--;
				checkMove();
			}
			break;
		case RIGHT:
			System.out.println(checkWay(player.getPosition(), MoveAction.RIGHT));
			if(checkWay(player.getPosition(), MoveAction.RIGHT)) {
				player.getPosition().x++;
				checkMove();
			}
			break;
		
			
		case DOWN:
			System.out.println(checkWay(player.getPosition(), MoveAction.DOWN));
			if(checkWay(player.getPosition(), MoveAction.DOWN)){
				player.getPosition().y++;
				checkMove();
			}
			break;
		
			
		case LEFT:
			System.out.println(checkWay(player.getPosition(), MoveAction.LEFT));
			if(checkWay(player.getPosition(), MoveAction.LEFT)) {
				player.getPosition().x--;
				checkMove();
			}
			break;
		default:
			break;
		}
		
	}

	@Override
	public Player getPlayer() {
		return player;
	}

}
