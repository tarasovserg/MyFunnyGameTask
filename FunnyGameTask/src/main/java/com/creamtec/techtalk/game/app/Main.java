package com.creamtec.techtalk.game.app;

import java.awt.Point;
import java.util.List;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.Feed;
import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.api.Monster;
import com.creamtec.techtalk.game.conf.ImplementationConfig;



/**
 * The game entry point.
 */
public class Main {

	public static boolean isCell(List<Feed> feeds, Point pos) {
		for(Feed feed: feeds) {
			if(feed.getPosition().x == pos.x && feed.getPosition().y == pos.y){
				return true;
			}
			
		}
		return false;
	}
    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
    	MazeGenerator maze = new MazeGeneratorImp();
    	List<Cell> list = maze.generateMaze(10, 10);
    	FeedProcessorImp feed = new FeedProcessorImp();
    	feed.initialize(list);
    	List<Feed> feeds = feed.getFeed();
    	MonsterProcessorImp mp = new MonsterProcessorImp();
    	mp.initialize(list);
    	List<Monster> monster = mp.getMonsters();
    	System.out.println("MONSTER: "+monster.size());
    	monster.remove(1);
    	System.out.println("MONSTER: "+monster.size());
    	mp.recreateMonsters();
    	System.out.println("MONSTER: "+monster.size());
    	for(Monster mst : monster) {
    		System.out.println("X: "+mst.getPosition().x + "   Y: "+mst.getPosition().y);
    	}
    	
    	System.out.println("REFRESH:");
    	mp.refreshMonstersCycle();
    	for(Monster mst : monster) {
    		System.out.println("X: "+mst.getPosition().x + "   Y: "+mst.getPosition().y);
    	}
    	for(int i=0; i<list.size(); i++) {
    		Cell cell = list.get(i);
    		if(cell.getPosition().y == 0) {
    			System.out.println();
    		}
    		/*System.out.println(cell.getPosition().x + "" + cell.getPosition().y);
    		if(true) continue;*/
    		if(cell.getBorder().hasBottom() == false && 
    				cell.getBorder().hasLeft() == false &&
    				cell.getBorder().hasRight() == false &&
    				cell.getBorder().hasTop() == false) {
    			if(isCell(feeds, cell.getPosition())){
    				System.out.print("8");
    			}
    			else System.out.print("*");
    			continue;
    		}
    		if(cell.getBorder().hasBottom()) {
    			System.out.print("B");
    			continue;
    		}
    		if(cell.getBorder().hasTop()) {
    			System.out.print("T");
    			continue;
    		}
    		if(cell.getBorder().hasLeft()) {
    			System.out.print("L");
    			continue;
    		}
    		if(cell.getBorder().hasRight()) {
    			System.out.print("R");
    			continue;
    		}
    		
    	}
    	
    	
        /*SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                @SuppressWarnings("unused")
				MazeGenerator generator = null;
                try {
                    generator = ImplementationConfig.getMazeGenerator();
                } catch (Exception e) {
                    LOGGER.error(e);
                }

//                GameFrame frame = new GameFrame(generator);
//                frame.setVisible(true);
            }

        });*/
    }

}
