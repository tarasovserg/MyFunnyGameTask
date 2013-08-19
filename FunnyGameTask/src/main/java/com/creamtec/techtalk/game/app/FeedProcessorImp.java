package com.creamtec.techtalk.game.app;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.Icon;

public class FeedProcessorImp  implements FeedProcessor{


	Random random = new Random();
	
	private Image img;
	
	private static final int FEED_GENERATION_RATE = 10;
	
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
	
	public ArrayList<Feed> feedList = new ArrayList<Feed>();
	
	public ArrayList<Feed> feedListCopy = new ArrayList<Feed>();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean initialize(List<Cell> mazeDescription) {
		feedList.clear();
		feedListCopy.clear();
		try {
			img = ImageIO.read(new File("feed1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//initialize feed in every
		for(Cell cell : mazeDescription) {
			if(cell.getPosition().x == 0 && cell.getPosition().y == 0) continue;
			
			if(random.nextInt(FEED_GENERATION_RATE)== 0 &&
					checkCellForDead(cell)) {
				FeedImp feed = new FeedImp();
				IconImp icon =  new IconImp(img);
				feed.setIcon(icon);
				feed.setPosition(cell.getPosition());
				feedList.add(feed);
			}
		}
		
		feedListCopy = (ArrayList<Feed>) feedList.clone();
		
		
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void regenerateFeed() {
		feedList.clear();
		feedList.addAll((ArrayList<Feed>) feedListCopy.clone()); 
	}

	@Override
	public List<Feed> getFeed() {
		return feedList;
	}

}
