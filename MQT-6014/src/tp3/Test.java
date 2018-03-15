package tp3;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

  public static void main(String[] args) {
    Operation op1 = new Operation(1, 2, 2);
    Operation op2 = new Operation(2, 3, 1);
    Operation op3 = new Operation(2, 3, 2);
    Operation op4 = new Operation(2, 3, 2);
    Operation op5 = new Operation(2, 3, 0);
    ArrayList<Operation> listOperation = new ArrayList<Operation>();
    listOperation.add(op5);
    listOperation.add(op2);
    listOperation.add(op1);
    listOperation.add(op4);
    listOperation.add(op3);

    Collections.sort(listOperation);

    for (int i = 0; i < listOperation.size(); i++)
      System.out.println(listOperation.get(i).toString());

  }

}
