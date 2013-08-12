package com.creamtec.techtalk.game.app;

import java.util.List;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.conf.ImplementationConfig;

/**
 * The game entry point.
 */
public class Main {

    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
    	MazeGenerator maze = new MazeGeneratorImp();
    	List<Cell> list = maze.generateMaze(10, 10);
    	for(int i=0; i<list.size(); i++) {
    		Cell cell = list.get(i);
    		if(cell.getPosition().y == 0) {
    			System.out.println();
    		}
    		//Hello World!
    		/*System.out.println(cell.getPosition().x + "" + cell.getPosition().y);
    		if(true) continue;*/
    		if(cell.getBorder().hasBottom() == false && 
    				cell.getBorder().hasLeft() == false &&
    				cell.getBorder().hasRight() == false &&
    				cell.getBorder().hasTop() == false) {
    			System.out.print("*");
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
