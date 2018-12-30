package Items;

import People.Person;

public class Pistol implements Item {
    public void addToInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.setInventory(i, "Pistol");
                break;
            }
        }
    }
    public String toString() {
        return "You found a pistol!";
    }
}
