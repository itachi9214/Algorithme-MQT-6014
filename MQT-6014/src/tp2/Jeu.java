package tp2;

import java.util.ArrayList;

public class Jeu {

  private static final int NB_BATEAUX = 4;
  private static final int DIM_X = 4;
  private static final int DIM_Y = 4;
  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 5;

  private ArrayList<Bateau> listOfBoat;

  public Jeu() {
    listOfBoat = new ArrayList<>();
    for (int i = MINIMUM; i < NB_BATEAUX; i++) {
      int randomNumberAbscissa = generateRandomNumber();
      int randomNumberOrdinate = generateRandomNumber();
      Bateau boat = new Bateau(randomNumberAbscissa, randomNumberOrdinate);
      listOfBoat.add(boat);
    }

  }

  private int generateRandomNumber() {
    return (int) (Math.random() * (MAXIMUM - MINIMUM));
  }

  public boolean tousCoules() {
    int numberOfBoatSunk = 0;
    for (int i = MINIMUM; i < listOfBoat.size(); i++) {
      if (listOfBoat.get(i).estCoule())
        numberOfBoatSunk++;
    }
    if (numberOfBoatSunk == NB_BATEAUX)
      return true;
    else
      return false;
  }

  public void demarrer() {
	int numberOfShot=0;
    int boatLeft = NB_BATEAUX;
    boolean noTouch;
    while (!tousCoules()) {
      noTouch = true;
      System.out.println("Bateau restant :" + boatLeft);
      System.out.println("Entrez l'abscisse ");
      int abscissa = Util.getNumber(MINIMUM, DIM_X);
      System.out.println("Entrez l'ordonnee ");
      int ordinate = Util.getNumber(MINIMUM, DIM_Y);
      for (int i = MINIMUM; i < NB_BATEAUX; i++) {
        if (listOfBoat.get(i).estTouche(abscissa, ordinate)) {
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
