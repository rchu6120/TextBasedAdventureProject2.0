/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Board;

import Rooms.CreatureRoom;
import Rooms.Room;
import Rooms.WinningRoom;

public class Board {
    private Room[][] map;
    private int area;
    public int creatureCount;

    public Board(Room[][] map) {
        this.map = map;
    }

    //Fills the board with normal rooms
    public void build(){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new Room(x, y);
                area++;
            }
        }

        //Create a random Winning room + makes sure it is not in the spawn location
        int x = (int) (Math.random() * map.length);
        int y = (int) (Math.random() * map.length);
        while (x == 0 && y == 0) {
            x = (int) (Math.random() * map.length);
            y = (int) (Math.random() * map.length);
        }
        map[x][y] = new WinningRoom(x, y);
        for (int i = 0; i < area; i+=10)
        {
            //Create a random Creature room.
            int x2 = (int) (Math.random() * map.length);
            int y2 = (int) (Math.random() * map.length);
            while ((x2 == 0 && y2 == 0) || (x2 == x && y2 == y)) {
                x2 = (int) (Math.random() * map.length);
                y2 = (int) (Math.random() * map.length);
            }
            map[x2][y2] = new CreatureRoom(x2, y2);
            creatureCount++;
        }
    }

    //Prints the board out
    public void print() {
        String str = "";
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                str += map[x][y];
            }
            str += "\n";
        }
        System.out.println(str);
    }

    public int getCreatureCount(){
        return creatureCount;
    }

}
