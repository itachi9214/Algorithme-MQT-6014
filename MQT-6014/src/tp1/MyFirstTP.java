package tp1;

public class MyFirstTP {

  public static void main(String[] args) {

    // code pour appeler la fonction d)
    double a = 2.3, b = 5.2, c = 7.3;
    estimateNumber(a, b, c);

    // code pour appeler la fonction e)
    double n1 = 13, n2 = 27, n3 = 53, n4 = 28;
    System.out.println(maxValue(n1, n2, n3, n4));

    // code pour appeler la fonction f)
    int nf = 10;

    // code pour appeler la fonction g)
    int g_n = 25;

  }

  private static int estimateCeiling(double number) {
    int wholeNumber = (int) number;
    if (wholeNumber == number)
      return wholeNumber;
    else if (number < 0)
      return wholeNumber;
    else
      return wholeNumber + 1;
  }

  private static int estimateFloor(double number) {
    int wholeNumber = (int) number;
    if (wholeNumber == number)
      return wholeNumber;
    else if (number < 0)
      return wholeNumber - 1;
    else
      return wholeNumber;
  }

  private static int estimateRound(double number) {
    return (int) number;
  }

  private static void estimateNumber(double ceiling, double floor, double round) {
    int ceilingValue = estimateCeiling(ceiling);
    int floorValue = estimateFloor(floor);
    int roundValue = estimateRound(round);
    int resultOfMultiplication = ceilingValue * floorValue * roundValue;

    System.out.println("Plafond = " + ceilingValue);
    System.out.println("Plancher = " + floorValue);
    System.out.println("Arrondi = " + roundValue);
    System.out.println("Le résultat du produit est égal à :" + resultOfMultiplication);
  }

  private static double maxValue(double value1, double value2, double value3, double value4) {
    double max = 0;
    double table[] = { value1, value2, value3, value4 };

    for (int i = 0; i < table.length; i++) {
      if (max >= table[i])
        max = max;
      else
        max = table[i];
    }

    return max;
  }

}
