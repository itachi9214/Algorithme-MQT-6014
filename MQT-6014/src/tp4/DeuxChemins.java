package tp4;

// Cet objet permet de trouver le nombre de composantes connexes dans un graphe
public class DeuxChemins {
  IGraphe g;
  IFilePriorite file_priorite;
  int[] parent;
  int[] distance;

  public DeuxChemins(IGraphe gr) {
    distance = new int[gr.NbNoeuds()];
    parent = new int[gr.NbNoeuds()];
    g = gr;
    file_priorite = new TableauPrioriteSimple(gr.NbNoeuds());
  }

  private void Init() {
    file_priorite.Vider();
    for (int i = 0; i < g.NbNoeuds(); i++) {
      distance[i] = 999999;
      parent[i] = -1;
    }
  }

  // retourne deux chemins differents entre s et t
  public Chemin Recherche(int s, int t) {
    Chemin chemin = new Chemin();
    Init();
    parent[s] = -2;
    distance[s] = 0;
    file_priorite.Ajouter(s, t);
    while (!file_priorite.EstVide()) {
      int v = file_priorite.SupprimerMin();

      for (Arc a : g.Adjacents(v)) {
        if (distance[v] + a.cout < distance[a.vers]) {
          distance[a.vers] = distance[v] + a.cout;
          if (parent[a.vers] == -1)
            file_priorite.Ajouter(a.vers, distance[a.vers]);
          else
            file_priorite.Decroitre(a.vers, distance[a.vers]);
          parent[a.vers] = v;
        }
        if(parent[a.vers] >= 0 && g.Existe(a.vers, parent[a.vers])==true && (g.TrouverArc(a.vers, parent[a.vers])!=a && g.TrouverArc(a.vers, parent[a.vers])!=null) )
        	System.out.println(parent[a.vers]);
        
        }
      
        }
//    for(int i = 0; i<g.NbNoeuds();i++){
//        if(parent[i] >= 0){
//        	System.out.println(g.TrouverArc(i, parent[i]));
//        	
//        	//chemin.Ajouter(g.TrouverArc(a.vers, parent[a.vers]));
//
//      }

    //}
    return chemin;
  }
}
