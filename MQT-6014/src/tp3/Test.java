package tp3;

import java.io.File;
import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
	  
	  Planification p1 = new Planification();
      p1.charger("C:/Users/SSDIA3/Desktop/TP3/MQT-6014-H18_Travail 3/operations2.txt");
	  //File fichi = new File("");
	  //System.out.println(fichi.exists());
     p1.affecter();
     System.out.println(p1.toString());

  }

}
