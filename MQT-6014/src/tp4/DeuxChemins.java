package tp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Cet objet permet de trouver le nombre de composantes connexes dans un graphe
public class DeuxChemins {
  IGraphe g;
  IFilePriorite file_priorite;
  int[] parent;
  int[] parent2;
  int[] distance;
  int[] distance2;

  public DeuxChemins(IGraphe gr) {
    distance = new int[gr.NbNoeuds()];
    distance2 = new int[gr.NbNoeuds()];
    parent = new int[gr.NbNoeuds()];
    parent2 = new int[gr.NbNoeuds()];
    g = gr;
    file_priorite = new TableauPrioriteSimple(gr.NbNoeuds());
  }

  private void Init() {
    file_priorite.Vider();
    for (int i = 0; i < g.NbNoeuds(); i++) {
      distance[i] = 999999;
      distance2[i] = 999999;
      parent[i] = -1;
      parent2[i] = -1;
    }
  }

  // retourne deux chemins differents entre s et t
  public ArrayList<Chemin> Recherche(int s, int t) {
	  double cout_total = 0 ;
	  //PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>();
	  ArrayList<Chemin> path = new ArrayList<Chemin>();
	  Chemin chemin = new Chemin();
    Init();
    parent[s] = -2;
    parent2[s] = -2;
    distance[s] = 0;
    distance2[s] = 0;
   // file_priorite.Ajouter(s,0);
    file_priorite.Ajouter(s, 0);
    while (!file_priorite.EstVide()) {
      int v = file_priorite.SupprimerMin();

      for (Arc a : g.Adjacents(v)) {
    	  int sommet = a.vers;
    	  int poids = a.cout;
    	  int distanceParcouru = distance[v]+poids;
        if (distanceParcouru< distance[a.vers]) {
         
        	//vertexQueue.remove(sommet);
        	distance[a.vers]=distanceParcouru;
        	parent[a.vers] = v;
        	file_priorite.Ajouter(sommet, parent[sommet]);
        	//chemin.Ajouter(sommet);
        	
        	}
        	
        }
    }
    for(int i=t;i>=0;i=parent[i]) {
    	chemin.Ajouter(i);
    }
    
    Collections.reverse(chemin.chemin);
   
    for(int i = 0;i<chemin.chemin.size()-1;i++) {
    	Arc a = g.TrouverArc(chemin.chemin.get(i),chemin.chemin.get(i+1));
    			cout_total+=a.cout;
    }
    chemin.SetCout(cout_total);
  path.add(chemin);
  
   
    return path;
   }
}
