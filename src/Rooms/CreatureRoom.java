/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Rooms;

import Board.Board;
import Game.Runner;
import Items.Bat;
import Items.Key;
import Items.Meat;
import People.*;

import java.util.Scanner;

import static Game.Runner.mrcount;

public class CreatureRoom extends Room{
    private boolean inside = false;
    private boolean dead = false;

    public CreatureRoom(int x, int y){
        super(x,y);
    }

    @Override
    public String toString() {
        if(inside){
            return "[X]";
        }
        else if(dead){
            return "[?]";
        }
        else {
            return "[C]";
        }
    }

    public void enterRoom(Person x) {

        occupant = x;
        inside = true;
        if(dead){
            System.out.println("You enter a plain old room");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
        // ADD random creature generator
        int creaturetype = (int)(Math.random()*10);

        Creature creature = new Gorgon(100,"Gorgon",(int)(Math.random()*100)+75);
        if(creaturetype > 6) {
            creature = new Robot(100,"Robot",(int)(Math.random()*300)+100);
        }
        if(x.getKillcounter()+1 == mrcount){
            creature = new Alien(100,"Alien",(int)(Math.random()*400)+200);
        }

        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("A space creature appeared! Prepare to battle this imbecile!");
        System.out.println(creature);

        String health = "\nHEALTH:   ";
        String healthbar = "";
        int healthbarlength = 0;
        for(int i = 0; i < creature.getHealth(); i++){
            healthbar += "=";
            healthbarlength++;
        }
        int damage;
        int dealt = 0;

        Runner.gameOff();
        Scanner in2 = new Scanner(System.in);
        System.out.println(health + healthbar);

        while(dealt < healthbarlength){

            System.out.println("Type your attack move.");
            String input = in2.nextLine();

            if(input.toLowerCase().equals("kick")){
                damage = (int) (Math.random() * 10) + 1;
            }
            else if(input.toLowerCase().equals("throw a bat")){
                damage = (int) (Math.random() * 10) + 1;
            }
            else if(input.toLowerCase().equals("fireball")){
                damage = (int) (Math.random() * 11) + 10;
            }
            else if(input.toLowerCase().equals("hydro pump")) {
                damage = (int) (Math.random() * 11) + 10;
            }
            else {
                damage = 0;
                System.out.println("Please enter a valid move.");
            }
            dealt += damage;
            if (healthbar.length() - damage > 0) {
                healthbar = healthbar.substring(0, healthbar.length() - damage);
                System.out.println(creature);
                System.out.println(health + healthbar);
                if (damage >= 10) {
                    System.out.println("Super effective!");
                }
                System.out.println("You did " + damage + " damage!");
                creature.attack(x);
                if(x.getHealth() < 0){
                    break;
                }

            }
        }
        if(x.getHealth() < 0){
            System.out.println("GAME OVER.");
            System.out.println("You killed "+x.killcounter+" creatures.");

        }
        else {
            System.out.println("========================");
            System.out.println("\nYOU BEAT THE CREATURE!\n");

            if(x.getKillcounter()+1 == mrcount){
                Key key = new Key();
                key.addtoInventory(x);
                System.out.println("you got a key!");

            }
            if(creaturetype > 6){
                Bat bat = new Bat();
                bat.addtoInventory(x);
                System.out.println("you got a bat!\nATTACK UP!");
            }
            if(creaturetype <= 6){
                Meat meat = new Meat();
                meat.addtoInventory(x);
                System.out.println("you got some meat!\n");
            }

            System.out.println("========================");
            dead = true;
            Runner.gameOn = true;
            x.killcounter++;
        }


    }

    @Override
    public void leaveRoom(Person x) {
        super.leaveRoom(x);
        occupant = null;
        inside = false;
    }
}

