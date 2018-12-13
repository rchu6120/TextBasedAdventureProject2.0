package Board;

import Rooms.Classroom;

public class Board {
    private Room[][] rooms;
    private int floorLevel;

    public Board(Room[][] room, int floorLevel) {
        this.rooms = room;
        this.floorLevel = floorLevel;
    }

    public Board(int floorLevel, int length, int width) {
        this.floorLevel = floorLevel;
        this.rooms = new Room[length][width];
        fillRooms();
    }

    public void fillRooms() {
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                rooms[x][y] = new Room(x, y);
            }
        }



        //Create the school classrooms.
        int EngX = (int) (Math.random() * rooms.length);
        int EngY = (int) (Math.random() * rooms.length);
        this.rooms[EngX][EngY] = new EnglishRoom(EngX, EngY);

        int MathX = (int) (Math.random() * rooms.length);
        int MathY = (int) (Math.random() * rooms.length);
        this.rooms[MathX][MathY] = new MathRoom(MathX, MathY);

        int SocX = (int) (Math.random() * rooms.length);
        int SocY = (int) (Math.random() * rooms.length);
        this.rooms[SocX][SocY] = new SocialStudiesRoom(SocX, SocY);

        int SciX = (int) (Math.random() * rooms.length);
        int SciY = (int) (Math.random() * rooms.length);
        this.rooms[SciX][SciY] = new ScienceRoom(SciX, SciY);

        int GymX = (int) (Math.random() * rooms.length);
        int GymY = (int) (Math.random() * rooms.length);
        this.rooms[MathX][MathY] = new GymRoom(GymX, GymY);
    }

    public String toString() {
        String school = "";
        for (int i = 0; i < rooms.length; i++) {
            String room = "";
            for (int j = 0; j < rooms[i].length; j++) {
                room += this.rooms[i][j].toString();
            }
            school += room + "\n";
        }
        return school;
    }
}
