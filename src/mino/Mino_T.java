package mino;

import java.awt.Color;

public class Mino_T extends Mino {
	
	public Mino_T() {
		create(Color.magenta);
	}
	
	public void setXY(int x, int y) {
		blocks[0].x = x;
		blocks[0].y = y;
		blocks[1].x = blocks[0].x;
		blocks[1].y = blocks[0].y - Block.SIZE;
		blocks[2].x = blocks[0].x - Block.SIZE;
		blocks[2].y = blocks[0].y;
		blocks[3].x = blocks[0].x + Block.SIZE;
		blocks[3].y = blocks[0].y ;
	}
	public void rotate() {
		
		currentRotation = (currentRotation == 3) ? 0 : ++currentRotation;
		
		switch (currentRotation) {
		case 0:
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x;
			tempB[1].y = blocks[0].y - Block.SIZE;
			tempB[2].x = blocks[0].x - Block.SIZE;
			tempB[2].y = blocks[0].y;
			tempB[3].x = blocks[0].x + Block.SIZE;
			tempB[3].y = blocks[0].y;
			break;
		case 1:
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x + Block.SIZE;
			tempB[1].y = blocks[0].y;
			tempB[2].x = blocks[0].x;
			tempB[2].y = blocks[0].y + Block.SIZE;
			tempB[3].x = blocks[0].x;
			tempB[3].y = blocks[0].y - Block.SIZE;
			break;
		case 2:
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x ;
			tempB[1].y = blocks[0].y + Block.SIZE;
			tempB[2].x = blocks[0].x + Block.SIZE;
			tempB[2].y = blocks[0].y;
			tempB[3].x = blocks[0].x - Block.SIZE;
			tempB[3].y = blocks[0].y;
			break;
		case 3:
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x - Block.SIZE;
			tempB[1].y = blocks[0].y;
			tempB[2].x = blocks[0].x;
			tempB[2].y = blocks[0].y + Block.SIZE;
			tempB[3].x = blocks[0].x;
			tempB[3].y = blocks[0].y - Block.SIZE;
			break;
		}
		
		System.arraycopy(tempB, 0, blocks, 0, tempB.length);
	}
}
