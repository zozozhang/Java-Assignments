package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

import control.Control;

public class Block implements Drawable
{
	
	private int xpos;
	private int ypos;
	private int blockHeight;
	
	//Constructor or Blocks
	public Block(int blockHeight, int xpos, int ypos) { 
		this.xpos = xpos; //the 'x' values
		this.ypos = ypos; //the 'y' values
		this.blockHeight = blockHeight;
	}
	
	
	@Override
	public void draw(Terminal terminal) {
		int MaxBlockRow = terminal.getTerminalSize().getRows()-1;
	
		if(blockHeight == 1) {
			terminal.applyForegroundColor(Color.YELLOW);
		}
		
		if(blockHeight == 2) {
			terminal.applyForegroundColor(Color.RED);
		}
		
		if(blockHeight == 3) {
			terminal.applyForegroundColor(Color.BLUE);
		}
		if(blockHeight > 3) {
			terminal.applyForegroundColor(Color.GREEN);
		}
		//looping through all blockHeights and assigning characters
		for (int star = 0; star < blockHeight; star++) {
			terminal.moveCursor(xpos, MaxBlockRow- ypos - star);
			terminal.putCharacter('+');
			
		}
			
		}
	
	//positioning of x
	public int getX() {
		return xpos;
	}
	//positioning of y
	public int getY() {
		return ypos;
	}
	public int getHeight() {
		return blockHeight;
	}
	
	public int getTop() {
		return ypos + blockHeight;
	}
	public void up() {
		ypos++;
	}
	public void down() {
		ypos--;
	}
	public void left() {
		xpos--;
	}
	public void right() {
		xpos++;
	}
}
