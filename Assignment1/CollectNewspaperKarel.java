/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	// This is the first coding problem in Assignment#1. 
	public void run() {
		 move();
		 move();
		 turnRight();
		 move();
		 turnLeft();
		 move();
		 pickBeeper();
		 turn180();
		 move();
		 move();
		 move();
		 turnRight();
		 move();
		 turnRight(); 
		}
	// Method allows Karel to Turn Right.
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	// Method allows Karel to Turn Around 180 degrees.
	private void turn180() {
		turnLeft();
		turnLeft();
	}
	
}
