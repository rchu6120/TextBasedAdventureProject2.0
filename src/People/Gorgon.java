/**
 * This version:
 * @author Ricky Chu
 * @version December 2018
 */
package People;

public class Gorgon extends Creature {
    public Gorgon(int health, String name) {
        super(health, name);
    }

    public String getImage() {
        return "             ,--.\n" +
        "          ,--.  .--,`) )  .--,\n" +
        "       .--,`) \\( (` /,--./ (`\n" +
        "      ( ( ,--.  ) )\\ /`) ).--,-.\n" +
        "       ;.__`) )/ /) ) ( (( (`_) )\n" +
        "      ( (  / /( (.' ''-.) )) )__.'-,\n" +
        "     _,--.( ( /`         `,/ ,--,) )\n" +
        "    ( (``) \\,` ==.    .==  \\( (`,-;\n" +
        "     ;-,( (_) ~6~ \\  / ~6~ (_) )_) )\n" +
        "    ( (_ \\_ (      )(      )__/___.'\n" +
        "    '.__,-,\\ \\     ''     /\\ ,-.\n" +
        "       ( (_/ /\\    __    /\\ \\_) )\n" +
        "        '._.'  \\  \\__/  /  '._.'\n" +
        "            .--`\\      /`--.\n" +
        "                 '----' \n";
    }
}
