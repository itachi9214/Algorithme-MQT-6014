package tp2;

import java.util.Scanner;

public class Util {

  private static Scanner scanner;

  public static int getNumber(int minimum, int maximum) {
    int number;
    do {
      // System.out.println("Entrer un nombre valide :");
      scanner = new Scanner(System.in);
      number = scanner.nextInt();
    } while (number > minimum && number > maximum);
    return number;
  }

}
