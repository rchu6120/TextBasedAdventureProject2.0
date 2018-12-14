package Rooms;

import Game.Runner;
import People.Student;
import java.util.Scanner;

public class ScienceRoom extends Classroom {
    public ScienceRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Student s) {
        System.out.println("Welcome to Mr.Watson's Biology Science Class! You will be exploring all sorts of living environments and understanding the reasoning behind it. Let me ask you a question first!");
        System.out.println("What type of cells help carry oxygen from the lungs to the rest of the body?");
        Scanner input = new Scanner(System.in);
        String statement = input.nextLine();
        System.out.println(getResponse(statement));
    }

    public String getResponse(String statement) {
        String response = "";

        if (findKeyword(statement, "Blood", 0) >= 0) {
            response = "Awesome! This is a great start to our unit as we will understand how the human body works!";
        } else {
            response = "Are you kidding me? You don't know Shakespeare? Get out of this class right now!";
        }
        return response;
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


