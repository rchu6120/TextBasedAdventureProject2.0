/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package Items;

import People.Person;

public class Food implements Item {

    public void addToInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.setInventory(i, "Food");
                break;
            }
        }
    }
}
