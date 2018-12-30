/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Game;

import Board.Board;
import People.Person;
import Rooms.CreatureRoom;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {

    public static boolean gameOn = true;
    public static void main(String[] args)
    {

        Room[][] map = new Room[5][5];
        Board board = new Board(map);
        //Setup player 1 and the input scanner with introduction text
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Space Creatures! There are too many creatures that exist in this world! Get rid of these filthy creatures on the board!" + "\n" + "What might be your name?");
        String name = in.nextLine();
        Person player1 = new Person(name, 0, 0,100,0,1);
        System.out.println("Why hello, " + player1.getName()+". There are many space creatures lying around the board." + "\n" + "You must defeat all of them before entering the UFO to go back home!");
        board.build();
        System.out.println("The rooms on the board marked with a \"C\" have a space creature inside the room!" + "\n" + "Use \"Kick\", \"Throw a bat\", \"Fireball\", or \"Hydro pump\" to beat each space creature!" + "\n" + "You must beat all the space creatures before going into the room marked with a \"W\" to win the game!");
        map[0][0].enterRoom(player1);

        //Starts the main game loop while gameOn is true
        while(gameOn) {
            board.print();
            System.out.println(player1);
            System.out.println("Where would you like to move? (Choose N, S, E, W) or eat your food with B and view your inventory with I.");
            String move = in.nextLine();
            if (validMove(move, player1, map)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            }
            // Additional keys that can be pressed for the user to interact with
            if (move.equals("I") || move.equals("i")) {
                System.out.println("============INVENTORY============");
                System.out.println("-Bat");
                for (int i = 0; i < player1.getInventory().length; i++) {
                    if (player1.getInventory()[i] == null) {
                        System.out.println("-empty");
                    }
                    else {
                        System.out.println("-" + player1.getInventory()[i]);
                    }
                }
                System.out.println("=================================");
            }
            if (move.equals("B") || move.equals("b")) {
                for (int i = 0; i < player1.getInventory().length; i++) {
                    if (player1.getInventory()[i] != null && player1.getInventory()[i].equals("Food")) {
                        player1.health += 40;
                        player1.getInventory()[i] = null;
                        System.out.println("You ate some delicious food.");
                        break;
                    } else if (i == player1.getInventory().length - 1) {
                        System.out.println("Please choose a valid move.");
                    }
                }
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
            case "n":
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
            case "e":
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

            case "w":
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
