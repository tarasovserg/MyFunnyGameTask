package com.creamtec.techtalk.game.app;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.Icon;

public class FeedProcessorImp  implements FeedProcessor{

	private int [] generatNumNoRep(int maxVal, int size) {
		int [] arr = new int[size];
		return arr;
		
	}
	Random random = new Random();
	
	private Image img;
	
	private static final int FEED_GENERATION_RATE = 10;
	
	/**
	 * Check if cell is accessible for gamer
	 * @param cell {@link Cell} object
	 * @return
	 */
	private boolean checkCellForDead(Cell cell){
		if(cell.getBorder().hasBottom()  && 
				cell.getBorder().hasLeft()  &&
				cell.getBorder().hasRight()  &&
				cell.getBorder().hasTop()) {
			return true;
			
		}
		else {
			return false;
		}
	}
	
	private List<Feed> feed = new ArrayList<Feed>();
	
	@Override
	public boolean initialize(List<Cell> mazeDescription) {
		img = ImageIO.read("");  
		//initialize feed in every
		for(Cell cell : mazeDescription) {
			if(random.nextInt(FEED_GENERATION_RATE)== 0 &&
					!checkCellForDead(cell)) {
				
				FeedImp feed = new FeedImp();
				
				IconImp icon =  new IconImp();
				feed.setIcon();
				feed.add(e);
				
			}
		}
		
		
		
		
		return true;
	}

	@Override
	public void regenerateFeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Feed> getFeed() {
		return feed;
	}

}
