package mino;

import java.awt.Color;

import main.PlayManager;

public class Mino_Bar extends Mino {
	
	public Mino_Bar() {
		create(Color.cyan);
	}
	
	public void setXY(int x, int y) {
		blocks[0].x = x;
		blocks[0].y = y;
		blocks[1].x = blocks[0].x;
		blocks[1].y = blocks[0].y - Block.SIZE;
		blocks[2].x = blocks[0].x;
		blocks[2].y = blocks[0].y + Block.SIZE;
		blocks[3].x = blocks[0].x;
		blocks[3].y = blocks[0].y + Block.SIZE * 2;
	}
	
	public void rotate() {
		
		currentRotation = (currentRotation == 3) ? 0 : ++currentRotation;
		boolean isStanding = currentRotation == 0 || currentRotation == 2;
		
		if (isStanding) {
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x;
			tempB[1].y = blocks[0].y - Block.SIZE;
			tempB[2].x = blocks[0].x;
			tempB[2].y = blocks[0].y + Block.SIZE;
			tempB[3].x = blocks[0].x ;
			tempB[3].y = blocks[0].y + Block.SIZE * 2;
		} else {
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x - Block.SIZE;
			tempB[1].y = blocks[0].y;
			tempB[2].x = blocks[0].x + Block.SIZE;
			tempB[2].y = blocks[0].y;
			tempB[3].x = blocks[0].x + Block.SIZE * 2;
			tempB[3].y = blocks[0].y;
		}
		
		if (isBottomReached(tempB)) {
			tempB[0].y = PlayManager.HEIGHT + PlayManager.top_y - Block.SIZE * 3;
			tempB[1].y = PlayManager.HEIGHT + PlayManager.top_y - Block.SIZE * 4;
			tempB[2].y = PlayManager.HEIGHT + PlayManager.top_y - Block.SIZE * 2;
			tempB[3].y = PlayManager.HEIGHT + PlayManager.top_y - Block.SIZE;
		}
		
		System.arraycopy(tempB, 0, blocks, 0, tempB.length);
	}
}
