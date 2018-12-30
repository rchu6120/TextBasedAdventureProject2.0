package Rooms;

import Game.Runner;
import Items.*;
import People.Person;
import Rooms.Room;

public class ItemRoom extends Room {
    boolean inside = false;
    boolean isDiscovered = false;

    public String toString() {
        if(inside){
            return "[X]";
        }
        if (isDiscovered) {
            return "[ ]";
        }
        else {
            return "[?]";
        }
    }

    Item[] randomItems = {new Bomb(), new Flamethrower(), new Flashlight(), new Gun(), new Pistol(), new Weapon()};
    public ItemRoom(int x, int y) {
        super(x, y);
    }
    public void enterRoom(Person x) {
        occupant = x;
        if (!isDiscovered) {
            int item = (int) (Math.random() * randomItems.length);
            System.out.println(randomItems[item]);
            randomItems[item].addToInventory(x);
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
        else {
            System.out.println("You already entered this room and found an item.");
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
    }

    public void leaveRoom(Person x)
    {
        occupant = null;
        inside = false;
        isDiscovered = true;
    }
}

