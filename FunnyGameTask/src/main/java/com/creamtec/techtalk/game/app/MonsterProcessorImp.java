package com.creamtec.techtalk.game.app;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Monster;
import com.creamtec.techtalk.game.api.MonsterProcessor;
import com.creamtec.techtalk.game.api.MoveAction;

public class MonsterProcessorImp implements MonsterProcessor {

	
	
	private List<Cell> cellList;
	
	MoveAction [] arr = new MoveAction[4];
	
	
	public static final int MONSTER_GENERATION_RATE = 25;
	
	private Random random = new Random();
	
	private Image img;
	
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	private ArrayList<Monster> monsterListCopy = new ArrayList<Monster>();
	/**
	 * Check if cell is accessible for gamer
	 * @param cell {@link Cell} object
	 * @return
	 */
	private boolean checkCellForDead(Cell cell){
		int borderCount = 0;
		
		if(cell.getBorder().hasBottom())borderCount++;
		if(cell.getBorder().hasLeft())borderCount++;
		if(cell.getBorder().hasRight()) borderCount++ ;
		if(cell.getBorder().hasTop()) borderCount++ ;
		
		if(borderCount<=2) return true;
		else return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean initialize(List<Cell> mazeDescription) {
		arr[0] = MoveAction.UP;
		arr[1] = MoveAction.RIGHT;
		arr[2] = MoveAction.DOWN;
		arr[3] = MoveAction.LEFT;
		cellList = mazeDescription;
		monsterList.clear();
		monsterListCopy.clear();
		try {
			img = ImageIO.read(new File("monster1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}  
		//initialize monster
		for(Cell cell : mazeDescription) {
			if(random.nextInt(MONSTER_GENERATION_RATE)== 0 &&
					checkCellForDead(cell)) {
				MonsterImp monster = new MonsterImp();
				IconImp icon =  new IconImp(img);
				monster.setIcon(icon);
				monster.setPosition(cell.getPosition());
				monsterList.add(monster);
			}
		}
		monsterListCopy = (ArrayList<Monster>) monsterList.clone();
		return true;
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
	
	private Cell getCellByPoint(Point position) {
		Cell cell = null;
		for(Cell cells: cellList) {
			if(cells.getPosition().x == position.x && cells.getPosition().y == position.y) { 
				cell = cells;
				break;
			}
		}
		return cell;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void recreateMonsters() {
		monsterList.clear();
		monsterList.addAll((ArrayList<Monster>) monsterListCopy.clone()); 
	}

	@Override
	public void refreshMonstersCycle() {
		if(monsterList.size()==0) return;
		int turn = -1;
		for(Monster monster : monsterList) {
			turn = random.nextInt(4);
			int i = 0;
			while(i<4) {
				if(checkWay(monster.getPosition(), arr[turn%4])) {
					switch(arr[turn]){
						case UP:
							monster.getPosition().y--;
							break;
						case RIGHT:
							monster.getPosition().x++;
							break;
						case DOWN:
							monster.getPosition().y++;
							break;
						case LEFT:
							monster.getPosition().x--;
							break;
						default :
							break;
					}
					break;
				}
				else {
					turn++;
					i++;
				}
			}
		}
		
	}

	@Override
	public List<Monster> getMonsters() {
		return monsterList;
	}

}
