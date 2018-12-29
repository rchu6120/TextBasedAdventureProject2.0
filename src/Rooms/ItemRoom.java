package Rooms;

import Game.Runner;
import Items.*;
import People.Person;
import Rooms.Room;

public class ItemRoom extends Room {
    Item[] randomItems = {new Bomb(), new Flamethrower(), new Flashlight(), new Gun(), new Pistol(), new Weapon()};
    public ItemRoom(int x, int y) {
        super(x, y);
    }
    public void enterRoom(Person x) {
        if (!isDiscovered) {
            int item = (int) (Math.random() * randomItems.length);
            System.out.println(randomItems[item]);
        }
        else {
            System.out.println("You already found an item in this room.");
        }
    }
}

