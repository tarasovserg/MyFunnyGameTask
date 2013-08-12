package com.creamtec.techtalk.game.app;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.MazeGenerator;

public class MazeGeneratorImp implements MazeGenerator{

	@Override
	public List<Cell> generateMaze(int horizontalCellCount,
			int verticalCellCount) {
		List<Cell> generateMazeResult = new ArrayList<>();
		
		for(int i=0; i<horizontalCellCount; i++) {
			
			for(int j=0; j<verticalCellCount; j++) {
				CellImp cell = new CellImp();
				CellBorderImp cellBorder = new CellBorderImp();
				//default border values
				if(i == 0) {
					cellBorder.setTop(true);
				}
				if(i == (horizontalCellCount-1)) {
					cellBorder.setBottom(true);
				}
				if(j == 0) {
					cellBorder.setLeft(true);
				}
				if(j == (verticalCellCount-1)) {
					cellBorder.setRigth(true);
				}
				cell.setBorder(cellBorder);
				Point position = new Point(i, j);
				cell.setPosition(position);
				generateMazeResult.add(cell);
			}
		}
		return generateMazeResult;
	}

}
