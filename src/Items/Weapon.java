package Items;

import People.Person;

public class Weapon {
    public void addtoInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.getInventory()[i] = "Weapon";
                break;
            }
        }
    }
    public String toString() {
        return "Don't know who could've made such a vague name like \"weapon\" a part of this game.";
    }
}
