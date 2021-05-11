package bullscows;

import java.util.Scanner;

public class Result {
    public void res() {
        Generator gen = new Generator();

        String key = gen.gen();



            if (!key.equals("-1")) System.out.println("Okay, let's start a game!");

        int turn = 1;

        do {
            if (key.equals("-1")){break;}
            int cow = 0;
            int bull = 0;
            // System.out.println(key.length());

            System.out.println("\nTurn " + turn + ":");
            Scanner scanner = new Scanner(System.in);
            String userKey = scanner.next();
            System.out.print("Grade: ");
            String[] arrKey = key.split("");
            String[] arrUserKey = userKey.split("");
            for (int i = 0; i < key.length(); i++) {
                if (arrKey[i].equals(arrUserKey[i])) {
                    bull++;
                }
            }
            for (int i = 0; i < arrKey.length; i++) {
                for (int j = 0; j < arrKey.length; j++) {
                    if (i != j) {
                        if (arrKey[i].equals(arrUserKey[j])) {
                            cow++;
                        }
                    }
                }
            }
            if (bull == 0 && cow == 0) {
                System.out.print("None");
            }
            if (bull > 0) {
                System.out.print(bull + " bull(s)");
            }
            if (bull > 0 && cow > 0) {
                System.out.print(" and ");
            }
            if (cow > 0) {
                System.out.print(cow + " cow(s)");
            }
            if (bull == key.length()) break;

            turn++;
        } while (true);
    }
}
