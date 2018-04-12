package tp4;

import java.util.Iterator;

public class ListeChainee<Item> implements Iterable<Item> {
  private class Node<Item> {
    Item item;
    Node<Item> suivant;

    public Node(Item it) {
      item = it;
    }
  }

  private Node<Item> tete;

  public void Ajouter(Item item) {
    Node<Item> n = new Node<Item>(item);
    n.suivant = tete;
    tete = n;
  }
  
  public void Retirer(Item item){
	  Node<Item> n = new Node<Item>(item);
	  
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListeChaineeIterator();
  }

  class ListeChaineeIterator implements Iterator<Item> {
    Node<Item> cur = tete;

    @Override
    public boolean hasNext() {
      return cur != null;
    }

    @Override
    public Item next() {
      Item v = cur.item;
      cur = cur.suivant;
      return v;
    }
  }

  public static void main(String[] args) {
    ListeChainee<Integer> liste = new ListeChainee<Integer>();
    liste.Ajouter(4);
    liste.Ajouter(5);
    liste.Ajouter(6);
    liste.Ajouter(7);

    for (int i : liste)
      System.out.print(i + " ");
    System.out.println();
  }
}
