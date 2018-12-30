/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room
{
    private boolean inside = false;
    public WinningRoom(int x, int y) {
        super(x, y);

    }

    @Override
    public String toString() {
        if (inside) {
            return "{X}";
        }
        return "{W}";
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        inside = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(x.getKillCount() == 3) {
            System.out.println("Congratulations you beat all the creatures and got into the UFO to go back home!");
            Runner.gameOff();
        }
        else {
            System.out.println("You must kill all the creatures before entering this room! You must leave right now!");
        }
    }
    @Override
    public void leaveRoom(Person x) {
        super.leaveRoom(x);
        occupant = null;
        inside = false;
    }
}
