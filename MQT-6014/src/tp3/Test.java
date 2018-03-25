package tp3;

import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {

    Planification p1 = new Planification();
    p1.charger("src/tp3/operations1.txt");

    // System.out.println(fichi.exists());
    p1.affecter();
    // Operation o1 = new Operation(1, 9, 3);
    // Operation o2 = new Operation(2, 1, 1);
    //
    // s.ajouter(o2);
    // s.ajouter(o1);
    // System.out.println(s.getEsperance());

    System.out.println(p1.toString());

  }

}
