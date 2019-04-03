/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Rooms;

import Items.Weapon;
import People.Person;

public class Room {
    Person occupant;
    int xLoc, yLoc;
    boolean inside = false;
    boolean isDiscovered = false;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }
    public String toString() {
        if(inside){
            return "[X]";
        }
        if(isDiscovered) {
            return "[ ]";
        }
        else {
            return "[?]";
        }
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x) {
        if (isDiscovered) {
            System.out.println("You already entered this room.");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        } else {
            System.out.println("You enter a plain old room.");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
        inside = false;
        isDiscovered = true;
    }
}

