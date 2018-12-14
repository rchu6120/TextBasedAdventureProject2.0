package Rooms;

import Game.Runner;
import People.Student;
import java.util.Scanner;

public class GymRoom extends Classroom {
    public GymRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Student s) {
        System.out.println("Welcome to Mr.Brutus's gym class! In here, we only LIFT.");
        System.out.println("Is it an eccentric movement or concentric movement if your muscle lengthens?");
        Scanner input = new Scanner(System.in);
        String statement = input.nextLine();
        System.out.println(getResponse(statement));
    }

    public String getResponse(String statement) {
        String response = "";

        if (findKeyword(statement, "Eccentric", 0) >= 0) {
            response = "I guess you're ready for some heavy lifting then! On a side note, now that you have went to all your classes, congratulations on making it to the end of your first day of high school! There are only so many more days left!";
        } else {
            response = "Man I'm going to have to train you for the rest of the year for not knowing this. On a side note, now that you have went to all your classes, congratulations on making it to the end of your first day of high school! There are only so many more days left!";
        }
        return response;
        Runner.gameOff();
    }

    public int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int psn = phrase.indexOf(goal, startPos);
        while (psn >= 0) {
            String before = " ", after = " ";
            if (psn > 0) {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length()) {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
                return psn;
            }
            psn = phrase.indexOf(goal, psn + 1);
        }
        return -1;
    }
}


