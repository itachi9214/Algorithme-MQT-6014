package tp3;

import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
	  
	  Planification p1 = new Planification();
      p1.charger("/operations1.txt");
      p1.affecter();
      System.out.println(p1);

  }

}
