package mino;

import java.awt.Color;

public class Mino_Z2 extends Mino {


	public Mino_Z2() {
		create(Color.red);
	}
	
	public void setXY(int x, int y) {
		blocks[0].x = x;
		blocks[0].y = y;
		blocks[1].x = blocks[0].x + Block.SIZE;
		blocks[1].y = blocks[0].y - Block.SIZE;
		blocks[2].x = blocks[0].x + Block.SIZE;
		blocks[2].y = blocks[0].y;
		blocks[3].x = blocks[0].x;
		blocks[3].y = blocks[0].y + Block.SIZE;
	}
	
	public void rotate() {
		
		currentRotation = (currentRotation == 3) ? 0 : ++currentRotation;
		
		if (currentRotation == 0 || currentRotation == 2) {
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x + Block.SIZE;
			tempB[1].y = blocks[0].y - Block.SIZE;
			tempB[2].x = blocks[0].x + Block.SIZE;
			tempB[2].y = blocks[0].y;
			tempB[3].x = blocks[0].x;
			tempB[3].y = blocks[0].y + Block.SIZE;
		} else {
			tempB[0].x = blocks[0].x;
			tempB[0].y = blocks[0].y;
			tempB[1].x = blocks[0].x + Block.SIZE;
			tempB[1].y = blocks[0].y + Block.SIZE;
			tempB[2].x = blocks[0].x;
			tempB[2].y = blocks[0].y + Block.SIZE;
			tempB[3].x = blocks[0].x - Block.SIZE;
			tempB[3].y = blocks[0].y;
		}
		
		System.arraycopy(tempB, 0, blocks, 0, tempB.length);
	}
}
