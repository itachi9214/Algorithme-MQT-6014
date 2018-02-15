package tp1;

public class Salle {

  private int no_salle;
  private int nb_operations;
  private int duree_totale;
  private int capacite_heure;

  public Salle(int no_salle, int nb_operations, int capacite_heure) {
    this.no_salle = no_salle;
    this.nb_operations = nb_operations;
    this.capacite_heure = capacite_heure;
    this.duree_totale = 0;
  }

  public String toString() {
    if (duree_totale > capacite_heure)
      return "Erreur capacite doit etre inferieure a la duree totale";
    else
      return "Salle [no_salle=" + no_salle + ", nb_operations=" + nb_operations + ", duree_totale="
          + duree_totale + ", capacite_heure=" + capacite_heure + "]";
  }

  public void assigner(Patient p) {
    if (p.getNo_salle() != -1) {
      System.out.println("Erreur:le numero de la salle du patient est incorrect");
    } else {
      p.setNo_salle(no_salle);
      duree_totale++;
    }
  }

}
