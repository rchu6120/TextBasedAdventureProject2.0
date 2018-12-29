/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Rooms;

import Board.Board;
import Game.Runner;
import Items.Food;
import People.*;

import java.util.Scanner;

import static Game.Runner.creaturecount;

public class CreatureRoom extends Room {
    private boolean inside = false;
    private boolean dead = false;

    public CreatureRoom(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        if (inside) {
            return "[X]";
        } else if (dead) {
            return "[ ]";
        } else {
            return "[C]";
        }
    }

    public void enterRoom(Person x) {

        occupant = x;
        inside = true;
        if (dead) {
            System.out.println("You enter a plain old room");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
        //A random creature generator
        int creaturetype = (int) (Math.random() * 30) + 1;
        if (creaturetype <= 30 && creaturetype > 20) {
            Creature creature = new Gorgon((int) (Math.random() * 20) + 50, "Gorgon");
        }
        if (creaturetype <= 20 && creaturetype > 10) {
            Creature creature = new Robot((int) (Math.random() * 20) + 50, "Robot");
        }
        else {
            Creature creature = new Alien((int) (Math.random() * 20) + 50, "Alien)";
        }

            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            System.out.println("A space creature appeared! Prepare to battle this imbecile!");
            System.out.println(creature);

            String health = "HEALTH: ";
            int damage;
            int dealt = 0;

            Runner.gameOff();
            Scanner in2 = new Scanner(System.in);
            System.out.println(health + creature.getHealth());
            String input;

            while (dealt < creature.getHealth()) {

                System.out.println("Type your attack move.");
                input = in2.nextLine();

                if (input.toLowerCase().equals("kick")) {
                    damage = (int) (Math.random() * 10) + 1;
                } else if (input.toLowerCase().equals("throw a bat")) {
                    damage = (int) (Math.random() * 10) + 1;
                } else if (input.toLowerCase().equals("fireball")) {
                    damage = (int) (Math.random() * 11) + 10;
                } else if (input.toLowerCase().equals("hydro pump")) {
                    damage = (int) (Math.random() * 11) + 10;
                } else {
                    damage = 0;
                    System.out.println("Please enter a valid move.");
                }
                dealt += damage;
                if (creature.getHealth() - damage > 0) {
                    creature.setHealth(creature.getHealth() - damage);
                    System.out.println(creature);
                    System.out.println(health + creature.getHealth());
                    if (damage >= 10) {
                        System.out.println("Super effective!");
                    }
                    System.out.println("You did " + damage + " damage!");
                    creature.attack(x);
                    if (x.getHealth() < 0) {
                        break;
                    }
                }
            }
            if (x.getHealth() < 0) {
                System.out.println("GAME OVER");
                System.out.println("You killed " + x.killcounter + " creatures.");

            } else {
                System.out.println("\nYOU BEAT THE CREATURE!\n");

                if (creaturetype >= 0) {
                    Food food = new Food();
                    food.addtoInventory(x);
                    System.out.println("You got some delicious food!\n");
                }

                System.out.println("=================================");
                dead = true;
                Runner.gameOn = true;
                x.killcounter++;
            }
        }

        @Override
        public void leaveRoom(Person x){
            super.leaveRoom(x);
            occupant = null;
            inside = false;
        }
    }


