package mino;

import java.awt.Color;

public class Mino_Z1 extends Mino{


	public Mino_Z1() {
		create(Color.green);
	}
	
	public void setXY(int x, int y) {
		blocks[0].x = x;
		blocks[0].y = y;
		blocks[1].x = blocks[0].x;
		blocks[1].y = blocks[0].y - Block.SIZE;
		blocks[2].x = blocks[0].x + Block.SIZE;
		blocks[2].y = blocks[0].y;
		blocks[3].x = blocks[0].x + Block.SIZE;
		blocks[3].y = blocks[0].y + Block.SIZE;
	}
}
