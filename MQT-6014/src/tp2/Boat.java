package tp2;

public class Boat {

  private int abscissa;
  private int ordinate;
  private boolean statutBoat;

  public Boat(int abscissa, int ordinate) {
    super();
    this.abscissa = abscissa;
    this.ordinate = ordinate;
    this.statutBoat = false;
  }

  public int getAbscissa() {
    return abscissa;
  }

  public void setAbscissa(int abscissa) {
    this.abscissa = abscissa;
  }

  public int getOrdinate() {
    return ordinate;
  }

  public void setOrdinate(int ordinate) {
    this.ordinate = ordinate;
  }

  public boolean isSunk() {
    return statutBoat;
  }

  public void setStatutBoat(boolean statutBoat) {
    this.statutBoat = statutBoat;
  }

  public boolean isTouch(int abscissa, int ordinate) {
    if (isSunk() && (this.abscissa == abscissa && this.ordinate == ordinate)) {
      System.out.println("Bateau deja touché");
      return true;
    } else if (this.abscissa == abscissa && this.ordinate == ordinate) {
      setStatutBoat(true);
      return true;
    } else {
      return false;
    }
  }

}
