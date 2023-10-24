package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;

import main.PlayManager;
import main.KeyHandler;

public class Mino {
	
	public Block[] blocks = new Block[4];
	public Block[] tempB = new Block[4];
	protected int autoDropCounter = 0;
	protected int currentRotation = 0;
	protected boolean isBottomReached, isLeftWallReached, isRightWallReached = false;
	
	public void create(Color color) {
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i] = new Block(color);
			tempB[i] =new Block(color);
		}
	}
	
	public void setXY(int x, int y) {}
	public void updateXY(int direction) {}
	public void rotate() {}
	
	public void update() {
		
		isBottomReached = isBottomReached(blocks);
		isRightWallReached = isRightWallReached(blocks);
		
		//Movement
		if (KeyHandler.upPressed) {
			rotate();
			KeyHandler.upPressed = false;
		}
		
		if (KeyHandler.downPressed && !isBottomReached) {
			
			if (!isBottomReached) {
				
				for (Block b: blocks) {
					b.y += Block.SIZE;
				}
			}
			
			//reset auto-counter
			autoDropCounter = 0;
			
			KeyHandler.downPressed = false;
		}
		
		if (KeyHandler.leftPressed) {
			
			for (Block b: blocks) {
				b.x -= Block.SIZE;
			}
			
			KeyHandler.leftPressed = false;
			
		}
		
		if (KeyHandler.rightPressed && !isRightWallReached) {
			
			for (Block b: blocks) {
				b.x += Block.SIZE;
			}
			
			KeyHandler.rightPressed = false;
		}
		
		autoDropCounter++; //increases every frame
		
		//auto-drop
		if (autoDropCounter == PlayManager.dropInterval && !isBottomReached) {
		
			for (Block b: blocks) {
				b.y += Block.SIZE;
			}
				
			autoDropCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int margin = 2;
		g2.setColor(blocks[0].color);
		g2.fillRect(blocks[0].x + margin, blocks[0].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
		g2.fillRect(blocks[1].x + margin, blocks[1].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
		g2.fillRect(blocks[2].x + margin, blocks[2].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
		g2.fillRect(blocks[3].x + margin, blocks[3].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
	}
	
	protected boolean collision() {
		return false;
	}
	
	protected boolean isRightWallReached(Block[] blocks) {
		
		return Arrays.stream(blocks)
					 .anyMatch(b -> b.x >= PlayManager.WIDTH);
	}
	
	protected boolean isBottomReached(Block[] blocks) {
		
		return Arrays.stream(blocks)
					 .anyMatch(b -> b.y >= PlayManager.HEIGHT);
	}
}
