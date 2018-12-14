package Rooms;

import Game.Runner;
import People.Student;
import java.util.Scanner;

public class EnglishRoom extends Classroom {
    public EnglishRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Student s) {
        System.out.println("Welcome to Mr.Harris's English Freshman Composition English Class! You must be so excited to be here so let me ask you a question!");
        System.out.println("Who wrote the play \"Romeo and Juliet\"?");
        Scanner input = new Scanner(System.in);
        String statement = input.nextLine();
        System.out.println(getResponse(statement));
    }

    public String getResponse(String statement) {
        String response = "";

        if (findKeyword(statement, "Shakespeare", 0) >= 0) {
            response = "Nice job! That's all for now then. Go on to your next class.";
        } else {
            response = "Man we're gonna have a long year together. Go on to your next class.";
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


