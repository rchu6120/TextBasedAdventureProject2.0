package Items;

import People.Person;

public class Flashlight {
    public void addtoInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.getInventory()[i] = "Flashlight";
                break;
            }
        }
    }
    public String toString() {
        return "You found a flashlight! Good for exploring dark areas";
    }
}
