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

    public Creature(int health, String name){
        this.health = health;
        this.name = name.toUpperCase();
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public String getName() {
        return name;
    }

    public abstract String getImage();

    public void attack(Person person) {
        System.out.println("\nThe "+getName()+" attacks!");
        int creaturedmg = (int)(Math.random()* 10) + 5;
        System.out.println("The " + getName() + " dealt " +creaturedmg+" damage!\n");
        person.health -=  creaturedmg;
        System.out.println(person.getName() +": health = "+person.getHealth());
        if(person.getHealth() <= 0){
            System.out.println("YOU DIED!!!");
            Runner.gameOff();
        }
    }

    public String toString() {
        return getImage() + "\nNAME: " + getName();
    }

}
