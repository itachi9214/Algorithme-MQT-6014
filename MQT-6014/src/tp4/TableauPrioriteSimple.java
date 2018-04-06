package tp4;

public class TableauPrioriteSimple implements IFilePriorite {
  int[] valeurs;

  public TableauPrioriteSimple(int n) {
    valeurs = new int[n];
    for (int i = 0; i < n; i++)
      valeurs[i] = Integer.MAX_VALUE;
  }

  public void Ajouter(int cle, int valeur) {
    valeurs[cle] = Math.min(valeurs[cle], valeur);
  }

  public int SupprimerMin() {
    int index_min = -1;
    int valeur_min = Integer.MAX_VALUE;
    for (int i = 0; i < valeurs.length; i++)
      if (valeur_min > valeurs[i]) {
        valeur_min = valeurs[i];
        index_min = i;
      }

    valeurs[index_min] = Integer.MAX_VALUE;
    return index_min;
  }

  public void Decroitre(int cle, int valeur) {
    valeurs[cle] = Math.min(valeurs[cle], valeur);
  }

  public boolean EstVide() {
    for (int i = 0; i < valeurs.length; i++)
      if (valeurs[i] < Integer.MAX_VALUE)
        return false;
    return true;
  }

  public void Vider() {
    for (int i = 0; i < valeurs.length; i++)
      valeurs[i] = Integer.MAX_VALUE;
  }

  public static void main(String[] args) {
    TableauPrioriteSimple tp = new TableauPrioriteSimple(10);
    tp.Ajouter(0, 10);
    tp.Ajouter(1, 2);
    tp.Ajouter(2, 3);
    tp.Ajouter(4, 5);
    tp.Ajouter(5, 8);

    System.out.println(tp.SupprimerMin());

    tp.Ajouter(1, 0);
    tp.Ajouter(2, 1);
    while (!tp.EstVide())
      System.out.println(tp.SupprimerMin());

    tp.Ajouter(1, 1);
    tp.Ajouter(6, 5);
    tp.Ajouter(7, 3);
    tp.Ajouter(8, 1);

    while (!tp.EstVide())
      System.out.println(tp.SupprimerMin());
  }
}
