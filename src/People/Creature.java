/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package People;

import Game.Runner;

public abstract class Creature {
    private int health;
    private String name;
    private int strength;

    public Creature(int health, String name, int strength){
        this.health = health;
        this.name = name.toUpperCase();
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public abstract String getImage();

    public void attack(Person person) {
        System.out.println("\nThe "+getName()+" attacks!");
        int monsterdmg = (int)(Math.random()*(getStrength()/10));
        System.out.println("It deals "+monsterdmg+" damage!\n");
        person.health -=  monsterdmg;
        System.out.println(person.getName() +": health = "+person.getHealth());
        if(person.getHealth() <= 0){
            System.out.println("YOU DIED!!!");
            Runner.gameOff();
        }
    }

    public String toString() {
        return getImage() + "\nNAME: " + getName()+  "\nSTRENGTH: "+getStrength();
    }

}
