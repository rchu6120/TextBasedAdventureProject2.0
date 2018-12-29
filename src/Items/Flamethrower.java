package Items;

import People.Person;

public class Flamethrower {
    public void addtoInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.getInventory()[i] = "Flamethrower";
                break;
            }
        }
    }
    @Override
    public String toString() {
        return "You found a flamethrower...It doesn't work on speace creatures silly.";
    }
}
