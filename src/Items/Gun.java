/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Items;

import People.Person;

public class Gun implements Item{

    public void addToInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.setInventory(i, "Gun");
                break;
            }
        }
    }
    public String toString() {
        return "You found a gun! As if they had any effect on space creatures...";
    }
}
