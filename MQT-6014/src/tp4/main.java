package tp4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class main {

  public static void main(String[] args) throws Exception {
    IGraphe g = Charger("src/tp4/rome99.gr");
    DeuxChemins deux = new DeuxChemins(g);
    System.out.println(deux.Recherche(1, 10));
    g.Retirer(g.TrouverArc(160, 159));
    System.out.println(deux.Recherche(1, 10));

  }

  public static IGraphe Charger(String nom_fichier) throws Exception {
    GrapheListe graphe = null;
    BufferedReader bufferedReader;
    String filePath = new File(nom_fichier).getAbsolutePath();
    FileReader fileReader = new FileReader(filePath);
    bufferedReader = new BufferedReader(fileReader);
    String line = bufferedReader.readLine();
    int nombreDeNoeuds = 0;

    while (line != null) {
      String[] lines = line.split(" ");
      if (lines[0].equals("c")) {

      } else if (lines[0].equals("p")) {
        nombreDeNoeuds = Integer.parseInt(lines[2]);
        graphe = new GrapheListe(nombreDeNoeuds, true);
      } else if (lines[0].equals("a")) {
        int source = Integer.parseInt(lines[1]);
        int destination = Integer.parseInt(lines[2]);
        int cout = Integer.parseInt(lines[3]);
        Arc arc = new Arc(source, destination, cout);
        graphe.Ajouter(arc);
        // System.out.println(graphe.NbArcs());
      }
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return graphe;
  }

}
