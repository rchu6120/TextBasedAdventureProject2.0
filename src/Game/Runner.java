package Game;

import People.Student;
import Rooms.Room;
import Rooms.WinningRoom;
import Board.Board;
import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        System.out.print("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼███\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼███████\n" +
                        "┼┼┼┼┼┼┼┼┼┼██████████████\n" +
                        "┼┼┼┼┼┼┼████████████████████\n" +
                        "┼┼┼┼██████████████████████████\n" +
                        "┼████████████████████████████████\n" +
                        "██████████████████████████████████\n" +
                        "┼████████████████████████████████\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼████████████████████████████████\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼████████████████████████████████\n" +
                        "┼████████████████████████████████\n" +
                        "┼████████████████████████████████\n" +
                        "┼█░░░░██░░░░██████████░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░█▒▒▒▒▒▒▒▒█░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░█▒▒▒▒▒▒▒▒█░░░░██░░░░█\n" +
                        "┼█████████████▒▒▒░░▒▒▒████████████\n" +
                        "┼█░░░░██░░░░█▒▒▒▒▒▒▒▒█░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░█▒▒▒▒▒▒▒▒█░░░░██░░░░█\n" +
                        "┼█░░░░██░░░░█▒▒▒▒▒▒▒▒█░░░░██░░░░█\n" +
                        "┼█████████████▒▒▒▒▒▒▒▒████████████\n" +
                        "┼█████████████▒▒▒▒▒▒▒▒████████████\n" +
                        "┼████████████▓▓▓▓▓▓▓▓▓▓████████████\n" +
                        "████████████▓▓▓▓▓▓▓▓▓▓▓████████████\n" +
                        "███████████▓▓▓▓▓▓▓▓▓▓▓▓▓███████████\n");
        System.out.println("Why hello freshman! I can see that it is your first day of high school and you are lost in such a big school like this! First off what might be your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello " + name + ", if I remember correctly, you were already given a program card with all your rooms listed on it. Try not to enter the wrong classrooms");
        System.out.println("or else there will be consequences! If you don't remember what your program card looks like, here is a picture of what it looks like");
        System.out.println();
        System.out.println("Each room is listed as follows:" + "\n" + "Eng FRESHMAN COMPOSITION Rm 35" + "\n" + "Math GEOMETRY Rm 29" + "Soc Studies GLOBAL HISTORY Rm 87" + "\n" + "");
        Room[][] building = new Room[5][5];

        //Fill the school with normal rooms
        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new WinningRoom(x, y);

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Welcome to your first day of school! Try to find all your classrooms and avoid walking into the wrong room."  );
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

            }
            else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "w":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "d":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "a":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}