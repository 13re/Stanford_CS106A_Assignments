/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 * 
 * Karel starts in the bottom left corner facing right. 
 * Karel needs to create a checkerboard pattern on any size world. 
 * 
 * STRATEGY 1
 * Drop a beeper every other step while zizagging to the top. 
 * Every time Karel moves East he should drop the same pattern.
 * 
 */


import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run() {
		if (frontIsBlocked()) {
			putBeeper();
			while(leftIsClear())
				fillLineWest();
				fillLineEast();
		}
		while (frontIsClear()) {
			if (leftIsClear()) {
				fillLineEast();
				fillLineWest();
			} else {
				fillLineEast();
			}
		}
	}
// Fills up any line zig-zagging East.
	private void fillLineEast() {
		if (noBeepersPresent()) { //in case 1 width world.
			putBeeper();
		}
			dashTheLine();
	}
// Checks how to start the line
// then fills the line zig-zagging West.
	private void fillLineWest() {
		turnLeft();
			if (leftIsClear()) { //in case world width=1
				if (beepersPresent()) {
					moveUpRightSide();
					move(); //we could only have this in 2+ width world
					if (noBeepersPresent()) { //in case 1 width world.
						putBeeper();
					}
						dashTheLine();
						moveUpRow();
				}else {
					moveUpRightSide();
					if (noBeepersPresent()) { //in case 1 width world.
						putBeeper();
					}
						dashTheLine();
						moveUpRow();
			}
		}
	}
//Fills the rest of a line every other step.
	private void dashTheLine() {
		while (frontIsClear()) {
			if (frontIsClear()) {
				move();
				if(frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
	}
// Moves up a row (on left) if there is one above to be filled.
	private void moveUpRow() {
		if (rightIsClear()) {
			turnRight();
			move();
			turnRight();
		}
	}
// Moves up one row on the right wall.
	private void moveUpRightSide() {
		move();
		turnLeft();
		
	}
}
