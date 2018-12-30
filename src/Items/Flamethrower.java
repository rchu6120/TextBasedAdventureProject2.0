package Items;

import People.Person;

public class Flamethrower implements Item {
    public void addToInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.setInventory(i, "Flamethrower");
                break;
            }
        }
    }
    @Override
    public String toString() {
        return "You found a flamethrower...it doesn't work on space creatures silly.";
    }
}
