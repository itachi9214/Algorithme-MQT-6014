package tp4;

import java.util.ArrayList;

public class GrapheListe implements IGraphe {
  private int nbnoeuds, nbarcs;
  private boolean est_dirige;
  private ArrayList<ListeChainee<Arc>> arcs;

  public GrapheListe(int noeuds, boolean dir) {
    nbnoeuds = noeuds + 1;
    est_dirige = dir;
    arcs = new ArrayList<ListeChainee<Arc>>();
    for (int i = 0; i < nbnoeuds; i++)
      arcs.add(new ListeChainee<Arc>());
  }

  public int NbNoeuds() {
    return nbnoeuds;
  }

  public int NbArcs() {
    return nbarcs;
  }

  public boolean EstDirige() {
    return est_dirige;
  }

  public void Ajouter(Arc a) {
    arcs.get(a.de).Ajouter(a);
    nbarcs++;
    if (!est_dirige) {
      arcs.get(a.vers).Ajouter(new Arc(a.vers, a.de, a.cout));
      nbarcs++;
    }
  }

  public void Retirer(Arc a) {
	  //arcs.remove(a.vers);
	  arcs.remove(a.de);
	  nbarcs--;
	  a.cout=0;
	  this.Adjacents(a.de).iterator().next().vers=Integer.MAX_VALUE;
	  if(!this.Existe(a.de, a.vers) && !this.Existe(a.vers, a.de) )
		  nbnoeuds--;
		  
  }

  // retour vrai si l'arc de i a j existe
  public boolean Existe(int i, int j) {
    for (Arc a : arcs.get(i))
      if (a.vers == j)
        return true;
    return false;
  }

  public Arc TrouverArc(int i, int j) {
    for (Arc a : arcs.get(i))
      if (a.vers == j)
        return a;
    return null;
  }

  // retourne un objet contenant tous les arcs sortant de i
  public Iterable<Arc> Adjacents(int i) {
    return arcs.get(i);
  }

  public String toString() {
    String s = "Graphe noeuds:" + nbnoeuds + " arcs:" + nbarcs + "\n";
    for (int i = 0; i < nbnoeuds; i++)
      for (Arc a : Adjacents(i))
        if (est_dirige || a.de < a.vers)
          s += a + "\n";
    return s;
  }

  public static void main(String[] args) {
    GrapheListe g = new GrapheListe(7, true);
    Arc b = new Arc(0, 1);
    Arc c = new Arc(0, 2);
    Arc d = new Arc (0, 3);
    g.Ajouter(b);
    g.Ajouter(c);
    g.Ajouter(d);
    Arc e = new Arc(1, 2);
	g.Ajouter(e);
    Arc f = new Arc(1, 5);
	g.Ajouter(f);
    Arc h = new Arc(2, 3);
	g.Ajouter(h);
    Arc x = new Arc(2, 5);
	g.Ajouter(x);
    Arc j = new Arc(3, 0);
	g.Ajouter(j);
    Arc k = new Arc(3, 2);
	g.Ajouter(k);
    Arc l = new Arc(3, 4);
	g.Ajouter(l);
    Arc m = new Arc(4, 3);
	g.Ajouter(m);
    Arc n = new Arc(4, 5);
	g.Ajouter(n);
    Arc o = new Arc(5, 6);
	g.Ajouter(o);
    Arc p = new Arc(6, 4);
	g.Ajouter(p);
    g.Retirer(b);
    g.Retirer(c);
    g.Retirer(d);
    
    for (int i = 0; i < g.nbnoeuds
    		; i++) {
      System.out.print("Noeud : " + i + " arcs : ");
      for (Arc a : g.Adjacents(i))
        System.out.print(a.vers + " ");
      System.out.println();
    }

  }
}
