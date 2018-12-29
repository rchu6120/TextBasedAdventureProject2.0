/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String Name;
    public int health;
    int xLoc, yLoc;
    public String[] inventory = new String[8];
    public int killcounter;
    public int dmg;


    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return Name;
    }

    public int getKillcounter(){
        return killcounter;
    }

    public int getDmg(){
        return dmg;
    }

    public String[] getInventory() {
        return inventory;
    }

    public Person (String Name, int xLoc, int yLoc, int health, int killcounter, int dmg)
    {
        this.Name = Name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.health = health;
        this.killcounter = killcounter;
        this.dmg = dmg;
    }

    @Override
    public String toString() {
        String statement = "";
        statement += Name + ':' + " Health = " + health;
        return statement;
    }
}
