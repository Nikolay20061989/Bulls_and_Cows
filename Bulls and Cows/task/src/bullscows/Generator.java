package bullscows;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    public String gen() {
        String[] codeAll = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String key = "";
        int size = 0;
        int number = 0;
        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);

        Random r = new Random();
        try {
            size = scanner.nextInt();
            System.out.println("Input the number of possible symbols in the code:");
            number = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Error:this isn't a valid number.");
            return "-1";
        }
        int[] secretCodeAll = new int[1000];
        String strArr[] = new String[1000];
        String secret = null;
        boolean bol;


        if (size > number) {
            System.out.println("Error: it's not possible to generate a code with a length of " + size + " with " + number + " unique symbols.");
            secret = "-1";
        } else if (size == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + size + " with " + number + " unique symbols.");
            secret = "-1";
        } else {
            try {


                printSecret(size, number, codeAll);
            } catch (Exception ee) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return "-1";
            }
            do {
                for (int i = 0; i < secretCodeAll.length; i++) {
                    secretCodeAll[i] = r.nextInt(number);
                }
                for (int i = 0; i < secretCodeAll.length; i++) {
                    for (int j = 0; j < secretCodeAll.length; j++) {
                        if (i != j && secretCodeAll[i] == secretCodeAll[j]) {
                            secretCodeAll[j] = -1;
                        }
                    }
                }

                for (int i = 0; i < secretCodeAll.length; i++) {
                    //System.out.print(secretCodeAll[i]+" ");
                    if (secretCodeAll[i] != -1) {
                        //strArr[i] = new String(String.valueOf(secretCodeAll[i]));
                        strArr[i] = new String(String.valueOf(codeAll[secretCodeAll[i]]));
                    } else strArr[i] = "x";
                }
                String strT = String.join("x", strArr).replace("x", "");
                //System.out.println("\n"+strT);
                secret = strT.substring(0, size);
                bol = secret.startsWith("0");
                //  System.out.println("\n"+secret);      // печатает код
            } while (bol);


        }
        return secret;
    }

    public void printSecret(int size, int number, String arr[]) {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print(" (0-");
        if (number <= 10) System.out.print(number - 1 + ").");
        if (number == 11) System.out.print("9, a).");
        if (number > 11) System.out.print("9, a-" + arr[number - 1] + ").");
        System.out.println();

    }
}