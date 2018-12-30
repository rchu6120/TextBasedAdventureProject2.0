/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Board;

import Rooms.CreatureRoom;
import Rooms.Room;
import Rooms.WinningRoom;
import Rooms.ItemRoom;

enum PossibleRooms {
    WinningRoom, CreatureRoom, ItemRoom, Room;
}

public class Board {
    private Room[][] map;
    public int creatureCount = 3;

    public Board(Room[][] map) {
        this.map = map;
    }

    public int getRandomRoomPosition() {
        int randomNum = (int) (Math.random() * 100);
        if (0 <= randomNum && randomNum <= 5) {
            return 0;
        }
        if (6 <= randomNum && randomNum <= 20) {
            return 1;
        }
        if (21 <= randomNum && randomNum <= 30) {
            return 2;
        }
        return 3;

    }

    //Fills the board with normal rooms
    public void build(){
        int x, y;
        int winningRooms = 1;
        int creatureRooms = 3;
        int itemRooms = 6;
        int regularRooms = 14;

        PossibleRooms[] gridRooms = new PossibleRooms[4];
        gridRooms[0] = PossibleRooms.WinningRoom;
        gridRooms[1] = PossibleRooms.ItemRoom;
        gridRooms[2] = PossibleRooms.CreatureRoom;
        gridRooms[3] = PossibleRooms.Room;

        PossibleRooms chosenRoom;

        for (x = 0; x < map.length; x++) {
            for (y = 0; y < map[x].length; y++) {
                // Starting room is always a regular room
                if (x == 0 && y == 0) {
                    map[x][y] = new Room(x, y);
                } else {
                    // Otherwise randomly assign a room to the map position
                    do {
                        chosenRoom = gridRooms[getRandomRoomPosition()];
                        if (chosenRoom == PossibleRooms.WinningRoom && winningRooms != 0) {
                            winningRooms -= 1;
                            map[x][y] = new WinningRoom(x, y);
                        }
                        if (chosenRoom == PossibleRooms.CreatureRoom && creatureRooms != 0) {
                            creatureRooms -= 1;
                            map[x][y] = new CreatureRoom(x, y);
                        }
                        if (chosenRoom == PossibleRooms.ItemRoom && itemRooms != 0) {
                            itemRooms -= 1;
                            map[x][y] = new ItemRoom(x, y);
                        }
                        if (chosenRoom == PossibleRooms.Room && regularRooms != 0) {
                            regularRooms -= 1;
                            map[x][y] = new Room(x, y);
                        }
                    } while (map[x][y] == null);
                }
            }
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
