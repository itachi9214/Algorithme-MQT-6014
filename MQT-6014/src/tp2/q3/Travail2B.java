package tp2.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Travail2B {

  private static final int INDEX_FIRST_ELEMENT = 0;

  public static void main(String[] args) {
    ArrayList<Integer> arraylist = new ArrayList<>();
    arraylist.add(1);
    arraylist.add(2);
    arraylist.add(-3);
    arraylist.add(4);
    arraylist.add(-2000);
    arraylist.add(-5000);
    arraylist.add(-11);
    arraylist.add(-100);
    arraylist.add(1);
    arraylist.add(1);
    arraylist.add(1);
    System.out.println(returnMinValue(arraylist));

  }

  private static int minValue(List<Integer> table) {
    Collections.sort(table);
    return table.get(INDEX_FIRST_ELEMENT);
  }

  private static List<Integer> extractFirstSubList(List<Integer> table) {
    List<Integer> firstSubList;
    if (table.size() % 2 == 0)
      firstSubList = table.subList(0, table.size() / 2);
    else
      firstSubList = table.subList(0, ((table.size() / 2) + 1));
    return firstSubList;
  }

  private static List<Integer> extractSecondSubList(List<Integer> table) {
    List<Integer> secondSubList = table.subList(table.size() / 2, table.size());
    if (table.size() % 2 == 0)
      secondSubList = table.subList(table.size() / 2, table.size());
    else
      secondSubList = table.subList(((table.size() / 2) + 1), table.size());
    return secondSubList;

  }

  private static int returnMinValue(List<Integer> table) {
    if (table.size() <= 2)
      return minValue(table);
    List<Integer> firstList = extractFirstSubList(table);
    List<Integer> secondList = extractSecondSubList(table);
    int elementValueRight = minValue(firstList);
    int elementValueLeft = minValue(secondList);
    if (elementValueRight < elementValueLeft)
      return returnMinValue(firstList);
    else
      return returnMinValue(secondList);
  }
}
