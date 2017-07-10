package robot.ascii;

import robot.Robot;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import control.Control;
import control.RobotControl;

//Robot Assignment for Programming 1 s1 2017
//ASCIIBot classes written by Caspar Ryan
public class ASCIIBot implements Robot
{
	// the Lanterna terminal
	private Terminal terminal;
	private Bar bars[];
	private Block blocks[];
	private int columnHeights[];
	private Arm arm;
	private Block heldBlock;
	
	//must have clear the screen
	
	// for simplicity I do not do graceful exiting code so just use the eclipse STOP button to exit
	public static void main(String[] args)
	{
		// instantiate ASCIIBot and run control()
		new RobotControl().control(new ASCIIBot(),null, null);
	}

	// the constructor initialises the Lanterna Terminal
	public ASCIIBot()
	{
		// create the terminal 20 rows, 15 columns
		terminal = TerminalFacade.createSwingTerminal(
				22, 14);

		// required by Lanterna framework to initialise
		terminal.enterPrivateMode();
		terminal.setCursorVisible(false);
		
		terminal.clearScreen();
		
		// set close operation so program with exit if "X" clicked
		if(terminal instanceof SwingTerminal)
		{
			((SwingTerminal) terminal).getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	@Override
	public void init(int[] barHeights, int[] blockHeights, int height,
			int width, int depth)
	{
		this.bars = new Bar[barHeights.length];
		this.blocks = new Block[blockHeights.length];
		this.columnHeights = new int [11];
		arm = new Arm (13, 1, 0);
		heldBlock = null;

	
		
		// delay 100 milliseconds for next "frame"
		delayAnimation(1000);
		
		
		//drawing bars
		for(int i = 0; i < barHeights.length; i++) {
			bars[i] = new Bar(barHeights[i], i+3); 
			columnHeights[i+3] = barHeights[i];
			
			
		}
		
		//drawing blocks
		int blockThreePos = 3;

		for (int i = 0; i < blockHeights.length; i++) {
			
			if (blockHeights[i] == 1) {
				blocks[i] = new Block(blockHeights[i], 1, columnHeights[1]);
				columnHeights[1] += blockHeights[i];
			}
			if (blockHeights[i] == 2) {
				blocks[i] = new Block(blockHeights[i], 2, columnHeights[2]);
				columnHeights[2] += blockHeights[i];
			}
			if (blockHeights[i] == 3) {
				blocks[i] = new Block(blockHeights[i], blockThreePos, columnHeights[blockThreePos]);
				columnHeights[blockThreePos] += blockHeights[i];
				blockThreePos++;
			
			}
		
		
		}
		 
		
		drawAll();
		
	}
	
	//this is the draw all method
	private void drawAll () {
		terminal.clearScreen();
		for (int i = 0; i < bars.length; i++) {
			bars[i].draw(terminal);
		}
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].draw(terminal);
		}
		arm.draw(terminal);
		delayAnimation(50);
	}
	
	
	@Override
	public void pick()
	{
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i].getTop() == arm.getY() && blocks[i].getX() == arm.getX()) {
				heldBlock = blocks[i];
			}
		}
	}

	@Override
	public void drop() 
	{
		heldBlock = null;
		
	}

	@Override
	public void up() 
	{
		arm.up();
		if (heldBlock != null) {
			heldBlock.up();
		}
		drawAll();
		
		
	}

	@Override
	public void down() 
	{
		arm.down();
		if (heldBlock != null) {
			heldBlock.down();
		}
		
		drawAll();
		
	}

	@Override
	public void contract()
	{
	
		arm.contract();
		if (heldBlock != null) {
			heldBlock.left();
		
		}
		
		drawAll();
	}

	@Override
	public void extend()
	{
	
		arm.extend();
		if (heldBlock != null) {
			heldBlock.right();
		}
		drawAll();
		
	}

	@Override
	public void lower()
	{
		arm.lower();
		if (heldBlock != null) {
			heldBlock.down();
		}
		
		drawAll();
	}

	@Override
	public void raise()
	{
		arm.raise();
		if (heldBlock != null) {
			heldBlock.up();
		}
		drawAll();
		
	}

	// delay in ms
	private void delayAnimation(int ms)
	{
		try
		{
			Thread.sleep(ms);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
