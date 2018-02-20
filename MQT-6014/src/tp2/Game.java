package tp2;

import java.util.ArrayList;

public class Game {

  private static final int NUMBER_OF_BOAT = 4;
  private static final int DIMENSION_ABSCISSA = 4;
  private static final int DIMENSION_ORDINATE = 4;
  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 5;

  private ArrayList<Boat> listOfBoat;

  public Game() {
    listOfBoat = new ArrayList<>();
    for (int i = MINIMUM; i < NUMBER_OF_BOAT; i++) {
      int randomNumberAbscissa = generateRandomNumber();
      int randomNumberOrdinate = generateRandomNumber();
      Boat boat = new Boat(randomNumberAbscissa, randomNumberOrdinate);
      listOfBoat.add(boat);
    }

  }

  private int generateRandomNumber() {
    return (int) (Math.random() * (MAXIMUM - MINIMUM));
  }

  public boolean allSunk() {
    int numberOfBoatSunk = 0;
    for (int i = MINIMUM; i < listOfBoat.size(); i++) {
      if (listOfBoat.get(i).isSunk())
        numberOfBoatSunk++;
    }
    if (numberOfBoatSunk == NUMBER_OF_BOAT)
      return true;
    else
      return false;
  }

  public void startGame() {
	int numberOfShot=0;
    int boatLeft = NUMBER_OF_BOAT;
    boolean noTouch;
    while (!allSunk()) {
      noTouch = true;
      System.out.println("Bateau restant :" + boatLeft);
      System.out.println("Entrez l'abscisse ");
      int abscissa = Util.getNumber(MINIMUM, DIMENSION_ABSCISSA);
      System.out.println("Entrez l'ordonnee ");
      int ordinate = Util.getNumber(MINIMUM, DIMENSION_ORDINATE);
      for (int i = MINIMUM; i < NUMBER_OF_BOAT; i++) {
        if (listOfBoat.get(i).isTouch(abscissa, ordinate)) {
          boatLeft--;
          noTouch = false;
          System.out.println("Bateau touché");
        }
      }
      numberOfShot++;
      if (noTouch)
        System.out.println("Aucun bateau touché ");
    }
    System.out.println("Félicitation Vous avez gagné en "+numberOfShot+" coups");

  }
}
