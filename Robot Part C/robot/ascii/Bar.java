package robot.ascii;

import java.util.Arrays;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

public class Bar implements Drawable
{
	// this is not a full implementation since the position is not calculated properly
	// just some basic code to get you started
	//for the arm: height, width and depth. need to draw.
	//bar and block key things: draw it (in correct position),
	//difference between position of bar and block: bar is always at bottom (horiztonal), block is stacked up (can be both horizontal and vertical)
	//pick up from right to left
	//for loop to draw bar_heights and block_height
	//arm is a seperate method
	
	//After drawing:
	//drawing arm at particular position involes the operation: return init, wait for robot control and wait until method calls on us
	//height, width and depth = draw entire arm. this is identified at 
	//draw all. time delay
	//also have to pick up and drop blocks. the extend is a little more complicated
	//pick and drop: which block do we need to pick up?
	
	private int height;
	private int position;
	
	//Constructor for Bars
	public Bar(int height, int position) { 
		this.height = height;
		this.position = position;

	}
	
	@Override
	public void draw(Terminal terminal)
	{
		
		System.out.println("Drawing");
		// (0 index for terminal)
		int maxRow = terminal.getTerminalSize().getRows()-1;
		int minRow = terminal.getTerminalSize().getRows() + 1;
		int maxCol = terminal.getTerminalSize().getColumns()-1;
		int minCol = terminal.getTerminalSize().getColumns()+1;
		
		terminal.applyForegroundColor(Terminal.Color.GREEN);
		
	
		// drawing all bars
		for (int rowPos = maxRow; rowPos > maxRow - height; rowPos--)
			
		{
			terminal.moveCursor(position, rowPos);
			terminal.putCharacter('*');
			
		}
	}
}
