package tp4;

public class Arc {
  public int de; // origine
  public int vers; // destination
  public int cout; // cout de l'arc
  // ajouter les champs desires selon l'application

  public Arc(int s, int t) {
    de = s;
    vers = t;
  }

  public Arc(int s, int t, int c) {
    de = s;
    vers = t;
    cout = c;
  }

  public String toString() {
    return de + "-" + vers;
  }
}
