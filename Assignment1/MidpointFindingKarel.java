/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 * -----------------------------
 * PRE-CONDITION
 * Karel starts at the bottom left facing right. 
 * World is empty, shape undefined. 
 * 
 * POST-CONDITION
 * Karel to be place beeper in a center spot of the bottom row.
 * No other beepers may be on the board. 
 * 
 * -----------------------------
 * STRATEGY
 * To find the mid point, have Karel move until his front 
 * is blocked by a wall or beeper, then place a beeper, 
 * turn around & repeat (as if he's closing the walls in on himself) 
 * until he is trapped between 2 beepers.
 * 
 * Then Karel will fill the last spot in the center with a beeper.
 * Then Karel will move & pick up all beepers on one side,
 * turn around & move till he sees a beeper, move past it, 
 * then clean up the other side. 
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run() {
		findCenter();
		cleanUp();
	}
/* ----------------------------------------
 * ----------------------------------------
 * ----------------------------------------
 * Karel finds the center by closing the 
 * walls (or beepers) in on himself
 * until he has no where left to go.
 * */
	private void findCenter() {
		putBeeper(); /*places 1st outer marker*/
		while (frontIsClear()) {
			move();
		}
		if (noBeepersPresent()) { /*in case the world is only 1-block wide*/
			putBeeper(); /*places 2nd outer marker*/
			moveInside();
		}
		while (noBeepersPresent()){ /*starts the sweep*/
			move();
			if (beepersPresent()) {
				moveInside();
				putBeeper();
				move();
			}
		}
	}
/*----------------------------------------
 * Moves Karel inside the beeper walls.
 * */
	private void moveInside() {
		turnAround();
		move();
	}
/*----------------------------------------
 *----------------------------------------
 * Removes all beepers except center. 
 * 	PRE-CONDITION__________________
 * 	bottom row is filled with beepers
 * 	with Karel one in-front of center beeper. 
 * 	POST-CONDITION__________________
 * 	only the beeper remaining 
 * 	is the middle one where Karel started.
 * */
	private void cleanUp() {
		if (frontIsBlocked()){ /*in case the world is only 1-3 blocks wide*/
			turnAround();
			if(frontIsClear()) { /*when 2-blocks wide*/
				move();
				if(frontIsClear()) { /*when 3-blocks wide*/
					move();	
					pickBeeper();
					turnAround();
					move();
					move();
				}
			pickBeeper();
			}
		} else { /*All other world sizes*/
			cleanFront();
			turnAround();
			while (noBeepersPresent()) {
				move(); /*moves onto center beeper*/
			}
			move(); /*moves in front of center beeeper*/
			cleanFront();
		}
	}
/*----------------------------------------
 * Removes all beepers in front of Karel
 * */
	
	private void cleanFront() {
		while (frontIsClear()) {
			pickBeeper();
			move();
		}
		pickBeeper();
	}
}
/*----------------------------------------
 * ----------------------------------------
 * ----------------------------------------
 * */
