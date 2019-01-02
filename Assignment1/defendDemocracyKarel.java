/*
 * File: defendDemocracyKarel
 * --------------------------
 * Stepwise Refinement. 
 * --------------------------
 * Voting punch card. 
 * Karel's job is to move across the punch card ballot 
 * and make sure that no stray bits of the card remain 
 * in any of the ballot spaces in which the user has 
 * attempted to cast a vote. 
 * --------------------------
 * Any column where a center beeper is present 
 * must be assumed as a non-vote & left alone. 
 * Any column without a center beeper is a vote 
 * & must be cleaned of any additional beepers by karel. 
 * --------------------------
 * --------------------------
 * PRE-CONDITIONS: 
 * Single-row of rectangles appearing on even intersections
 * Ballot-size may vary (1-1,000+ rectangles) 
 * Begins 1-square to left of first rectangle 
 * Ends 1-square to right of last rectangle. 
 * Ballot rectangles = 1-width, 3-height
 * 
 * Karel begins 1-left of the first ballot rectangle 
 * facing the hole that gives access to the voting are along the center line of rectangles.
 * --------------------------
 * POST-CONDITIONS
 * Karel must finish execution facing east at the rightmost edge of the ballot. 
 * Every rectangle that originally had no center-beeper should now contain no beepers at all. 
 * --------------------------
 * --------------------------
 * Strategy,
 * Move across the board checking for holes every other step 
 * (on rectangles), clear all beepers in rectangles with 
 * center holes until the end wall is reached.
 */

import stanford.karel.*;
public class defendDemocracyKarel extends SuperKarel {
	
	public void run() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) { //if hole exists
				clearRectangle();
				move();
			}else {
				move();
				}
			}
		}
/*Clears the rectangle if a hole exists*/
	private void clearRectangle() {
		turnRight();
		move();
		if (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		move();
		if (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		turnLeft();
	}
			
}
