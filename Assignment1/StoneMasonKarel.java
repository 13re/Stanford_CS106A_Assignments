/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 * -----------------------------
 * PRE-CONDITION
 * Karel starts at 1st Ave & 1st Street, 
 * Facing east, w/ infinite # of beepers in bag
 * (also assuming Karel starts on the first column)
 * -----------------------------
 * Columns = 4 units aparts. 
 * End of columns = marked by wall after final column. 
 * Program should work for any # of columns. 
 * Top of column is marked by a wall, but not always same height. 
 * Some stones are already in place, do not place 2nd beeper on these. 
 * -----------------------------
 * POST-CONDITION
 * All columns filled. No missing stones.  
 * -----------------------------
 * STRATEGY
 * Fill first Column
 * 
 * Move to next column
 * Fill in missing column blocks
 * Repeat until hit right wall
 */ 

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		fillColumn();
		while (frontIsClear()) {
			moveToNextColumn();
			fillColumn();
		}
	}
	
/* Fills column, then returns to bottom of column facing east. 
 */
	private void fillColumn() {
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				putBeeper();
				move();
			}
		}
		if (beepersPresent()) {
			returnToBottom();
		} else {
			putBeeper();
			returnToBottom();
		}
	}
/* Returns Karel to the Bottom of the Column. 
 * Pre-condition: Karel is at the top of a filled column facing North.
 * Post-condition: Karel is at the Bottom of a filled Column facing East.
 * */
	private void returnToBottom() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
/* Moves Karel to the next column which is always 4 units away. 
 * */
	private void moveToNextColumn() {
		move();
		move();
		move();
		move();
	}
}
