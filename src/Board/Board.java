package Board;

import Rooms.Room;

public class Board {
    private Room[][] School = new Room[5][5];
    public Board(Room[][] School) {
        this.School = School;
    }
    public void fillRooms() {
        for (int x = 0; x < School.length; x++)
        {
            for (int y = 0; y < School[x].length; y++)
            {
                School[x][y] = new Room(x,y);
            }
        }
    }
    public String toString() {
        String school = "";
        for (int i = 0; i < School.length; i++) {
            String room = "";
            for (int j = 0; j < School[i].length; j++) {
                room += this.School[i][j].toString();
            }
            school += room + "\n";
        }
        return school;
    }
}
