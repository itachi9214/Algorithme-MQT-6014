package tp4;

import java.util.ArrayList;
import java.util.Collections;


// Cet objet permet de trouver le nombre de composantes connexes dans un graphe
public class DeuxChemins {
  IGraphe g;
  IFilePriorite file_priorite;
  IFilePriorite file_priorite2;
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
    file_priorite2 = new TableauPrioriteSimple(gr.NbNoeuds());
  }

  private void Init() {

    file_priorite.Vider();
    file_priorite2.Vider();
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
	  double cout_total2 = 0;
	  ArrayList<Chemin> path = new ArrayList<Chemin>();
	  Chemin chemin = new Chemin();
	  Chemin chemin2 = new Chemin();
	  dijkstra(s);
	  
    for(int i=t;i>=0;i=parent[i]) {	
    	chemin.Ajouter(i);
    }
    
    for(int i=t;i>=0;i=parent2[i]) {	
    	chemin2.Ajouter(i);
    }
    
    
    Collections.reverse(chemin.chemin);
    Collections.reverse(chemin2.chemin);
   
    for(int i = 0;i<chemin.chemin.size()-1;i++) {
    	Arc a = g.TrouverArc(chemin.chemin.get(i),chemin.chemin.get(i+1));
    	if(a!=null)
    		cout_total+=a.cout;
    }
    
    for(int i = 0;i<chemin2.chemin.size()-1;i++) {
    	Arc a = g.TrouverArc(chemin2.chemin.get(i),chemin2.chemin.get(i+1));
    	if(a!=null)
    		cout_total2+=a.cout;
    }
    chemin.SetCout(cout_total);
    chemin2.SetCout(cout_total2);
    path.add(chemin);
    path.add(chemin2);
  
   
    return path;
   }

public void dijkstra(int s) {

	Init();
    parent[s] = -2;
    parent2[s] = -2;
    distance[s] = 0;
    distance2[s] = 0;
    file_priorite2.Ajouter(s, 0);
    file_priorite.Ajouter(s, 0);
    
    while (!file_priorite.EstVide()) {
      int v = file_priorite.SupprimerMin();

      for (Arc a : g.Adjacents(v)) {
    	  int sommet = a.vers;
    	  int poids = a.cout;
    	  int distanceParcourue = distance[v]+poids;
    	  
    	  
        if (distanceParcourue< distance[a.vers]) {
        	distance[a.vers]=distanceParcourue;
        	parent[a.vers] = v;
        	file_priorite.Ajouter(sommet, distance[a.vers]);       	       	
        	}
        
        }
      
    }   
   while (!file_priorite2.EstVide()) {
        int v = file_priorite2.SupprimerMin();

        for (Arc a : g.Adjacents(v)) {
      	  int sommet = a.vers;
      	  int poids = a.cout;
      	  int distanceParcourue = distance2[v]+poids;
      	  if(distanceParcourue == distance2[a.vers]) {
      		distance2[a.vers]=distanceParcourue;
            parent2[a.vers] = v;
            file_priorite2.Ajouter(sommet, parent2[sommet]);
      	  }
      	  else if (distanceParcourue< distance2[a.vers]) {
          	distance2[a.vers]=distanceParcourue;
          	parent2[a.vers] = v;
          	file_priorite2.Ajouter(sommet, distance2[a.vers]);
          	}
          }
        }
   }
}

