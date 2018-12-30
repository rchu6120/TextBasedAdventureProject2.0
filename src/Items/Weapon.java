package Items;

import People.Person;

public class Weapon implements Item {
    public void addToInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.setInventory(i, "Weapon");
                break;
            }
        }
    }
    public String toString() {
        return "You found a weapon! Don't know who could've made such a vague name like \"weapon\" a part of this game.";
    }
}
