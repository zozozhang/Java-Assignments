package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

import control.Control;

public class Arm implements Drawable
{
	private int height;
	private int width;
	private int depth;

	//Constructor for robot arm
	public Arm(int height, int width, int depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
		
	}
	@Override

	public void draw(Terminal terminal)
	{
		int MaxBlockRow = terminal.getTerminalSize().getRows()-1;
		terminal.applyForegroundColor(Color.WHITE);
		
		//looping through height
		for (int dash = 0; dash < height-1; dash++) {
			terminal.moveCursor(0, MaxBlockRow- dash);
			terminal.putCharacter('|');
		}
		//looping through width
		for (int dash = 0; dash < width; dash++) {
			terminal.moveCursor(dash, MaxBlockRow- height+1);
			terminal.putCharacter('-');
		}
		//looping through depth
		for (int dash = 0; dash < depth+1; dash++) {
			terminal.moveCursor(width, MaxBlockRow- height+1+dash);
			terminal.putCharacter('|');
		}
	}
	public int getX() { 
		return width;
	}
	
	public int getY() {
		return height-depth-1;
	}
	
	public void up() {
		height++;
	}
	public void down() {
		height--;
	}
	public void extend() {
		width++;
	}
	public void contract() {
		width--;
	}
	public void lower() {
		depth++;
	}
	public void raise() {
		depth--;
	}
	
}
