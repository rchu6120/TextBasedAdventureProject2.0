/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package People;

public class Alien extends Creature {

    public Alien(int health, String name, int strength) {
        super(health, name, strength);
    }

    @Override
    public String getImage() {
        return "  \n" +
                "       .-'''''-.       .-''''-.\n" +
                "      /        \\      /        \\\n" +
                "     /_        _\\    /_        _\\\n" +
                "    // \\      / \\\\  // \\      / \\\\\n" +
                "    |\\__\\    /__/|  |\\__\\    /__/|\n" +
                "     \\    ||    /    \\    ||    /\n" +
                "      \\        /      \\        /\n" +
                "       \\  __  /        \\  __  / \n" +
                "        '.__.'          '.__.'\n" +
                "         |  |            |  |\n" +
                "         |  |            |  |\n";
    }
}