package control;
import java.util.Arrays;
import java.util.Scanner;

import robot.Robot;

//Name: Ze Chen (Zoe) Zhang
//Student ID: s3602957

//Robot Assignment for Programming 1 s1 2017
//Adapted by Caspar from original Robot code in RobotImpl.jar written by Dr Charles Thevathayan
public class RobotControl implements Control {
	private Robot robot;

	// note use of constants from Control interface
	private int height = Control.INITIAL_HEIGHT;
	private int width = Control.INITIAL_WIDTH;
	private int depth = Control.INITIAL_DEPTH;

	private int[] barHeights;
	private int[] blockHeights;

	// called by RobotImpl
	// the unused arrays are based on cmd line params to RobotImpl but not used
	// in this assignment
	@Override
	public void control(Robot robot, int barHeightsUnused[], int blockHeightsUnused[]) {
		// save robot so we can access it from other methods
		this.robot = robot;

		// ------ASSIGNMENT PART A-------
		// replace this code with a console based menu to create and populate
		// the arrays (in separate method(s))
		//this.barHeights = new int[]
			//{ 7, 3, 1, 7, 5, 3, 2 };
		//this.blockHeights = new int[]
			//{ 3, 2, 2, 3, 1, 1 };
		
		Scanner sc = new Scanner(System.in);
		barHeights = createBars(sc);
		blockHeights = createBlocks(sc);
		System.out.println(Arrays.toString(barHeights));
		System.out.println(Arrays.toString(blockHeights));
		System.out.println("Completed Sucessfully");
	
		

		
		
		
		// initialise the robot
		robot.init(barHeights,blockHeights,height,width,depth);
	
		// a simple private method to demonstrate how to control (assignment PART B)
		// note use of constant from Control interface
		moveToWidth(Control.MAX_WIDTH);

		// assignment part B implemented here
	}

	private void moveToWidth(int width) {
		while (this.width < width) {
			robot.extend();
			this.width++;
		}
	}

	// assignment part A methods implemented here

	private int[] createBars(Scanner sc) {
		
		System.out.println("Please enter number of bars (min 1/max 7)");
		int numberBars = sc.nextInt();
				
		int barHeights[] = new int [numberBars]; //creating new array
		
		for (int i = 0; i < numberBars; i++) { //checking if conditions are met
			int increaseNumber = (int) (i + 1);
			System.out.println("Please enter the height of bar " + increaseNumber + " of " + numberBars
					+ " (min 1/ max " + numberBars + ")");
			barHeights[i] = sc.nextInt();
			
			
			while (barHeights[i] < 1 || barHeights[i] > numberBars) { //if inout value does not meet requirements, execute the following
				System.out.println("Error, " + "Please re-enter the height of bar " + increaseNumber + " of " + numberBars);
				barHeights[i] = sc.nextInt();
				
			}
		}
		return barHeights;
		
	}

	private int[] createBlocks(Scanner sc) {
		System.out.println("Please enter number of blocks (min 1/max 12)");
		int numberBlocks = sc.nextInt();

			int blockHeights[] = new int [numberBlocks]; //creating a new array of integers
			
			for (int i = 0; i < numberBlocks; i++) { //checking conditions
				int increaseBlockNumber = (int) (i + 1);
				System.out.println("Please enter the height of block " + increaseBlockNumber + " of " + numberBlocks
						+ " (min 1/ max " + numberBlocks + ")");
				blockHeights[i] = sc.nextInt();
				
				while (blockHeights[i] < 1 || blockHeights[i] > numberBlocks) { //if conditions aren't met, execute the following
					System.out.println("Error, " + "Please re-enter the height of block " + increaseBlockNumber + " of " + numberBlocks);
					blockHeights[i] = sc.nextInt();
					
				}


			}
			
		return blockHeights;
	}

	// assignment part B methods implemented here
	}
	