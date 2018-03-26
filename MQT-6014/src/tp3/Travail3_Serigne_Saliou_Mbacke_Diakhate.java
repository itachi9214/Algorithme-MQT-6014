package tp3;

import java.io.IOException;

public class Travail3_Serigne_Saliou_Mbacke_Diakhate {

  public static void main(String[] args) throws IOException {

    Planification p1 = new Planification();
    p1.charger("src/tp3/operations2.txt");

    p1.affecter();
  
    System.out.println(p1.toString());

  }

}
