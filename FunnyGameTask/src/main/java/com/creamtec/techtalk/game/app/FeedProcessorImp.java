package com.creamtec.techtalk.game.app;

import java.util.ArrayList;
import java.util.List;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.FeedProcessor;

public class FeedProcessorImp  implements FeedProcessor{

	private int [] generatNumNoRep(int maxVal, int size) {
		int [] arr = new int[size];
		return arr;
		
	}
	
	private List<Feed> feed;
	
	@Override
	public boolean initialize(List<Cell> mazeDescription) {
		// TODO Auto-generated method stub
		
		
		feed = new ArrayList<Feed>();
		
		
		return true;
	}

	@Override
	public void regenerateFeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Feed> getFeed() {
		// TODO Auto-generated method stub
		return null;
	}

}
