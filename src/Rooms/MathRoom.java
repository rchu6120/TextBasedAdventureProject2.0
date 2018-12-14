package Rooms;

import Game.Runner;
import People.Student;
import java.util.Scanner;

public class MathRoom extends Classroom {
    public MathRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Student s) {
        System.out.println("Welcome to Ms.Nielson's Geometry Math Class! In here, we learn about all kinds of shapes and proofs to these formulas! Let me ask you a question.");
        System.out.println("How many degrees are in a triangle??");
        Scanner input = new Scanner(System.in);
        String statement = input.nextLine();
        System.out.println(getResponse(statement));
    }

    public String getResponse(String statement) {
        String response = "";

        if (findKeyword(statement, "180", 0) >= 0) {
            response = "Great job! You're ready to explore all the different kinds of proofs in this class! Move on to your next class.";
        } else {
            response = "Hm...maybe we're going to have to refine your knowledge on shapes. You may leave.";
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


